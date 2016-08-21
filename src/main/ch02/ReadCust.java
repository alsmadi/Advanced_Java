// File: ReadCust.java
package main.ch02;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadCust {
  public static void main(String args[]) {

    ObjectInputStream in = null;
    try {
      in = new ObjectInputStream(
        new FileInputStream("customer.ser"));
      Customer p = (Customer) in.readObject();
      System.out.println(p);
    }
    catch (ClassCastException e) {
      System.err.println("Error casting object to a Customer");
    }
    catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }
    catch (IOException e) {
      System.err.println("Error reading object: " + e.getMessage());
    }
    finally {
      try {
        in.close();
      }
      catch (IOException e) {
        System.err.println(e.getMessage());
      }
    }
  }
}
