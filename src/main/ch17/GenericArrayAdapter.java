// File: GenericArrayAdapter.java

import solutions.ch17solutions.GenericArray;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericArrayAdapter<E> implements Collection<E> {
  private GenericArray<E> adaptee;

  public GenericArrayAdapter() {
    adaptee = new GenericArray<E>();
  }
  public GenericArrayAdapter(int initialSize) {
    adaptee = new GenericArray<E>(initialSize);
  }

  public boolean add(E o) {
    adaptee.addElement(o);
    return true;
  }
  public boolean addAll(Collection<? extends E> c) {
    Iterator<? extends E> it = c.iterator();
    while (it.hasNext()) {
      add(it.next());
    }
    return true;
  }
  public void clear() {
    adaptee.removeAllElements();
  }
  public boolean contains(Object obj) {
    if (adaptee.indexOfObject(obj) < 0) {
      return false;
    }
    return true;
  }
  public boolean containsAll(Collection<?> c) {
    Iterator<?> it = c.iterator();
    while (it.hasNext()) {
      if (!contains(it.next())) {
        return false;
      }
    }
    return true;
  }
  public boolean isEmpty() {
    if (adaptee.getSize() == 0)
      return true;
    else
      return false;
  }
  public Iterator<E> iterator() {

    return new Iterator<E>() {
      int current = 0;
      public boolean hasNext() {
        return current != adaptee.getSize();
      }
      public E next() {
        try {
          E nextElem = (E)adaptee.getElement(current++);
          return nextElem;
        }
        catch(IndexOutOfBoundsException e) {
          throw new NoSuchElementException();
        }
      }
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  public boolean removeAll(Collection<?> c) {
    throw new UnsupportedOperationException();
  }
  public boolean remove(Object obj) {
    throw new UnsupportedOperationException();
  }
  public boolean retainAll(Collection<?> c) {
    throw new UnsupportedOperationException();
  }
  public int size() {
    return adaptee.getSize();
  }
  public Object[] toArray() {
    return adaptee.getArray();
  }
  @SuppressWarnings("unchecked") // Not supported in 1.5.0
  public <T> T[] toArray(T[] array){
    // make sure array is big enough
    int size = adaptee.getSize();
    if (array.length < size) {
      array = (T[])java.lang.reflect.Array.newInstance(
        array.getClass().getComponentType(), size);
    }
    // add elements to array
    Iterator<E> it = this.iterator();
    Object[] temp = array;
    for (int i = 0; i < size; i++) {
      temp[i] = it.next();
    }
    // add null terminator
    if (array.length > size) {
      array[size] = null;
    }
    return array;
  }
  public boolean equals(Object o) {
    return adaptee.equals(o);
  }
  public int hashCode() {
    return adaptee.hashCode();
  }
}
