package com.libiao.customer.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;

/**
 * 文件工具类
 */
@Slf4j
@Component
public class FileUtil {

    @Value("CONTRACT_PATH")
    public String CONTRACT_PATH;

    public String saveContract(MultipartFile multpartfile, Long clientId){
        return saveFile(multpartfile,clientId,CONTRACT_PATH);
    }

    private String saveFile(MultipartFile multpartfile, Long clientId, String path) {
        // 检查路径是否存在，不存在则创建
        String filePath = path + clientId;//将原图片存放在pics目录下
        File file = new File(filePath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
        // 文件名
        String targetFileName = "";

        String[] arr = Objects.requireNonNull(multpartfile.getOriginalFilename()).split("\\.");
        long nanoTime = System.nanoTime();
        targetFileName = nanoTime + "." + arr[arr.length - 1];
        File savefile = new File(new File(filePath), targetFileName);

        try {
            multpartfile.transferTo(savefile);
        } catch (Exception e) {
            log.error("系统找不到指定的路径！", e);
            throw new ServiceException(HttpStatus.FAILED_DEPENDENCY,"文件上传失败");
        }
        return targetFileName;
    }

}
