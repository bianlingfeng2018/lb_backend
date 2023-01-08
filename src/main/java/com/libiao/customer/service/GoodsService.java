package com.libiao.customer.service;

import com.libiao.customer.model.PageVO;
import com.libiao.customer.dal.model.MallGoodsVO;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsService {

  ResponseVO<PageVO<MallGoodsVO>> getGoodsByPage(int pageNum, int pageSize);

  ResponseVO<?> updateGoodsById(String mallGoods, MultipartFile[] imgList1, MultipartFile[] imgList2);

  ResponseVO<?> addGoods(String mallGoods, MultipartFile[] imgList1, MultipartFile[] imgList2);

  ResponseVO<MallGoodsVO> getGoodsById(Long id);
}
