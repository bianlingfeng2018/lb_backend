package com.libiao.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.ClientBillOutMapper;
import com.libiao.customer.dal.model.ClientBillIncome;
import com.libiao.customer.dal.model.ClientBillIncomeExample;
import com.libiao.customer.dal.model.ClientBillOut;
import com.libiao.customer.dal.model.ClientBillOutExample;
import com.libiao.customer.entity.req.BillOutAddReq;
import com.libiao.customer.entity.req.BillOutReq;
import com.libiao.customer.service.BillOutService;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillOutServiceImpl implements BillOutService {

    @Autowired
    ClientBillOutMapper outMapper;


    @Override
    public ResponseVO<PageInfo> getAllOutBill(BillOutReq req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        ClientBillOutExample example = new ClientBillOutExample();
        ClientBillOutExample.Criteria criteria = example.createCriteria();
        if (null != req.getClientId()) {
            criteria.andClientIdEqualTo(req.getClientId());
        }
        if (null != req.getStatus()) {
            criteria.andStatusEqualTo(req.getStatus());
        }
        if (null != req.getEndTime() && null != req.getStartTime()) {
            criteria.andStartTimeBetween(req.getStartTime(), req.getEndTime());
        }
        if (null != req.getLastStartTime() && null != req.getLastEndTime()) {
            criteria.andLastTimeBetween(req.getLastStartTime(), req.getLastEndTime());
        }
        List list = outMapper.selectByExample(example);
        PageInfo<ClientBillOut> pageInfo = new PageInfo<ClientBillOut>(list);
        return ResponseUtil.success(pageInfo);
    }

    @Override
    public ResponseVO addOneOutBill(BillOutAddReq req) {
        return null;
    }
}
