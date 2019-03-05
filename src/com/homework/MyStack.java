package com.homework;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> implements MyStackInterface<E> {
    private final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int elementCounter;

    public MyStack() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public E push(E item) {
        if (elementCounter == elementData.length) {
            elementData = Arrays.copyOf(elementData, elementCounter + 1);
            elementData[elementCounter] = item;
            elementCounter = elementCounter + 1;
        }
        return item;
    }

    @Override
    public void remove(int index) {
        if (index >= elementCounter) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                    elementCounter);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCounter - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCounter--;
        elementData[elementCounter] = null;
    }

    @Override
    public void clear() {
        final Object[] elements = elementData;
        for (int to = elementCounter, i = elementCounter = 0; i < to; i++)
            elements[i] = null;
    }

    @Override
    public int size() {
        return elementCounter;
    }

    @Override
    public E peek() {
        int len = size();

        if (len == 0) {
            throw new EmptyStackException();
        }
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
        if (index >= elementCounter) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                    elementCounter);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCounter - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCounter--;
        elementData[elementCounter] = null;
    }

    public E elementAt(int index) {
        if (index >= elementCounter) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCounter);
        }

        return (E) elementData[index];
    }

}
