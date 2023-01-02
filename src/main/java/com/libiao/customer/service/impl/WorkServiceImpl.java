package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.TestWorkOrderItemMapper;
import com.libiao.customer.dal.mapper.TestWorkOrderMapper;
import com.libiao.customer.dal.mapper.TestWorkOrderSampleMapper;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.work.WorkOrderDetailReq;
import com.libiao.customer.model.work.WorkOrderItemVO;
import com.libiao.customer.model.work.WorkOrderListReq;
import com.libiao.customer.model.work.WorkOrderVO;
import com.libiao.customer.service.WorkService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.DateUtils;
import com.libiao.customer.util.LikeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    //工作单列表
    @Autowired
    private TestWorkOrderMapper testWorkOrderMapper;
    @Autowired
    private TestWorkOrderItemMapper testWorkOrderItemMapper;
    @Autowired
    private TestWorkOrderSampleMapper testWorkOrderSampleMapper;

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

    //工作单
    @Override
    public WorkOrderVO detail(WorkOrderDetailReq req){
        WorkOrderVO vo = new WorkOrderVO();
        TestWorkOrder testWorkOrder = testWorkOrderMapper.selectByPrimaryKey(req.getId());
        BeanCopyUtil.copy(testWorkOrder,vo);
        TestWorkOrderItemExample example = new TestWorkOrderItemExample();
        example.createCriteria().andTestWorkOrderIdEqualTo(req.getId());
        List<TestWorkOrderItem> testWorkOrderItems = testWorkOrderItemMapper.selectByExample(example);
        List<WorkOrderItemVO> itemVOList = new ArrayList<>(testWorkOrderItems.size());
        testWorkOrderItems.forEach(item->itemVOList.add(BeanCopyUtil.copy(item,WorkOrderItemVO.class)));
        vo.setItemList(itemVOList);
        TestWorkOrderSampleExample sampleExample = new TestWorkOrderSampleExample();
        sampleExample.createCriteria().andTestWorkOrderIdEqualTo(req.getId());
        List<TestWorkOrderSample> testWorkOrderSamples = testWorkOrderSampleMapper.selectByExample(sampleExample);
        List<String> fileList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(testWorkOrderSamples)){
            testWorkOrderSamples.forEach(sample->fileList.add(sample.getFileName()));
        }
        vo.setFileNameList(fileList);
        return vo;
    }

}
