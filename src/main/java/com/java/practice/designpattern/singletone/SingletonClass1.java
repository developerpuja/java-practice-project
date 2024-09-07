package com.java.practice.designpattern.singletone;

import java.io.Serializable;

public class SingletonClass1 implements Serializable, Cloneable {
    // volatile object so the value will reflate for all threads

    private static volatile SingletonClass1 INSTANCE;

    //private constructor
    private SingletonClass1() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Object already created");
        }
    }

    protected Object readResolve() {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }

    public SingletonClass1 getInstance() {
       if (INSTANCE == null) {
           synchronized (SingletonClass1.class) {
               if (INSTANCE == null) {
                   return new SingletonClass1();
               }
           }
       }
       return INSTANCE;
    }

}
