package com.example.Fileupload.service;

import com.example.Fileupload.entity.Admin;
import com.example.Fileupload.entity.Candidate;
import com.example.Fileupload.repository.AdminRepository;

import java.util.List;

public class AdminService {

public final AdminRepository repository;

public AdminService(AdminRepository repository){
this.repository=repository;
}

public Admin save(Admin admin){
    return repository.save(admin);
}
    public List<Admin> getAll(){
        return repository.findAll();
    }

}

yoyoyoyoyoy