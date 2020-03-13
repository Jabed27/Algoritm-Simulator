package com.example.jabed.algorithmsimulator;

import android.widget.Toast;

public class CustomException {

    static  void exceptionhandling(int value)
    {

        if(value==1)
        {
            throw new ArithmeticException("field is empty");
        }
        if(value==2)
        {
            throw new ArithmeticException("incorrect input");
        }

    }
}
