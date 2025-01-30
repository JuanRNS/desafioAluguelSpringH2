package com.example.jrns.desafioAluguel.service;

import com.example.jrns.desafioAluguel.entity.Car;
import com.example.jrns.desafioAluguel.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Service
public class CarService implements Serializable {

    @Autowired
    private CarRepository carRepository;

    @Serial
    private static final long serialVersionUID = 1L;

    public void cadastrarCarro(Car car) {
        carRepository.save(car);
    }
    public List<Car> listarCarros() {
        return carRepository.findAll();
    }
    public Car buscarCarroPorId(Long id) {
        return carRepository.findById(id).get();
    }
    public void excluirCarro(Car car) {
        carRepository.delete(car);
    }
    public void alterarCarro(Car car) {
        Car carAtual = carRepository.findById(car.getId()).get();
        carAtual.setModelo(car.getModelo());
        carAtual.setMarca(car.getMarca());
    }
}
