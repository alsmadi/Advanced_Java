// File: JDBCSavepoint.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCSavepoint {
  public static void main(String args[])  {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      Connection conn = DriverManager.getConnection(url);

      conn.setAutoCommit(false);
      String s1 = "UPDATE employee SET salary = salary * 1.1253";
      String s2 = "UPDATE employee SET title = 'CEO' WHERE id = 9683";
      Statement stmt = conn.createStatement();

      stmt.executeUpdate(s1);
      Savepoint sp = conn.setSavepoint("SVP1");
      stmt.executeUpdate(s2);

      conn.rollback(sp);
      conn.commit();
      stmt.close();
      conn.close();
    }
    catch (ClassNotFoundException cnfe) {
      System.err.println(cnfe);
    }
    catch (SQLException sqle) {
      System.err.println(sqle);
    }
  }
}


