package com.example.Fileupload.controller;

import com.example.Fileupload.service.FileStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController

public class FileUploadController {

    public final FileStorageService fileStorageService;

    public FileUploadController(FileStorageService fileStorageService){
      this.fileStorageService=fileStorageService;
    }

    @PostMapping("/uploads")
    public ResponseEntity<String> uploadFile(
            @RequestPart(value = "file", required = false) MultipartFile file,
            @RequestPart(value = "upload", required = false) MultipartFile upload
    ) throws IOException {
        MultipartFile targetFile = (file != null) ? file : upload;

        if (targetFile == null || targetFile.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Missing file in multipart request. Use form-data key 'file'.");
        }

        return ResponseEntity.ok(fileStorageService.storeFile(targetFile));
    }

}



