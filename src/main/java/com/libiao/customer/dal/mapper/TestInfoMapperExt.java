package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.SplitInfo;
import com.libiao.customer.model.test.TestInfoVO;
import com.libiao.customer.model.work.CheckItemReq;
import com.libiao.customer.model.work.CheckItemVO;

import java.util.List;

public interface TestInfoMapperExt {

    List<TestInfoVO> getTestInfo(Integer itemId);

    List<SplitInfo> getTotalSplitInfo();

    List<CheckItemVO> getComCheckItemList(CheckItemReq req);

    String getDirectorByGoodsId(Long goodsId);
}
