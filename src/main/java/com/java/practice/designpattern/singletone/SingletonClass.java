package com.java.practice.designpattern.singletone;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class SingletonClass implements Serializable , Cloneable{
    private static final long serialVersionUID = 1L;

    // Volatile variable to ensure visibility of changes across threads
    private static volatile SingletonClass instance;

    // Private constructor to prevent instantiation
    private SingletonClass() {
        if (instance != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    // Double-checked locking for lazy initialization and thread safety
    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

    // readResolve method to preserve singleton property during deserialization
    protected Object readResolve() {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }

    // Main method for testing
    public static void main(String[] args) throws CloneNotSupportedException {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();

        System.out.println(instance1 == instance2); // should print true
        SingletonClass instance4 = (SingletonClass)instance1.clone();
        System.out.println("instance1- "+instance1);
        System.out.println("instance2- "+instance2);
       // System.out.println("instance3- "+instance3);
        System.out.println("instance4- "+instance4);

        // Try reflection
        try {
            Constructor<SingletonClass> constructor = SingletonClass.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingletonClass instance3 = constructor.newInstance();
            System.out.println(instance1 == instance3); // should throw exception and not reach this line
        } catch (Exception e) {
            System.out.println("In catch");
            System.out.println(e.getMessage()); // should print "Instance already created"
        }
    }
}
