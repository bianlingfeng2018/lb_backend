package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.DeviceItemRel;
import com.libiao.customer.dal.model.DeviceItemRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceItemRelMapper {
    long countByExample(DeviceItemRelExample example);

    int deleteByExample(DeviceItemRelExample example);

    int deleteByPrimaryKey(@Param("deviceId") Long deviceId, @Param("itemId") Integer itemId);

    int insert(DeviceItemRel row);

    int insertSelective(DeviceItemRel row);

    List<DeviceItemRel> selectByExample(DeviceItemRelExample example);

    DeviceItemRel selectByPrimaryKey(@Param("deviceId") Long deviceId, @Param("itemId") Integer itemId);

    int updateByExampleSelective(@Param("row") DeviceItemRel row, @Param("example") DeviceItemRelExample example);

    int updateByExample(@Param("row") DeviceItemRel row, @Param("example") DeviceItemRelExample example);

    int updateByPrimaryKeySelective(DeviceItemRel row);

    int updateByPrimaryKey(DeviceItemRel row);
}