package solutions.AppAsolutions;

// File: DeptEmps.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DeptEmps {
  public static void main (String args []) {
    Connection conn;
    try {
      String dept = "";
      try {
        BufferedReader br = new BufferedReader(
          new InputStreamReader(System.in));
        System.out.print("Enter a dept code and press <Return>: ");
        dept = br.readLine();
        if (dept == null) {
          System.out.println("No department entered.  Exiting.");
          System.exit(0);
        }
      } catch(IOException ioe) {
        ioe.printStackTrace();
      }
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      conn = DriverManager.getConnection
        ("jdbc:derby://localhost:1527/j2se");

      String sqltxt = "SELECT id, firstname, lastname, title " +
        " FROM employee WHERE department_code = ?";
      PreparedStatement pstmt = conn.prepareStatement( sqltxt);
      pstmt.setString(1, dept);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        System.out.println("Employees of department " + dept + ":");
        do {
          String id = rs.getString(1);
          String name = rs.getString(2) + " " + rs.getString(3);
          String title = rs.getString(4);
          System.out.println(id + "\t" + name + "\t" + title);
        } while (rs.next());
      }
      else {
        System.out.println("No employees found for " + dept + ".");
      }
      rs.close();
      pstmt.close();
      conn.close();
    }
    catch (ClassNotFoundException cnfe) {
      System.out.println("Unable to load driver class: " + cnfe);
    }
    catch (SQLException sqle) {
      System.err.println(sqle);
    }
  }
}