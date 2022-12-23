package com.libiao.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.ClientBillIncomeMapper;
import com.libiao.customer.dal.model.ClientBillIncome;
import com.libiao.customer.dal.model.ClientBillIncomeExample;
import com.libiao.customer.entity.req.BillIncomeAddReq;
import com.libiao.customer.entity.req.BillIncomeReq;
import com.libiao.customer.service.BillIncomeService;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillIncomeServiceImpl implements BillIncomeService {

    @Autowired
    ClientBillIncomeMapper incomeMapper;


    @Override
    public ResponseVO<PageInfo> getAllIncomeBill(BillIncomeReq req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        ClientBillIncomeExample example = new ClientBillIncomeExample();
        ClientBillIncomeExample.Criteria criteria = example.createCriteria();
        if (null != req.getClientId()) {
            criteria.andClientIdEqualTo(req.getClientId());
        }
        if (null != req.getOperType()) {
            criteria.andOprationTypeEqualTo(req.getOperType());
        }
        if (null != req.getEndTime() && null != req.getStartTime()) {
            criteria.andOperationTimeBetween(req.getStartTime(), req.getEndTime());
        }
        List list = incomeMapper.selectByExample(example);
        PageInfo<ClientBillIncome> pageInfo = new PageInfo<ClientBillIncome>(list);
        return ResponseUtil.success(pageInfo);
    }

    @Override
    public ResponseVO addOneIncomeBill(BillIncomeAddReq req) {
        ClientBillIncome billIncome = new ClientBillIncome();
        billIncome.setClientId(req.getClientId());
        billIncome.setOperationAmount(req.getOperAmount());
        billIncome.setOperationTime(new Date());
        billIncome.setOperUser(req.getOperUser());
        billIncome.setOprationType("入账");
        billIncome.setDesc(req.getDesc());
        long amount = getClientAccountAmount(req.getClientId());
        billIncome.setOriginAmount(amount);
        billIncome.setFinalAmount(amount - req.getOperAmount());
        int row = incomeMapper.insertSelective(billIncome);
        return row == 1 ? ResponseUtil.success() : ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }


    private Long getClientAccountAmount(String clientId) {


        return 0L;
    }

}
