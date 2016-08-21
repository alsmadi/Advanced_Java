// File: IdGenerator.java

public class IdGenerator {
  private int counter = 0;
  public int getNextId() {
    return counter++;
  }
}
