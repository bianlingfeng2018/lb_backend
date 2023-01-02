package com.libiao.customer.controller;

import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.test.TestInfoVO;
import com.libiao.customer.model.test.TestItemReq;
import com.libiao.customer.service.TestInfoService;
import com.libiao.customer.util.AccessController;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "测试相关接口")
@RequestMapping("test")
@RestController
public class TestInfoController {

    @Autowired
    private TestInfoService testInfoService;

    @ApiOperation("获取检测方法和检测条件")
    @PostMapping("getItemById")
    @AccessController
    public ResponseEntity<ListResponseVO<TestInfoVO>> getItemById(@RequestBody TestItemReq req){
        List<TestInfoVO> testInfo = testInfoService.getTestInfo(req.getItemId());
        return ResponseUtil.getListResponseVO(testInfo, testInfo.size());
    }

}
