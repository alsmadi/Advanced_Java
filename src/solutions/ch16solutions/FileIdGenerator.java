package solutions.ch16solutions;

// File: FileIdGenerator.java

public class FileIdGenerator implements IdGenerator3 {
  private int counter;
  private static FileIdGenerator theInstance;

  private FileIdGenerator() {
    counter = Configuration.getNext();
  }

  public static synchronized FileIdGenerator getInstance() {
    if (theInstance == null) {
      theInstance = new FileIdGenerator();
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
