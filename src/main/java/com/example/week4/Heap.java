package com.example.week4;

import java.util.*;

public class Heap {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        List<Player> players = new ArrayList<>();
        try {
            while (true) {
                Player player = new Player();
                players.add(player);
            }
        } catch (OutOfMemoryError e) {
            long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            long memoryUsage = endMemory - startMemory;
            System.out.println("Out of memory error occurred after " + elapsedTime + "ms with " + memoryUsage + " bytes used.");
        }

    }
}
