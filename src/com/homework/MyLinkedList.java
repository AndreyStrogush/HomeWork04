package com.homework;

import java.util.LinkedList;

public class MyLinkedList<E> implements MyList<E> {
    private int size;
    private Node<E> firstNode;
    private Node<E> lastNode;


    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return null;
    }

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
