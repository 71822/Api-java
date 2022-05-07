package com.example.demo.dao;


import com.example.demo.model.Employe;
import com.example.demo.view.AffichageEmploye;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Integer> {

    @Query("SELECT COUNT(*) FROM Employe E")
    @JsonView(AffichageEmploye.class)
    Integer compteAdministrateur();

}
