package com.libiao.customer.util.file;

import static org.apache.commons.lang3.ArrayUtils.isEmpty;

import com.google.common.collect.Lists;
import com.libiao.customer.util.FileVO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Lingfeng
 */
@Slf4j
public class FileUploadUtil {


  /**
   * 上传文件到文件夹下
   *
   * @param fileDirStr 目标文件夹
   * @param files      待上传文件
   * @throws IOException
   */
  public static void uploadToFileDir(String fileDirStr, MultipartFile[] files) throws IOException {
    if (ArrayUtils.isEmpty(files)) {
      log.debug("未上传任何新文件.");
      return;
    }
    File fileDir = new File(fileDirStr);
    if (!fileDir.exists()) {
      boolean b = fileDir.mkdirs();
    }
    File[] children = fileDir.listFiles();
    for (MultipartFile file : files) {
      String uniqueName = getUniqueFileName(file.getOriginalFilename());
      String path = fileDir.getAbsolutePath() + File.separator + uniqueName;
      log.info(path);
      file.transferTo(new File(path));
    }
  }

  private static String getUniqueFileName(String name) {
    return UUID.randomUUID() + "." + getFileSuffix(name);
  }

  public static void recurseDelFile(String fileStr) {
    File file = new File(fileStr);
    if (!file.exists()) {
      return;
    }
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      if (isEmpty(files)) {
        boolean delete = file.delete();
        return;
      }
      for (File children : files) {
        recurseDelFile(children.getAbsolutePath());
      }
      return;
    }
    boolean delete = file.delete();
  }

  public static void recurseDelFileExcept(String fileStr, List<String> excepts) {
    File file = new File(fileStr);
    if (!file.exists()) {
      return;
    }
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      if (isEmpty(files)) {
        boolean delete = file.delete();
        return;
      }
      for (File children : files) {
        if (excepts.stream().anyMatch(s -> Objects.equals(s, children.getName()))) {
          log.debug("{} 文件保留，不做删除操作", children.getName());
          continue;
        }
        recurseDelFile(children.getAbsolutePath());
      }
      return;
    }
    boolean delete = file.delete();
  }

  public static ArrayList<FileVO> getFileChildrenVOs(String parentPath) {
    ArrayList<FileVO> fileVOs = Lists.newArrayList();
    File file = new File(parentPath);
    File[] files = file.listFiles();
    if (files != null && files.length > 0) {
      for (File f : files) {
        FileVO fileVO = new FileVO();
        fileVO.setName(f.getName());
        fileVO.setPath(parentPath);
        fileVOs.add(fileVO);
      }
    }
    return fileVOs;
  }

  /**
   * 获取文件后缀名
   */
  public static String getFileSuffix(String fileName) {
    if (fileName == null) {
      return null;
    }
    String suffix = null;
    if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
      suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    return suffix;
  }

  /**
   * 获取文件前缀名
   */
  public static String getFilePrefix(String fileName) {
    if (fileName == null) {
      return null;
    }
    String prefix = null;
    if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
      prefix = fileName.substring(0, fileName.lastIndexOf("."));
    }
    return prefix;
  }
}
