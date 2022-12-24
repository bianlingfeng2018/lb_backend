package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.CommissionChangeRecord;
import com.libiao.customer.dal.model.CommissionChangeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommissionChangeRecordMapper {
    long countByExample(CommissionChangeRecordExample example);

    int deleteByExample(CommissionChangeRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommissionChangeRecord row);

    int insertSelective(CommissionChangeRecord row);

    List<CommissionChangeRecord> selectByExample(CommissionChangeRecordExample example);

    CommissionChangeRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CommissionChangeRecord row, @Param("example") CommissionChangeRecordExample example);

    int updateByExample(@Param("row") CommissionChangeRecord row, @Param("example") CommissionChangeRecordExample example);

    int updateByPrimaryKeySelective(CommissionChangeRecord row);

    int updateByPrimaryKey(CommissionChangeRecord row);
}