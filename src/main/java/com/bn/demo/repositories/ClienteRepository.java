package com.cliente.demo.repositories;

import com.cliente.demo.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

}
