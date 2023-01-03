package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestRecordSubItem;
import com.libiao.customer.dal.model.TestRecordSubItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestRecordSubItemMapper {
    long countByExample(TestRecordSubItemExample example);

    int deleteByExample(TestRecordSubItemExample example);

    int insert(TestRecordSubItem row);

    int insertSelective(TestRecordSubItem row);

    List<TestRecordSubItem> selectByExample(TestRecordSubItemExample example);

    int updateByExampleSelective(@Param("row") TestRecordSubItem row, @Param("example") TestRecordSubItemExample example);

    int updateByExample(@Param("row") TestRecordSubItem row, @Param("example") TestRecordSubItemExample example);
}