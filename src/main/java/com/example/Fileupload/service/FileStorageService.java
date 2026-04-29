package com.example.Fileupload.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

    private  final String uploadDir = "uploads/";

    public String storeFile(MultipartFile file) throws IOException {
        Path uploadPath= Paths.get(uploadDir);

        if(!Files.exists(uploadPath)){
            Files.createDirectory(uploadPath);
        }

        String originalName = file.getOriginalFilename();
        String filename= UUID.randomUUID()+"_"+originalName;

        Path filePath = uploadPath.resolve(filename);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return " File Uploaded at: " +filePath.toString();
    }

}
