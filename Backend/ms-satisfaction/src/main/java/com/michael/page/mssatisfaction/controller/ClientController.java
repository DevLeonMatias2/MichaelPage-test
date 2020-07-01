package com.michael.page.mssatisfaction.controller;

import com.michael.page.mssatisfaction.model.entity.Client;
import com.michael.page.mssatisfaction.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Endpoint de Cliente", consumes = "endpoint de creacion y reporte de encuestas de usuario")
public class ClientController {


    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/new")
    @ApiOperation(value = "creacion de nuevo registro", notes = "retorna el usario creado")
    public ResponseEntity<?> createQualification(@Valid @RequestBody Client user) {
        Client client;
        Map<String, Object> response = new HashMap<>();

        try {
            client = clientService.createNewQualifier(user);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (client == null) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);

    }

    @GetMapping(value = "/report")
    @ApiOperation(value = "Listado de todas las encuestas ", notes = "encuestas")
    public ResponseEntity<?> getAll() {
        List<Client> listClient;
        Map<String, Object> response = new HashMap<>();
        try {
            listClient = clientService.findAll();
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(listClient, HttpStatus.OK);

    }

}
