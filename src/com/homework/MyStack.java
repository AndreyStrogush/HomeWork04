package com.homework;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> implements MyStackInterface<E> {
    private final int DEFAULT_CAPACITY = 10;
    transient Object[] elementData;
    protected int elementCount;

    public MyStack() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public E push(E item) {
        if (elementCount == elementData.length)
            elementData = Arrays.copyOf(elementData, elementCount + 1);
        elementData[elementCount] = item;
        elementCount = elementCount + 1;
        return item;
    }

    @Override
    public void remove(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                    elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null;
    }

    @Override
    public void clear() {
        final Object[] es = elementData;
        for (int to = elementCount, i = elementCount = 0; i < to; i++)
            es[i] = null;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public E peek() {
        int len = size();

        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    @Override
    public E pop() {
        E obj;
        int len = size();

        obj = peek();
        removeElementAt(len - 1);

        return obj;
    }

    public void removeElementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                    elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null;
    }

    public E elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }

        return (E) elementData[index];
    }

}

/*
2.4 Stack Написать свой класс MyStack как аналог классу Stack. LIFO (last-in-first-out).
Можно делать либо с помощью Node либо с помощью массива.
 Реализовать методы: push, remove, clear, size, peek, pop;
 */