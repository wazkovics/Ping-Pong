package com.example.week4.Tests;

import com.example.week4.Player;

import java.util.*;

public class Stack {
    static int count = 0;
    static long startTime = System.currentTimeMillis();
    static long previousTime = startTime;
    public static void stacktest() {

        try {
            takestackspace(0);

        } catch (StackOverflowError t) {
//            t.printStackTrace();
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Error occurred after " + elapsedTime + "ms");
            System.out.println("The amount of objects created are " + count);
        }

    }
    public static void takestackspace(int depth) {

        if (depth < 1000000) {
            if (count % 1000 == 0) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - previousTime;
                System.out.println("Time taken for last 1000 objects " + elapsedTime + "ms");
                previousTime = currentTime;
            }
            count++;
            takestackspace(depth + 1);
        } else {
            throw new StackOverflowError();
        }
    }
}
