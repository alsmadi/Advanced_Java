package solutions.ch02solutions;

// File: WriteDept.java

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class WriteDept {
  public static void main(String args[]) throws ParseException {
    SimpleDateFormat f = new SimpleDateFormat("M/d/yyyy");
    Date d = f.parse("08/05/1960");
    Employee armstrong = new Employee(5, "Neil", "Armstrong",
      "Astronaut", "SP", 1, d, 30000);
    Department space = new Department("SP", "Space Division",
      armstrong, "Edwards", "CA");
    ObjectOutputStream out = null;

    try {
      out = new ObjectOutputStream(new FileOutputStream("dept.ser"));
    }
    catch (IOException e) {
      System.err.println("Error opening output file: "
          + e.getMessage());
      System.exit(1);
    }

    try {
      out.writeObject(space);
      System.err.println("Wrote \"" + space + "\" to file");
    }
    catch (IOException e) {
      System.err.println("Error writing to file: " + e.getMessage());
      System.exit(2);
    }
    finally {
      try {
        out.close();
      }
      catch (IOException e) {
        System.exit(3);
      }
    }
  }
}
