package com.example.demo.dao;

import com.example.demo.model.Caracteristique;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristiqueDao extends JpaRepositoriesRegistrar<Caracteristique, Integer> {
}
