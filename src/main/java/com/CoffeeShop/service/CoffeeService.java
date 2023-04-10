package com.CoffeeShop.service;

import com.CoffeeShop.entity.Coffee;
import com.CoffeeShop.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;
    public void save(Coffee b){
        coffeeRepository.save(b);
    }
    public List<Coffee> getAllCoffee(){
        return coffeeRepository.findAll();
    }

    public Coffee getMyCoffeeId(int id){
        return coffeeRepository.findById(id).get();
    }

}
