package com.task1;

import java.util.ArrayList;
import java.util.Comparator;

public class Fibonacci extends SearchMethod {
    private final ArrayList<Integer> arrList = new ArrayList<>();

    public void add (ArrayList<Integer> arr) {
        arrList.addAll(arr);
    }

    private static int get (int pos) {
        ArrayList<Integer> row = new ArrayList<>();
        
        row.add(0);
        row.add(1);

        for (int i = 2; i <= pos; i++) {
            row.add(i, row.get(i-1) + row.get(i-2));
        }

        return  row.get(pos);
    }

    public int search(int searchVal) {
        long timerBegin = System.currentTimeMillis();
        search(searchVal, arrList);
        return Math.toIntExact(System.currentTimeMillis() - timerBegin);
    }

    public int insert(int insertVal) {
        long timerBegin = System.currentTimeMillis();
        arrList.add(insertVal);
        arrList.sort(Comparator.naturalOrder());
        return Math.toIntExact(System.currentTimeMillis() - timerBegin);
    }

    public int del(int delVal) {
        long timerBegin = System.currentTimeMillis();
        if (arrList.contains(delVal)) arrList.remove(delVal);
        return Math.toIntExact(System.currentTimeMillis() - timerBegin);
    }

    private static boolean search (int searchVal, ArrayList<Integer> inArr) {
        ArrayList<Integer> arr = new ArrayList<>(inArr);

        int lastFib;

        if (arr.size() == 1) {
           return arr.get(0) == searchVal;
        }

        if (searchVal < arr.get(0)) return false;

        for (lastFib = 0;get(lastFib)  < arr.size(); lastFib++) {
            if (searchVal == arr.get(get(lastFib))) {
                return true;
            } else if ((searchVal < arr.get(get(lastFib))) && (arr.size() > 4)) {
                return search(searchVal, new ArrayList<>(arr.subList(get(lastFib - 1), get(lastFib))));
            } else if ((searchVal < arr.get(get(lastFib))) && (arr.size() <= 4)) {
                return false;
            }
        }

        if (get(lastFib-1) < arr.size()) {
            return search(searchVal, new ArrayList<>(arr.subList(get(lastFib-1), arr.size())));
        } else {
            return false;
        }


    }

}


