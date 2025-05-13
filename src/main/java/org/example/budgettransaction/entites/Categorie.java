package org.example.budgettransaction.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String nom;
    private String type;
    @OneToMany(mappedBy = "categorie")
    private List<Transaction> transaction;
    @OneToOne()
    @JoinColumn(name = "idbudget")
    private Budget budget;


}
