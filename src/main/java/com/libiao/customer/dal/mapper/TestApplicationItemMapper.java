package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestApplicationItem;
import com.libiao.customer.dal.model.TestApplicationItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestApplicationItemMapper {
    long countByExample(TestApplicationItemExample example);

    int deleteByExample(TestApplicationItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestApplicationItem row);

    int insertSelective(TestApplicationItem row);

    List<TestApplicationItem> selectByExample(TestApplicationItemExample example);

    TestApplicationItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestApplicationItem row, @Param("example") TestApplicationItemExample example);

    int updateByExample(@Param("row") TestApplicationItem row, @Param("example") TestApplicationItemExample example);

    int updateByPrimaryKeySelective(TestApplicationItem row);

    int updateByPrimaryKey(TestApplicationItem row);
}