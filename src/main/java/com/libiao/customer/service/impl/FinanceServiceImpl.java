package com.libiao.customer.service.impl;

import static com.libiao.customer.util.SystemConstant.getTestApplicationFormImageDir;
import static com.libiao.customer.util.SystemConstant.getTestApplicationFormPDFDir;
import static com.libiao.customer.util.file.FileUploadUtil.getFileChildrenVOs;
import static org.springframework.http.MediaTypeFactory.getMediaType;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.libiao.customer.model.PageVO;
import com.libiao.customer.dal.model.Finance;
import com.libiao.customer.dal.model.FinanceVO;
import com.libiao.customer.repository.FinanceRepository;
import com.libiao.customer.service.FinanceService;
import com.libiao.customer.util.ConvertUtil;
import com.libiao.customer.util.FileVO;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FinanceServiceImpl implements FinanceService {

  private final FinanceRepository financeRepository;

  public FinanceServiceImpl(FinanceRepository financeRepository) {
    this.financeRepository = financeRepository;
  }

  @Override
  public ResponseVO<PageVO<FinanceVO>> getFinancesByPage(int pageNo, int pageSize) {
    try {
      PageHelper.startPage(pageNo, pageSize);
      PageHelper.orderBy("id desc");
      List<Finance> list = financeRepository.selectAll();
      PageInfo<Finance> pageInfo = new PageInfo<>(list);

      PageInfo<FinanceVO> voPageInfo = ConvertUtil.DO2VO(pageInfo, entity -> {
        FinanceVO vo = new FinanceVO();
        BeanUtils.copyProperties(entity, vo);
        Long tradeId = entity.getTradeId();
        // PDF
        String path = getTestApplicationFormPDFDir(String.valueOf(tradeId));
        ArrayList<FileVO> fileVOs = getFileChildrenVOs(path);
        vo.setPdfList(fileVOs);
        // image
        String path2 = getTestApplicationFormImageDir(String.valueOf(tradeId));
        ArrayList<FileVO> fileVOs2 = getFileChildrenVOs(path2);
        vo.setImageList(fileVOs2);
        return vo;
      });
      return ResponseUtil.success(voPageInfo);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> updateFinanceById(Finance finance) {
    try {
      int affected = financeRepository.updateById(finance);
      JSONObject jsonObject = new JSONObject(true);
      jsonObject.put("msg", "更新记录成功");
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> addFinance(Finance finance) {
    try {
      int affected = financeRepository.insert(finance);
      JSONObject jsonObject = new JSONObject(true);
      jsonObject.put("msg", "新增记录成功");
      jsonObject.put("data", finance);
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<Void> deleteFinanceById(Long id) {
    try {
      int affected = financeRepository.deleteById(id);
      return ResponseUtil.success();
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<Finance> getFinanceById(Long id) {
    try {
      Finance finance = financeRepository.findFinanceById(id);
      if (Objects.isNull(finance)) {
        return ResponseUtil.error(404, "未找到记录");
      }
      return ResponseUtil.success(finance);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> getTestTradeApplicationFormPDFs(Long tradeId) {
    try {
      String path = getTestApplicationFormPDFDir(String.valueOf(tradeId));
      File file = new File(path);
      File[] files = file.listFiles();
      if (files == null || files.length == 0) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "未找到PDF文件");
        return ResponseUtil.success(jsonObject);
      }
      ArrayList<FileVO> fileVOs = Lists.newArrayList();
      for (File f : files) {
        FileVO fileVO = new FileVO();
        fileVO.setName(f.getName());
        fileVO.setPath(path);
        fileVOs.add(fileVO);
      }
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("data", fileVOs);
      jsonObject.put("msg", "获取PDF文件列表成功");
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  @Override
  public ResponseVO<?> getTestTradeApplicationFormImages(Long tradeId) {
    try {
      String path = getTestApplicationFormImageDir(String.valueOf(tradeId));
      File file = new File(path);
      File[] files = file.listFiles();
      if (files == null || files.length == 0) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "未找到Images文件");
        return ResponseUtil.success(jsonObject);
      }
      ArrayList<FileVO> fileVOs = Lists.newArrayList();
      for (File f : files) {
        FileVO fileVO = new FileVO();
        fileVO.setName(f.getName());
        fileVO.setPath(path);
        fileVOs.add(fileVO);
      }
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("data", fileVOs);
      jsonObject.put("msg", "获取Image文件列表成功");
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

}
