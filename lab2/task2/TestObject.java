package com.task2;

import java.util.Objects;

public class TestObject {
    private String text;
    private int number;

    public TestObject(String text, int number) {
        this.text = text;
        this.number = number;
    }

    public void set(String text, int number) {
        this.text = text;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestObject that = (TestObject) o;
        return number == that.number && Objects.equals(text, that.text);
    }

}
