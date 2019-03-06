package com.homework;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> test = new MyArrayList<>();
        System.out.println("ArrayList");
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

        MyLinkedList<String> testL = new MyLinkedList<>();
        System.out.println("Linked list");
        testL.add("first");
        testL.add("second");
        testL.add("third");
        testL.add("fourth");
        testL.add("fifth");
        System.out.println(testL.get(1));
        System.out.println(testL.get(2));
        System.out.println(testL.get(3));
        System.out.println(testL.get(4));
        testL.remove(2);
        System.out.println(testL.get(2));

        MyStack<Integer> testS = new MyStack<>();
        System.out.println("Stack");
        testS.push(4);
        testS.push(6);
        testS.push(99);
        System.out.println("size " + test.size());
        System.out.println(testS.pop());
        testS.push(33);
        testS.push(55);
        System.out.println("size " + test.size());
        System.out.println(testS.peek());
        testS.remove(2);
        System.out.println(testS.peek());
        testS.push(4);
        testS.push(33);
        System.out.println(testS.peek());

    }
}
