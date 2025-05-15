package org.example.budgettransaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.example.budgettransaction.entites.Categorie;
import org.example.budgettransaction.entites.Transaction;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data




public class CategorieDto implements Serializable {
     Long idCategorie;

    String nom;
    String type;
    Long idBudget;

    public CategorieDto(Long idCategorie, String nom, String type, Long idBudget) {
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.type = type;
        this.idBudget = idBudget;
    }

    public CategorieDto() {
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getIdBudget() {
        return idBudget;
    }

    public void setIdBudget(Long idBudget) {
        this.idBudget = idBudget;
    }
}