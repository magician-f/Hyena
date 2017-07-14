package com.test.hyena.ui;

public class Calculator {

    public double sum(double a, double b) {
        return a + b;
    }

    public double substract(double a, double b) {
        return a - b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public String test(String lineStr) {
//        lineStr = lineStr.substring(0, lineStr.lastIndexOf(" "));
        lineStr = lineStr.substring(1, lineStr.length());
        return lineStr;
    }
}
