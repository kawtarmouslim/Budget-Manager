package org.example.budgettransaction.controller;


import org.example.budgettransaction.Services.BudgetService;
import org.example.budgettransaction.entites.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    //Ajouter
    public Budget addBudget(@RequestBody Budget budget) {
        return budgetService.saveBudget(budget);
    }

    //Récupérer

    public Budget getBudgetById(@PathVariable Long id) {
        return budgetService.getBudgetById(id);
    }

    //Récupérer tous les budgets

    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    // Modifier

    public Budget updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        return budgetService.updateBudget(budget);
    }

    // Supprimer
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }

}
