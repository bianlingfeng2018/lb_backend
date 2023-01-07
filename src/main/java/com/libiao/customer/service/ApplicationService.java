package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestApplicationForm;
import com.libiao.customer.model.application.*;

public interface ApplicationService {

    PageInfo<TestApplicationForm> list(ApplicationListReq req);
    //新增申请单
    void createApplication(AddApplicationReq req);

    ApplicationDetailVO detail(ApplicationDetailReq req);

    void modify(ModifyApplicationReq req);

    void review(ReviewApplicationReq req);

    void confirm(ApplicationDetailReq req);
}
