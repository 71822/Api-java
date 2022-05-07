package com.example.demo.controller;


import com.example.demo.dao.EmployeDao;
import com.example.demo.dao.UtilisateurDao;
import com.example.demo.model.Employe;
import com.example.demo.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class UtilisateurController {

    UtilisateurDao utilisateurDao;
    EmployeDao employeDao;

    @Autowired
    public UtilisateurController(UtilisateurDao utilisateurDao, EmployeDao employeDao) {

        this.utilisateurDao = utilisateurDao;
        this.employeDao = employeDao;
    }

    @GetMapping("/compte-utilisateur")
    public Integer compteUtilisateur() {
        return this.utilisateurDao.compteUtilisateur();
    }


    @DeleteMapping("/utilisateur/{login}")
    public String supprimeUtilisateur(@PathVariable String login) {

        Utilisateur utilisateur =  utilisateurDao.findByLogin(login).orElse(null);
        int id = utilisateur.getId();
        Employe employe = employeDao.findById(id).orElse(null);

        String reponse = "";
        if(employe == null) {
            utilisateurDao.deleteById(id);
            reponse = "Utilisateur supprimé";
        }else if(employe != null){
            reponse = "Impossible de supprimer un administrateur";
        }
        return reponse;

    }

}
