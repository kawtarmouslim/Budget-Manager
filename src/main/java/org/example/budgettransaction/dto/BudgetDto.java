package org.example.budgettransaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

public class BudgetDto implements Serializable {
    Long idBudget;
    Double montant;

    public Long getIdBudget() {
        return idBudget;
    }

    public void setIdBudget(Long idBudget) {
        this.idBudget = idBudget;
    }

    public BudgetDto() {
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public BudgetDto(Long idBudget, Double montant) {
        this.idBudget = idBudget;
        this.montant = montant;
    }
}