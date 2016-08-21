package solutions.AppAsolutions;

// File: SalRpt1.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class SalRpt1 {
  public static void main(String args []) {
    Connection conn;
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();

      String sqltxt;
      sqltxt = "SELECT FIRSTNAME, LASTNAME, SALARY FROM EMPLOYEE";
      ResultSet rs = stmt.executeQuery(sqltxt);

      String name;
      String dept;
      float salary;
      float totalsalary = 0.0F;

      while (rs.next()) {
        name = rs.getString(1) + " " + rs.getString(2);
        salary = rs.getFloat(3);
        totalsalary += salary;
        System.out.printf("%1s \t %2.2f %n", name, salary);
      }
      System.out.println("----------\nTotal salary: " + totalsalary);
      stmt.close();
      conn.close();
    }
    catch (ClassNotFoundException cnfe) {
      System.err.println("Unable to load driver class: " + cnfe);
    }
    catch (SQLException sqle) {
      System.err.println(sqle);
    }
  }
}