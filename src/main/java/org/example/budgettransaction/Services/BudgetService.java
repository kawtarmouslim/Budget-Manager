package org.example.budgettransaction.Services;

import org.example.budgettransaction.dto.BudgetDto;
import org.example.budgettransaction.entites.Budget;
import org.example.budgettransaction.repesotory.BudgetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Ajouter
    public BudgetDto saveBudget(BudgetDto budgetDto) {
        Budget budget = modelMapper.map(budgetDto, Budget.class);
        Budget saved = budgetRepository.save(budget);
        return modelMapper.map(saved, BudgetDto.class);
    }

    // Récupérer par ID
    public BudgetDto getBudgetById(Long id) {
        Optional<Budget> budget = budgetRepository.findById(id);
        return budget.map(b -> modelMapper.map(b, BudgetDto.class)).orElse(null);
    }

    // Récupérer tous les budgets
    public List<BudgetDto> getAllBudgets() {
        List<Budget> budgets = budgetRepository.findAll();
        return budgets.stream()
                .map(budget -> modelMapper.map(budget, BudgetDto.class))
                .collect(Collectors.toList());
    }

    // Modifier
    public BudgetDto updateBudget(Long id, BudgetDto budgetDto) {
        // Récupérer le budget existant ou lancer une exception
        Budget existing = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget introuvable avec l'id: " + id));

        // Mettre à jour uniquement les champs nécessaires
        existing.setMontant(budgetDto.getMontant());

        // Sauvegarder
        Budget updated = budgetRepository.save(existing);

        // Retourner le DTO
        return modelMapper.map(updated, BudgetDto.class);
    }


    // Supprimer
    public void deleteBudget(Long idBudget) {
        budgetRepository.deleteById(idBudget);
    }
}
