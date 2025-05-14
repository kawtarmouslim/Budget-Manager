package org.example.budgettransaction.controller;


import org.example.budgettransaction.Services.BudgetService;
import org.example.budgettransaction.entites.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    //Ajouter
    @PostMapping
    public Budget addBudget(@RequestBody Budget budget) {
        return budgetService.saveBudget(budget);
    }

    //Récupérer
    @GetMapping("/{id}")
    public Budget getBudgetById(@PathVariable Long id) {
        return budgetService.getBudgetById(id);
    }

    //Récupérer tous les budgets
    @GetMapping
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    // Modifier
    @PutMapping("/{id}")
    public Budget updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        return budgetService.updateBudget(budget);
    }

    // Supprimer
    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }

}
