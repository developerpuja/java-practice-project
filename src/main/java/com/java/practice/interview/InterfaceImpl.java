package com.java.practice.interview;

public class InterfaceImpl implements InterfaceClass1, InterfaceClass2{

    @Override
    public void testAbstractMethod() {

    }

    @Override
    public void print() {

    }

    @Override
    public void defaultMethod() {
        InterfaceClass1.super.defaultMethod();
    }
}
