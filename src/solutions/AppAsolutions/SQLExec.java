package solutions.AppAsolutions;

// File: SQLExec.java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class SQLExec {
  public static void main(String args[]) {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      String buf;
      String sqlString = "";

      try {
        BufferedReader br = new BufferedReader(
          new InputStreamReader(System.in));
        System.out.println("Enter a SQL statement. Enter 'q' to quit");

        while ((buf = br.readLine()) != null) {
          if (buf.equals("q")) {
            break;
          }
          sqlString += buf + " ";
        }
      }
      catch(IOException ioe) {
        ioe.printStackTrace();
        System.exit(1);
      }
      System.out.println("Executing SQL statement:");
      System.out.println(sqlString);

      Connection conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();

      int count = 0;
      if (sqlString.trim().toUpperCase().startsWith("SELECT")) {
        ResultSet rs = stmt.executeQuery(sqlString);
        while (rs.next ()) {
          count++;
        }
        rs.close();
        System.out.printf("%n%1d row(s) retrieved.%n", count);
      }
      else {
        count = stmt.executeUpdate(sqlString);
        System.out.printf("%n%1d row(s) updated.%n", count);
      }
      stmt.close();
      conn.close();
    }
    catch (ClassNotFoundException cnfe) {
      System.err.println("Unable to load driver class: " + cnfe);
    }
    catch (SQLException sqle) {
      System.err.println(sqle);
    }
  }
}