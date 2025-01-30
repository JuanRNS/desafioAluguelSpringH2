package com.example.jrns.desafioAluguel.repository;

import com.example.jrns.desafioAluguel.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
