package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.TestWorkOrderMapper;
import com.libiao.customer.dal.model.TestWorkOrder;
import com.libiao.customer.dal.model.TestWorkOrderExample;
import com.libiao.customer.model.work.WorkOrderListReq;
import com.libiao.customer.service.WorkService;
import com.libiao.customer.util.DateUtils;
import com.libiao.customer.util.LikeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    //工作单列表
    @Autowired
    private TestWorkOrderMapper testWorkOrderMapper;

    @Override
    public PageInfo<TestWorkOrder> list(WorkOrderListReq req){
        TestWorkOrderExample testWorkOrderExample = new TestWorkOrderExample();
        TestWorkOrderExample.Criteria criteria = testWorkOrderExample.createCriteria();
        if (StringUtils.hasLength(req.getWorkOrderNum())){
            criteria.andWorkOrderNumLike(LikeUtil.totalLike(req.getWorkOrderNum()));
        }
        if (StringUtils.hasLength(req.getComName())){
            criteria.andComNameLike(LikeUtil.totalLike(req.getComName()));
        }
        if (req.getSubContract() != null){
            criteria.andSubContractEqualTo(req.getSubContract());
        }
        if (req.getStatus() != null){
            criteria.andStatusEqualTo(req.getStatus());
        }
        if (StringUtils.hasLength(req.getOrderDateStart()) && StringUtils.hasLength(req.getOrderDateEnd())){
            criteria.andOrderDateBetween(DateUtils.stringToDate(req.getOrderDateStart(),"yyyy-MM-dd"),
                    DateUtils.stringToDate(req.getOrderDateEnd(),"yyyy-MM-dd"));
        }
        if (StringUtils.hasLength(req.getPlanDateStart()) && StringUtils.hasLength(req.getPlanDateEnd())){
            criteria.andPlanDateBetween(DateUtils.stringToDate(req.getPlanDateStart(),"yyyy-MM-dd"),
                    DateUtils.stringToDate(req.getPlanDateEnd(),"yyyy-MM-dd"));
        }
        PageInfo<TestWorkOrder> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        List<TestWorkOrder> testWorkOrders = testWorkOrderMapper.selectByExample(testWorkOrderExample);
        page = new PageInfo<>(testWorkOrders);
        return page;
    }

}
