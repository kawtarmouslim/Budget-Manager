package org.example.budgettransaction.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Budget {
    @Id
    private Long idBudget;
    private Double montant;
    @OneToOne(mappedBy = "budget")
    private Categorie category;

}
