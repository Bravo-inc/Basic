package com.eight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


/**
 * Напишите программу, которая запрашивает день рождения в формате: DD.MM.YYYY и показывает день недели для него.
 * Сделайте так, чтобы программа показывала количество прожитых дней.
 */
public class First {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Locale.setDefault(Locale.ENGLISH);
        long DAY_IN_MILLIS = 24 * 60 * 60 * 1000;

        System.out.println("Insert the Date in DD.MM.YYYY format:");
        Scanner in = new Scanner(System.in);
        try {
            Date birthday = format.parse(in.nextLine());
            in.close();

            long days = (new Date().getTime() - birthday.getTime()) / DAY_IN_MILLIS;
            if (days < 0) days = 0;

            System.out.println("Weekday: " + new SimpleDateFormat("EEEE").format(birthday));
            System.out.println("Lived: " + days);

        } catch (ParseException e) {
            System.out.println("Wrong format");
        }
    }
}
