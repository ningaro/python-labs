package com.task1;

import java.util.*;

class BinaryTree extends SearchMethod {
    private final TreeSet<Integer> tree = new TreeSet<>();

    public void add(ArrayList<Integer> arr) {
        tree.addAll(arr);
    }

    public int search(int searchVal) {
        long timerBegin = System.currentTimeMillis();
        tree.contains(searchVal);
        return Math.toIntExact(System.currentTimeMillis() - timerBegin);
    }

    public int insert(int insertVal) {
        long timerBegin = System.currentTimeMillis();
        tree.add(insertVal);
        return Math.toIntExact(System.currentTimeMillis() - timerBegin);
    }

    public int del(int delVal) {
        long timerBegin = System.currentTimeMillis();
        tree.remove(delVal);
        return Math.toIntExact(System.currentTimeMillis() - timerBegin);
    }
}

