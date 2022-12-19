package com.libiao.customer.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.libiao.customer.dal.model.BasicStandard;
import com.libiao.customer.dal.model.BasicTestItem;
import com.libiao.customer.dal.model.BasicTestItemGroupVO;
import com.libiao.customer.repository.BasicCountryRepository;
import com.libiao.customer.repository.BasicStandardRepository;
import com.libiao.customer.repository.BasicTestItemRepository;
import com.libiao.customer.service.BasicService;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.stereotype.Service;

@Service
public class BasicServiceImpl implements BasicService {

  private final BasicTestItemRepository basicTestItemRepository;
  private final BasicCountryRepository basicCountryRepository;
  private final BasicStandardRepository basicStandardRepository;


  public BasicServiceImpl(BasicTestItemRepository basicTestItemRepository,
      BasicCountryRepository basicCountryRepository,
      BasicStandardRepository basicStandardRepository) {
    this.basicTestItemRepository = basicTestItemRepository;
    this.basicCountryRepository = basicCountryRepository;
    this.basicStandardRepository = basicStandardRepository;
  }

  @Override
  public ResponseVO<?> getAllTestItems() {
    try {
      List<BasicTestItem> testItems = basicTestItemRepository.selectAll();
      List<BasicTestItemGroupVO> result = Lists.newArrayList();

      Map<String, List<BasicTestItem>> map = Maps.newHashMap();
      for (BasicTestItem testItem : testItems) {
        String method = testItem.getExt1();
        String key = method == null ? "未分组" : method;
        List<BasicTestItem> list = null;
        if (map.containsKey(key)) {
          list = map.get(key);
        } else {
          list = Lists.newArrayList();
          map.put(key, list);
        }
        list.add(testItem);
      }

      for (Entry<String, List<BasicTestItem>> entry : map.entrySet()) {
        result.add(new BasicTestItemGroupVO(entry.getValue(), entry.getKey(), Lists.newArrayList()));
      }
      return ResponseUtil.success(result);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> getAllStandards() {
    try {
      List<BasicStandard> list = basicStandardRepository.selectAll();
      return ResponseUtil.success(list);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }
}
