package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestWorkOrder;
import com.libiao.customer.model.work.WorkOrderListReq;

public interface WorkService {
    PageInfo<TestWorkOrder> list(WorkOrderListReq req);
}
