package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestApplicationForm;
import com.libiao.customer.dal.model.TestApplicationFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestApplicationFormMapper {
    long countByExample(TestApplicationFormExample example);

    int deleteByExample(TestApplicationFormExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestApplicationForm row);

    int insertSelective(TestApplicationForm row);

    List<TestApplicationForm> selectByExample(TestApplicationFormExample example);

    TestApplicationForm selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestApplicationForm row, @Param("example") TestApplicationFormExample example);

    int updateByExample(@Param("row") TestApplicationForm row, @Param("example") TestApplicationFormExample example);

    int updateByPrimaryKeySelective(TestApplicationForm row);

    int updateByPrimaryKey(TestApplicationForm row);
}