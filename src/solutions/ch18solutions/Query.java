package solutions.ch18solutions;

// File: Query.java

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Query extends DatabaseAccessTemplate {
  private ResultSet rs;

  protected void runStatement(Statement stmt, String sql)
      throws Exception {
    rs = stmt.executeQuery(sql);
  }
  protected void processResults()
      throws Exception {

    ResultSetMetaData rsmd = rs.getMetaData();
    int numColumns = rsmd.getColumnCount();

    for (int i = 1; i <= numColumns; i++) {
      System.out.print(rsmd.getColumnName(i) + "\t");
    }
    System.out.println();

    while (rs.next()) {
      for (int i = 1; i < numColumns; i++) {
        System.out.print(rs.getString(i) + "\t");
      }
      System.out.println();
    }
    rs.close();
  }
}