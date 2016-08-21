// File: JDBCRowSetUpdate.java

import java.sql.*;
import com.sun.rowset.CachedRowSetImpl;
import javax.sql.rowset.CachedRowSet;

public class JDBCRowSetUpdate {
  public static void main(String args[])  {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      Connection conn = DriverManager.getConnection(url);
      String sqlStmt = "SELECT id, salary, title " +
        "FROM employee " +
        "ORDER BY lastname";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sqlStmt);

      CachedRowSet crs = new CachedRowSetImpl();
      crs.populate(rs);
      stmt.close();

      while (crs.next()) {
        if (! crs.getString("title").equals("Manager")) {
          float oldSal = crs.getFloat("salary");
          crs.updateFloat("salary", oldSal * 1.1f);
        }
        crs.updateRow();
      }
      crs.setTableName("employee");
      crs.acceptChanges(conn);
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}


