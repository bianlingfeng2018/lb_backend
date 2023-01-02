package com.libiao.customer.service;

import com.libiao.customer.model.test.TestInfoVO;

import java.util.List;

public interface TestInfoService {
    List<TestInfoVO> getTestInfo(Integer itemId);
}
