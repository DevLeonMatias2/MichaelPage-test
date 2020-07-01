package com.michael.page.mssatisfaction.service;

import com.michael.page.mssatisfaction.model.dao.ClientDao;
import com.michael.page.mssatisfaction.model.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import java.util.Date;
import java.util.List;

@Controller
public class ClientServiceImpl implements ClientService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public Client createNewQualifier(Client client) {
        logger.info("Ingresando Nuevo Registro->{}", client);
        client.setCreateDate(new Date());
        return clientDao.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll() ;
    }

}
