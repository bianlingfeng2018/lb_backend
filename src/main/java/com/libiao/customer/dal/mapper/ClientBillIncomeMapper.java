package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.ClientBillIncome;
import com.libiao.customer.dal.model.ClientBillIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientBillIncomeMapper {
    long countByExample(ClientBillIncomeExample example);

    int deleteByExample(ClientBillIncomeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClientBillIncome row);

    int insertSelective(ClientBillIncome row);

    List<ClientBillIncome> selectByExample(ClientBillIncomeExample example);

    ClientBillIncome selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") ClientBillIncome row, @Param("example") ClientBillIncomeExample example);

    int updateByExample(@Param("row") ClientBillIncome row, @Param("example") ClientBillIncomeExample example);

    int updateByPrimaryKeySelective(ClientBillIncome row);

    int updateByPrimaryKey(ClientBillIncome row);
}