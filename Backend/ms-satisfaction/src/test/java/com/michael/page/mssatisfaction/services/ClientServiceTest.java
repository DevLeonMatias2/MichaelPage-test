package com.michael.page.mssatisfaction.services;

import com.michael.page.mssatisfaction.model.dao.ClientDao;
import com.michael.page.mssatisfaction.model.entity.Client;
import com.michael.page.mssatisfaction.service.ClientService;
import com.michael.page.mssatisfaction.service.ClientServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientServiceImpl clientServiceimpl;

    @Mock
    private ClientDao clientDao;


    @Test
    public void testGetListAll() {
        when(clientDao.findAll()).thenReturn(new ArrayList<>());
        assertEquals(new ArrayList<>(), clientServiceimpl.findAll());
    }


    @Test
    public void testCreateNewQualifier() {
        Client client = new Client("10", "email", "name", new Date(), 2, "msj");
        Client clientMock = mock(Client.class);
        when(clientDao.save(clientMock)).thenReturn(client);
        assertEquals(2, clientServiceimpl.createNewQualifier(clientMock).getScore());
    }


}
