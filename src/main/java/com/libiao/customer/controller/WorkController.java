package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestWorkOrder;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.work.WorkOrderDetailReq;
import com.libiao.customer.model.work.WorkOrderListReq;
import com.libiao.customer.model.work.WorkOrderListVO;
import com.libiao.customer.model.work.WorkOrderVO;
import com.libiao.customer.service.WorkService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 工作单相关
 * 收到样品后，自动生产工作单
 * 根据表 9 10 11 12，来确定哪个实验室的谁来负责这个工作单
 * 优先非分包商
 */
@Api(tags = "工作单相关接口")
@RequestMapping("workOrder")
@RestController
public class WorkController {

    @Autowired
    private WorkService workService;

    @ApiOperation("工作单列表接口")
    @PostMapping("list")
    public ResponseEntity<ListResponseVO<WorkOrderListVO>> list(@RequestBody WorkOrderListReq req){
        List<WorkOrderListVO> voList = new ArrayList<>();
        PageInfo<TestWorkOrder> list = workService.list(req);
        list.getList().forEach(order->voList.add(BeanCopyUtil.copy(order,WorkOrderListVO.class)));
        return ResponseUtil.getListResponseVO(voList,list.getTotal());
    }

    @ApiOperation("工作单详情")
    @PostMapping("detail")
    public ResponseEntity<WorkOrderVO> detail(@RequestBody WorkOrderDetailReq req){
        WorkOrderVO detail = workService.detail(req);
        return ResponseUtil.getResponseVO(detail);
    }

}
