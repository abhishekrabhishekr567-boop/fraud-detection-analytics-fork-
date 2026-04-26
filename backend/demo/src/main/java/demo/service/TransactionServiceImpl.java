package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Override
    public Page<Transaction> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Transaction getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }

    @Override
    public Transaction create(Transaction transaction) {
        return repository.save(transaction);
    }
}