package com.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Дан целочисленный массив A размера N.
 * Назовем серией группу подряд идущих одинаковых элементов, а длиной серии - количество этих элементов (длина серии может быть равна 1).
 * Сформировать динамический массив java.util.ArrayList seriesList, хранящих длины всех серий исходного массива и значения элементов, образующих эти серии.
 * Разработайте вариант программы в стиле java 1.5 с использованием параметризованных типов и For-Each цикла for.
 */
public class First {

    private List<Series> seriesList = new ArrayList<Series>();
    private int[] array;

    public First(int[] array) {
        if (array == null || array.length < 1) {
            System.out.println("Error");
            System.exit(0);
        } else
            this.array = array;
    }

    public static void main(String[] args) {

        //int[] A = {1, 1, 2, 3, 3, 3, 4, 4, 5};

        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the array length:");
            int size = in.nextInt();

            int[] A = new int[size];
            System.out.println("Insert array elements:");
            for (int i = 0; i < size; i++) {
                A[i] = in.nextInt();
            }
            System.out.println("Entered array elements:");
            for (int i = 0; i < size; i++) {
                System.out.print(" " + A[i]);
            }

            First f = new First(A);
            f.getSeries();
            f.printSeries();
        } catch (NegativeArraySizeException e) {
            System.out.println("Array length must be > 0");
        }
    }

    public void getSeries() {
        int counter = 1, temp = array[0];
        for (int i = 1; i < array.length; i++) {
            if (temp == array[i]) {
                counter++;
            } else {
                seriesList.add(new Series(temp, counter));
                temp = array[i];
                counter = 1;
            }
            if (i == array.length - 1) seriesList.add(new Series(array[i], counter));
        }
    }

    public void printSeries() {
        for (Series e : seriesList) {
            System.out.println("Element " + e.getElement() + " Length " + e.getLength());
        }
    }
}


