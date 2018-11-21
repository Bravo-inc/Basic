package com.six;


public class FirstException extends Exception {


    private final String s;

    public FirstException(String s){
        this.s = s;

    }

    public void printMessage(){
        System.out.println(s);
    }
}
