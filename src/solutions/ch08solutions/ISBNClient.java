package solutions.ch08solutions;

// File: ISBNClient.java

import java.rmi.Naming;

public class ISBNClient {
  public static void main(String args[]) {
    try {
      String loc = "rmi://localhost/ISBNImpl";
      ISBN_IF isbn = (ISBN_IF) Naming.lookup(loc);

      String result = isbn.getTitle("0201310058");
      System.out.println("Title for 0201310058: " + result);
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
}

