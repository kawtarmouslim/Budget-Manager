package org.example.budgettransaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.example.budgettransaction.entites.Budget;

import java.io.Serializable;

@AllArgsConstructor
@Data
@Value
public class BudgetDto implements Serializable {
    Long idBudget;
    Double montant;
    Long categoryId;

}