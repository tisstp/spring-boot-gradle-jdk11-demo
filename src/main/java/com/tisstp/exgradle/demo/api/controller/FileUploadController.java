package com.tisstp.exgradle.demo.api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;

/**
 * @author sathaphorn.stp (Tis)
 * @since 18-12-2019, 4:53 PM
 */
@Api
@Controller
public class FileUploadController {

  @RequestMapping(value = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, method = RequestMethod.POST)
  public ResponseEntity<Void> uploadFile(@RequestPart String description, @RequestPart MultipartFile file) {
    //yaay!
    return ResponseEntity.ok(null);
  }

}
