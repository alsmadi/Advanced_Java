package solutions.ch18solutions;

// File: DatabaseAccessTemplate.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public abstract class DatabaseAccessTemplate {
  public void executeSQL(String driverClass, String url, String sql,
      String username, String password) {
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = createConnection(driverClass, url, username, password);
      stmt = createStatement(conn);
      runStatement(stmt, sql);
      processResults();
    }
    catch (Exception e) {
      System.err.println(e);
    }
    finally {
      cleanup(stmt, conn);
    }
  }
  protected abstract void runStatement(Statement stmt, String sql)
      throws Exception;
  protected void processResults() throws Exception {
  }
  protected Connection createConnection(String driverClass,
      String url, String user, String pw) throws Exception {
    Class.forName(driverClass);
    Connection conn = DriverManager.getConnection(url, user, pw);
    return conn;
  }
  protected Statement createStatement(Connection c) throws Exception {
    Statement stmt = c.createStatement();
    return stmt;
  }
  protected final void cleanup(Statement stmt, Connection conn) {
    try {
      stmt.close();
      conn.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
}