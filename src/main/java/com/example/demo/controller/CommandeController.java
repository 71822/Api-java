package com.example.demo.controller;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dao.CommandeDao;
import com.example.demo.dao.UtilisateurDao;
import com.example.demo.view.AffichageCommande;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CommandeController {

    UtilisateurDao utilisateurDao;
    CommandeDao commandeDao;
    ArticleDao articleDao;

    @Autowired
    public CommandeController(UtilisateurDao utilisateurDao, CommandeDao commandeDao,ArticleDao articleDao) {

        this.utilisateurDao = utilisateurDao;
        this.commandeDao = commandeDao;
        this.articleDao = articleDao;
    }

    @GetMapping("/liste-commande")
    @JsonView({AffichageCommande.class})
    public List<Object> listeLigneCommande() {
        return commandeDao.commande();
    }

}
