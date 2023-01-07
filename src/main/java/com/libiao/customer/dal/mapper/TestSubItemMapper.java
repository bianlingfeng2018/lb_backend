package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestSubItem;
import com.libiao.customer.dal.model.TestSubItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestSubItemMapper {
    long countByExample(TestSubItemExample example);

    int deleteByExample(TestSubItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestSubItem row);

    int insertSelective(TestSubItem row);

    List<TestSubItem> selectByExample(TestSubItemExample example);

    TestSubItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestSubItem row, @Param("example") TestSubItemExample example);

    int updateByExample(@Param("row") TestSubItem row, @Param("example") TestSubItemExample example);

    int updateByPrimaryKeySelective(TestSubItem row);

    int updateByPrimaryKey(TestSubItem row);
}