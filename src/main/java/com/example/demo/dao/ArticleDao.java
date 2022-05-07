package com.example.demo.dao;

import com.example.demo.model.Article;
import com.example.demo.model.Commande;
import com.example.demo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleDao extends JpaRepository<Article,Integer> {

    @Query("SELECT a.employe.login, a.nom FROM Article a WHERE a.employe.id = :id")
    List<Object> listeArticleAgerer(@Param("id") Integer id);

}
