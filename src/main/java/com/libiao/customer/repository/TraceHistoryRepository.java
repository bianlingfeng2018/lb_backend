package com.libiao.customer.repository;

import com.libiao.customer.dal.model.TraceHistory;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;

public interface TraceHistoryRepository {

  int insertTraceHistory(TraceHistory history);

  List<TraceHistory> findAllByClientId(Long id);
}
