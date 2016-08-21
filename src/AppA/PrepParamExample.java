// File: PrepParamExample.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepParamExample {
  private PreparedStatement pst;

  public PrepParamExample() {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      Connection conn = DriverManager.getConnection(url);

      pst = conn.prepareStatement("SELECT department_name " +
        "FROM department WHERE department_code = ?");

      System.out.println(getDeptName("RD"));
      System.out.println(getDeptName("HR"));
      pst.close();
      conn.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String getDeptName(String deptid) throws SQLException {
    pst.setString(1, deptid);
    ResultSet rs = pst.executeQuery();
    String dept = "";
    while (rs.next()) {
      dept += rs.getString(1) + "\n";
    }
    return dept;
  }

  public static void main(String args[]) {
    new PrepParamExample();
  }
}
