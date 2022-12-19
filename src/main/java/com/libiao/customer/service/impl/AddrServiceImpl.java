package com.libiao.customer.service.impl;

import com.libiao.customer.dal.model.TfArea;
import com.libiao.customer.repository.AddrRepository;
import com.libiao.customer.service.AddrService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddrServiceImpl implements AddrService {

  final
  private AddrRepository addrRepository;

  public AddrServiceImpl(AddrRepository addrRepository) {
    this.addrRepository = addrRepository;
  }

  @Override
  public List<TfArea> findAllProvince() {
    return addrRepository.findByPidAndLevel(0, 1);
  }

  @Override
  public List<TfArea> findAllCityByProvinceId(String code) {
    return addrRepository.findByPidAndLevel(Integer.parseInt(code), 2);
  }

  @Override
  public List<TfArea> findAllAreaByCityId(String code) {
    return addrRepository.findByPidAndLevel(Integer.parseInt(code), 3);
  }

  @Override
  public TfArea findAreaById(String id) {
    return addrRepository.findById(Integer.parseInt(id));
  }
}
