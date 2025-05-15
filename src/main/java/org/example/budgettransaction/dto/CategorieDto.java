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



@NoArgsConstructor
public class CategorieDto implements Serializable {

    String nom;
    String type;


    public CategorieDto(String nom, String type) {
        this.nom = nom;
        this.type = type;
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
}