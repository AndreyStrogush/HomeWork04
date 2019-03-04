package com.homework;

public interface MyList <E> {
    boolean add(E e);

    void remove(int index);

    void clear();

    int size();

    E get(int index);
}

//add, remove, clear, size, get;