package org.example.budgettransaction.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Transaction {
    @Id
    private Long id;
    private double montant;
    private Date date;
    private String description;
    @ManyToOne
    private Categorie categorie;
}
