package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.BasicStandard;
import com.libiao.customer.dal.model.BasicStandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasicStandardMapper {
    long countByExample(BasicStandardExample example);

    int deleteByExample(BasicStandardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BasicStandard row);

    int insertSelective(BasicStandard row);

    List<BasicStandard> selectByExample(BasicStandardExample example);

    BasicStandard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") BasicStandard row, @Param("example") BasicStandardExample example);

    int updateByExample(@Param("row") BasicStandard row, @Param("example") BasicStandardExample example);

    int updateByPrimaryKeySelective(BasicStandard row);

    int updateByPrimaryKey(BasicStandard row);
}