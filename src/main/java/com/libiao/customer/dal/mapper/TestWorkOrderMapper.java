package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestWorkOrder;
import com.libiao.customer.dal.model.TestWorkOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestWorkOrderMapper {
    long countByExample(TestWorkOrderExample example);

    int deleteByExample(TestWorkOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestWorkOrder row);

    int insertSelective(TestWorkOrder row);

    List<TestWorkOrder> selectByExample(TestWorkOrderExample example);

    TestWorkOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestWorkOrder row, @Param("example") TestWorkOrderExample example);

    int updateByExample(@Param("row") TestWorkOrder row, @Param("example") TestWorkOrderExample example);

    int updateByPrimaryKeySelective(TestWorkOrder row);

    int updateByPrimaryKey(TestWorkOrder row);
}