package com.java.practice.designpattern.singletone;

import java.io.Serial;
import java.io.Serializable;

public class SingletonClass2 implements Cloneable, Serializable {
    private volatile SingletonClass2 INSTANCE;
    // to avoid reflection api
    private SingletonClass2(){
        if (INSTANCE != null) {
           throw new IllegalStateException("Instance already present");
        }
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }

    @Serial
    protected Object readResolve() {
        return getInstance();
    }

    // double lock check
    public SingletonClass2 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonClass2.class) {
                if (INSTANCE == null) {
                    return new SingletonClass2();
                }
            }
        }

        return INSTANCE;
    }
}
/**
 * 1. volatile instance
 * 2. private constructor with null check
 * 3. override clone method
 * 4. double lock check synchronised block
 * 5. readResolve method to avoid deserialization
 */