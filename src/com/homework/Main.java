package com.homework;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> test = new MyArrayList<>();
        test.add(4);
        test.add(6);
        test.add(99);
        test.add(33);
        test.add(55);
        System.out.println(test.get(1));
        System.out.println(test.get(3));
        test.remove(2);
        System.out.println(test.get(3));
        System.out.println(test.size());
        test.clear();
        System.out.println(test.get(0));
    }
}

/*
2.1 Реализовать ArrayList Написать свой класс com.homework.MyArrayList как аналог классу ArrayList.
 Можно использовать 1 массив для хранения данных.
Реализовать следующие методы: add, remove, clear, size, get;
 */