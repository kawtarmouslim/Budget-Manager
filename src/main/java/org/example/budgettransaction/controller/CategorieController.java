package org.example.budgettransaction.controller;

import lombok.AllArgsConstructor;
import org.example.budgettransaction.dto.CategorieDto;
import org.example.budgettransaction.service.CategorieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
