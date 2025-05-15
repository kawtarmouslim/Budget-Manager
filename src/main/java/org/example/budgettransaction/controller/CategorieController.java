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
    // ajouter
    public ResponseEntity<CategorieDto> save(@RequestBody CategorieDto dto) {
        CategorieDto saved = categorieService.save(dto);
        return ResponseEntity.ok(saved);
    }
    //toutes les catégories
    @GetMapping
    public ResponseEntity<List<CategorieDto>> getAll() {
        List<CategorieDto> categories = categorieService.getAll();
        return ResponseEntity.ok(categories);
    }

    // Modifier
    @PutMapping("/{id}")
    public ResponseEntity<CategorieDto> update(@PathVariable Long id, @RequestBody CategorieDto dto) {
        CategorieDto updated = categorieService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    // Supprimer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categorieService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
