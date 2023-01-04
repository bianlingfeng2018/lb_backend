package com.libiao.customer.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.constant.QuotationEnum;
import com.libiao.customer.dal.mapper.ClientMapper;
import com.libiao.customer.dal.mapper.CustomerBillMapper;
import com.libiao.customer.dal.mapper.TestQuotationMapper;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.bill.CustomerBillListReq;
import com.libiao.customer.model.bill.CustomerBillReq;
import com.libiao.customer.model.bill.CustomerBillVo;
import com.libiao.customer.service.ClientService;
import com.libiao.customer.service.CustomerBillService;
import com.libiao.customer.service.CustomerService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CustomerBillServiceImpl implements CustomerBillService {

    @Autowired
    CustomerBillMapper billMapper;
    @Autowired
    CustomerService customerService;
    @Autowired
    TestQuotationMapper quotationMapper;

    @Autowired
    private CustomerBillMapper customerBillMapper;
    @Autowired
    private TestQuotationMapper testQuotationMapper;


    @Override
    public ResponseEntity<ListResponseVO<CustomerBillVo>> list(CustomerBillListReq req) {
        PageHelper.startPage(req.getPage(), req.getPageSize());
        CustomerBillExample example = new CustomerBillExample();
        CustomerBillExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(req.getClientId())) {
            criteria.andClientIdEqualTo(req.getClientId());
        }
        if (req.getStatus() != null) {
            criteria.andStatusEqualTo(req.getStatus());
        }
        if (null != req.getEndTime() && null != req.getStartTime()) {
            criteria.andOperTimeBetween(req.getStartTime(), req.getEndTime());
        }
        if (null != req.getUploadStartTime() && null != req.getUploadEndTime()) {
            criteria.andUploadTimeBetween(req.getUploadStartTime(), req.getUploadEndTime());
        }
        List<CustomerBill> list = billMapper.selectByExample(example);
        PageInfo<CustomerBill> pageInfo = new PageInfo<>(list);
        List<CustomerBillVo> billVos = new ArrayList<>();
        pageInfo.getList().forEach(bill->{
            CustomerBillVo vo = BeanCopyUtil.copy(bill,CustomerBillVo.class);
            Client client = customerService.getClientByClientId(bill.getClientId());
            if(null!=client){
                vo.setClientName(client.getName());
            }
            TestQuotationExample quotationExample = new TestQuotationExample();
            quotationExample.createCriteria().andQuotationNumEqualTo(bill.getTradeId());
            List<TestQuotation> quotations = quotationMapper.selectByExample(quotationExample);
            if(quotations.size()!=0){
                vo.setTradeName(quotations.get(0).getTradeName());
            }
            billVos.add(vo);
        });

        return ResponseUtil.getListResponseVO(billVos, pageInfo.getTotal());
    }

    @Override
    public ResponseEntity getOne(Long id) {
        CustomerBill bill = billMapper.selectByPrimaryKey(id);
        if(null == bill) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"记录不存在");
        CustomerBillVo vo = BeanCopyUtil.copy(bill,CustomerBillVo.class);
        Client client = customerService.getClientByClientId(bill.getClientId());
        if(null!=client){
            vo.setClientName(client.getName());
        }
        TestQuotationExample quotationExample = new TestQuotationExample();
        quotationExample.createCriteria().andQuotationNumEqualTo(bill.getTradeId());
        List<TestQuotation> quotations = quotationMapper.selectByExample(quotationExample);
        if(quotations.size()!=0){
            vo.setTradeName(quotations.get(0).getTradeName());
        }
        return ResponseUtil.getResponseVO(vo);
    }

    @Override
    public ResponseEntity add(CustomerBillReq req) {
        CustomerBill bill = BeanCopyUtil.copy(req,CustomerBill.class);
        int row = billMapper.insertSelective(bill);
        if(row !=1) return ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR,"系统错误");
        return ResponseUtil.getDefaultResp();
    }

    @Override
    public ResponseEntity<BaseResponseVO> update(CustomerBillReq req) {
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

        //根据核销单找到报价单
        TestQuotationExample qExample = new TestQuotationExample();
        qExample.createCriteria().andQuotationNumEqualTo(customerBill.getTradeId());
        final List<TestQuotation> testQuotations = testQuotationMapper.selectByExample(qExample);
        if (!CollectionUtils.isEmpty(testQuotations)){
            final TestQuotation testQuotation = testQuotations.get(0);
            final Integer totalCost = testQuotation.getTotalCost();
            final Integer paidAmt = testQuotation.getPaidAmt();
            int operAmount = req.getIncomeAmt().intValue();
            TestQuotation update = new TestQuotation();
            update.setId(testQuotation.getId());
            update.setPaidAmt(paidAmt+operAmount);
            if (totalCost > paidAmt + operAmount){
                //已付部分
                update.setPayStatus(QuotationEnum.PART_PAID.getCode());
            }else {
                //已经全付
                update.setPayStatus(QuotationEnum.TOTAL_PAID.getCode());
            }
            testQuotationMapper.updateByPrimaryKeySelective(update);
        }

        return ResponseUtil.getDefaultResp();
    }
}
