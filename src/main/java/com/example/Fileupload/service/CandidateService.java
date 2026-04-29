package com.example.Fileupload.service;

import com.example.Fileupload.entity.Candidate;
import com.example.Fileupload.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    public final CandidateRepository repository;

    public CandidateService(CandidateRepository repository){
        this.repository=repository;
    }

    public Candidate save( Candidate candidate){
        return repository.save(candidate);
    }

    public List<Candidate> getAll(){
        return repository.findAll();
    }

}
