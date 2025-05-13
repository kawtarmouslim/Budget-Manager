package org.example.budgettransaction.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String alimentation;
    private String logement;
    private  String transport;

}
