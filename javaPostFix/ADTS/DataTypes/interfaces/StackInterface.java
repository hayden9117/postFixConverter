package ADTS.DataTypes.interfaces;

import java.util.NoSuchElementException;

public interface StackInterface<E> {

    public boolean push(E item);

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public E clear();

    public E pop() throws NoSuchElementException;

    public E peek() throws NoSuchElementException;

}