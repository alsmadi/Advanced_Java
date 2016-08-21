package solutions.ch17solutions;

// File: FacadeClient2.java

public class FacadeClient2 {
  public static void main(String[] args) {
    IOFacade2 facade = IOFacade2.getInstance();

    String text = "To be, or not to be: that is the question";

    byte[] bytes = {70, 65, 67, 65, 68, 69, 1, 1, 1};

    try {
      facade.writeToSerializedObjectFile("string.ser", text);
      facade.writeToTextFile("string.txt", text);
      facade.writeToBinaryFile("bytes.bin", bytes);
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
}