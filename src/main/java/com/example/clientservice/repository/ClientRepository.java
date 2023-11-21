package com.example.clientservice.repository;

import com.example.clientservice.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
