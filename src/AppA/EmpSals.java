// File: EmpSals.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class EmpSals {

  public static void main(String args[]) {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      Connection conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();

      String sqltxt;
      sqltxt = "SELECT firstname, lastname, salary, department_name" +
        " FROM employee, department " +
        " WHERE employee.department_code=department.department_code";
      ResultSet rs = stmt.executeQuery(sqltxt);

      String name;
      String dept;
      float salary;
      while (rs.next()) {
        name = rs.getString("FIRSTNAME") + " " +
          rs.getString("LASTNAME");
        dept = rs.getString("DEPARTMENT_NAME");
        salary = rs.getFloat("SALARY");
        System.out.println(name + "\t" + dept + "\t" + salary);
      }

      stmt.close();
      conn.close();
    }
    catch (ClassNotFoundException cnfe) {
      System.out.println("Unable to load driver class: " + cnfe);
      System.exit(1);
    }
    catch (SQLException sqle) {
      System.out.println("SQL Error:");
      System.out.println("     Code: " + sqle.getErrorCode());
      System.out.println("  Message: " + sqle.getMessage());
      System.exit(1);
    }
  }
}

