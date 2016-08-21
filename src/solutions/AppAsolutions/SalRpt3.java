package solutions.AppAsolutions;

// File: SalRpt3.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SalRpt3 {
  public static void main(String args[]) {
    Connection conn;
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();

      String sqltxt;
      sqltxt = "SELECT FIRSTNAME, LASTNAME, SALARY, DEPARTMENT_NAME " +
        "FROM EMPLOYEE, DEPARTMENT  " +
        "WHERE EMPLOYEE.DEPARTMENT_CODE = DEPARTMENT.DEPARTMENT_CODE";
      ResultSet rs = stmt.executeQuery(sqltxt);

      String name;
      String dept;
      float salary;
      float totalsalary = 0.0F;
      float tempsal;
      Map<String, Float> map = new HashMap<String, Float>();

      while (rs.next()) {
        name = rs.getString(1) + " " + rs.getString(2);
        salary = rs.getFloat(3);
        totalsalary += salary;

        System.out.print(SQLUtils.rPadTrunc(name, 30));
        System.out.printf("%1.2f %n", salary);
        dept = rs.getString(4);

        if (map.containsKey(dept)) {
          // unboxing and generics simplify this process
          tempsal = map.get(dept);
        }
        else {
          tempsal = 0.0F;
        }
        map.put(dept, new Float(tempsal + salary));
      }

      System.out.println( SQLUtils.rPadTrunc("", 38, '-'));
      System.out.print(SQLUtils.rPadTrunc("Total salary:", 28));
      System.out.printf("%1.2f%n", totalsalary);
      stmt.close();
      conn.close();

      System.out.println("\nTotal Salary for Department");
      Set<String> keys = map.keySet();
      Iterator<String> it = keys.iterator();
      while (it.hasNext() ) {
        dept = it.next();
        System.out.printf("%1.2f \t %2s %n", map.get(dept), dept);
      }
    }
    catch (ClassNotFoundException cnfe) {
      System.err.println("Unable to load driver class: " + cnfe);
    }
    catch (SQLException sqle) {
      System.err.println(sqle);
    }
  }
}
