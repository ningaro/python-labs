package com.task2;

import java.util.ArrayList;
import java.util.HashMap;

public class ChainHash<K, V> extends HashMap<K, V> {
    public int hashCode(int num) {
        return num;
    }

    public void put(TestObject value) {
        Integer key = hashCode(value.getNumber());

        if (super.get(key) != null) {
            ArrayList<TestObject> tempAr = (ArrayList<TestObject>) super.get(key);
            tempAr.add(value);
            super.put((K) key, (V) tempAr);
        } else {
            ArrayList<TestObject> tempAr = new ArrayList<>();
            tempAr.add(value);
            super.put((K) key, (V) tempAr);
        }
        println();
    }

    public V get(TestObject value) {
        int key = hashCode(value.getNumber());
        return super.get(key);
    }

    public void println() {
        this.forEach((key, value) -> System.out.println(key + " | " + value));
        System.out.println();
    }
}
