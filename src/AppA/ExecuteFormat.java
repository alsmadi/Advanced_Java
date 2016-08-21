// File: ExecuteFormat.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;

public class ExecuteFormat {

  public static void main(String args[])
    throws ClassNotFoundException {

    Class.forName("org.apache.derby.jdbc.ClientDriver");
    String url = "jdbc:derby://localhost:1527/j2se";
    try {
      Connection conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();
      ResultSet rs;
      rs = stmt.executeQuery("SELECT * FROM DEPARTMENT");

      ResultSetMetaData rsmd = rs.getMetaData();
      int cols = rsmd.getColumnCount();
      int colWidth[] = new int[cols];

      String resultLine = "";
      for (int col=1; col <= cols; col++) {
        colWidth[col-1] = getAppDisplayWidth(rsmd, col);
        resultLine += SQLUtils.rPadTrunc(rsmd.getColumnName(col),
            colWidth[col-1]);
        if (col < cols) {
          resultLine += " ";
        }
      }
      System.out.println(resultLine);

      while (rs.next()) {
        resultLine = "";
        for (int col=1; col <= cols; col++) {
          resultLine += SQLUtils.rPadTrunc(rs.getString(col),
              colWidth[col-1]);
          if (col < cols) {
            resultLine += " ";
          }
        }
        System.out.println(resultLine);
      }
      stmt.close();
      conn.close();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  static int getAppDisplayWidth(ResultSetMetaData rsmd, int col)
      throws SQLException {

    switch (rsmd.getColumnType(col)) {
      case Types.NUMERIC:
      case Types.INTEGER:
        return 9;
      case Types.TIMESTAMP:
        return 22;
      case Types.DATE:
        return 10;
      case Types.TIME:
        return 8;
      default :
        return rsmd.getColumnDisplaySize(col);
    }
  }
}
