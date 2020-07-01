package com.michael.page.mssatisfaction.model.dao;

import com.michael.page.mssatisfaction.model.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends MongoRepository<Client, String> {

    Client findByEmail(String email);
}
