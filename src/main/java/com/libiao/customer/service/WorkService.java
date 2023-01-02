package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestWorkOrder;
import com.libiao.customer.model.work.ConfirmWorkOrderReq;
import com.libiao.customer.model.work.WorkOrderDetailReq;
import com.libiao.customer.model.work.WorkOrderListReq;
import com.libiao.customer.model.work.WorkOrderVO;
import org.springframework.transaction.annotation.Transactional;

public interface WorkService {
    PageInfo<TestWorkOrder> list(WorkOrderListReq req);

    //工作单
    WorkOrderVO detail(WorkOrderDetailReq req);

    //确认工作单
    @Transactional
    void confirm(ConfirmWorkOrderReq req);

    //删除工作单
    void delete(WorkOrderDetailReq req);
}
