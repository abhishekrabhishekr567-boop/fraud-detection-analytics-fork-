package com.example.demo.service;

import com.example.demo.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {

    Page<Transaction> getAll(Pageable pageable);

    Transaction getById(Long id);

    Transaction create(Transaction transaction);
}