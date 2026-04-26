package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    // 🔹 GET ALL (Pagination)
    @GetMapping("/all")
    public ResponseEntity<Page<Transaction>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    // 🔹 GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // 🔹 CREATE (IMPORTANT: @Valid + @RequestBody)
    @PostMapping("/create")
    public ResponseEntity<Transaction> create(@Valid @RequestBody Transaction transaction) {
        return new ResponseEntity<>(service.create(transaction), HttpStatus.CREATED);
    }
}