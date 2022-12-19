package com.libiao.customer.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.Certification;
import com.libiao.customer.repository.CertificationRepository;
import com.libiao.customer.service.CertificationBizService;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.WebUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.exception.LibiaoException;
import com.libiao.customer.util.file.FileUtil;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CertificationBizServiceImpl implements CertificationBizService {

    @Autowired
    private CertificationRepository certificationRepository;

    @Transactional
    @Override
    public ResponseVO<?> uploadFile(MultipartFile file) {
        try{
            if(file.isEmpty()){
                return ResponseUtil.error(ErrorCodeEnum.UPLOAD_ERROR_NO_FILE); // 没有文件被上传
            }
            String fileName = file.getOriginalFilename();
            String path = com.libiao.customer.util.file.FileUtil.buildFilePath(file); // 需要修改一下
            File dest = new File(path);
            if(!dest.getParentFile().exists()){  // 如果文件夹不存在，那么就创建文件夹
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);

            JSONObject uploadFileResult = new JSONObject(true);
            // 上传文件后，返回上传的文件的文件名
            uploadFileResult.put("fileName", fileName);
            uploadFileResult.put("msg", "文件保存成功");
            return ResponseUtil.success(uploadFileResult);
        }catch (Exception e){
            log.error("上传文件发生异常， msg is：{}", e.toString(), e);
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO<?> uploadCertification(Certification certification) {
        try {
            // 写入文件到数据库中
            certification.setPath(com.libiao.customer.util.file.FileUtil.buildFilePath(certification.getName()));
            certification.setEncryptionKey(UUID.randomUUID().toString());
            int affectedRows = certificationRepository.insert(certification);
            JSONObject uploadFileResult = new JSONObject(true);
            uploadFileResult.put("affectedRows", affectedRows);
            uploadFileResult.put("fileId", certification.getId()); // 文件id
            uploadFileResult.put("fileName", certification.getName()); // 文件名称
            uploadFileResult.put("encryptionKey", certification.getEncryptionKey()); // 文件密钥
            uploadFileResult.put("msg", "证书数据写入数据库成功");
            return ResponseUtil.success(uploadFileResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    /**
     * 这个好像不用返回
     * @param response
     * @param encryptionKey
     * @return
     */
    @Override
    public ResponseVO<?> downloadCertificationByEncryptionKey(HttpServletResponse response, String encryptionKey) {
        try{
            List<Certification> certifications = certificationRepository.selectByEncryptionKey(encryptionKey);
            if(certifications != null && certifications.size() != 0){
                
                Certification certification = certifications.get(0);
                File file = new File(certification.getPath());
                if(file.exists()){
                    FileInputStream inputStream = new FileInputStream(file);
                    response.setHeader("content-disposition", "inline;fileName=" + URLEncoder.encode(certification.getName(), "UTF-8"));
                    response.setContentType( "application/x-msdownload");
                    ServletOutputStream outputStream = response.getOutputStream();
                    IOUtils.copy(inputStream, outputStream);
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(outputStream);
                    JSONObject downloadResult = new JSONObject(true);
                    downloadResult.put("fileName", certification.getName());
                    downloadResult.put("msg", "下载成功");
                    return ResponseUtil.success(downloadResult);
                }
            }
            return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO<?> downloadCertificationById(HttpServletResponse response, Long certificationId) {

        try{
            Certification certification = certificationRepository.selectByPrimaryKey(certificationId); // 查找文件;
            File file = new File(certification.getPath());
            if(file.exists()){
                FileInputStream inputStream = new FileInputStream(file);
                response.setHeader("content-disposition", "inline;fileName=" + URLEncoder.encode(certification.getName(), "UTF-8"));
                response.setContentType( "application/x-msdownload");
                ServletOutputStream outputStream = response.getOutputStream();
                IOUtils.copy(inputStream, outputStream);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(outputStream);
                JSONObject downloadResult = new JSONObject(true);
                downloadResult.put("fileName", certification.getName());
                downloadResult.put("msg", "下载成功");
                return ResponseUtil.success(downloadResult);
            }
            return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO<?> deleteCertification(Long certificationId) {
        try{
            int affected_rows = certificationRepository.deleteByPrimaryKey(certificationId);
            JSONObject delResult = new JSONObject(true);
            delResult.put("delStatus", true);
            delResult.put("affected_rows", affected_rows);
            return ResponseUtil.success(delResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO<?> queryCertificationList(int pageNum, int pageSize, String name, String encryptionKey) {
        try{
            String userName = WebUtil.getAccessToken().getUsername();
            String permission = WebUtil.getAccessToken().getPermission();
            List<Certification> certificationList = null;
            PageHelper.startPage(pageNum, pageSize);
            PageHelper.orderBy("id desc");
            if(permission.equals("user")){ // 普通用户，只能看到普通用户本身的证书
                certificationList = certificationRepository.selectAllByUsername(userName);
            }else{ // 管理员，可以看到所有的证书
                certificationList = certificationRepository.selectAll();
            }
            if(!StringUtils.isEmpty(name)){
                certificationList = certificationList.stream().filter(item -> item.getName().contains(name)).collect(Collectors.toList());
            }
            if(!StringUtils.isEmpty(encryptionKey)){
                certificationList = certificationList.stream().filter(item -> item.getEncryptionKey().contains(encryptionKey)).collect(Collectors.toList());
            }
            PageInfo<Certification> pageInfo = new PageInfo<>(certificationList);
            return ResponseUtil.success(pageInfo);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO<?> queryTest(String user) {
        try{
            String hello = String.format("hello, %s!", user);
            return ResponseUtil.success(hello);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }    }

    @Override
    public ResponseVO<?> queryFileNameByEncryptionKey(String encryptionKey) {
        try {
            List<Certification> certifications = certificationRepository.selectByEncryptionKey(encryptionKey);
            if(certifications != null && certifications.size() != 0) {
                Certification certification = certifications.get(0);
                return ResponseUtil.success(certification.getName());
            }
            return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> previewByCertificationId(Long certificationId) {
        try{
            Certification certification = certificationRepository.selectByPrimaryKey(certificationId);
            certification.setPath("C:\\Users\\PC\\Documents\\WeChat Files\\wxid_8jshvfbs073e21\\FileStorage\\File\\2022-08\\检测报价单.xls");
            if(certification == null){
                return new ResponseEntity(new LibiaoException("请求的证书文件不存在,输入的证书id可能错误"), HttpStatus.NOT_FOUND);
            }
            String filePath = certification.getPath();
            File file = new File(filePath);
            if(file.exists() == false){
                return new ResponseEntity(new LibiaoException("请求的证书文件不存在"), HttpStatus.NOT_FOUND);
            }
            String destFilePath = FileUtil.toPdf(filePath);
            File destFile = new File(destFilePath);
            FileInputStream fileInputStream = new FileInputStream(destFile);
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-disposition", "inline;filename=" + destFile.getName());
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(destFile.length())
                    .contentType(MediaType.parseMediaType("application/pdf"))
                    .body(new InputStreamResource(fileInputStream));

        }catch (Exception e){
            return new ResponseEntity(new LibiaoException(ErrorCodeEnum.UNKNOWN_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> previewByEncryptionKey(String encryptionKey) {
        try{
            List<Certification> certificationList = certificationRepository.selectByEncryptionKey(encryptionKey);
            if(certificationList == null || certificationList.size() == 0){
                return new ResponseEntity(new LibiaoException("请求的证书文件不存在,输入的密钥可能错误"), HttpStatus.NOT_FOUND);
            }
            Certification certification = certificationList.get(0);
            String filePath = certification.getPath();
            File file = new File(filePath);
            if(file.exists() == false){
                return new ResponseEntity<>(new LibiaoException("请求的证书文件不存在"), HttpStatus.NOT_FOUND);
            }

            String destFilePath = FileUtil.toPdf(filePath);
            File destFile = new File(destFilePath);
            FileInputStream fileInputStream = new FileInputStream(destFile);
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-disposition", "inline;filename=" + destFile.getName());
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(destFile.length())
                    .contentType(MediaType.parseMediaType("application/pdf"))
                    .body(new InputStreamResource(fileInputStream));
        }catch (Exception e){
            return new ResponseEntity(new LibiaoException(ErrorCodeEnum.UNKNOWN_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
