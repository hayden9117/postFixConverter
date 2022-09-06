package ADTS.DataTypes.interfaces;

import java.util.NoSuchElementException;

public interface ArrayInterface<E> {

    public int getSize();

    public boolean push(E item);

    public boolean isEmpty();

    public boolean isFull();

    public E pop() throws NoSuchElementException;

    public void removeIndex(E index) throws NoSuchElementException;

    public void toArray();
}
