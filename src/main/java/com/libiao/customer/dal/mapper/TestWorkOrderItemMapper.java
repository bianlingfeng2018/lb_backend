package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestWorkOrderItem;
import com.libiao.customer.dal.model.TestWorkOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestWorkOrderItemMapper {
    long countByExample(TestWorkOrderItemExample example);

    int deleteByExample(TestWorkOrderItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestWorkOrderItem row);

    int insertSelective(TestWorkOrderItem row);

    List<TestWorkOrderItem> selectByExample(TestWorkOrderItemExample example);

    TestWorkOrderItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestWorkOrderItem row, @Param("example") TestWorkOrderItemExample example);

    int updateByExample(@Param("row") TestWorkOrderItem row, @Param("example") TestWorkOrderItemExample example);

    int updateByPrimaryKeySelective(TestWorkOrderItem row);

    int updateByPrimaryKey(TestWorkOrderItem row);
}