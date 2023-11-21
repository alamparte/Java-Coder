package com.example.clientservice.controller;

import com.example.clientservice.model.ClientModel;
import com.example.clientservice.model.ClientResponse;
import com.example.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "api/clientsapi")
// Spring MVC convierte automáticamente en JSON antes de enviar la rta HTTP
@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    // método POST para crear un cliente nuevo
    @PostMapping("/")
    public ResponseEntity<ClientModel> create(@RequestBody ClientModel client) {
        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
    }
    // método GET por ID para obtener la data de ese ID-cliente
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable Long id) {
        // en la variable clientFound se guarda el cliente encontrado
        ClientModel clientFound = clientService.findById(id);
        //en caso de ser null
        if (clientFound == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // se guarda en la variable edad el resultado del calculo edad
        int edad = clientService.calcularEdad(clientFound);

        // se instancia la clase ClientResponse para construir la rta JSON
        ClientResponse response = new ClientResponse(clientFound.getName(), clientFound.getLastName(), edad);
        // se retorna la response
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
