package com.libiao.customer.controller;

import com.libiao.customer.dal.model.MallGoodsVO;
import com.libiao.customer.model.PageVO;
import com.libiao.customer.service.GoodsService;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class MallCtrl {

  private final GoodsService goodsService;

  public MallCtrl(GoodsService goodsService) {
    this.goodsService = goodsService;
  }

  @RequestMapping(value = "/api/mall/goods-page", method = RequestMethod.GET)
  public ResponseVO<PageVO<MallGoodsVO>> getGoodsPage(
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return goodsService.getGoodsByPage(pageNum, pageSize);
  }

  @RequestMapping(value = "/api/mall/goods", method = RequestMethod.PUT)
  public ResponseVO<?> updateGoods(
      @RequestParam("postForm") String mallGoods,
      @RequestParam(value = "imageList1", required = false) MultipartFile[] imgList1,
      @RequestParam(value = "imageList2", required = false) MultipartFile[] imgList2) {
    return goodsService.updateGoodsById(mallGoods, imgList1, imgList2);
  }

  @RequestMapping(value = "/api/mall/goods", method = RequestMethod.POST)
  public ResponseVO<?> addGoods(
      @RequestParam("postForm") String mallGoods,
      @RequestParam("imageList1") MultipartFile[] imgList1,
      @RequestParam("imageList2") MultipartFile[] imgList2) {
    return goodsService.addGoods(mallGoods, imgList1, imgList2);
  }

  @RequestMapping(value = "/api/mall/goods/{id}", method = RequestMethod.GET)
  public ResponseVO<MallGoodsVO> getFinance(@PathVariable(value = "id") Long id) {
    return goodsService.getGoodsById(id);
  }
}
