package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.CheckCompany;
import com.libiao.customer.dal.model.TestWorkOrder;
import com.libiao.customer.model.work.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WorkService {
    PageInfo<TestWorkOrder> list(WorkOrderListReq req);

    //工作单
    WorkOrderVO detail(WorkOrderDetailReq req);

    //确认工作单
    @Transactional
    void confirm(ConfirmWorkOrderReq req);

    //删除工作单
    void delete(WorkOrderDetailReq req);

    List<CheckCompany> comList(CheckComListReq req);

    //获得该公司下的能测试的，这个测试项目
    List<CheckItemVO> getComCheckItemList(CheckItemReq req);
}
