package com.CoffeeShop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MyCoffee")
public class YourCoffee {
    @Id
    private int id;
    private String coffeeName;

    public YourCoffee(int id, String coffeeName, String price) {
        this.id = id;
        this.coffeeName = coffeeName;
        this.price = price;
    }

    public YourCoffee() {
        super();
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
