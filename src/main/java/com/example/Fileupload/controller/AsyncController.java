package com.example.Fileupload.controller;
import com.example.Fileupload.service.AsyncService;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
    public class AsyncController {

    private final AsyncService asyncService;
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/async")
    public String testAsync() throws Exception {
        CompletableFuture<String> task1 = asyncService.processTask("Girish");
        CompletableFuture<String> task2 = asyncService.processTask("Developer");
        // wait for both tasks to complete
        CompletableFuture.allOf(task1, task2).join();
        return task1.get() + " & " + task2.get();
    }
}