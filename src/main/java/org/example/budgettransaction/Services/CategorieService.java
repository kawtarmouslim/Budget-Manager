package org.example.budgettransaction.Services;


import org.example.budgettransaction.dto.CategorieDto;
import org.example.budgettransaction.entites.Categorie;
import org.example.budgettransaction.repesotory.CategorieRepository;
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
    private ModelMapper modelMapper;

    // Ajouter
    public CategorieDto save(CategorieDto categorieDto) {
        Categorie categorie = modelMapper.map(categorieDto, Categorie.class);
        Categorie saved = categorieRepository.save(categorie);
        return modelMapper.map(saved, CategorieDto.class);
    }

    // toutes les catégories
    public List<CategorieDto> getAll() {
        List<Categorie> categories = categorieRepository.findAll();
        return categories.stream()
                .map(cat -> modelMapper.map(cat, CategorieDto.class))
                .collect(Collectors.toList());
    }

    // Modifier
    public CategorieDto update(Long id, CategorieDto dto) {
        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable"));
        categorie.setNom(dto.getNom());
        categorie.setType(dto.getType());
        Categorie updated = categorieRepository.save(categorie);
        return modelMapper.map(updated, CategorieDto.class);
    }

    // Supprimer
    public void delete(Long id) {
        categorieRepository.deleteById(id);
    }
}

