package com.example.demo.controller;


import com.example.demo.dao.ArticleDao;
import com.example.demo.dao.CommandeDao;
import com.example.demo.dao.UtilisateurDao;
import com.example.demo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ArticleController {

    ArticleDao articleDao;
    UtilisateurDao utilisateurDao;
    CommandeDao commandeDao;

    @Autowired
    public ArticleController(UtilisateurDao utilisateurDao, CommandeDao commandeDao, ArticleDao articleDao) {

        this.utilisateurDao = utilisateurDao;
        this.commandeDao = commandeDao;
        this.articleDao = articleDao;
    }

    @PostMapping("/article")
    public String ajoutArticle(@RequestBody Article article) {
        articleDao.save(article);
        return "Ok";
    }
}
