package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestWorkOrder;
import java.util.List;

public interface TestWorkOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestWorkOrder row);

    TestWorkOrder selectByPrimaryKey(Long id);

    List<TestWorkOrder> selectAll();

    List<TestWorkOrder> selectByEmployee(String employee);

    int updateByPrimaryKey(TestWorkOrder row);

    List<TestWorkOrder> queryTestWorkOrderByTestTradeId(Long testTradeId);

    List<TestWorkOrder> selectAllByOwner(String owner);
}