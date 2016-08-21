// File: JDBCRowSetList.java

import javax.sql.RowSet;
import com.sun.rowset.CachedRowSetImpl;

public class JDBCRowSetList {
  public static void main(String args[])  {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      String sqlStmt = "SELECT id, lastname, salary, title " +
        "FROM employee " +
        "ORDER BY lastname";

      RowSet rs = new CachedRowSetImpl();
      rs.setUrl(url);
      rs.setCommand(sqlStmt);
      rs.execute();

      while (rs.next()) {
        System.out.println(rs.getString("id") + "  " +
          rs.getString("lastname") + " " + rs.getFloat("salary")
          + "  " + rs.getString("title"));
      }
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}


