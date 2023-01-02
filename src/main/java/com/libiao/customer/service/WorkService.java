package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestWorkOrder;
import com.libiao.customer.model.work.WorkOrderDetailReq;
import com.libiao.customer.model.work.WorkOrderListReq;
import com.libiao.customer.model.work.WorkOrderVO;

public interface WorkService {
    PageInfo<TestWorkOrder> list(WorkOrderListReq req);

    //工作单
    WorkOrderVO detail(WorkOrderDetailReq req);
}
