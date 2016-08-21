// File: RowIdExample.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RowIdExample {
  public static void main(String args[]) {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      Connection conn = DriverManager.getConnection(url);
      conn.setAutoCommit(false);

      Statement empStatement = conn.createStatement();
      Statement deptStatment = conn.createStatement(
        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

      ResultSet empResultSet;
      ResultSet deptResultSet = deptStatment.executeQuery(
        "SELECT department_code, department_name, manager_id " +
        "FROM department" );

      while (deptResultSet.next()) {
        String currentDeptCode =
          deptResultSet.getString("department_code");
        empResultSet = empStatement.executeQuery(
          "SELECT id, department_code " +
          "FROM employee " +
          "WHERE title = 'Department Manager'");

        while (empResultSet.next()) {
          String employeeDeptCode =
            empResultSet.getString("department_code");
          if (employeeDeptCode.equals(currentDeptCode)) {
            // determine if current department has a manager_id
            // don't update a row that already has a manager_id
            deptResultSet.getInt("manager_id");
            if (!deptResultSet.wasNull())
              continue;

            System.out.print("Updating dept " + currentDeptCode);
            int mgrId = empResultSet.getInt("id");
            System.out.println(", setting manager_id to " + mgrId);
            deptResultSet.updateInt("manager_id", mgrId);
            deptResultSet.updateRow();
          }
        }
        empResultSet.close();
      }
      deptResultSet.close();
      empStatement.close();
      deptStatment.close();
      conn.commit();
      conn.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}

