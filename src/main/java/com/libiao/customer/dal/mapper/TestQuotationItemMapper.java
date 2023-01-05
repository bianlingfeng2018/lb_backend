package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestQuotationItem;
import com.libiao.customer.dal.model.TestQuotationItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestQuotationItemMapper {
    long countByExample(TestQuotationItemExample example);

    int deleteByExample(TestQuotationItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestQuotationItem row);

    int insertSelective(TestQuotationItem row);

    List<TestQuotationItem> selectByExample(TestQuotationItemExample example);

    TestQuotationItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestQuotationItem row, @Param("example") TestQuotationItemExample example);

    int updateByExample(@Param("row") TestQuotationItem row, @Param("example") TestQuotationItemExample example);

    int updateByPrimaryKeySelective(TestQuotationItem row);

    int updateByPrimaryKey(TestQuotationItem row);
}