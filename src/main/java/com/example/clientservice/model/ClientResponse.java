package com.example.clientservice.model;

import lombok.Data;

@Data
public class ClientResponse {
    private String nombre;
    private String apellido;
    private int edad;
    public ClientResponse(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
