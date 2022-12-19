package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestWorkOrderItem;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestWorkOrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestWorkOrderItem row);

    TestWorkOrderItem selectByPrimaryKey(Long id);

    List<TestWorkOrderItem> selectAll();

    List<TestWorkOrderItem> selectByTestWorkOrderId(Long testWorkOrderId);

    int updateByPrimaryKey(TestWorkOrderItem row);

    int batchInsert(@Param("testWorkOrderItemList")List<TestWorkOrderItem> testWorkOrderItemList);
}