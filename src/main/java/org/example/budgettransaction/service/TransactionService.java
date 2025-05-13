package org.example.budgettransaction.service;

import lombok.AllArgsConstructor;
import org.example.budgettransaction.entites.Transaction;
import org.example.budgettransaction.repesotory.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {
    public final TransactionRepository transactionRepository;


}
