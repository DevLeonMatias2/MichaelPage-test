package com.michael.page.mssatisfaction.service;

import com.michael.page.mssatisfaction.model.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    Client createNewQualifier(Client client);

    Client findByEmail(String email);

    List<Client> findAll();
}
