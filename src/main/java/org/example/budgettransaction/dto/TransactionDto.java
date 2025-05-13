package org.example.budgettransaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.example.budgettransaction.entites.Transaction;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    double montant;
    Date date;
    String description;
    Long idCategorie;

}