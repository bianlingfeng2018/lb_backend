package com.libiao.customer.service.impl;

import static org.springframework.http.MediaTypeFactory.getMediaType;

import com.libiao.customer.service.FileService;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.exception.LibiaoException;
import java.io.File;
import java.io.FileInputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Lingfeng
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

  /**
   * 获取二进制文件，写入ResponseEntity，并设置内容处置为预览（inline）
   * @param path 文件路径
   * @param name 文件名称
   * @return
   */
  @Override
  public ResponseEntity<?> getFile(String path, String name) {
    try {
      File file = new File(path + File.separator + name);
      FileInputStream fileInputStream = new FileInputStream(file);
      HttpHeaders headers = new HttpHeaders();
      headers.add("content-disposition", "inline;filename=" + file.getName());
      return ResponseEntity
          .ok()
          .headers(headers)
          .contentLength(file.length())
          .contentType(getMediaType(name).get())
          .body(new InputStreamResource(fileInputStream));
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity(new LibiaoException(ErrorCodeEnum.UNKNOWN_ERROR),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
