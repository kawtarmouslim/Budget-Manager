package org.example.budgettransaction.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.budgettransaction.dto.TransactionDto;
import org.example.budgettransaction.entites.Categorie;
import org.example.budgettransaction.entites.Transaction;
import org.example.budgettransaction.repesotory.CategorieRepository;
import org.example.budgettransaction.repesotory.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class TransactionService {
    private ModelMapper modelMapper ;
    @Autowired
    private final TransactionRepository transactionRepository;
    private final CategorieRepository categorieRepository;

    public TransactionService(ModelMapper modelMapper, TransactionRepository transactionRepository, CategorieRepository categorieRepository) {
        this.modelMapper = modelMapper;
        this.transactionRepository = transactionRepository;
        this.categorieRepository = categorieRepository;
    }

    public TransactionDto save(TransactionDto transactionDto) {
        Categorie categorie = categorieRepository.findById(transactionDto.getIdCategorie())
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'id: " + transactionDto.getIdCategorie()));
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        transaction.setCategorie(categorie);
        Transaction savedTransaction = transactionRepository.save(transaction);
        TransactionDto result = modelMapper.map(savedTransaction, TransactionDto.class);
        result.setIdCategorie(savedTransaction.getCategorie().getIdCategorie()); // en cas de bug ModelMapper
        return result;
    }

    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(transaction -> {
                    TransactionDto dto = modelMapper.map(transaction, TransactionDto.class);
                    dto.setIdCategorie(transaction.getCategorie().getIdCategorie());
                    return dto;
                })
                .collect(Collectors.toList());
    }
    @Transactional
    public TransactionDto updateTansaction(Long id, TransactionDto transactionDto) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction introuvable avec l'id: " + id));
        Categorie categorie = categorieRepository.findById(transactionDto.getIdCategorie())
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'id: " + transactionDto.getIdCategorie()));
        existingTransaction.setMontant(transactionDto.getMontant());
        existingTransaction.setDate(transactionDto.getDate());
        existingTransaction.setDescription(transactionDto.getDescription());
        existingTransaction.setCategorie(categorie);
        Transaction updatedTransaction = transactionRepository.save(existingTransaction);
        TransactionDto updatedDto = modelMapper.map(updatedTransaction, TransactionDto.class);
        updatedDto.setIdCategorie(updatedTransaction.getCategorie().getIdCategorie());

        return updatedDto;
    }

    public  void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }



}
