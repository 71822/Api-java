package com.example.demo.model;


import com.example.demo.view.AffichageCommande;
import com.example.demo.view.AffichageEmploye;
import com.fasterxml.jackson.annotation.JsonView;
import com.example.demo.view.AffichageUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    public Utilisateur() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({AffichageUtilisateur.class, AffichageEmploye.class})
    private Integer id;

   @JsonView({AffichageUtilisateur.class, AffichageEmploye.class, AffichageCommande.class})
    private String login;

    @JsonView({AffichageUtilisateur.class, AffichageEmploye.class})
    private String password;


    @ManyToMany
    @JoinTable(
            name = "utilisateur_moyen_paiement",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "moyen_paiement_id")
    )
    @JsonView(AffichageUtilisateur.class)
    private List<MoyenPaiement> listeMoyenPaiement = new ArrayList<>();

}
