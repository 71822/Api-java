package com.example.demo.model;

import com.example.demo.view.AffichageArticle;
import com.example.demo.view.AffichageCommande;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
//@IdClass(CleMaitrise.class)
@Getter
@Setter
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({AffichageCommande.class, AffichageArticle.class})
    private Integer id;

    @JsonView({AffichageCommande.class, AffichageArticle.class})
    private Date datePaiement;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonView({AffichageCommande.class, AffichageArticle.class})
    private Utilisateur utilisateur;


}
