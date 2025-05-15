package org.example.budgettransaction.controller;

import lombok.AllArgsConstructor;
import org.example.budgettransaction.dto.CategorieDto;
import org.example.budgettransaction.Services.CategorieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategorieController {

    private final CategorieService categorieService;

    @PostMapping("categorie")

    public ResponseEntity<CategorieDto> save(@RequestBody CategorieDto dto) {
        CategorieDto saved = categorieService.save(dto);
        return ResponseEntity.ok(saved);
    }



}
