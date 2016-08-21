// File: DML.java

import solutions.ch18solutions.DatabaseAccessTemplate;
import java.sql.Statement;

public class DML extends DatabaseAccessTemplate {
  private int updateCount;
  protected void runStatement(Statement stmt, String sql)
      throws Exception {
    updateCount = stmt.executeUpdate(sql);
  }
}