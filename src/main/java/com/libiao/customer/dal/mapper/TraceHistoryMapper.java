package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.TraceHistory;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;

public interface TraceHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TraceHistory row);

    TraceHistory selectByPrimaryKey(Long id);

    List<TraceHistory> selectAll();

    int updateByPrimaryKey(TraceHistory row);

    List<TraceHistory> selectByClientId(Long id);
}