package com.CoffeeShop.controller;

import com.CoffeeShop.service.MyCoffeeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCoffeeListController {
    @Autowired
    private MyCoffeeListService myCoffeeListService;

@RequestMapping("/deleteItemById/{id}")
    public String deleteMyItem(@PathVariable ("id") int id){
    myCoffeeListService.deleteItemById(id);
        return "redirect:/your_orders";
    }
}
