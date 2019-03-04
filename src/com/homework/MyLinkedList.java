package com.homework;


public class MyLinkedList<E> implements MyList<E> {
    private int size;
    private Node<E> firstNode;
    private Node<E> lastNode;

    public MyLinkedList() {
        firstNode = new Node<>(null, null, null);
        lastNode = firstNode;
        size = 0;
    }

    @Override
    public boolean add(E e) {
        final Node<E> l = lastNode;
        final Node<E> newNode = new Node<>(l, e, null);
        lastNode = newNode;
        if (l == null)
            firstNode = newNode;
        else
            l.next = newNode;
        size++;
        return true;
    }

    @Override
    public void remove(int index) {
        checkElementIndex(index);
        Node<E> node = getNode(index);
        if (node != null) {
            remove(node);
        }
    }

    public void remove(Node<E> node) {
        final Node<E> next = node.next;
        final Node<E> prev = node.prev;

        if (prev == null) {
            firstNode = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            lastNode = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
    }

    @Override
    public void clear() {
        for (Node<E> x = firstNode; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        firstNode = lastNode = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        Node<E> target = getNode(index);
        return target.item;
    }

    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> target = firstNode;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

}
