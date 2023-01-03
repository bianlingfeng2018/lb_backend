package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestOriRecord;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.ori.OriRecordDetailReq;
import com.libiao.customer.model.ori.OriRecordDetailVO;
import com.libiao.customer.model.ori.OriRecordListReq;
import com.libiao.customer.model.ori.OriRecordListVO;
import com.libiao.customer.service.OriRecordService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "原始记录单")
@RestController
@RequestMapping("ori")
public class OriRecordController {

    @Autowired
    private OriRecordService oriRecordService;

    @PostMapping("list")
    @ApiOperation("原始记录单列表")
    public ResponseEntity<ListResponseVO<OriRecordListVO>> list(@RequestBody OriRecordListReq req){
        final PageInfo<TestOriRecord> list = oriRecordService.list(req);
        List<OriRecordListVO> voList = new ArrayList<>();
        list.getList().forEach(record->voList.add(BeanCopyUtil.copy(record,OriRecordListVO.class)));
        return ResponseUtil.getListResponseVO(voList,list.getTotal());
    }

    @PostMapping("detail")
    @ApiOperation("原始记录单详情")
    public ResponseEntity<OriRecordDetailVO> detail(@RequestBody OriRecordDetailReq req){
        final OriRecordDetailVO detail = oriRecordService.detail(req);
        return ResponseUtil.getResponseVO(detail);
    }

}
