package com.example.demo.model;


import com.example.demo.view.AffichageEmploye;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Employe extends Utilisateur {

    @JsonView({AffichageEmploye.class})
    private Boolean administrateur;

}
