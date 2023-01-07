package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.LabInfo;
import com.libiao.customer.dal.model.LabInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LabInfoMapper {
    long countByExample(LabInfoExample example);

    int deleteByExample(LabInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LabInfo row);

    int insertSelective(LabInfo row);

    List<LabInfo> selectByExample(LabInfoExample example);

    LabInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") LabInfo row, @Param("example") LabInfoExample example);

    int updateByExample(@Param("row") LabInfo row, @Param("example") LabInfoExample example);

    int updateByPrimaryKeySelective(LabInfo row);

    int updateByPrimaryKey(LabInfo row);
}