// File: SalariesAction.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.PrivilegedAction;
import java.text.NumberFormat;
import java.util.StringTokenizer;

public class SalariesAction implements PrivilegedAction {
  private static NumberFormat nf = NumberFormat.getCurrencyInstance();

  public Object run() {
    BufferedReader in = null;
    double totalSalary = 0.0;
    try {
      in = new BufferedReader(new FileReader("salaries.txt"));
      String line = null;
      while ((line = in.readLine()) != null) {
        StringTokenizer t = new StringTokenizer(line, "|");
        if (t.countTokens() >= 3) {
          System.out.print("Name: " + t.nextToken());
          System.out.print(" Position: " + t.nextToken());
          double salary = Double.parseDouble(t.nextToken());
          System.out.println(" Salary: " + nf.format(salary));
          totalSalary += salary;
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (in != null) {
        try {
          in.close();
        }
        catch (IOException ioe) {
          ioe.printStackTrace();
        }
      }
    }
    return new Double(totalSalary);
  }
}
