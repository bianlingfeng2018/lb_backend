package com.libiao.customer.service;

import org.springframework.http.ResponseEntity;

public interface FileService {

  ResponseEntity<?> getFile(String path, String name);

}
