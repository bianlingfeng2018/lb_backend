package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestQuotationItem;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestQuotationItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestQuotationItem row);

    TestQuotationItem selectByPrimaryKey(Long id);

    List<TestQuotationItem> selectByTestQuotationId(Long testQuotationId);

    List<TestQuotationItem> selectAll();

    int updateByPrimaryKey(TestQuotationItem row);

    int batchInsert(@Param("testQuotationItemList") List<TestQuotationItem> testQuotationItemList); // 批量插入
}