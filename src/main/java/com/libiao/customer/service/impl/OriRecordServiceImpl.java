package com.libiao.customer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.ori.*;
import com.libiao.customer.service.OriRecordService;
import com.libiao.customer.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
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
        //???????????????
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
            throw new ServiceException(HttpStatus.NOT_FOUND,"?????????????????????????????????????????????");
        }
        TestOriRecord update = new TestOriRecord();
        update.setId(req.getId());
        update.setStatus(req.getStatus());
        update.setReviewId(req.getUser().getId());
        update.setReviewName(req.getUser().getNickname());
        update.setReviewReason(req.getReviewReason());
        testOriRecordMapper.updateByPrimaryKeySelective(update);
        //??????????????????????????????????????????????????????????????????????????????????????????????????????????????????

        TestOriRecordExample example = new TestOriRecordExample();
        example.createCriteria().andApplicationNumEqualTo(testOriRecord.getApplicationNum()).andStatusNotEqualTo((byte) 2);
        List<TestOriRecord> testOriRecords = testOriRecordMapper.selectByExample(example);

        String editor = systemParameterMapperExt.getValueByKey("EDITOR");
        String approver = systemParameterMapperExt.getValueByKey("APPROVER");
        if (CollectionUtils.isEmpty(testOriRecords)){
            //???????????????
            TestApplicationFormExample appExample = new TestApplicationFormExample();
            appExample.createCriteria().andApplicationNumEqualTo(testOriRecord.getApplicationNum());
            List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(appExample);
            TestApplicationForm testApplicationForm = testApplicationForms.get(0);

            //??????????????????????????????
            example = new TestOriRecordExample();
            example.createCriteria().andApplicationNumEqualTo(testOriRecord.getApplicationNum()).andStatusEqualTo((byte) 2);
            List<TestOriRecord> oriRecords = testOriRecordMapper.selectByExample(example);
            //?????????????????????????????????
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

            //????????????????????????????????????????????????????????????????????????
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
            //???????????????????????????
            report.setTester(testStr);
            report.setReportStatus((byte) 0);
            testReportMapper.insertSelective(report);
        }
    }

    //??????????????????????????????????????????????????????????????????
    //??????test_item_id
    @Override
    public TestItemInfoVO testInfo(TestItemInfoReq req){
        TestItemInfoVO vo = new TestItemInfoVO();
        BasicStandardExample example = new BasicStandardExample();
        example.createCriteria().andTestItemIdEqualTo(req.getTestItemId());
        List<BasicStandard> basicStandards = basicStandardMapper.selectByExample(example);
        BasicStandard basicStandard = basicStandards.get(0);
        BeanCopyUtil.copy(basicStandard,vo);
        //1:???????????? 2:??????????????? 3:??????????????? 4:?????????????????????
        if (basicStandard.getType() == 2){
            //???????????????
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
        //?????????????????????
        //???????????????????????????????????????
        String idStr = String.valueOf(req.getUser().getId());
        TestOriRecord record = testOriRecordMapper.selectByPrimaryKey(req.getOriRecordId());
        if (record.getStatus() == 2){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"??????????????????????????????");
        }
        if (req.getUploadType() == 1){
            if (record.getStatus() != 0){
                throw new ServiceException(HttpStatus.BAD_REQUEST, "???????????????????????????????????????");
            }
        } else if (req.getUploadType() == 2){
            //????????? ????????????????????????????????????
            if(record.getStatus() != 1  && record.getStatus() != 3) {
                throw new ServiceException(HttpStatus.BAD_REQUEST, "???????????????????????????????????????");
            }
        }
        boolean flag = false;
        log.info("idStr={}",idStr);
        String[] split = record.getTestPersonId().split(",");
        log.info("split={}",record.getTestPersonId());
        for (String s : split) {
            if (s.equals(idStr)){
                flag = true;
                break;
            }
        }
        if (!flag){
            throw new ServiceException(HttpStatus.BAD_REQUEST,"??????????????????????????????????????????");
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
        log.info("update={}", JSONObject.toJSONString(update));
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
            throw new ServiceException(HttpStatus.BAD_REQUEST,"?????????????????????");
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
