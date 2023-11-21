package com.example.clientservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
//@Data
@Table(name = "clients")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    public ClientModel(Long id, String name, String lastName, LocalDate fechaNacimiento) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.fechaNacimiento = fechaNacimiento;
    }
}
