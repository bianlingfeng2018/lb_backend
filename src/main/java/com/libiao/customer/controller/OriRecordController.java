package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.TestOriRecord;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.ori.*;
import com.libiao.customer.service.OriRecordService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.DateUtils;
import com.libiao.customer.util.FileUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "原始记录单")
@RestController
@RequestMapping("ori")
public class OriRecordController {

    @Autowired
    private OriRecordService oriRecordService;
    @Autowired
    private FileUtil fileUtil;

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

    @PostMapping("review")
    @ApiOperation("审核原始记录单")
    public ResponseEntity<BaseResponseVO> review(@RequestBody ReviewOriRecordReq req){
        oriRecordService.review(req);
        return ResponseUtil.getDefaultResp();
    }

    @ApiOperation(value = "上传文件")
    @PostMapping("upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
        String fileName = fileUtil.saveRecord(file, DateUtils.getDate("yyyyHHmm"));
        return ResponseUtil.getResponseVO(fileName);
    }

    //上传结果
    public void result(){

    }

}
