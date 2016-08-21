package solutions.ch15solutions;

// File: Pager.java

public class Pager {
  public native void page(String message, String id);

  static {
    System.loadLibrary("Pager");
  }
}
