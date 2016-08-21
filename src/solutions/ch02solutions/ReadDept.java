package solutions.ch02solutions;

// File: ReadDept.java

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDept {
  public static void main(String[] args) {
    ObjectInputStream in = null;
    try {
      in = new ObjectInputStream(new FileInputStream("dept.ser"));
    }
    catch (IOException e) {
      System.out.println("Error opening input file: " +
        e.getMessage());
      System.exit(1);
    }

    Department d = null;

    try {
      d = (Department) in.readObject();
    }
    catch (ClassCastException e) {
      System.out.println("Error casting object to a Department: " +
        e.getMessage());
      System.exit(2);
    }
    catch (IOException e) {
      System.out.println("Error reading object: " + e.getMessage());
      System.exit(3);
    }
    catch (ClassNotFoundException e) {
      System.out.println(e.getMessage() + " class not found");
      System.exit(4);
    }
    finally {
      try {
        in.close();
      }
      catch (IOException e) {
        System.exit(5);
      }
    }
    // write to the screen
    System.out.println(d);
  }
}
