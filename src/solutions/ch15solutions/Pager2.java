package solutions.ch15solutions;

// File: Pager2.java

public class Pager2 {
  public native void page(String message, String id);
  public native String who(String id);

  static {
    System.loadLibrary("Pager2");
  }
}
