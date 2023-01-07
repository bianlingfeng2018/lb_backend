package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.BasicStandardLevel;
import com.libiao.customer.dal.model.BasicStandardLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasicStandardLevelMapper {
    long countByExample(BasicStandardLevelExample example);

    int deleteByExample(BasicStandardLevelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BasicStandardLevel row);

    int insertSelective(BasicStandardLevel row);

    List<BasicStandardLevel> selectByExample(BasicStandardLevelExample example);

    BasicStandardLevel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") BasicStandardLevel row, @Param("example") BasicStandardLevelExample example);

    int updateByExample(@Param("row") BasicStandardLevel row, @Param("example") BasicStandardLevelExample example);

    int updateByPrimaryKeySelective(BasicStandardLevel row);

    int updateByPrimaryKey(BasicStandardLevel row);
}