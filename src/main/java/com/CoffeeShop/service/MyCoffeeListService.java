package com.CoffeeShop.service;

import com.CoffeeShop.entity.YourCoffee;
import com.CoffeeShop.repository.MyCoffeeListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCoffeeListService {

    @Autowired
    private MyCoffeeListRepo myCoffeeListRepo;

    public void saveMyCoffeeList(YourCoffee yourCoffee){
        myCoffeeListRepo.save(yourCoffee);
    }
    public List<YourCoffee> showMyCoffeeList()
    {
        return myCoffeeListRepo.findAll();
    }

    public void deleteItemById(int id)
    {
        myCoffeeListRepo.deleteById(id);
    }
}
