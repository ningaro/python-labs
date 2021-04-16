package com.task1;

import java.util.ArrayList;

public class ArrayGenerator {

    public static ArrayList<Integer> gen(int size) {
        ArrayList<Integer> arr = new ArrayList<>();

        int arrLen = (int) Math.pow(2, size);

        for (int i = 0; i < arrLen; i++) {
            arr.add(i, randomInt((int) Math.pow(2, size)));
        }

        return arr;

    }

    public static int randomSizeNotMoreArr (int size) {
       return randomInt((int) Math.pow(2, size + 1));
    }

    private static int randomInt(int max) {
        return (int) (0 + (Math.random() * max));
    }
}
