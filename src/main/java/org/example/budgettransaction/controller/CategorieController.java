package org.example.budgettransaction.controller;

import lombok.AllArgsConstructor;
import org.example.budgettransaction.dto.CategorieDto;
import org.example.budgettransaction.Services.CategorieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/categorie")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping("categorie")
    // ajouter
    public ResponseEntity<CategorieDto> save(@RequestBody CategorieDto dto) {
        CategorieDto saved = categorieService.save(dto);
        return ResponseEntity.ok(saved);
    }
    //toutes les catégories
    @GetMapping("categories")
    public ResponseEntity<List<CategorieDto>> getAll() {
        List<CategorieDto> categories = categorieService.getAll();
        return ResponseEntity.ok(categories);
    }

    // Modifier
    @PutMapping("{idcategorie}")
    public ResponseEntity<CategorieDto> update(@PathVariable Long idcategorie , @RequestBody CategorieDto dto) {
        CategorieDto updated = categorieService.update(idcategorie, dto);
        return ResponseEntity.ok(updated);
    }


    // Supprimer
    @DeleteMapping("{idcategorie}")
    public ResponseEntity<CategorieDto> deleteCategorie(@PathVariable Long idcategorie) {

            categorieService.deleteCategorie(idcategorie);
            return ResponseEntity.ok().build();

    }

}
