package com.libiao.customer.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.libiao.customer.dal.mapper.BasicGoodsClassMapper;
import com.libiao.customer.dal.mapper.BasicGoodsMaterialMapper;
import com.libiao.customer.dal.mapper.BasicHscodeMapper;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.repository.BasicCountryRepository;
import com.libiao.customer.repository.BasicStandardRepository;
import com.libiao.customer.repository.BasicTestItemRepository;
import com.libiao.customer.service.BasicService;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

  @Autowired
  BasicGoodsClassMapper goodsClassMapper;
  @Autowired
  BasicGoodsMaterialMapper goodsMaterialMapper;
  @Autowired
  BasicHscodeMapper hscodeMapper;

  @Override
  public ResponseVO<?> getAllTestItems() {
    try {
      List<BasicTestItem> testItems = basicTestItemRepository.selectAll();
      List<BasicTestItemGroupVO> result = Lists.newArrayList();

      Map<String, List<BasicTestItem>> map = Maps.newHashMap();
      for (BasicTestItem testItem : testItems) {
        String method = testItem.getExt1();
        String key = method == null ? "?????????" : method;
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

  @Override
  public ResponseEntity<List<BasicGoodsClass>> getAllGoodsClass() {
    return ResponseUtil.getResponseVO(goodsClassMapper.selectByExample(new BasicGoodsClassExample()));
  }

  @Override
  public ResponseEntity<List<BasicGoodsMaterial>> getAllGoodsMaterial() {
    return  ResponseUtil.getResponseVO(goodsMaterialMapper.selectByExample(new BasicGoodsMaterialExample()));
  }

  @Override
  public ResponseEntity<List<BasicHscode>> getAllHSCode() {
    return  ResponseUtil.getResponseVO(hscodeMapper.selectByExample(new BasicHscodeExample()));
  }


}
