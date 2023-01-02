package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestWorkOrderSample;
import com.libiao.customer.dal.model.TestWorkOrderSampleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestWorkOrderSampleMapper {
    long countByExample(TestWorkOrderSampleExample example);

    int deleteByExample(TestWorkOrderSampleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestWorkOrderSample row);

    int insertSelective(TestWorkOrderSample row);

    List<TestWorkOrderSample> selectByExample(TestWorkOrderSampleExample example);

    TestWorkOrderSample selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestWorkOrderSample row, @Param("example") TestWorkOrderSampleExample example);

    int updateByExample(@Param("row") TestWorkOrderSample row, @Param("example") TestWorkOrderSampleExample example);

    int updateByPrimaryKeySelective(TestWorkOrderSample row);

    int updateByPrimaryKey(TestWorkOrderSample row);
}