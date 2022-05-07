package com.example.demo.dao;

import com.example.demo.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande,Integer> {

    @Query("SELECT c.id, c.datePaiement, c.utilisateur.login, l.quantite, a.nom, a.prix FROM Commande c, LigneCommande l, Article a")
    List<Object> commande();

}
