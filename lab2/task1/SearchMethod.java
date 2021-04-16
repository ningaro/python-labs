package com.task1;

import java.util.ArrayList;

public abstract class SearchMethod {
    protected int sortTime;

    public abstract void add(ArrayList<Integer> arr);

    public abstract int search(int searchVal);

    public abstract int insert(int insertVal);

    public abstract int del(int delVal);

}
