package com.example.multiplelistfilterarraylist;

public class Dish {

    private int dishId;
    private String dishName;

    public Dish(int dishId, String dishName) {
        this.dishId = dishId;
        this.dishName = dishName;
    }

    public int getDishId() {
        return dishId;
    }

    public String getDishName() {
        return dishName;
    }

}
