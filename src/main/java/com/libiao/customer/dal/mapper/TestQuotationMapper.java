package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestQuotation;
import java.util.List;

public interface TestQuotationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestQuotation row);

    TestQuotation selectByPrimaryKey(Long id);

    List<TestQuotation> selectAll();

    int updateByPrimaryKey(TestQuotation row);

    List<TestQuotation> selectByEmployee(String employee); // 根据用户名来过滤

    List<TestQuotation> selectAllByOwner(String employee);

    List<TestQuotation> queryTestQuotationByTestTradeId(Long testTradeId);
}