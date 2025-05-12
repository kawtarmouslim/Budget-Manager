package org.example.budgettransaction.repesotory;

import org.example.budgettransaction.entites.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
