// File: WriteCust.java
package main.ch02;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteCust {
  public static void main(String args[]) {
    Customer armstrong = new Customer(11, "Neil Armstrong",
      "Astronaut", "08/05/1930", 1);
    ObjectOutputStream out = null;
    try {
      out = new ObjectOutputStream(
        new FileOutputStream("customer.ser"));
      out.writeObject(armstrong);
      System.out.println("Wrote \"" + armstrong + "\" to file");
    }
    catch (IOException e) {
      System.err.println("Error writing object: " + e.getMessage());
    }
    finally {
      try {
        out.close();
      }
      catch (IOException e) {
        System.err.println(e.getMessage());
      }
    }
  }
}

