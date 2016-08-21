package solutions.ch17solutions;

// File: GenericArray.java

public class GenericArray<T> {
  private T[] array;
  private int currentIndex = 0;
  private int initialSize = 0;

  public GenericArray() {
    this(1000);
  }
  public GenericArray(int size) {
    initialSize = size;
    array = getNewArray(initialSize);
  }

  public void addElement(T element) {
    array[currentIndex++] = element;
  }
  public int indexOfObject(Object o) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }
  public T[] getArray() {
    return array;
  }
  public T getElement(int index) {
    return array[index];
  }
  public int getLength() {
    return array.length;
  }
  public int getSize() {
    return currentIndex;
  }
  public boolean removeElement(int index) {
    if (index <= array.length) {
      array[index] = null;
      shiftArray(index);
      currentIndex--;
      return true;
    }
    return false;
  }
  public void removeAllElements() {
    array = getNewArray(initialSize);
    currentIndex = 0;
  }
  @SuppressWarnings("unchecked") // Not supported in 1.5.0
  private T[] getNewArray(int size) {
    return (T[])new Object[size];
  }
  private void shiftArray(int index) {
    T[] tempArray = getNewArray(array.length);

    System.arraycopy(array, 0, tempArray, 0, index);
    int numLeft = array.length - index - 1;
    System.arraycopy(array, index + 1, tempArray, index, numLeft);
    array = tempArray;
  }
}