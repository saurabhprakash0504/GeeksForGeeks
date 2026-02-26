package com.practice;

import java.io.Serializable;
import java.util.Random;

public class Demo implements Serializable {

    private static final long serialVersionUID = 1L;

    static int a = 100;              // static → not serialized
    transient int b = 200;           // transient → skipped
    final int c = 300;               // final → serialized
    //transient final int d = 400;     // transient + final → tricky
    transient final int d = new Random().nextInt();


    @Override
    public String toString() {
        return "Demo{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
