package org.example.budgettransaction.controller;

import org.example.budgettransaction.Services.BudgetService;
import org.example.budgettransaction.dto.BudgetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    // Ajouter
    @PostMapping
    public BudgetDto addBudget(@RequestBody BudgetDto budgetDto) {
        return budgetService.saveBudget(budgetDto);
    }

    // Récupérer par ID
    @GetMapping("/{id}")
    public BudgetDto getBudgetById(@PathVariable Long id) {
        return budgetService.getBudgetById(id);
    }

    // Récupérer tous
    @GetMapping
    public List<BudgetDto> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    // Modifier
    @PutMapping("/{id}")
    public BudgetDto updateBudget(@PathVariable Long id, @RequestBody BudgetDto budgetDto) {
        return budgetService.updateBudget(id, budgetDto);
    }

    // Supprimer
    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }
}
