package com.java.practice.designpattern.prototype;

import lombok.Data;

@Data
public abstract class Vehicle implements Cloneable{
    private String engine;
    private String model;
    private double price;

    public Vehicle(String engine, String model, double price) {
        this.engine = engine;
        this.model = model;
        this.price = price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
