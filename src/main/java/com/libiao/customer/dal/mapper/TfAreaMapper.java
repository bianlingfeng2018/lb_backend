package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TfArea;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TfAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TfArea row);

    TfArea selectByPrimaryKey(Integer id);

    List<TfArea> selectAll();

    int updateByPrimaryKey(TfArea row);

  List<TfArea> selectByPidAndLevel(@Param("pid") int pid, @Param("level") int level);
}