package com.example.week4.Tests;

//import java.util.*;
//
//public class Heap {
//    public static void heapstest() {
//
//        long startTime = System.currentTimeMillis();
//        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        List<Player> players = new ArrayList<>();
//        try {
//            while (true) {
//                Player player = new Player();
//                players.add(player);
//            }
//        } catch (OutOfMemoryError e) {
//            long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//            long endTime = System.currentTimeMillis();
//            long elapsedTime = endTime - startTime;
//            long memoryUsage = endMemory - startMemory;
//            System.out.println("Out of memory error occurred after " + elapsedTime + "ms with " + memoryUsage + " bytes used.");
//        }
//
//    }
//}

//import java.util.*;
//
//public class Heap {
//    public static void heapstest() {
//
//        long startTime = System.currentTimeMillis();
//        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
////        List<Player> players = new ArrayList<>();
//        List<Game> games = new ArrayList<>();
//        List<Integer> players = new ArrayList<>();
//        int count = 0;
//        try {
//            while (true) {
////                Player player = new Player();
//                Integer player = new Integer(1);
////                Game game = new Game();
//                players.add(player);
//                count++;
////                games.add(game);
//            }
//        } catch (Throwable t) {
//            long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//            long endTime = System.currentTimeMillis();
//            long elapsedTime = endTime - startTime;
//            long memoryUsage = endMemory - startMemory;
//            System.out.println("Error occurred after " + elapsedTime + "ms with " + memoryUsage + " bytes used.");
//            System.out.println("The amount of objects created are "+count);
//        }
//
//    }
//}


import com.example.week4.Player;

import java.util.*;

public class Heap {
    public static void heapstest() {

        long startTime = System.currentTimeMillis();
        List<Integer> players = new ArrayList<>();
//        List<Player> players = new ArrayList<>();
        int count = 0;
        long previousTime = startTime;
        try {
            while (true) {
                Integer player = new Integer(1);
//                Player player = new Player();
                players.add(player);
                count++;

                if (count % 10000000 == 0) {
                    long currentTime = System.currentTimeMillis();
                    long elapsedTime = currentTime - previousTime;
                    System.out.println("Time taken for last 10000000 objects " + elapsedTime + " ms");
                    previousTime = currentTime;
                }
            }
        } catch (Throwable t) {
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Error occurred after " + elapsedTime);
            System.out.println("The amount of objects created are " + count);
        }

    }
}

