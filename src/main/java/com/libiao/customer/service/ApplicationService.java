package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestApplicationForm;
import com.libiao.customer.model.application.AddApplicationReq;
import com.libiao.customer.model.application.ApplicationListReq;

public interface ApplicationService {
    PageInfo<TestApplicationForm> list(ApplicationListReq req);

    //新增申请单
    void createApplication(AddApplicationReq req);
}
