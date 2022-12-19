package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.TfAreaMapper;
import com.libiao.customer.dal.model.TfArea;
import com.libiao.customer.repository.AddrRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Lingfeng
 */
@Repository
public class AddrRepositoryImpl implements AddrRepository {
  private final TfAreaMapper areaMapper;

  public AddrRepositoryImpl(TfAreaMapper areaMapper) {
    this.areaMapper = areaMapper;
  }

  @Override
  public List<TfArea> findByPidAndLevel(int pid, int level) {
    return areaMapper.selectByPidAndLevel(pid, level);
  }

  @Override
  public TfArea findById(int id) {
    return areaMapper.selectByPrimaryKey(id);
  }
}
