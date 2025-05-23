package org.example.budgettransaction.controller;

import lombok.AllArgsConstructor;
import org.example.budgettransaction.Services.TransactionService;
import org.example.budgettransaction.dto.TransactionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("transaction")
    public ResponseEntity<TransactionDto> save(@RequestBody TransactionDto dto) {
        TransactionDto saved = transactionService.save(dto);
        return ResponseEntity.ok(saved);
    }
    @GetMapping
    public ResponseEntity<List<TransactionDto>> findAll() {
        List<TransactionDto> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<TransactionDto> delete(@PathVariable Long id) {
        transactionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<TransactionDto> update(@PathVariable Long id, @RequestBody TransactionDto dto) {
        TransactionDto transactionDto=transactionService.updateTansaction(id, dto);
        return ResponseEntity.ok(transactionDto);
    }

}
