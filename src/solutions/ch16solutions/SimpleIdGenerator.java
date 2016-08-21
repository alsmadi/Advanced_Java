package solutions.ch16solutions;

// File: SimpleIdGenerator.java

public class SimpleIdGenerator implements IdGenerator3 {
  private int counter;
  private static SimpleIdGenerator theInstance;

  public static synchronized SimpleIdGenerator getInstance() {
    if (theInstance == null) {
      theInstance = new SimpleIdGenerator();
    }
    return theInstance;
  }

  private SimpleIdGenerator() {
    counter = 0;
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
