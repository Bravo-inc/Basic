package com.nine;


import java.io.*;
import java.util.*;

/**
 * Откройте текстовый файл так, чтобы вы смогли прочесть его построчно.
 * Читайте каждую строку, как String, и поместите этот объект String в LinkedList.
 * Распечатайте все строки из LinkedList в обратном порядке.
 */

public class FileReader {

    private final File file;
    private List<String> list;

    public FileReader(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("The file does not exist.");
        }
    }

    public void readFile() {
        Scanner in = null;
        try {
            list = new LinkedList<String>();
            in = new Scanner(file);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert in != null;
            in.close();
        }
    }

    public void printContent() {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        FileReader reader;
        try {
            reader = new FileReader("test.txt");
            reader.readFile();
            reader.printContent();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
