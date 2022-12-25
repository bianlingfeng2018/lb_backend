package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.CustomerBill;
import com.libiao.customer.dal.model.CustomerBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerBillMapper {
    long countByExample(CustomerBillExample example);

    int deleteByExample(CustomerBillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustomerBill row);

    int insertSelective(CustomerBill row);

    List<CustomerBill> selectByExample(CustomerBillExample example);

    CustomerBill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CustomerBill row, @Param("example") CustomerBillExample example);

    int updateByExample(@Param("row") CustomerBill row, @Param("example") CustomerBillExample example);

    int updateByPrimaryKeySelective(CustomerBill row);

    int updateByPrimaryKey(CustomerBill row);
}