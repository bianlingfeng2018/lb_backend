package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.TestQuotationMapper;
import com.libiao.customer.dal.model.TestQuotation;
import com.libiao.customer.dal.model.TestQuotationExample;
import com.libiao.customer.model.quotation.QuotationListReq;
import com.libiao.customer.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private TestQuotationMapper testQuotationMapper;


    @Override
    public PageInfo<TestQuotation> list(QuotationListReq req){
        PageInfo<TestQuotation> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        TestQuotationExample example = new TestQuotationExample();
        final TestQuotationExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasLength(req.getQuotationNum())){
            criteria.andQuotationNumEqualTo(req.getQuotationNum());
        }
        if (StringUtils.hasLength(req.getClientName())){
            criteria.andClientNameEqualTo(req.getClientName());
        }
        if (StringUtils.hasLength(req.getTradeName())){
            criteria.andTradeNameEqualTo(req.getTradeName());
        }
        if (Objects.nonNull(req.getPayStatus())){
            criteria.andPayStatusEqualTo(req.getPayStatus());
        }
        if (Objects.nonNull(req.getStep())){
            criteria.andStepEqualTo(req.getStep());
        }

        final List<TestQuotation> quotations = testQuotationMapper.selectByExample(example);
        page = new PageInfo<>(quotations);
        return page;
    }

}
