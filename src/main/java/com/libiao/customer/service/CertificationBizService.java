package com.libiao.customer.service;

import com.libiao.customer.dal.model.Certification;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface CertificationBizService {

    public ResponseVO<?> uploadFile(MultipartFile file);

    public ResponseVO<?> uploadCertification(Certification certification);

    public ResponseVO<?> downloadCertificationById(HttpServletResponse response, Long certificationId);

    public ResponseVO<?> downloadCertificationByEncryptionKey(HttpServletResponse response, String encryptionKey);

    public ResponseVO<?> deleteCertification(Long certificationId);

    public ResponseVO<?> queryCertificationList(int pageNum, int pageSize, String name, String encryptionKey);

    public ResponseVO<?> queryTest(String user);

    public ResponseVO<?> queryFileNameByEncryptionKey(String encryptionKey);

    public ResponseEntity<?> previewByCertificationId(Long certificationId);

    public ResponseEntity<?> previewByEncryptionKey(String encryptionKey);

}
