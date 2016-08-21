package solutions.ch16solutions;

// File: IdGenerator2.java

public class IdGenerator2 {
  private int counter;
  private static IdGenerator2 theInstance;

  private IdGenerator2() {
    counter = 0;
  }

  public static synchronized IdGenerator2 getInstance() {
    if (theInstance == null) {
      theInstance = new IdGenerator2();
    }
    return theInstance;
  }
  public synchronized int getNextId() {
    return counter++;
  }
  /*
   * This method is not strictly necessary in this example, but if
   * your Singleton class were to extend a class that implemented
   * clone(), without this method it would be possible to create more
   * than one instance via cloning.
   */
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }
}
