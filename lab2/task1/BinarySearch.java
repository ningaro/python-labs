package com.task1;

import java.util.*;

class BinarySearch extends SearchMethod {
    private final ArrayList<Integer> arrList = new ArrayList<>();

    public void add(ArrayList<Integer> arr) {
        arrList.addAll(arr);
    }

    public int search (int searchNum){
        long timerBegin = System.currentTimeMillis();
        search(this.arrList, searchNum);
        return Math.toIntExact(System.currentTimeMillis() - timerBegin);
    }

    public int insert(int insertVal) {
        return 0;
    }

    public int del(int delVal) {
        return 0;
    }

    private int search (ArrayList<Integer> arr, int searchNum) {
        int centerPos = arr.size() / 2;

        if (arr.size() > 1) {
            return arr.get(centerPos) < searchNum
                    ? search(new ArrayList<>(arr.subList(centerPos, arr.size())), searchNum)
                    : search(new ArrayList<>(arr.subList(0, centerPos)), searchNum);
        } else
            return arr.get(centerPos) == searchNum ? centerPos : -1;
    }
}
