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


@AllArgsConstructor
@NoArgsConstructor
public class CategorieDto implements Serializable {

    String nom;
    String type;




}