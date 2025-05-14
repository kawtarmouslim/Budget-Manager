package org.example.budgettransaction.controller;

import lombok.AllArgsConstructor;
import org.example.budgettransaction.dto.TransactionDto;
import org.example.budgettransaction.Services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("transaction")
    public ResponseEntity<TransactionDto> save(@RequestBody TransactionDto dto) {
        TransactionDto saved = transactionService.save(dto);
        return ResponseEntity.ok(saved);
    }


}
