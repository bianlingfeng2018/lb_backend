package com.libiao.customer.service.impl;

import static com.libiao.customer.util.SystemConstant.getMallGoodsImage1Dir;
import static com.libiao.customer.util.SystemConstant.getMallGoodsImage2Dir;
import static com.libiao.customer.util.file.FileUploadUtil.getFileChildrenVOs;
import static com.libiao.customer.util.file.FileUploadUtil.recurseDelFile;
import static com.libiao.customer.util.file.FileUploadUtil.recurseDelFileExcept;
import static com.libiao.customer.util.file.FileUploadUtil.uploadToFileDir;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.controller.PageVO;
import com.libiao.customer.dal.model.MallGoods;
import com.libiao.customer.dal.model.MallGoodsVO;
import com.libiao.customer.repository.GoodsRepository;
import com.libiao.customer.service.GoodsService;
import com.libiao.customer.util.ConvertUtil;
import com.libiao.customer.util.FileVO;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GoodsServiceImpl implements GoodsService {

  private final GoodsRepository goodsRepository;

  public GoodsServiceImpl(GoodsRepository goodsRepository) {
    this.goodsRepository = goodsRepository;
  }

  @Override
  public ResponseVO<PageVO<MallGoodsVO>> getGoodsByPage(int pageNum, int pageSize) {
    try {
      PageHelper.startPage(pageNum, pageSize);
      PageHelper.orderBy("id desc");
      List<MallGoods> list = goodsRepository.selectAll();
      PageInfo<MallGoods> pageInfo = new PageInfo<>(list);

      PageInfo<MallGoodsVO> voPageInfo = ConvertUtil.DO2VO(pageInfo, entity -> {
        MallGoodsVO vo = new MallGoodsVO();
        BeanUtils.copyProperties(entity, vo);
        Long id = entity.getId();
        // image1
        String path = getMallGoodsImage1Dir(String.valueOf(id));
        ArrayList<FileVO> fileVOs = getFileChildrenVOs(path);
        vo.setImageList1(fileVOs);
        // image2
        String path2 = getMallGoodsImage2Dir(String.valueOf(id));
        ArrayList<FileVO> fileVOs2 = getFileChildrenVOs(path2);
        vo.setImageList2(fileVOs2);
        return vo;
      });
      return ResponseUtil.success(voPageInfo);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> updateGoodsById(String mallGoodsStr, MultipartFile[] imgList1, MultipartFile[] imgList2) {
    try {
      MallGoods mallGoods = JSON.parseObject(mallGoodsStr, MallGoods.class);
      int affected = goodsRepository.updateById(mallGoods);
      //上传附件
      MallGoodsVO mallGoodsVO = JSON.parseObject(mallGoodsStr, MallGoodsVO.class);
      List<FileVO> carouselImgList = mallGoodsVO.getImageList1();
      List<FileVO> introImgList = mallGoodsVO.getImageList2();
      List<String> carouseImgNameList = carouselImgList.stream().map(fileVO -> fileVO.getName())
          .collect(Collectors.toList());
      List<String> introImgNameList = introImgList.stream().map(fileVO -> fileVO.getName())
          .collect(Collectors.toList());
      String dir1 = getMallGoodsImage1Dir(String.valueOf(mallGoods.getId()));
      recurseDelFileExcept(dir1, carouseImgNameList);
      uploadToFileDir(dir1, imgList1);
      String dir2 = getMallGoodsImage2Dir(String.valueOf(mallGoods.getId()));
      recurseDelFileExcept(dir2, introImgNameList);
      uploadToFileDir(dir2, imgList2);

      JSONObject jsonObject = new JSONObject(true);
      jsonObject.put("msg", "更新记录成功");
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> addGoods(String mallGoodsStr, MultipartFile[] imgList1, MultipartFile[] imgList2) {
    try {
      MallGoods mallGoods = JSON.parseObject(mallGoodsStr, MallGoods.class);
      int affected = goodsRepository.insert(mallGoods);
      //上传附件
      String dir1 = getMallGoodsImage1Dir(String.valueOf(mallGoods.getId()));
      recurseDelFile(dir1);
      uploadToFileDir(dir1, imgList1);
      String dir2 = getMallGoodsImage2Dir(String.valueOf(mallGoods.getId()));
      recurseDelFile(dir2);
      uploadToFileDir(dir2, imgList2);

      JSONObject jsonObject = new JSONObject(true);
      jsonObject.put("msg", "新增记录成功");
      jsonObject.put("data", mallGoods);
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<MallGoodsVO> getGoodsById(Long id) {
    try {
      MallGoods goods = goodsRepository.selectById(id);
      MallGoodsVO vo = new MallGoodsVO();
      BeanUtils.copyProperties(goods, vo);
      // imageList1
      String path = getMallGoodsImage1Dir(String.valueOf(id));
      ArrayList<FileVO> fileVOs = getFileChildrenVOs(path);
      vo.setImageList1(fileVOs);
      // imageList2
      String path2 = getMallGoodsImage2Dir(String.valueOf(id));
      ArrayList<FileVO> fileVOs2 = getFileChildrenVOs(path2);
      vo.setImageList2(fileVOs2);

      JSONObject jsonObject = (JSONObject) JSONObject.toJSON(vo);
      jsonObject.put("testItemList", JSONObject.parse(goods.getTestItemList()));
      jsonObject.put("mealList", JSONObject.parse(goods.getMealList()));
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }
}
