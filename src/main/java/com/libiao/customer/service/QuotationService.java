package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.Quotation;
import com.libiao.customer.dal.model.TestQuotation;
import com.libiao.customer.model.quotation.*;

/**
 * 报价单相关
 */
public interface QuotationService {
    PageInfo<TestQuotation> list(QuotationListReq req);

    void create(CreateQuotationReq req);

    //编辑报价单，只有未审核的报价单可以编辑
    void modify(ModifyQuotationReq req);

    void examine(ExamineQuotationReq req);

    void addQuot(AddQuotationReq req);

    String getRate();
}
