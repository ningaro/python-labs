package com.task2;

import java.util.ArrayList;

public class Task2 {
    public static void main (String[] args) {
        SimpleHash<Integer, TestObject> SimpleHashMap = new SimpleHash<>();
        RandomHash<Integer, TestObject> RandomHashMap = new RandomHash<>();
        ChainHash<Integer, ArrayList<TestObject>> ChainHashMap = new ChainHash<>();
        //Тестовые объекты
        TestObject n1 = new TestObject("Hello world!", 362);
        TestObject n2 = new TestObject("Привет мир!", 12);
        TestObject n3 = new TestObject("Привет, это коллизия", 12);
        //Ответы при поиске
        TestObject f1, f2, f3; TestObject[] af1, af2, af3;

        System.out.println("\n ---- Метод цепочек  ----");
        //Заполнение таблицы
        ChainHashMap.put(n1);
        ChainHashMap.put(n2);
        ChainHashMap.put(n3);

        //Поиск в таблице
        ChainHashMap.get(n1).forEach((obj) -> {
            System.out.println("[n1] " + obj.getText() + " | " + obj.getNumber());
        });
        ChainHashMap.get(n2).forEach((obj) -> {
            System.out.println("[n2] " + obj.getText() + " | " + obj.getNumber());
        });

        System.out.println("\n ---- Простое рехэширование  ----");
        //Заполнение таблицы
        SimpleHashMap.put(n1);
        SimpleHashMap.put(n2);
        SimpleHashMap.put(n3);

        //Поиск в таблице
        f1 = SimpleHashMap.get(n1);
        f3 = SimpleHashMap.get(n3);
        System.out.printf("%d | %s\n", f1.getNumber(), f1.getText());
        System.out.printf("%d | %s\n", f3.getNumber(), f3.getText());

        System.out.println("\n ---- Рехэширование с помощью псевдослучайных чисел ----");
        //Заполнение таблицы
        RandomHashMap.put(n1);
        RandomHashMap.put(n2);
        RandomHashMap.put(n3);

        //Поиск в таблице
        f1 = RandomHashMap.get(n1);
        f2 = RandomHashMap.get(n2);
        f3 = RandomHashMap.get(n3);
        System.out.printf("%d | %s\n", f1.getNumber(), f1.getText());
        System.out.printf("%d | %s\n", f2.getNumber(), f2.getText());
        System.out.printf("%d | %s\n", f3.getNumber(), f3.getText());

    }
}
