package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.TestApplicationFormMapper;
import com.libiao.customer.dal.mapper.TestApplicationItemMapper;
import com.libiao.customer.dal.mapper.TestApplicationSampleMapper;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.application.*;
import com.libiao.customer.service.ApplicationService;
import com.libiao.customer.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private TestApplicationFormMapper testApplicationFormMapper;
    @Autowired
    private TestApplicationSampleMapper testApplicationSampleMapper;
    @Autowired
    private TestApplicationItemMapper testApplicationItemMapper;

    @Override
    public PageInfo<TestApplicationForm> list(ApplicationListReq req){
        PageInfo<TestApplicationForm> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());

        TestApplicationFormExample testApplicationFormExample = new TestApplicationFormExample();
        TestApplicationFormExample.Criteria criteria = testApplicationFormExample.createCriteria();
        if (StringUtils.hasLength(req.getApplicationNum())){
            criteria.andApplicationNumLike("%"+req.getApplicationNum()+"%");
        }
        if (StringUtils.hasLength(req.getApplicationName())){
            criteria.andApplicationNameLike("%" + req.getApplicationName() + "%");
        }
        if (req.getSampleStatus() != null){
            criteria.andSampleStatusEqualTo(req.getSampleStatus());
        }
        if (req.getContractStatus() != null){
            criteria.andContractStatusEqualTo(req.getContractStatus());
        }
        List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(testApplicationFormExample);
        page = new PageInfo<>(testApplicationForms);
        return page;
    }

    //新增申请单
    @Override
    public void createApplication(AddApplicationReq req){

        TestApplicationForm record = new TestApplicationForm();
        BeanCopyUtil.copy(req,record);
        List<Integer> credentials = req.getCredentials();
        int credential = 0;
        if (!CollectionUtils.isEmpty(credentials)){
            for (Integer integer : credentials) {
                credential = credential | integer;
            }
        }
        //进行位运算
        record.setCredential(credential);
        //生成申请单号 LTI+T+年份后两位+月份+日+ （A-Z）
        String applicationNum = redisUtil.getAppNo(DateUtils.getDate("yyMMdd"));
        record.setApplicationNum(applicationNum);
        testApplicationFormMapper.insertSelective(record);

        List<SampleTestReq> sampleList = req.getSampleList();
        if (CollectionUtils.isEmpty(sampleList)){
            return;
        }
        //添加多种样品
        for (SampleTestReq sampleTestReq : sampleList) {
            TestApplicationSample row = new TestApplicationSample();
            BeanCopyUtil.copy(sampleTestReq,row);
            row.setApplicationFormId(record.getId());
            row.setApplicationNum(applicationNum);
            testApplicationSampleMapper.insertSelective(row);
            //添加样品下的测试项目
            List<SampleItemReq> itemList = sampleTestReq.getItemList();
            if (CollectionUtils.isEmpty(itemList)){
                continue;
            }
            for (SampleItemReq sampleItemReq : itemList) {
                TestApplicationItem item = new TestApplicationItem();
                BeanCopyUtil.copy(sampleItemReq,item);
                item.setAppSampleId(row.getId());
                item.setApplicationNum(applicationNum);
                testApplicationItemMapper.insertSelective(item);
            }
        }
    }

    @Override
    public ApplicationDetailVO detail(ApplicationDetailReq req){
        TestApplicationFormExample example = new TestApplicationFormExample();
        example.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        List<TestApplicationForm> testApplicationForms = testApplicationFormMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(testApplicationForms)){
            throw new ServiceException(HttpStatus.NOT_FOUND,"申请单不存在");
        }
        TestApplicationForm testApplicationForm = testApplicationForms.get(0);
        ApplicationDetailVO vo = new ApplicationDetailVO();
        BeanCopyUtil.copy(testApplicationForm,vo);
        //转换资质
        Integer credential = testApplicationForm.getCredential();
        List<Integer> serviceString = CredentialByteUtil.getServiceString(credential);
        vo.setCredentials(serviceString);
        //查询其他样品信息
        TestApplicationSampleExample sampleExample = new TestApplicationSampleExample();
        sampleExample.createCriteria().andApplicationFormIdEqualTo(testApplicationForm.getId());
        List<TestApplicationSample> testApplicationSamples = testApplicationSampleMapper.selectByExample(sampleExample);
        if (CollectionUtils.isEmpty(testApplicationSamples)){
            return vo;
        }
        List<SampleTestReq> sampleTestList = new ArrayList<>();
        for (TestApplicationSample testApplicationSample : testApplicationSamples) {
            SampleTestReq row = new SampleTestReq();
            BeanCopyUtil.copy(testApplicationSample,row);
            //查询样品下面的项目
            TestApplicationItemExample itemExample = new TestApplicationItemExample();
            itemExample.createCriteria().andAppSampleIdEqualTo(testApplicationSample.getId());
            List<TestApplicationItem> testApplicationItems = testApplicationItemMapper.selectByExample(itemExample);
            if (!CollectionUtils.isEmpty(testApplicationSamples)){
                List<SampleItemReq> list = new ArrayList<>();
                for (TestApplicationItem testApplicationItem : testApplicationItems) {
                    SampleItemReq item = new SampleItemReq();
                    BeanCopyUtil.copy(testApplicationItem,item);
                    list.add(item);
                }
                row.setItemList(list);
            }
            sampleTestList.add(row);
        }
        vo.setSampleList(sampleTestList);
        return vo;
    }

    @Override
    public void modify(ModifyApplicationReq req){
        TestApplicationFormExample example = new TestApplicationFormExample();
        example.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());

        TestApplicationForm record = new TestApplicationForm();
        BeanCopyUtil.copy(req,record);
        List<Integer> credentials = req.getCredentials();
        int credential = 0;
        if (!CollectionUtils.isEmpty(credentials)){
            for (Integer integer : credentials) {
                credential = credential | integer;
            }
        }
        //进行位运算
        record.setCredential(credential);


        testApplicationFormMapper.updateByExampleSelective(record,example);

        List<SampleTestReq> sampleList = req.getSampleList();
        //删除下属的sample
        TestApplicationSampleExample sampleExample = new TestApplicationSampleExample();
        sampleExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        testApplicationSampleMapper.deleteByExample(sampleExample);
        //删除item
        TestApplicationItemExample itemExample = new TestApplicationItemExample();
        itemExample.createCriteria().andApplicationNumEqualTo(req.getApplicationNum());
        testApplicationItemMapper.deleteByExample(itemExample);

        //application_id
        if (CollectionUtils.isEmpty(sampleList)){
            return;
        }
        //添加多种样品
        for (SampleTestReq sampleTestReq : sampleList) {
            TestApplicationSample row = new TestApplicationSample();
            BeanCopyUtil.copy(sampleTestReq,row);
            row.setApplicationFormId(record.getId());
            row.setApplicationNum(req.getApplicationNum());
            testApplicationSampleMapper.insertSelective(row);
            //添加样品下的测试项目
            List<SampleItemReq> itemList = sampleTestReq.getItemList();
            if (CollectionUtils.isEmpty(itemList)){
                continue;
            }
            for (SampleItemReq sampleItemReq : itemList) {
                TestApplicationItem item = new TestApplicationItem();
                BeanCopyUtil.copy(sampleItemReq,item);
                item.setAppSampleId(row.getId());
                testApplicationItemMapper.insertSelective(item);
            }
        }

    }
}
