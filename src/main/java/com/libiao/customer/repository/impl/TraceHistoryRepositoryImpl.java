package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.TraceHistoryMapper;
import com.libiao.customer.dal.model.TraceHistory;
import com.libiao.customer.repository.TraceHistoryRepository;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author Lingfeng
 */
@Repository
public class TraceHistoryRepositoryImpl implements TraceHistoryRepository {

  final
  TraceHistoryMapper traceHistoryMapper;

  public TraceHistoryRepositoryImpl(TraceHistoryMapper traceHistoryMapper) {
    this.traceHistoryMapper = traceHistoryMapper;
  }

  @Override
  public int insertTraceHistory(TraceHistory history) {
    return traceHistoryMapper.insert(history);
  }

  @Override
  public List<TraceHistory> findAllByClientId(Long id) {
    return traceHistoryMapper.selectByClientId(id);
  }
}
