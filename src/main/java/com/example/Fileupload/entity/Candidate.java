package com.example.Fileupload.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Candidate {
    @Id
    @GeneratedValue
    private Long id;
    private String empName;
    private String empRole;
    private String fileName;
    private String filePath;

    public Long getId() {
        return id;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpRole() {
        return empRole;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;

    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}



