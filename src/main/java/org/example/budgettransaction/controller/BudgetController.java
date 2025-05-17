package org.example.budgettransaction.controller;

import org.example.budgettransaction.Services.BudgetService;
import org.example.budgettransaction.dto.BudgetDto;
import org.example.budgettransaction.dto.CategorieDto;
import org.example.budgettransaction.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    // Ajouter
    @PostMapping("budget")
    public ResponseEntity<BudgetDto> addBudget(@RequestBody BudgetDto budgetDto) {
        BudgetDto savedBudget = budgetService.saveBudget(budgetDto);
        return ResponseEntity.ok(savedBudget);

    }

//
//    // Récupérer par ID
//    @GetMapping("/{id}")
//    public BudgetDto getBudgetById(@PathVariable Long id) {
//        return budgetService.getBudgetById(id);
//    }
//
@GetMapping("budgets")
public ResponseEntity<List<BudgetDto>> getAll() {
    List<BudgetDto> budgets = budgetService.getAllBudgets();
    return ResponseEntity.ok(budgets);
}
    @PutMapping("{idBudget}")
    public ResponseEntity<BudgetDto> update(@PathVariable Long idBudget , @RequestBody BudgetDto dto) {
        BudgetDto updated = budgetService.updateBudget(idBudget, dto);
        return ResponseEntity.ok(updated);
    }
//    // Supprimer
@DeleteMapping("{idBudget}")
public ResponseEntity<BudgetDto> delete(@PathVariable Long idBudget) {
    budgetService.deleteBudget(idBudget);
    return ResponseEntity.ok().build();
}
}
