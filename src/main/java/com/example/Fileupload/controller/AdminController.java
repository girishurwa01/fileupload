package com.example.Fileupload.controller;

import com.example.Fileupload.entity.Admin;
import com.example.Fileupload.service.AdminService;
import com.example.Fileupload.service.CandidateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/")

public class AdminController {

    public final AdminService service;

    public AdminController(AdminService service){
        this.service=service;
    }

    @PostMapping
    public Admin create (@RequestBody Admin admin){
       return service.save(admin);
    }

}
