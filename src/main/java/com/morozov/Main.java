package com.morozov;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        double c = 3.25;

        System.out.println("Сложение: " + (a + b));
        System.out.println("Разница: " + (a - b));
        System.out.println("Умножение: " + (a * b));
        System.out.println("Деление: " + (a / b));

        System.out.println("Сложение int и double: " + (a + b + c));
        System.out.println("Разница int и double: " + (a - b - c));
        System.out.println("Умножение int и double: " + (a * b * c));
        System.out.println("Деление int и double: " + (a / b / c));

        System.out.println("a больше b: " + (a > b));
        System.out.println("a меньше b: " + (a < b));
        System.out.println("a ровно b: " + (a == b));
        System.out.println("a не ровно b: " + (a != b));

        if (a >= b) {
            System.out.println("Верно");
        }
        else if (a <= b) {
            System.out.println("Не верно");
        }

        System.out.println("Максимальное значение double: " + Double.MAX_VALUE);
        System.out.println("Минимальное значение double: " + Double.MIN_VALUE);

        double owerflowDouble = Double.MAX_VALUE * 2;
        double roundingDouble = Double.MIN_VALUE / 2;
        double underflowDouble = -1.0 / 0.0;
        System.out.println("Переполненное значение вверх double: " + owerflowDouble);
        System.out.println("Округление до 0 double: " + roundingDouble);
        System.out.println("Переполненное значение вниз double: " + underflowDouble );

    }
}
