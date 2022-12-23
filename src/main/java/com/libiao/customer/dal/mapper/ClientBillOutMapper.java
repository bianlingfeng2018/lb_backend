package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.ClientBillOut;
import com.libiao.customer.dal.model.ClientBillOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientBillOutMapper {
    long countByExample(ClientBillOutExample example);

    int deleteByExample(ClientBillOutExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClientBillOut row);

    int insertSelective(ClientBillOut row);

    List<ClientBillOut> selectByExample(ClientBillOutExample example);

    ClientBillOut selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") ClientBillOut row, @Param("example") ClientBillOutExample example);

    int updateByExample(@Param("row") ClientBillOut row, @Param("example") ClientBillOutExample example);

    int updateByPrimaryKeySelective(ClientBillOut row);

    int updateByPrimaryKey(ClientBillOut row);
}