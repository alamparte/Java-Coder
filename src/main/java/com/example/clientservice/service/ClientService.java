package com.example.clientservice.service;

import com.example.clientservice.model.ClientModel;
import com.example.clientservice.model.ClientResponse;
import com.example.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    // crear nuevo cliente
    public ClientModel create(ClientModel newClient) {
        return this.clientRepository.save(newClient);
    }

    // buscar cliente
    public ClientModel findById(Long id) {
        Optional<ClientModel> clientJSON = this.clientRepository.findById(id);
        return clientJSON.orElse(null);
    }
    // calcular edad
    public int calcularEdad(ClientModel client) {
        LocalDate fechaNacimiento = client.getFechaNacimiento();
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
}