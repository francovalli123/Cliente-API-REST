package com.entregable.Cliente.API.REST.repository;

import com.entregable.Cliente.API.REST.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel,Long> {


}
