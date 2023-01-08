package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.ori.*;
import com.libiao.customer.service.OriRecordService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.LikeUtil;
import com.libiao.customer.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class OriRecordServiceImpl implements OriRecordService {

    @Autowired
    private TestOriRecordMapper testOriRecordMapper;
    @Autowired
    private TestRecordSubItemMapper testRecordSubItemMapper;
    @Autowired
    private BasicStandardMapper basicStandardMapper;
    @Autowired
    private BasicStandardLevelMapper basicStandardLevelMapper;

    @Override
    public PageInfo<TestOriRecord> list(OriRecordListReq req){
        PageInfo<TestOriRecord> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        TestOriRecordExample example = new TestOriRecordExample();
        final TestOriRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasLength(req.getRecordNum())){
            criteria.andRecordNumLike(LikeUtil.totalLike(req.getRecordNum()));
        }
        if (req.getStatus() != null){
            criteria.andStatusEqualTo(req.getStatus());
        }
        if (StringUtils.hasLength(req.getQuotationNum())){
            criteria.andQuotationNumEqualTo(req.getQuotationNum());
        }
        final List<TestOriRecord> testOriRecords = testOriRecordMapper.selectByExample(example);
        page = new PageInfo<>(testOriRecords);
        return page;
    }

    @Override
    public OriRecordDetailVO detail(OriRecordDetailReq req){
        OriRecordDetailVO vo = new OriRecordDetailVO();
        final TestOriRecord testOriRecord = testOriRecordMapper.selectByPrimaryKey(req.getId());
        BeanCopyUtil.copy(testOriRecord,vo);
        //查找子项目
        TestRecordSubItemExample example = new TestRecordSubItemExample();
        example.createCriteria().andOriRecordIdEqualTo(req.getId());
        final List<TestRecordSubItem> testRecordSubItems = testRecordSubItemMapper.selectByExample(example);
        List<OriRecordSubItemVO> subItemVOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(testRecordSubItems)){
            testRecordSubItems.forEach(sub->subItemVOS.add(BeanCopyUtil.copy(sub,OriRecordSubItemVO.class)));
        }
        vo.setSubList(subItemVOS);
        return vo;
    }

    @Override
    @Transactional
    public void review(ReviewOriRecordReq req){
        final TestOriRecord testOriRecord = testOriRecordMapper.selectByPrimaryKey(req.getId());
        if (testOriRecord == null || 1 != testOriRecord.getStatus()){
            throw new ServiceException(HttpStatus.NOT_FOUND,"原始记录单未找到，或状态不正确");
        }
        TestOriRecord update = new TestOriRecord();
        update.setId(req.getId());
        update.setStatus(req.getStatus());
        update.setReviewId(req.getUser().getId());
        update.setReviewName(req.getUser().getNickname());
        update.setReviewReason(req.getReviewReason());
        testOriRecordMapper.updateByPrimaryKeySelective(update);
        //TODO 确认该原始记录单的申请单下的所有原始记录单都已经审核完毕，那么生成检测报告单

    }

    //更新原始记录单，首先获取测试类型和对应的参数
    //根据test_item_id
    @Override
    public TestItemInfoVO testInfo(TestItemInfoReq req){
        TestItemInfoVO vo = new TestItemInfoVO();
        BasicStandardExample example = new BasicStandardExample();
        example.createCriteria().andTestItemIdEqualTo(req.getTestItemId());
        List<BasicStandard> basicStandards = basicStandardMapper.selectByExample(example);
        BasicStandard basicStandard = basicStandards.get(0);
        BeanCopyUtil.copy(basicStandard,vo);
        //1:单个限值 2:多级别限值 3:纯文本判断 4:包含测试子项目
        if (basicStandard.getType() == 2){
            //查询多级别
            BasicStandardLevelExample levelExample = new BasicStandardLevelExample();
            levelExample.createCriteria().andStandardIdEqualTo(basicStandard.getId());
            List<BasicStandardLevel> basicStandardLevels = basicStandardLevelMapper.selectByExample(levelExample);
            List<TestItemInfoLvlVO> levelList = new ArrayList<>();
            basicStandardLevels.forEach(lvl->levelList.add(BeanCopyUtil.copy(lvl,TestItemInfoLvlVO.class)));
            vo.setLevelList(levelList);
        }else if (4 == basicStandard.getType()){
            TestRecordSubItemExample subExample = new TestRecordSubItemExample();
            subExample.createCriteria().andOriRecordIdEqualTo(req.getOriRecordId());
            List<TestRecordSubItem> testSubItems = testRecordSubItemMapper.selectByExample(subExample);
            List<TestItemSubInfoVO> subList = new ArrayList<>();
            testSubItems.forEach(sub->subList.add(BeanCopyUtil.copy(sub,TestItemSubInfoVO.class)));
            vo.setSubList(subList);
        }
        return vo;
    }

    @Override
    @Transactional
    public void upload(UploadTestResultReq req){
        //更新原始记录单
        //只有指定的测试人员才能上传
        String idStr = String.valueOf(req.getUser().getId());
        TestOriRecord record = testOriRecordMapper.selectByPrimaryKey(req.getOriRecordId());
        if (record.getStatus() == 2){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"审核通过，不能再上传");
        }
        boolean flag = false;
        String[] split = record.getTestPersonId().split(",");
        for (String s : split) {
            if (s.equals(idStr)){
                flag = true;
                break;
            }
        }
        if (!flag){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"非分配的测试人员，不能再上传");
        }

        TestOriRecord update = new TestOriRecord();
        update.setId(req.getOriRecordId());
        update.setTestResult(req.getTestResult());
        update.setTestValue(req.getTestValue());
        update.setOriReportFile(req.getFileName());
        update.setTestLevel(req.getTestLevel());
        update.setRemark(req.getRemark());
        testOriRecordMapper.updateByPrimaryKeySelective(update);
        if (!CollectionUtils.isEmpty(req.getSubList())) {
            for (SubResultVO subResultVO : req.getSubList()) {
                TestRecordSubItem subUpdate = new TestRecordSubItem();
                subUpdate.setId(subResultVO.getId());
                subUpdate.setAvgValue(subResultVO.getAvgValue());
                subUpdate.setTestResult(subResultVO.getTestResult());
                testRecordSubItemMapper.updateByPrimaryKeySelective(subUpdate);
            }
        }
    }

    @Override
    public void assignment(AssignmentReq req){
        TestOriRecord record = testOriRecordMapper.selectByPrimaryKey(req.getOriRecordId());
        if (record.getStatus() != 0){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"该订单已经分配");
        }
        TestOriRecord update = new TestOriRecord();
        update.setId(req.getOriRecordId());
        StringBuilder name = new StringBuilder();
        StringBuilder id = new StringBuilder();
        for (UserVO user : req.getUserList()) {
            name.append(user.getNickname()).append(",");
            id.append(user.getId()).append(",");
        }
        update.setTestPersonId(id.deleteCharAt(id.length()-1).toString());
        update.setTestPerson(name.deleteCharAt(name.length()-1).toString());
        testOriRecordMapper.updateByPrimaryKeySelective(update);
    }

}
