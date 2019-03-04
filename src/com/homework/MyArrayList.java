package com.homework;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
    private final int DEFAULT_CAPACITY = 10;
    transient Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, size + 1);
        }
        elementData[size] = e;
        size = size + 1;
        return true;
    }

    @Override
    public void remove(int index) {
        if (size - index >= 0) {
            System.arraycopy(elementData, index + 1, elementData, index, size - index);
        }
        elementData[size] = null;
        size--;
    }

    @Override
    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
    }

    @Override
    public int size() {
        return elementData.length;
    }

    @Override
    public E get(int index) {
        return (E)elementData[index];
    }

}
