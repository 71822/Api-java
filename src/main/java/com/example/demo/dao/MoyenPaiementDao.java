package com.example.demo.dao;

import com.example.demo.model.MoyenPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoyenPaiementDao extends JpaRepository<MoyenPaiement,Integer> {
}
