package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.ClientBillOut;
import java.util.List;

public interface ClientBillOutMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientBillOut row);

    ClientBillOut selectByPrimaryKey(Long id);

    List<ClientBillOut> selectAll();

    int updateByPrimaryKey(ClientBillOut row);
}