package com.java.practice.designpattern.prototype;

public class FourWheeler extends Vehicle{
    private boolean isElectric;
    private boolean isDiesel;
    private boolean isAutomatic;

    public FourWheeler(String engine, String model, double price, boolean isElectric, boolean isDiesel, boolean isAutomatic) {
        super(engine, model, price);
        this.isElectric = isElectric;
        this.isAutomatic = isAutomatic;
        this.isDiesel = isDiesel;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (TwoWheeler)super.clone();
    }
}
