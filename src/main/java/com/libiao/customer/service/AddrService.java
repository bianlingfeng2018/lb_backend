package com.libiao.customer.service;

import com.libiao.customer.dal.model.TfArea;
import java.util.List;

public interface AddrService {

  List<TfArea> findAllProvince();

  List<TfArea> findAllCityByProvinceId(String code);

  List<TfArea> findAllAreaByCityId(String code);

  TfArea findAreaById(String id);
}
