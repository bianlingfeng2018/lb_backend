package com.libiao.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.CustomerBillMapper;
import com.libiao.customer.dal.model.CustomerBill;
import com.libiao.customer.dal.model.CustomerBillExample;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.bill.CustomerBillListReq;
import com.libiao.customer.model.bill.CustomerBillReq;
import com.libiao.customer.service.CustomerBillService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CustomerBillServiceImpl implements CustomerBillService {

    @Autowired
    CustomerBillMapper billMapper;

    @Override
    public ResponseEntity<ListResponseVO<CustomerBill>> list(CustomerBillListReq req) {
        PageHelper.startPage(req.getPage(), req.getPageSize());
        CustomerBillExample example = new CustomerBillExample();
        CustomerBillExample.Criteria criteria = example.createCriteria();
        if (null != req.getClientId()) {
            criteria.andClientIdEqualTo(req.getClientId());
        }
        if (null != req.getStatus()) {
            criteria.andStatusEqualTo(req.getStatus());
        }
        if (null != req.getEndTime() && null != req.getStartTime()) {
            criteria.andOperTimeBetween(req.getStartTime(), req.getEndTime());
        }
        if (null != req.getUploadStartTime() && null != req.getUploadEndTime()) {
            criteria.andUploadTimeBetween(req.getUploadStartTime(), req.getUploadEndTime());
        }
        List list = billMapper.selectByExample(example);
        PageInfo<CustomerBill> pageInfo = new PageInfo<CustomerBill>(list);
        return ResponseUtil.getListResponseVO(pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public ResponseEntity getOne(Long id) {
        CustomerBill bill = billMapper.selectByPrimaryKey(id);
        if(null == bill) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"记录不存在");
        return ResponseUtil.getResponseVO(bill);
    }

    @Override
    public ResponseEntity add(CustomerBillReq req) {
        CustomerBill bill = BeanCopyUtil.copy(req,CustomerBill.class);
        int row = billMapper.insertSelective(bill);
        if(row !=1) return ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR,"系统错误");
        return ResponseUtil.getDefaultResp();
    }

    @Override
    public ResponseEntity update(CustomerBillReq req) {
        CustomerBillExample example = new CustomerBillExample();
        example.createCriteria().andIdEqualTo(req.getId()).andClientIdEqualTo(req.getClientId());
        List<CustomerBill> list = billMapper.selectByExample(example);
        if(list.size()!=1) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"记录不存在或有多条记录");
        CustomerBill customerBill = BeanCopyUtil.copy(req,CustomerBill.class);
        customerBill.setId(list.get(0).getId());
        customerBill.setStatus(req.getStatus());
        customerBill.setOperUser(String.valueOf(req.getUser().getId()));
        customerBill.setOperTime(new Date());
        int row = billMapper.updateByPrimaryKeySelective(customerBill);
        if(row !=1) return ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR,"系统错误");
        return ResponseUtil.getDefaultResp();
    }
}
