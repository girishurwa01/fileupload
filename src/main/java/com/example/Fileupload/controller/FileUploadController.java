package com.example.Fileupload.controller;

import com.example.Fileupload.service.FileStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        String path = fileStorageService.storeFile(file);

        return ResponseEntity.ok("File uploaded at: " + path);
    }

}



