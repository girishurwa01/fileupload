package com.example.Fileupload.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async
    public CompletableFuture<String> processTask(String name) throws InterruptedException {

        System.out.println("Started task for: " + name);

        Thread.sleep(3000); // simulate delay

        System.out.println("Completed task for: " + name);

        return CompletableFuture.completedFuture("Hello " + name);
    }
}