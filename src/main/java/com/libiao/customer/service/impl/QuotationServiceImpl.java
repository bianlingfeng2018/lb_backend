package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.QuotationMapper;
import com.libiao.customer.dal.model.Quotation;
import com.libiao.customer.model.quotation.QuotationListReq;
import com.libiao.customer.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private QuotationMapper quotationMapper;

    @Override
    public PageInfo<Quotation> list(QuotationListReq req){
        PageInfo<Quotation> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        final List<Quotation> quotations = quotationMapper.selectAll();
        page = new PageInfo<>(quotations);
        return page;
    }

}
