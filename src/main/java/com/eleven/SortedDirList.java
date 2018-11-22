package com.eleven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Создайте класс, называемый SortedDirList с конструктором, который принимает информацию о пути к директории и строит список из файлов в этой директории.
 * Создайте два перегруженных метода list( ) и list( String fileType), которые будут производить либо полный список, или подмножество из списка, основываясь на аргументе.
 * Добавьте метод size( ), который принимает имя файла и возвращает размер этого файла.
 */
public class SortedDirList {
    private File directory;
    private List<File> list;

    public SortedDirList(String path) throws FileNotFoundException {
        directory = new File(path);
        if (!directory.isDirectory()) {
            throw new FileNotFoundException("This is not a directory");
        }

        list = new ArrayList<File>();
        list = Arrays.asList(directory.listFiles());
    }

    public List<File> list() {
        return list;
    }

    public List<File> list(final String fileType) {
        List<File> list = new ArrayList<File>();
        FilenameFilter typeFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String lowerCase = name.toLowerCase();
                if (lowerCase.endsWith(fileType)) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        list = Arrays.asList(directory.listFiles(typeFilter));
        return list;
    }

    public long size(String fileName) {
        File file = new File(fileName);
        return file.length();
    }

    public static void main(String[] args) {
        SortedDirList dirList = null;
        try {
            dirList = new SortedDirList(".");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (File f : dirList.list("class")) {
            String name = f.getName();
            System.out.println(name + "  " + dirList.size(name));
        }

    }
}
