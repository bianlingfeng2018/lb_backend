package com.libiao.customer.service.impl;

import com.libiao.customer.dal.mapper.TestInfoMapperExt;
import com.libiao.customer.model.test.TestInfoVO;
import com.libiao.customer.service.TestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestInfoServiceImpl implements TestInfoService {

    @Autowired
    private TestInfoMapperExt testInfoMapperExt;

    @Override
    public List<TestInfoVO> getTestInfo(Integer itemId){
        List<TestInfoVO> testInfo = testInfoMapperExt.getTestInfo(itemId);
        return testInfo;
    }

}
