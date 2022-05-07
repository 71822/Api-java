package com.example.demo.model;

import com.example.demo.view.AffichageArticle;
import com.example.demo.view.AffichageCommande;
import com.example.demo.view.AffichageEmploye;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Article {

    public Article() {
    }

    public Article(String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Collection<Article> getListeArticle() {
        return null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({AffichageArticle.class, AffichageEmploye.class})
    private Integer id;

    @JsonView({AffichageArticle.class, AffichageEmploye.class, AffichageCommande.class})
    private String nom;

    @JsonView({AffichageArticle.class, AffichageEmploye.class, AffichageCommande.class})
    private float prix;


    @JsonView({AffichageArticle.class, AffichageEmploye.class})
    @ManyToOne
    @JoinColumn(name = "gestionnaire_id")
    private Employe employe;


}
