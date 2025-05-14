package org.example.budgettransaction.Services;


import org.example.budgettransaction.entites.Budget;
import org.example.budgettransaction.repesotory.BudgetRepository;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    // ajouter
    public Budget saveBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    // Récupérer par id

    public Budget getBudgetById(long id) {
        return budgetRepository.findById(id).get();
    }

    // Récupérer

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

     // Modifier

    public Budget updateBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    // Supprimer

    public void deleteBudget(long id) {
        budgetRepository.deleteById(id);
    }

}
