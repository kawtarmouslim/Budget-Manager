package org.example.budgettransaction.Services;


import org.example.budgettransaction.dto.CategorieDto;
import org.example.budgettransaction.dto.TransactionDto;
import org.example.budgettransaction.entites.Budget;
import org.example.budgettransaction.entites.Categorie;
import org.example.budgettransaction.repesotory.BudgetRepository;
import org.example.budgettransaction.repesotory.CategorieRepository;
import org.example.budgettransaction.repesotory.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private BudgetRepository budgetRepository;
    private TransactionRepository transactionRepository;
    @Autowired
    public CategorieService(CategorieRepository categorieRepository, TransactionRepository transactionRepository) {
        this.categorieRepository = categorieRepository;
        this.transactionRepository = transactionRepository;
    }
    @Autowired
    private ModelMapper modelMapper;

    // Ajouter
    public CategorieDto save(CategorieDto categorieDto) {
        Budget budget = budgetRepository.findById(categorieDto.getIdBudget())
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'id: " + categorieDto.getIdBudget()));
        Categorie categorie = modelMapper.map(categorieDto, Categorie.class);
        Categorie saved = categorieRepository.save(categorie);
        CategorieDto reslt= modelMapper.map(saved, CategorieDto.class);
        reslt.setIdBudget(saved.getBudget().getIdBudget()); // en cas de bug ModelMapper
        return reslt;
    }

    public List<CategorieDto> getAll() {
        List<Categorie> categories = categorieRepository.findAll();

        return categories.stream().map(categorie -> {
            CategorieDto dto = modelMapper.map(categorie, CategorieDto.class);
            if (categorie.getBudget() != null) {
                dto.setIdBudget(categorie.getBudget().getIdBudget());
            } else {
                // Decide what to do if budget is null; maybe set to null or a default value
                dto.setIdBudget(null);
            }
            return dto;
        }).collect(Collectors.toList());
    }



    public CategorieDto update(Long id, CategorieDto dto) {
        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable"));
        categorie.setNom(dto.getNom());
        categorie.setType(dto.getType());
        if (dto.getIdBudget() != null) {
            Budget budget = budgetRepository.findById(dto.getIdBudget())
                    .orElseThrow(() -> new RuntimeException("Budget introuvable avec l'id: " + dto.getIdBudget()));
            categorie.setBudget(budget);
        }
        Categorie updated = categorieRepository.save(categorie);
        // Mapping manuel pour éviter le bug ModelMapper sur budget
        CategorieDto result = modelMapper.map(updated, CategorieDto.class);
        result.setIdBudget(updated.getBudget().getIdBudget());
        result.setIdCategorie(updated.getIdCategorie());
        return result;
    }

    public void deleteCategorie(Long id) {
        // Vérifie si la catégorie existe
        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'id: " + id));
        // Supprime la catégorie
        categorieRepository.delete(categorie);
    }



}

