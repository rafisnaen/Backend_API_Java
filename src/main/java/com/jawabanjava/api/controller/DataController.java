package com.jawabanjava.api.controller;

import com.jawabanjava.api.model.ViewDataResponse;
import com.jawabanjava.api.repository.DataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    private final DataRepository repo;

    public DataController(DataRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/api/data")
    public ViewDataResponse getData() {
        return new ViewDataResponse(repo.findAllTransactions(), repo.findAllStatus());
    }
}
