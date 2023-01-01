package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.TestApplicationFormMapper;
import com.libiao.customer.dal.model.TestApplicationForm;
import com.libiao.customer.dal.model.TestApplicationFormExample;
import com.libiao.customer.model.application.AddApplicationReq;
import com.libiao.customer.model.application.ApplicationListReq;
import com.libiao.customer.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private TestApplicationFormMapper testApplicationFormMapper;

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
    public void tt(AddApplicationReq req){



    }
}
