package com.entregable.Cliente.API.REST.controller;

import com.entregable.Cliente.API.REST.model.ClientModel;
import com.entregable.Cliente.API.REST.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "api/clients")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/")
        public ResponseEntity<ClientModel> create(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String fechaNacimiento) {
        return new ResponseEntity<>(this.clientService.create(nombre, apellido, fechaNacimiento), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.clientService.findById(id), HttpStatus.OK);
    }




}
