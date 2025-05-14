package org.example.budgettransaction.service;

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
@AllArgsConstructor
public class TransactionService {
    private ModelMapper modelMapper ;
    @Autowired
    private final TransactionRepository transactionRepository;
    private final CategorieRepository categorieRepository;

    @Transactional
    public TransactionDto save(TransactionDto transactionDto) {
        // Étape 1 : charger la catégorie
        Categorie categorie = categorieRepository.findById(transactionDto.getIdCategorie())
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'id: " + transactionDto.getIdCategorie()));

        // Étape 2 : mapper DTO vers Entity avec ModelMapper
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);

        // Étape 3 : injecter manuellement la catégorie (ModelMapper ne sait pas faire ça tout seul)
        transaction.setCategorie(categorie);

        // Étape 4 : sauvegarde
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Étape 5 : remapper vers DTO
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


}
