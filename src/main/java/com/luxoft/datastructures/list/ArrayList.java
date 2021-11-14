package com.luxoft.datastructures.list;

import java.util.StringJoiner;

public class ArrayList implements List {

    private int size;
    private Object[] array;

    public ArrayList() {
        this.array = new Object[10];
    }

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index is larger than size of the Array List");
        }
        if (size == array.length) {
            grow();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index is larger than size of the Array List");
        }
        Object o = get(index);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return o;
    }


    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        var result = array[index];
        array[index] = value;
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            Object valueInStack = array[i];
            if (value.equals(valueInStack)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            Object valueInStack = array[i];
            if (value.equals(valueInStack)) {
                return i;
            }
        }
        return -1;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            Object[] newArray = new Object[(int) (array.length * 1.5)];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }

    private void grow() {
        Object[] growArray = new Object[(int) (array.length * 1.5)];
        for (int i = 0; i < size; i++) {
            growArray[i] = array[i];
        }
        array = growArray;
    }
}