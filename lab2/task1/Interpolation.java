package com.task1;

import java.util.ArrayList;
import java.util.Comparator;

public class Interpolation extends SearchMethod{
    ArrayList<Integer> arrList = new ArrayList<>();

    public void add(ArrayList<Integer> arr) {
        arrList.addAll(arr);
    }

    public int search(int searchVal) {
        long searchBegin = System.currentTimeMillis();
        search(arrList, searchVal);
        int searchTime = Math.toIntExact(System.currentTimeMillis() - searchBegin);

        return searchTime;
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

    private boolean search(ArrayList<Integer> sortedArray, int toFind) {
        int mid;
        int low = 0;
        int high = sortedArray.size()-1;

        while (sortedArray.get(low) < toFind && sortedArray.get(high) > toFind) {
            if (sortedArray.get(high) == sortedArray.get(low)) // Защита от деления на 0
                break;
            mid = (int) (low + (((long) (toFind - sortedArray.get(low)) * (high - low))) / (sortedArray.get(high) - sortedArray.get(low)));

            if (sortedArray.get(mid) < toFind)
                low = mid + 1;
            else if (sortedArray.get(mid) > toFind)
                high = mid - 1;
            else
                return true;
        }

        if (sortedArray.get(low) == toFind || sortedArray.get(high) == toFind)
            return true;

        return false; // Не найдено
    }
}
