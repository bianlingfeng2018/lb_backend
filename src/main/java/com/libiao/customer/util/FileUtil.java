package com.libiao.customer.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Objects;

/**
 * 文件工具类
 */
@Slf4j
@Component
public class FileUtil {

    @Value("${CONTRACT_PATH}")
    public String CONTRACT_PATH;
    @Value("${BILL_PATH}")
    public String BILL_PATH;

    public String getCONTRACT_PATH() {
        return CONTRACT_PATH;
    }

    public void setCONTRACT_PATH(String CONTRACT_PATH) {
        this.CONTRACT_PATH = CONTRACT_PATH;
    }

    public String getBILL_PATH() {
        return BILL_PATH;
    }

    public void setBILL_PATH(String BILL_PATH) {
        this.BILL_PATH = BILL_PATH;
    }

    /**
     * 保存水单
     * @param multpartfile
     * @param clientId
     * @return
     */
    public String saveBill(MultipartFile multpartfile, String clientId){
        return saveFile(multpartfile,clientId,BILL_PATH);
    }

    /**
     * 下载水单
     * @param fileName
     * @param response
     */
    public void downloadBill(String fileName, HttpServletResponse response){
        downloadFile(BILL_PATH,fileName,response);
    }

    public String saveContract(MultipartFile multpartfile, String date){
        return saveFile(multpartfile,date,CONTRACT_PATH);
    }

    public void downloadContract(String fileName, HttpServletResponse response){
        downloadFile(CONTRACT_PATH,fileName,response);
    }

    private String saveFile(MultipartFile multpartfile, String route, String path) {
        // 检查路径是否存在，不存在则创建
        String filePath = path + route;//将原图片存放在pics目录下
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

    /**
     * 下载文件
     * @param filePath
     * @param fileName
     * @param response
     */
    private void  downloadFile(String filePath, String fileName, HttpServletResponse response){
        try{
            File file = new File(filePath);
            if (file.exists()) {
                InputStream ins = new FileInputStream(file);
                BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面
                OutputStream outs = response.getOutputStream();// 获取文件输出IO流
                BufferedOutputStream bouts = new BufferedOutputStream(outs);
                response.setContentType("application/octet-stream");// 设置response内容的类型
                response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));// 设置头部信息
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                // 开始向网络传输文件流
                while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                    bouts.write(buffer, 0, bytesRead);
                }
                bouts.flush();// 这里一定要调用flush()方法
                ins.close();
                bins.close();
                outs.close();
                bouts.close();
            }
        } catch (IOException e) {
            log.error("下载文件异常",e);
            throw new ServiceException(HttpStatus.BAD_GATEWAY,"系统异常");
        }
    }
}
