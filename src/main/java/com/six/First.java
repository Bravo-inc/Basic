package com.six;

/**
 * Создайте ваш собственный класс исключений, используя ключевое слово extends.
 * Напишите конструктор для этого класса,который принимает аргумент String, и хранит его внутри объекта в ссылке String.
 * Напишите метод, который печатает хранящийся String. Создайте предложение try-catch для наблюдения своего собственного исключения.
 */
public class First {

    public static void Ex(String s) throws FirstException{
        throw new FirstException(s);
    }
    public static void main(String [] args){
        try {
            Ex("Error");
        } catch (FirstException e) {
            e.printMessage();
        }
    }
}
