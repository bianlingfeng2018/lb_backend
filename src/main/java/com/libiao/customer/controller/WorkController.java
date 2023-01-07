package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.CheckCompany;
import com.libiao.customer.dal.model.TestWorkOrder;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.work.*;
import com.libiao.customer.service.WorkService;
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

/**
 * 工作单相关
 * 收到样品后，自动生产工作单
 * 根据表 9 10 11 12，来确定哪个实验室的谁来负责这个工作单
 * 优先非分包商
 */
@Api(tags = "工作单相关接口")
@RequestMapping("workOrder")
@RestController
public class WorkController {

    @Autowired
    private WorkService workService;
    @Autowired
    private FileUtil fileUtil;

    @ApiOperation("工作单列表接口")
    @PostMapping("list")
    public ResponseEntity<ListResponseVO<WorkOrderListVO>> list(@RequestBody WorkOrderListReq req){
        List<WorkOrderListVO> voList = new ArrayList<>();
        PageInfo<TestWorkOrder> list = workService.list(req);
        list.getList().forEach(order->voList.add(BeanCopyUtil.copy(order,WorkOrderListVO.class)));
        return ResponseUtil.getListResponseVO(voList,list.getTotal());
    }

    @ApiOperation("工作单详情")
    @PostMapping("detail")
    public ResponseEntity<WorkOrderVO> detail(@RequestBody WorkOrderDetailReq req){
        WorkOrderVO detail = workService.detail(req);
        return ResponseUtil.getResponseVO(detail);
    }

    @ApiOperation("确认工作单")
    @PostMapping("confirm")
    public ResponseEntity<BaseResponseVO> confirm(@RequestBody ConfirmWorkOrderReq req){
        workService.confirm(req);
        return ResponseUtil.getDefaultResp();
    }

    @ApiOperation("删除工作单")
    @PostMapping("delete")
    public ResponseEntity<BaseResponseVO> delete(@RequestBody WorkOrderDetailReq req){
        workService.delete(req);
        return ResponseUtil.getDefaultResp();
    }

    @ApiOperation(value = "上传样品图片")
    @PostMapping("upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
        String fileName = fileUtil.saveSample(file, DateUtils.getDate("yyyyHHmm"));
        return ResponseUtil.getResponseVO(fileName);
    }

    @ApiOperation(value = "下载样品图片")
    @GetMapping(value = "download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response){
        fileUtil.downloadSample(fileName, response);
    }

    //TODO 这块和自动创建，还差校验CAS资质逻辑
    @ApiOperation(value = "检测公司列表")
    @GetMapping(value = "comList")
    public ResponseEntity<ListResponseVO<CheckCompanyVO>> comList(@RequestBody CheckComListReq req){
        List<CheckCompany> checkCompanies = workService.comList(req);
        List<CheckCompanyVO> voList = new ArrayList<>();
        checkCompanies.forEach(item->voList.add(BeanCopyUtil.copy(item,CheckCompanyVO.class)));
        return ResponseUtil.getListResponseVO(voList,voList.size());
    }

    @ApiOperation(value = "该公司下检测项目列表")
    @GetMapping(value = "itemList")
    public ResponseEntity<ListResponseVO<CheckItemVO>> itemList(@RequestBody CheckItemReq req){
        List<CheckItemVO> itemList = workService.getComCheckItemList(req);
        List<CheckItemVO> voList = new ArrayList<>();
        itemList.forEach(item->voList.add(BeanCopyUtil.copy(item,CheckItemVO.class)));
        return ResponseUtil.getListResponseVO(voList,voList.size());
    }

    //
}
