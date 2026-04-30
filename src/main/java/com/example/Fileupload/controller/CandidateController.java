package com.example.Fileupload.controller;

import com.example.Fileupload.entity.Candidate;
import com.example.Fileupload.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/candidates")
public class CandidateController {
    public final CandidateService service;

     public CandidateController(CandidateService service){
        this.service=service;
    }

    @PostMapping
    public Candidate create(@Valid @RequestBody Candidate candidate){
         return service.save(candidate);
    }

    @GetMapping
    public List<Candidate> getAll(){
         return service.getAll();
    }
}
