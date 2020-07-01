package com.michael.page.mssatisfaction.controller;

import com.michael.page.mssatisfaction.model.entity.Client;
import com.michael.page.mssatisfaction.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@Api(value="Endpoint de Cliente", consumes="endpoint de creacion y reporte de encuestas de usuario")
public class ClientController {


    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value="/new")
    @ApiOperation(value="creacion de nuevo registro",notes="retorna el usario creado")
    public Client createQualification(@Valid @RequestBody Client user){
        return clientService.createNewQualifier(user);
    }

    @GetMapping(value = "/report")
    @ApiOperation(value = "Listado de todas las encuestas ",notes="encuestas")
    public List<Client> getAll(){
        return clientService.findAll();
    }

}
