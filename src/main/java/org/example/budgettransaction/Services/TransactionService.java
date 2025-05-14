package org.example.budgettransaction.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.budgettransaction.dto.TransactionDto;
import org.example.budgettransaction.entites.Transaction;
import org.example.budgettransaction.repesotory.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class TransactionService {
    private ModelMapper modelMapper ;
    private final TransactionRepository transactionRepository;


    @Transactional
    public TransactionDto save(TransactionDto transactionDto) {
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return modelMapper.map(savedTransaction, TransactionDto.class);
    }


    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
                return transactions.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
    }


}
