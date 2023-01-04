package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TestQuotation;
import com.libiao.customer.dal.model.TestQuotationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestQuotationMapper {
    long countByExample(TestQuotationExample example);

    int deleteByExample(TestQuotationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestQuotation row);

    int insertSelective(TestQuotation row);

    List<TestQuotation> selectByExample(TestQuotationExample example);

    TestQuotation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestQuotation row, @Param("example") TestQuotationExample example);

    int updateByExample(@Param("row") TestQuotation row, @Param("example") TestQuotationExample example);

    int updateByPrimaryKeySelective(TestQuotation row);

    int updateByPrimaryKey(TestQuotation row);
}