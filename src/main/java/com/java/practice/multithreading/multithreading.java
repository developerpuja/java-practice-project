package com.java.practice.multithreading;

public class multithreading {
    public static void main(String[] args) {
      MyThread myThread = new MyThread();
      myThread.start();

      Thread thread = new Thread(new MyRunnable());
      thread.start();
    }
}
