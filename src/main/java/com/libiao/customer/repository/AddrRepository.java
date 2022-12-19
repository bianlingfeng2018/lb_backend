package com.libiao.customer.repository;

import com.libiao.customer.dal.model.TfArea;
import java.util.List;

public interface AddrRepository {

  List<TfArea> findByPidAndLevel(int pid, int level);

  TfArea findById(int id);
}
