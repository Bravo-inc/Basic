package com.five;

/**
 * Создайте класс с main( ), который выбрасывает объект, класса Exception внутри блока try.
 * Передайте конструктору Exception аргумент String.
 * Поймайте исключение внутри предложение catch и напечатайте аргумент String.
 * Добавьте предложение finally и напечатайте сообщение, чтобы убедится, что вы были там.
 */
public class First {
    public First() {
        try {
            throw new Exception("Exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            System.out.println("I was hear");
        }
    }

    public static void main(String[] args) {
        new First();
    }
}
