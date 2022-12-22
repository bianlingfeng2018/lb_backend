package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.ClientBillIncome;
import java.util.List;

public interface ClientBillIncomeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientBillIncome row);

    ClientBillIncome selectByPrimaryKey(Long id);

    List<ClientBillIncome> selectAll();

    int updateByPrimaryKey(ClientBillIncome row);
}