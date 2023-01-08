package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.ori.*;
import com.libiao.customer.service.OriRecordService;
import com.libiao.customer.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private TestReportMapper testReportMapper;
    @Autowired
    private TestApplicationFormMapper testApplicationFormMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SystemParameterMapperExt systemParameterMapperExt;
    @Autowired
    private TestInfoMapperExt testInfoMapperExt;


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
        //确认该原始记录单的申请单下的所有原始记录单都已经审核完毕，那么生成检测报告单

        TestOriRecordExample example = new TestOriRecordExample();
        example.createCriteria().andApplicationNumEqualTo(testOriRecord.getApplicationNum()).andStatusNotEqualTo((byte) 2);
        List<TestOriRecord> testOriRecords = testOriRecordMapper.selectByExample(example);

        String editor = systemParameterMapperExt.getValueByKey("EDITOR");
        String approver = systemParameterMapperExt.getValueByKey("APPROVER");
        if (CollectionUtils.isEmpty(testOriRecords)){
            //找到申请单
            TestApplicationFormExample appExample = new TestApplicationFormExample();
            appExample.createCriteria().andApplicationNumEqualTo(testOriRecord.getApplicationNum());
            List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(appExample);
            TestApplicationForm testApplicationForm = testApplicationForms.get(0);

            //找到所有的原始记录单
            example = new TestOriRecordExample();
            example.createCriteria().andApplicationNumEqualTo(testOriRecord.getApplicationNum()).andStatusEqualTo((byte) 2);
            List<TestOriRecord> oriRecords = testOriRecordMapper.selectByExample(example);
            //获取下面所有的测试人员
            Set<String> tester = new HashSet<>();
            for (TestOriRecord oriRecord : oriRecords) {
                String testPerson = oriRecord.getTestPerson();
                String[] split = testPerson.split(",");
                for (String s : split) {
                    tester.add(s);
                }
            }
            StringBuilder test = new StringBuilder();
            tester.forEach(str->test.append(str).append(","));
            String testStr = test.deleteCharAt(test.length() - 1).toString();

            //不存在未审核的原始记录单，那么开始生成检测报告单
            TestReport report = new TestReport();
            report.setQuotationNum(testOriRecord.getQuotationNum());
            report.setApplicationNum(testOriRecord.getApplicationNum());
            report.setReportNum(redisUtil.getReportNo(DateUtils.getCurrentTime("yyyyMMdd")));
            report.setReportDate(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            report.setPlanDate(sdf.format(testApplicationForm.getPlanDate()));
            report.setClient(testApplicationForm.getApplicationName());
            report.setApprover(approver);
            report.setEditor(editor);
            String charger = testInfoMapperExt.getDirectorByGoodsId(testApplicationForm.getGoodsId());
            report.setCharger(charger);
            //获取所有的测试人员
            report.setTester(testStr);
            report.setReportStatus((byte) 0);
            testReportMapper.insertSelective(report);
        }
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
        if (req.getUploadType() == 1){
            if (record.getStatus() != 0){
                throw new ServiceException(HttpStatus.BAD_REQUEST, "记录单状态不正确，不可上传");
            }
        } else if (req.getUploadType() == 2){
            //待审核 和审核未通过的，可以编辑
            if(record.getStatus() != 1  && record.getStatus() != 3) {
                throw new ServiceException(HttpStatus.BAD_REQUEST, "记录单状态不正确，不可编辑");
            }
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
        update.setLimitValue(req.getLimitValue());
        update.setRemark(req.getRemark());
        update.setStatus((byte) 1);
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
