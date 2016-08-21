// File: Batch.java

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      conn = DriverManager.getConnection(url);
      conn.setAutoCommit(false);

      stmt = conn.createStatement();
      stmt.addBatch("UPDATE department SET manager_id = 7223 " +
        " WHERE department_code = 'AC'");
      stmt.addBatch("UPDATE department SET manager_id = 6881 " +
        " WHERE department_code = 'AD'");
      stmt.addBatch("UPDATE department SET manager_id = 8339 " +
        " WHERE department_code = 'CS'");
      stmt.addBatch("UPDATE department SET manager_id = 8053 " +
        " WHERE department_code = 'HR'");
      int[] uc = stmt.executeBatch();

      conn.commit();
    }
    catch (BatchUpdateException bue) {
      try {
        conn.rollback();
      }
      catch (SQLException e) {
        System.err.println(e);
      }
      System.err.println(bue);
    }
    catch (Exception e) {
      System.err.println(e);
    }
    finally {
      try {
        if (stmt != null)
          stmt.close();
        if (conn != null)
          conn.close();
      }
      catch (SQLException ignore) {}
    }
  }
}
