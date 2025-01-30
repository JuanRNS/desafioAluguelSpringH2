package com.example.jrns.desafioAluguel.inst;

import com.example.jrns.desafioAluguel.entity.Client;
import com.example.jrns.desafioAluguel.repository.CarRepository;
import com.example.jrns.desafioAluguel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        clientRepository.deleteAll();

        Client client1 = new Client(null,
                "Juan Ramalho",
                "064.328.814-71",
                null,
                LocalDate.parse("01/06/2002",dtf),
                LocalDate.parse("01/05/2018",dtf), LocalDate.now());
        Client client2 = new Client(null,
                "Kayllane Mendes",
                "035.333.344-72",
                null,
                LocalDate.parse("22/05/2002",dtf),
                LocalDate.parse("01/08/2018",dtf), LocalDate.now());
        Client client3 = new Client(null,
                "Fafa Mendes",
                "033.333.344-72",
                null,
                LocalDate.parse("22/05/2003",dtf),
                LocalDate.parse("01/08/2020",dtf), LocalDate.now());
        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);

    }
}
