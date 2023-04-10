package com.CoffeeShop.repository;

import com.CoffeeShop.entity.YourCoffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCoffeeListRepo extends JpaRepository<YourCoffee,Integer> {
}
