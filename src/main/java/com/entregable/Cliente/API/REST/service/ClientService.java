package com.entregable.Cliente.API.REST.service;


import com.entregable.Cliente.API.REST.model.ClientModel;
import com.entregable.Cliente.API.REST.repository.ClientRepository;

import org.jetbrains.annotations.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientModel create(String nombre, String apellido, String fechaNacimiento ){
        ClientModel c = new ClientModel();
        c.setNombre(nombre);
        c.setApellido(apellido);
        c.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
        return this.clientRepository.save(c);
    }

    public String findById(Long id){
        Optional<ClientModel> cajaCliente = this.clientRepository.findById(id);
        if(cajaCliente.isPresent()){
            ClientModel c = cajaCliente.get();

            String jsonFormat = " {\n" +
                    "                \"id\": " + c.getId() + "," +
                    "                \"nombre\": " + "\"" + c.getNombre() + "\"" + "," +
                    "                \"apellido\": " + "\""  + c.getApellido() + "\""+ "," +
                    "                \"edad\": " + "\"" + this.calcularEdad(c.getFechaNacimiento()) + "\"" +
            "              }";

            return jsonFormat;
        }
        return null;
    }

    private int calcularEdad(@NotNull LocalDate fechaNacimiento){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento.toString(), fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);

        return periodo.getYears();
    }
}
