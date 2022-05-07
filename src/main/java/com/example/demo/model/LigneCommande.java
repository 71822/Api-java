package com.example.demo.model;

import com.example.demo.view.AffichageArticle;
import com.example.demo.view.AffichageCommande;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({AffichageCommande.class})
    private Integer id;

    @JsonView({AffichageCommande.class, AffichageArticle.class})
    private Integer quantite;

    @ManyToOne
    @JsonView({AffichageCommande.class, AffichageArticle.class})
    private Commande commande;

    @ManyToOne
    @JsonView({AffichageCommande.class, AffichageArticle.class})
    private Article article;
}
