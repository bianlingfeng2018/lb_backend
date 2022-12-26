package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.Quotation;
import com.libiao.customer.dal.model.TestQuotation;
import com.libiao.customer.model.quotation.QuotationListReq;

/**
 * 报价单相关
 */
public interface QuotationService {
    PageInfo<TestQuotation> list(QuotationListReq req);
}
