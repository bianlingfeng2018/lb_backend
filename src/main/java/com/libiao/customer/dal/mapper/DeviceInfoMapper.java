package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.DeviceInfo;
import com.libiao.customer.dal.model.DeviceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceInfoMapper {
    long countByExample(DeviceInfoExample example);

    int deleteByExample(DeviceInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeviceInfo row);

    int insertSelective(DeviceInfo row);

    List<DeviceInfo> selectByExample(DeviceInfoExample example);

    DeviceInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") DeviceInfo row, @Param("example") DeviceInfoExample example);

    int updateByExample(@Param("row") DeviceInfo row, @Param("example") DeviceInfoExample example);

    int updateByPrimaryKeySelective(DeviceInfo row);

    int updateByPrimaryKey(DeviceInfo row);
}