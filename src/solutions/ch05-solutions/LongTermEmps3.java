// File: LongTermEmps3.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class LongTermEmps3 {
  public static void main(String args[]){
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      Connection conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();

      ResultSet result = stmt.executeQuery(
        "SELECT id, lastname, firstname, hire_date, salary " +
        "FROM employee " +
        "WHERE hire_date < {d '1995-01-01'}");


      CachedRowSet crs = new CachedRowSetImpl();
      crs.populate(result);
      crs.moveToInsertRow();
      crs.updateInt("id",1000);
      crs.updateString("lastname","Seitz");
      crs.updateString("firstname","Robert");
      crs.updateFloat("salary",100000);
      crs.insertRow();
      crs.moveToCurrentRow();

      while (crs.next()) {
        System.out.println(crs.getString("lastname") + "  " +
          crs.getString("hire_date") + " " +
          crs.getString("salary"));
      }
      crs.setTableName("employee");
      crs.acceptChanges(conn);
      crs.close();
      conn.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
