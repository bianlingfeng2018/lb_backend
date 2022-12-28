package com.libiao.customer.controller;

import com.libiao.customer.dal.model.BasicTestItem;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.product.BasicItemVO;
import com.libiao.customer.model.product.GoodsVO;
import com.libiao.customer.service.ProductService;
import com.libiao.customer.util.AccessController;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "商品相关接口")
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @AccessController
    @ApiOperation("获取基本检测项列表")
    @PostMapping("item/list")
    public ResponseEntity<ListResponseVO<BasicItemVO>> itemList(){
        List<BasicTestItem> basicTestItemList = productService.getBasicTestItemList();
        List<BasicItemVO> voList = new ArrayList<>(basicTestItemList.size());
        basicTestItemList.forEach(item->voList.add(BeanCopyUtil.copy(item,BasicItemVO.class)));
        return ResponseUtil.getListResponseVO(voList, voList.size());
    }

    //获取商品列表
    @AccessController
    @ApiOperation("获取商品列表")
    @PostMapping("list")
    public ResponseEntity<ListResponseVO<GoodsVO>> goodsList(){
        List<GoodsVO> voList = productService.getProductList();
        return ResponseUtil.getListResponseVO(voList, voList.size());
    }

    @AccessController
    @ApiOperation("创建商品")
    @PostMapping("create")
    public ResponseEntity<ListResponseVO<GoodsVO>> create(){
        List<GoodsVO> voList = productService.getProductList();
        return ResponseUtil.getListResponseVO(voList, voList.size());
    }

}
