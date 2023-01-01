package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.TestApplicationFormMapper;
import com.libiao.customer.dal.mapper.TestApplicationItemMapper;
import com.libiao.customer.dal.mapper.TestApplicationSampleMapper;
import com.libiao.customer.dal.model.TestApplicationForm;
import com.libiao.customer.dal.model.TestApplicationFormExample;
import com.libiao.customer.dal.model.TestApplicationItem;
import com.libiao.customer.dal.model.TestApplicationSample;
import com.libiao.customer.model.application.AddApplicationReq;
import com.libiao.customer.model.application.ApplicationListReq;
import com.libiao.customer.model.application.SampleItemReq;
import com.libiao.customer.model.application.SampleTestReq;
import com.libiao.customer.service.ApplicationService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.DateUtils;
import com.libiao.customer.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
                testApplicationItemMapper.insertSelective(item);
            }
        }
    }
}
