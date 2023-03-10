package com.libiao.customer.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.ClientCommissionMapper;
import com.libiao.customer.dal.mapper.CommissionChangeRecordMapper;
import com.libiao.customer.dal.mapper.TestQuotationMapper;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.ErrorMessage;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.balance.*;
import com.libiao.customer.model.enums.CommissionStatus;
import com.libiao.customer.model.quotation.QuotationDetailReq;
import com.libiao.customer.model.quotation.QuotationDetailVO;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.service.CommissionService;
import com.libiao.customer.service.QuotationService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CommissionServiceImpl implements CommissionService {

    @Autowired
    CommissionChangeRecordMapper recordMapper;
    @Autowired
    ClientCommissionMapper commissionMapper;

    @Autowired
    BalanceService balanceService;

    @Autowired
    TestQuotationMapper quotationMapper;

    @Override
    public ResponseEntity<ListResponseVO<CommissionVo>> getCommissionList(CommissionListReq req) {
        PageHelper.startPage(req.getPage(), req.getPageSize());
        ClientCommissionExample clientCommissionExample = new ClientCommissionExample();
        ClientCommissionExample.Criteria criteria = clientCommissionExample.createCriteria();
        if (!StringUtils.isEmpty(req.getClientId())) {
            criteria.andClientIdEqualTo(req.getClientId());
        }
        if (!StringUtils.isEmpty(req.getClientName())) {
            criteria.andClientNameEqualTo(req.getClientName());
        }
        if (!StringUtils.isEmpty(req.getStatus())) {
            criteria.andStatusEqualTo(req.getStatus());
        }
        List<ClientCommission> list = commissionMapper.selectByExample(clientCommissionExample);
        PageInfo<ClientCommission> pageInfo = new PageInfo<>(list);
        List<CommissionVo> voList = new ArrayList<>();
        pageInfo.getList().forEach(clientCommission -> {
            CommissionVo commissionVo = BeanCopyUtil.copy(clientCommission, CommissionVo.class);
            Balance balance = balanceService.getBalance(clientCommission.getClientId());
            if(null == balance){
                commissionVo.setUnsettleCommission(0L);
            }else{
                commissionVo.setUnsettleCommission(balance.getUnsettleCommission());
            }

            voList.add(commissionVo);
        });

        return ResponseUtil.getListResponseVO(voList, pageInfo.getTotal());
    }

    @Override
    public boolean addRecord(CommissionChangeRecord req) {
//        req.setStatus(CommissionStatus.IN_APPROVE.getName());
        req.setOperTime(new Date());
        log.info("??????????????????????????????????????????req={}", JSONObject.toJSONString(req, true));
        return recordMapper.insertSelective(req) == 1;
    }

    @Override
    public ResponseEntity updateRecord(CommissionRecordReq req) {
        CommissionChangeRecord record = recordMapper.selectByPrimaryKey(req.getId());
        if(null == record) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"???????????????");
        record.setOperUser(String.valueOf(req.getUser().getId()));
        record.setOperTime(req.getSettleTime());
        record.setStatus("2");
        return recordMapper.updateByPrimaryKey(record)==1?ResponseUtil.getDefaultResp():ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR,"??????????????????");
    }

    @Override
    public ResponseEntity addRate(CommissionReq req) {
        Balance balance = balanceService.getBalance(req.getClientId());
        if (null == balance) return ResponseUtil.convert(HttpStatus.NOT_FOUND, "???????????????");
        ClientCommissionExample example = new ClientCommissionExample();
        example.createCriteria().andClientIdEqualTo(req.getClientId());
        List<ClientCommission> list = commissionMapper.selectByExample(example);
        if (list.size() >= 1) return ResponseUtil.convert(HttpStatus.MULTIPLE_CHOICES, "???????????????");
        ClientCommission commission = new ClientCommission();
        commission.setCreateTime(new Date());
        commission.setStatus(CommissionStatus.IN_APPROVE.getName());
        commission.setRate(0);
        commission.setInreviewRate(req.getRate());
        commission.setClientId(req.getClientId());
        commission.setClientName(req.getClientName());
        commission.setChangeUser(String.valueOf(req.getUser().getId()));
        int row = commissionMapper.insertSelective(commission);
        return row == 1 ? (ResponseUtil.getDefaultResp()) : ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR, "????????????");
    }

    @Override
    public ResponseEntity changeRate(CommissionReq req) {
        if (null == req.getId()) return ResponseUtil.convert(HttpStatus.NOT_ACCEPTABLE, "id??????");
        ClientCommissionExample example = new ClientCommissionExample();
        example.createCriteria().andIdEqualTo(req.getId()).andClientIdEqualTo(req.getClientId());
        List<ClientCommission> list = commissionMapper.selectByExample(example);
        if (list.size() != 1) return ResponseUtil.convert(HttpStatus.NOT_FOUND, "???????????????");
        ClientCommission record = list.get(0);
        record.setStatus(CommissionStatus.IN_APPROVE.getName());
        record.setInreviewRate(req.getRate());
        record.setReason(req.getReason());
        record.setChangeUser(String.valueOf(req.getUser().getId()));
        record.setChangeTime(new Date());
        int row = commissionMapper.updateByPrimaryKey(record);
        if (row != 1) return ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR, "????????????");
        return ResponseUtil.getDefaultResp();
    }

    @Override
    public ResponseEntity approve(CommissionReq req) {
        if (null == req.getId()) return ResponseUtil.convert(HttpStatus.NOT_ACCEPTABLE, "id??????");
        ClientCommissionExample example = new ClientCommissionExample();
        example.createCriteria().andIdEqualTo(req.getId()).andClientIdEqualTo(req.getClientId());
        List<ClientCommission> list = commissionMapper.selectByExample(example);
        if (list.size() != 1) return ResponseUtil.convert(HttpStatus.NOT_FOUND, "???????????????");
        ClientCommission record = list.get(0);
        record.setStatus(CommissionStatus.parse(req.getStatus()).getName());
        record.setReason(req.getReason());
        record.setRate(record.getInreviewRate());
        record.setApproveUser(String.valueOf(req.getUser().getId()));
        record.setApproveTime(new Date());
        int row = commissionMapper.updateByPrimaryKey(record);
        if (row != 1) return ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR, "????????????");
        return ResponseUtil.getDefaultResp();
    }

    @Override
    public ResponseEntity<ListResponseVO<CommissionRecordVo>> getCommissionRecordList(CommissionListReq req) {

        PageHelper.startPage(req.getPage(),req.getPageSize());
        CommissionChangeRecordExample clientCommissionExample = new CommissionChangeRecordExample();
        CommissionChangeRecordExample.Criteria criteria = clientCommissionExample.createCriteria();
        if (!StringUtils.isEmpty(req.getClientId())) {
            criteria.andClientIdEqualTo(req.getClientId());
        }
        if (!StringUtils.isEmpty(req.getClientName())) {
            criteria.andClientNameEqualTo(req.getClientName());
        }
        if (!StringUtils.isEmpty(req.getStatus())) {
            criteria.andStatusEqualTo(req.getStatus());
        }
        List<CommissionChangeRecord> list = recordMapper.selectByExample(clientCommissionExample);
        List<CommissionRecordVo>  recordVos = new ArrayList<>();
        list.forEach(record->{
            CommissionRecordVo commissionRecordVo = BeanCopyUtil.copy(record, CommissionRecordVo.class);
            TestQuotationExample example = new TestQuotationExample();
            example.createCriteria().andQuotationNumEqualTo(record.getTradeId());
            List<TestQuotation> quotations = quotationMapper.selectByExample(example);
            if(quotations.size()!=0){
                commissionRecordVo.setTradeName(quotations.get(0).getTradeName());
            }
            recordVos.add(commissionRecordVo);
        });

        PageInfo<CommissionChangeRecord> pageInfo = new PageInfo<>(list);
        return ResponseUtil.getListResponseVO(recordVos,pageInfo.getTotal());
    }
}
