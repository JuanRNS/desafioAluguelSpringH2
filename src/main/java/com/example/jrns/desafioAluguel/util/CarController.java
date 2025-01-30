package com.example.jrns.desafioAluguel.util;

import com.example.jrns.desafioAluguel.entity.Car;
import com.example.jrns.desafioAluguel.entity.Client;
import com.example.jrns.desafioAluguel.repository.CarRepository;
import com.example.jrns.desafioAluguel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CarController {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllCars() {
        return clientRepository.findAll();
    }

}
