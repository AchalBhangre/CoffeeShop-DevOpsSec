package com.CoffeeShop.controller;

import com.CoffeeShop.entity.Coffee;
import com.CoffeeShop.entity.YourCoffee;
import com.CoffeeShop.service.CoffeeService;
import com.CoffeeShop.service.MyCoffeeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CafeController {
    @Autowired
    CoffeeService coffeeService;

    @Autowired
    MyCoffeeListService myCoffeeListService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/coffee_register")
    public String coffeeRegister(){
        return "coffeeRegister";
    }

    @GetMapping("/available_coffee")
    public ModelAndView getAllCoffee(){
        List<Coffee> list=coffeeService.getAllCoffee();
        /*ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("coffeeList");
        modelAndView.addObject("coffee",list);*/
        return new ModelAndView("availableCoffee","coffee",list);
    }

    @GetMapping("/your_orders")
    public String getMyOrders(Model model){
        List<YourCoffee> list=myCoffeeListService.showMyCoffeeList();
        model.addAttribute("coffee",list);
        return "yourOrders";
    }
    @PostMapping("/save")
    public String addCoffeeRecord(@ModelAttribute Coffee coffee){
        coffeeService.save(coffee);
        return "redirect:/available_coffee";
    }
    @RequestMapping("/myCoffeeList/{id}")
    public String getMyCoffeeList(@PathVariable("id") int id)
    {
        Coffee coffee=coffeeService.getMyCoffeeId(id);
        YourCoffee myCoffee=new YourCoffee(coffee.getId(),coffee.getCoffeeName(),coffee.getPrice());
        myCoffeeListService.saveMyCoffeeList(myCoffee);
        return "redirect:/your_orders";
    }
    @RequestMapping("/coffeeEdit/{id}")
    public String editMyCoffeeList(@PathVariable("id") int id,Model model)
    {
        Coffee coffeeId=coffeeService.getMyCoffeeId(id);
        model.addAttribute("coffee",coffeeId);
        return "CoffeeEdit";
    }
}
