package com.three;


public class Series {
    private final int element;
    private final int length;

    public Series(int element, int length) {
        this.element = element;
        this.length = length;
    }

    public int getElement() {
        return element;
    }

    public int getLength() {
        return length;
    }
}
