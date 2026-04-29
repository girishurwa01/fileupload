package com.example.Fileupload.controller;

import com.example.Fileupload.service.FileStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController

public class FileUploadController {

    public final FileStorageService fileStorageService;

    public FileUploadController(FileStorageService fileStorageService){
      this.fileStorageService=fileStorageService;
    }

    @PostMapping("uploads/")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
        return fileStorageService.storeFile(file);
    }

}



