package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.BasicCountry;
import com.libiao.customer.dal.model.BasicStandard;
import com.libiao.customer.dal.model.BasicTestItem;
import com.libiao.customer.model.BasePageReq;
import com.libiao.customer.model.BaseResponseVO;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.product.*;
import com.libiao.customer.service.ProductService;
import com.libiao.customer.util.AccessController;
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
    public ResponseEntity<ListResponseVO<GoodsVO>> goodsList(@RequestBody GoodsListReq req){
        List<GoodsVO> voList = productService.getProductList(req);
        return ResponseUtil.getListResponseVO(voList, voList.size());
    }

    @AccessController
    @ApiOperation("创建商品")
    @PostMapping("create")
    public ResponseEntity<BaseResponseVO> create(@RequestBody AddGoodsReq req){
        productService.createProduct(req);
        return ResponseUtil.getDefaultResp();
    }

    @AccessController
    @ApiOperation("获取出口国")
    @PostMapping("country/list")
    public ResponseEntity<ListResponseVO<CountryVO>> countryList(@RequestBody BasePageReq req){

        final PageInfo<BasicCountry> basicCountryPageInfo = productService.countryList(req);
        List<CountryVO> voList = new ArrayList<>(basicCountryPageInfo.getList().size());
        for (BasicCountry basicCountry : basicCountryPageInfo.getList()) {
            voList.add(BeanCopyUtil.copy(basicCountry,CountryVO.class));
        }
        return ResponseUtil.getListResponseVO(voList,basicCountryPageInfo.getTotal());
    }

    @AccessController
    @ApiOperation("获取标准列表")
    @PostMapping("standard/list")
    public ResponseEntity<ListResponseVO<StandardVO>> standardList(@RequestBody StandardListReq req){

        final PageInfo<BasicStandard> basicCountryPageInfo = productService.standardList(req);
        List<StandardVO> voList = new ArrayList<>(basicCountryPageInfo.getList().size());
        for (BasicStandard basicCountry : basicCountryPageInfo.getList()) {
            voList.add(BeanCopyUtil.copy(basicCountry,StandardVO.class));
        }
        return ResponseUtil.getListResponseVO(voList,basicCountryPageInfo.getTotal());
    }

}
