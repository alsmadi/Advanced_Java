// File: FacadeClient.java

public class FacadeClient {
  public static void main(String[] args) {
    IOFacade facade = IOFacade.getInstance();
    String text = "To be, or not to be: that is the question";
    byte[] bytes = {70, 65, 67, 65, 68, 69, 1, 1, 1};

    try {
      facade.writeToTextFile("string.txt", text);
      facade.writeToBinaryFile("bytes.bin", bytes);
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
}