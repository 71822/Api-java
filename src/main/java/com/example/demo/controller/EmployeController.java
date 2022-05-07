package com.example.demo.controller;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dao.EmployeDao;
import com.example.demo.model.Article;
import com.example.demo.model.Employe;
import com.example.demo.view.AffichageArticle;
import com.example.demo.view.AffichageEmploye;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeController {

    EmployeDao employeDao;
    ArticleDao articleDao;

    @Autowired
    public EmployeController(EmployeDao employeDao, ArticleDao articleDao) {

        this.employeDao = employeDao;
        this.articleDao = articleDao;
    }

    @GetMapping("/employe/{id}")
    @JsonView({AffichageArticle.class})
    public List<Object> listeArticleAgerer(@PathVariable int id){

        return articleDao.listeArticleAgerer(id);
    }

    @GetMapping("/liste-employe")
    @JsonView(AffichageEmploye.class)
    public List<Employe> employe(){
        List<Employe> listeEmploye = this.employeDao.findAll();
        return listeEmploye;
    }

    @GetMapping("/compte-administrateur")
    public Integer compteAdministrateur() {
        return this.employeDao.compteAdministrateur();
    }


}
