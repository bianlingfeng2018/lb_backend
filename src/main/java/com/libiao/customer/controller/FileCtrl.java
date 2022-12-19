package com.libiao.customer.controller;

import com.libiao.customer.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FileCtrl {

  private final FileService fileService;

  public FileCtrl(FileService fileService) {
    this.fileService = fileService;
  }

  @ResponseBody
  @RequestMapping(value = "/api/file", method = RequestMethod.GET)
  public ResponseEntity<?> getFile(@RequestParam String path, @RequestParam String name) {
    return fileService.getFile(path, name);
  }

}
