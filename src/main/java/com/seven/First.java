package com.seven;

/**
 * Напишите код для генерации и поимки ArrayIndexOutOfBoundsException.
 */
public class First {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        try {
            System.out.println(a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Someone does not know how to count");
        }
    }
}