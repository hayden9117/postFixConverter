package ADTS.DataTypes;

import java.util.NoSuchElementException;

import ADTS.DataTypes.interfaces.StackInterface;

public class Stack<E> implements StackInterface<E> {

    private E[] items;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {

        numItems = 0;
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) (new Object[DEFAULT_CAPACITY]);
        items = temp;

    }

    public E pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {

            return items[--numItems];
        }
    }

    public E peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return items[numItems - 1];
        }

    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    private void expand() {
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) (new Object[items.length * 2]);
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public boolean push(E item) {
        boolean result = true;
        if (isFull()) {
            expand();
        } else {
            items[numItems] = item;
            numItems++;
        }
        return result;
    }

    @Override
    public boolean isFull() {

        return numItems == items.length;

    }

    @Override
    public int size() {

        return items.length;

    }

    @Override
    public E clear() throws NoSuchElementException {
        if (numItems < 1) {
            throw new NoSuchElementException();
        }
        numItems = 0;
        return items[numItems];

    }

}
