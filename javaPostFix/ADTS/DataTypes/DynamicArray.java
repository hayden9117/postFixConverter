package ADTS.DataTypes;

import java.util.NoSuchElementException;

import ADTS.DataTypes.interfaces.ArrayInterface;

public class DynamicArray<E> implements ArrayInterface<E> {
    private E[] items;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray() {

        numItems = 0;
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) (new Object[DEFAULT_CAPACITY]);
        items = temp;

    }

    public E pop() throws NoSuchElementException {
        if (numItems < 1) {
            throw new NoSuchElementException();
        }
        numItems--;
        return items[numItems];
    }

    @Override
    public void removeIndex(E index) throws NoSuchElementException {
        if (numItems < 1) {
            throw new NoSuchElementException();
        }
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) (new Object[items.length]);
        for (int i = (int) index; i < numItems - 1; i++) {

            temp[i] = items[i + 1];
        }
        items[numItems - 1] = null;
        numItems--;

    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int getSize() {

        return numItems;
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

    public boolean isFullAtCapacity() {
        return numItems == items.length;

    }

    public void toArray() {
        System.out.print("[");
        for (int i = 0; i < numItems; i++) {

            if (i < numItems - 1) {
                System.out.print(" " + items[i] + ",");
            }
            if (i == numItems - 1) {
                System.out.print(" " + items[numItems - 1]);
            }
        }
        System.out.print("]");
    }

}
