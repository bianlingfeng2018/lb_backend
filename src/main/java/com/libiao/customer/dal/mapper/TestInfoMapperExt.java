package com.libiao.customer.dal.mapper;

import com.libiao.customer.model.test.TestInfoVO;

import java.util.List;

public interface TestInfoMapperExt {

    List<TestInfoVO> getTestInfo(Integer itemId);

}
