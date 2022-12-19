package com.libiao.customer.controller;

import com.libiao.customer.dal.model.Certification;
import com.libiao.customer.service.CertificationBizService;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


@Slf4j
@Controller
@RequestMapping(value = "/api/certification")
@CrossOrigin
public class CertificationCtrl {


    @Autowired
    private CertificationBizService certificationBizService;

    /**
     * 上传证书
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/uploadFile")
    public ResponseVO<?> uploadFile(@RequestParam("file") MultipartFile file, HttpServletResponse response){
        log.info("/api/cerfication/uploadFile file name is : {}", file.getName());
        return certificationBizService.uploadFile(file);
    }

    @ResponseBody
    @PostMapping(value = "/uploadCertification")
    public ResponseVO<?> uploadCerfication(@RequestBody Certification certification){
        return certificationBizService.uploadCertification(certification);
    }

    /**
     * 下载证书, 根据用户证书来下载
     */
    @ResponseBody
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseVO<?> downloadCertification(HttpServletResponse response, @RequestParam("certificationId") Long certificationId){
        return certificationBizService.downloadCertificationById(response, certificationId);
    }

    @ResponseBody
    @RequestMapping(value = "/downloadByEncryptionKey", method = RequestMethod.GET)
    public ResponseVO<?> downloadCertification(HttpServletResponse response, @RequestParam("encryptionKey") String encryptionKey){
        return certificationBizService.downloadCertificationByEncryptionKey(response, encryptionKey);
    }

    @ResponseBody
    @RequestMapping(value = "/previewByCertificationId", method = RequestMethod.GET)
    public ResponseEntity<?> previewByCertificationId(@RequestParam("certificationId") Long certificationId){
        return certificationBizService.previewByCertificationId(certificationId);
    }

    @ResponseBody
    @RequestMapping(value = "/previewByEncryptionKey", method = RequestMethod.GET)
    public ResponseEntity<?> previewByEncryptionKey(@RequestParam("encryptionKey") String encryptionKey){
        return certificationBizService.previewByEncryptionKey(encryptionKey);
    }


    @ResponseBody
    @RequestMapping(value = "/queryFileNameByEncryptionKey", method = RequestMethod.GET)
    public ResponseVO<?> queryFileNameByEncryptionKey(@RequestParam("encryptionKey") String encryptionKey){
        return certificationBizService.queryFileNameByEncryptionKey(encryptionKey);
    }

    /**
     * 删除证书，根据证书id来删除证书
     * @return
     */
    @ResponseBody
    @DeleteMapping(value = "/delete")
    public ResponseVO<?> delCertification(@RequestParam("certificationId") Long certificationId){
        return certificationBizService.deleteCertification(certificationId);
    }


    /**
     * 展示证书列表, 分页查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public ResponseVO<?> queryCertificationList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                              @RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize,
                                                @RequestParam(name = "name", required = false) String name,
                                                @RequestParam(name = "encryptionKey", required = false) String encryptionKey){
        return certificationBizService.queryCertificationList(pageNum, pageSize, name, encryptionKey);
    }


    @ResponseBody
    @PostMapping(value = "/queryTest")
    public ResponseVO<?> queryTest(@RequestParam(value = "user", required = true) String user) {
        return certificationBizService.queryTest(user);
    }

}

