package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class test {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    private void init (){

        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    void appelApiGetListeEmploye_obtientCode200() throws Exception {

        mvc.perform(get("/liste-employe")).andExpect(status().isOk());

    }

    @Test
    void appelApiGetListeEmploye_contientJSON() throws Exception {

        mvc.perform(get("/liste-employe").contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void appelApiGetListeEmploye_neContientPasMotDePasse() throws Exception {

        //deuxieme employe possède une propriété "id"
        mvc.perform(get("/liste-employe"))
                .andExpect(jsonPath("$[1].login").exists());

        //deuxieme possède une propriété "password"
        mvc.perform(get("/liste-employe"))
                .andExpect(jsonPath("$[1].password").exists());

    }
}
