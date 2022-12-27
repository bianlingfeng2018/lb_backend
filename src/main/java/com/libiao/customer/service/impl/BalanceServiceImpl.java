package com.libiao.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.BalanceInfoMapper;
import com.libiao.customer.dal.mapper.BalanceMapper;
import com.libiao.customer.dal.mapper.ClientMapper;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.balance.BalanceListReq;
import com.libiao.customer.model.balance.BalanceReq;
import com.libiao.customer.repository.ClientRepository;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.service.ClientService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    BalanceMapper balanceMapper;

    @Autowired
    BalanceInfoMapper balanceInfoMapper;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Balance getBalance(String clientId) {
        BalanceExample balanceExample = new BalanceExample();
        balanceExample.createCriteria().andClientIdEqualTo(clientId);
        List<Balance> list = balanceMapper.selectByExample(balanceExample);
        log.info("getBalance list={}",list);
        if(list.size() !=1){
            return null;
        }
        return list.get(0);
    }

    @Override
    public PageInfo<Balance> getBalanceList(BalanceListReq listReq) {
//        ClientExample clientExample = new ClientExample();
//        ClientExample.Criteria criteria =  clientExample.createCriteria();
//        ClientExample.Criteria criteria2 =  clientExample.createCriteria();
//        if(null != listReq.getClient()){
//            criteria.andClientNumLike(listReq.getClient());
//            criteria2.andNameLike(listReq.getClient());
//        }
//
//        if(null !=listReq.getStartTime() && null !=listReq.getEndTime()){ //时间是varchar类型？
////            criteria.andReserveDaysBetween(listReq.getStartTime(),listReq.getEndTime());
////            criteria2.andReserveDaysBetween(listReq.getStartTime(),listReq.getEndTime());
//        }
//        clientExample.or(criteria2);
//        List<Client> clients = clientMapper.selectByExample(clientExample);
        ClientParamVO paramVO = new ClientParamVO();
        paramVO.setCnameOrAbbr(listReq.getClient());
        List<Client> clients = clientRepository.selectAllByCondition(paramVO);
//        List<Client> clients = vo.getData();
        if(clients.size() == 0) return new PageInfo<>(new ArrayList<>());

        List<String> clientIds = new ArrayList<>();
        clients.forEach(client -> clientIds.add(client.getClientNum()));
        PageHelper.startPage(listReq.getPage(),listReq.getPageSize());
        BalanceExample balanceExample = new BalanceExample();
        balanceExample.createCriteria().andClientIdIn(clientIds);
        List<Balance> balances = balanceMapper.selectByExample(balanceExample);
        return new PageInfo<>(balances);
    }


    @Override
    public boolean addRecord(BalanceReq req) {
        Balance balance = BeanCopyUtil.copy(req,Balance.class);
        int row = balanceMapper.insertSelective(balance);
        return row == 1;
    }

    @Override
    public ResponseEntity updateRecord(BalanceReq req) {
        log.info("开始查询余额记录：clientID = {},id={}",req.getClientId(),req.getId());
       Balance balance = null;
        if(null!=req.getId()){
           balance = balanceMapper.selectByPrimaryKey(req.getId());
        }else {
            BalanceExample balanceExample = new BalanceExample();
            balanceExample.createCriteria().andClientIdEqualTo(req.getClientId());
            List<Balance> list = balanceMapper.selectByExample(balanceExample);
            if(list.size() == 1){
                balance = list.get(0);
            }
        }
        if(null == balance) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"记录不存在");
        Balance bean = BeanCopyUtil.copy(req,Balance.class);
        bean.setId(balance.getId());
        int row = balanceMapper.updateByPrimaryKeySelective(bean);
        if(row != 1) return ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR,"系统错误");
        return ResponseUtil.getDefaultResp();
    }

    @Override
    public boolean addInfo(BalanceInfo info) {
       int row = balanceInfoMapper.insertSelective(info);
        return row == 1;
    }

    @Override
    public List<BalanceInfo> getBalanceInfoList(String clientId) {
        BalanceInfoExample balanceExample = new BalanceInfoExample();
        balanceExample.createCriteria().andClientIdEqualTo(clientId);
        return  balanceInfoMapper.selectByExample(balanceExample);
    }
}
