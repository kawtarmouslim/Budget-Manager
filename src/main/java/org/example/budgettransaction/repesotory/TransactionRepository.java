package org.example.budgettransaction.repesotory;

import org.example.budgettransaction.entites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
