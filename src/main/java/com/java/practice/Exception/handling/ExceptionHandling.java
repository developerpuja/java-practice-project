package com.java.practice.Exception.handling;

import java.io.IOException;

public class ExceptionHandling extends ExceptionHandlingSuper{

    ExceptionHandling(String s) {
        super(s);
    }

    /**
     * this super class method throws unchecked exception it is not mandatory for child class to throw the
     * exception or it can throw another exception.
     * @param num
     */
    @Override
    void checkExcpHadling(Integer num) throws NullPointerException{
        super.checkExcpHadling(num);
    }

    /**
     * here super class method throws checked exception so child class method has to throw same exception
     * @throws IOException
     */
    @Override
    void checkCheckedException() throws IOException {
        super.checkCheckedException();
    }

    /**
     * this method superclass method does not throw any exception so child class method cannot throw the
     * checked exception, it can throw unchecked exception.
     */
    @Override
    void testMethod() {
        super.testMethod();
    }
}
