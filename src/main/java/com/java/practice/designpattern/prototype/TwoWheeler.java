package com.java.practice.designpattern.prototype;

public class TwoWheeler extends Vehicle{
    private boolean isElectric;


    public TwoWheeler(String engine, String model, double price, boolean isElectric) {
        super(engine, model, price);
        this.isElectric = isElectric;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (FourWheeler)super.clone();
    }
}
