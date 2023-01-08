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

import javax.servlet.http.HttpServletResponse;
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

    @ApiOperation(value = "上传文件")
    @GetMapping("download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response){
        fileUtil.downloadRecord(fileName,response);
    }

    @ApiOperation(value = "上传/编辑结果")
    @PostMapping("uploadResult")
    public ResponseEntity<BaseResponseVO> uploadResult(@RequestBody UploadTestResultReq req){
        oriRecordService.upload(req);
        return ResponseUtil.getDefaultResp();
    }

    @ApiOperation(value = "获取测试信息")
    @PostMapping("test/info")
    public ResponseEntity<TestItemInfoVO> testInfo(@RequestBody TestItemInfoReq req){
        TestItemInfoVO testItemInfoVO = oriRecordService.testInfo(req);
        return ResponseUtil.getResponseVO(testItemInfoVO);
    }

    @ApiOperation(value = "分配")
    @PostMapping("assignment")
    public ResponseEntity<BaseResponseVO> assignment(@RequestBody AssignmentReq req){
        oriRecordService.assignment(req);
        return ResponseUtil.getDefaultResp();
    }
}
