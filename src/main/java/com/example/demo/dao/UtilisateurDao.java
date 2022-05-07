package com.example.demo.dao;

import com.example.demo.model.Utilisateur;
import com.example.demo.view.AffichageUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur,Integer> {

    Optional<Utilisateur> findByLogin(String login);

    @Query("SELECT COUNT(*) FROM Utilisateur U")
    @JsonView(AffichageUtilisateur.class)
    Integer compteUtilisateur();

}
