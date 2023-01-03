package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestQuotation;
import com.libiao.customer.model.quotation.QuotationListReq;

import java.util.List;

public interface QuotationMapperExt {

    Long getServiceId();

    List<TestQuotation> getQuotationList(QuotationListReq req);
}
