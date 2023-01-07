package com.libiao.customer.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.ClientBillIncomeMapper;
import com.libiao.customer.dal.model.Balance;
import com.libiao.customer.dal.model.ClientBillIncome;
import com.libiao.customer.dal.model.ClientBillIncomeExample;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.bill.BillIncomeAddReq;
import com.libiao.customer.model.bill.BillIncomeReq;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.service.BillIncomeService;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillIncomeServiceImpl implements BillIncomeService {

    @Autowired
    ClientBillIncomeMapper incomeMapper;

    @Autowired
    BalanceService balanceService;


    @Override
    public ResponseEntity<ListResponseVO<ClientBillIncome>> getAllIncomeBill(BillIncomeReq req) {
        PageHelper.startPage(req.getPage(), req.getPageSize());
        ClientBillIncomeExample example = new ClientBillIncomeExample();
        ClientBillIncomeExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty( req.getClientId())) {
            criteria.andClientIdEqualTo(req.getClientId());
        }
        if (!StringUtils.isEmpty(req.getOperType())) {
            criteria.andOprationTypeEqualTo(req.getOperType());
        }
        if (null != req.getEndTime() && null != req.getStartTime()) {
            criteria.andOperationTimeBetween(req.getStartTime(), req.getEndTime());
        }
        example.setOrderByClause("operation_time DESC");
        List list = incomeMapper.selectByExample(example);
        PageInfo<ClientBillIncome> pageInfo = new PageInfo<ClientBillIncome>(list);
        return ResponseUtil.getListResponseVO(pageInfo.getList(),pageInfo.getTotal());
    }

    @Override
    public ResponseVO addOneIncomeBill(BillIncomeAddReq req) {
        ClientBillIncome billIncome = new ClientBillIncome();
        billIncome.setClientId(req.getClientId());
        billIncome.setOperationAmount(req.getOperAmount());
        billIncome.setOperationTime(new Date());
        billIncome.setOperUser(String.valueOf(req.getUser().getId()));
        billIncome.setOprationType(req.getOperType());
        billIncome.setDescp(req.getDescp());
        billIncome.setIncomeComp(req.getIncomeComp());
        Balance balance = balanceService.getBalance(req.getClientId());
        long amount = balance.getBalanceAmt();
        billIncome.setOriginAmount(amount);
        billIncome.setFinalAmount(amount - req.getOperAmount());
        int row = incomeMapper.insertSelective(billIncome);
        return row == 1 ? ResponseUtil.success() : ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }


}
