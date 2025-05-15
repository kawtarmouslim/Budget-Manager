package org.example.budgettransaction.Services;

import lombok.AllArgsConstructor;
import org.example.budgettransaction.dto.CategorieDto;
import org.example.budgettransaction.entites.Categorie;
import org.example.budgettransaction.repesotory.CategorieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor

public class CategorieService {
    private final CategorieRepository categorieRepository;
    @Autowired
    public ModelMapper modelMapper ;

    public CategorieDto save(CategorieDto categorieDto) {
        Categorie categorie = modelMapper.map(categorieDto, Categorie.class);
        Categorie savedCategorie=categorieRepository.save(categorie);
        return modelMapper.map(savedCategorie, CategorieDto.class);
    }




}
