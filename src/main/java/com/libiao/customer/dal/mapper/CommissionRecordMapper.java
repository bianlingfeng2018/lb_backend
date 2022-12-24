package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.CommissionRecord;
import com.libiao.customer.dal.model.CommissionRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommissionRecordMapper {
    long countByExample(CommissionRecordExample example);

    int deleteByExample(CommissionRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommissionRecord row);

    int insertSelective(CommissionRecord row);

    List<CommissionRecord> selectByExample(CommissionRecordExample example);

    CommissionRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CommissionRecord row, @Param("example") CommissionRecordExample example);

    int updateByExample(@Param("row") CommissionRecord row, @Param("example") CommissionRecordExample example);

    int updateByPrimaryKeySelective(CommissionRecord row);

    int updateByPrimaryKey(CommissionRecord row);
}