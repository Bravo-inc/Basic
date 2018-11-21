package com.ten;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Создайте класс TimeLoggin, который будет принимать в качестве аргумента
 * имя журнального файла (например, my_programm.log). При каждом запуске программы TimeLoggin
 * должен производить запись в журнальный файл о времени старта программы. Журнальный файл должен
 * быть в кодировке UTF-8 и его записи должны быть в следующем формате:
 * Программа стартовала 27.12.2007, 10:57:35
 * Программа стартовала 20.01.2008, 07:16:09
 * Программа стартовала 01.02.2008, 23:50:15
 */
public class TimeLoggin {

    private static final  SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, hh:mm:ss");
    private final File file;

    private TimeLoggin(String fileName) throws FileNotFoundException {
        if (fileName == null || fileName.length() < 1) {
            throw new FileNotFoundException("File not found.");
        }
        file = new File(fileName);
        writeLog();
        System.out.println("Log file has been updated");
    }

    private void writeLog() {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);
            writer.write("Программа стартовала: " + formatter.format(new Date()));
            writer.write("\r\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new TimeLoggin("my_programm.log");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}