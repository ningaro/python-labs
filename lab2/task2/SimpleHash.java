package com.task2;

import java.util.HashMap;

public class SimpleHash<K, V> extends HashMap<K, V> {
    public int hashCode(int num) {
        return num;
    }

    public void put(TestObject value) {
        Integer key = hashCode(value.getNumber());

        super.put((K) key, (V) value);
        println();
    }

    public V get(TestObject value) {
        int key = hashCode(value.getNumber());
        if (super.get(key) != null && !value.equals(super.get(key))) {
            int i = 1;
            do {
                key = hashCode(value.getNumber()) + i++;
            } while (!value.equals(super.get(key)));
        }
        return super.get(key);
    }

    public void println() {
        this.forEach((key, value) -> System.out.println(key + " | " + value));
        System.out.println();
    }
}
