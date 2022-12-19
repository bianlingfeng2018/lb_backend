package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestApplicationForm;
import java.util.List;

public interface TestApplicationFormMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestApplicationForm row);

    TestApplicationForm selectByPrimaryKey(Long id);

    List<TestApplicationForm> selectByEmployee(String employee);

    List<TestApplicationForm> selectAll();

    int updateByPrimaryKey(TestApplicationForm row);

    List<TestApplicationForm> queryTestApplicationFormByTestTradeId(Long testTradeId);

    List<TestApplicationForm> selectAllByOwner(String owner);
}