// File: MyConnection.java

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
  private Connection connection;
  private static MyConnection theInstance;

  private MyConnection() {
    try {
      String driverClass = "org.apache.derby.jdbc.ClientDriver";
      String url = "jdbc:derby://localhost:1527/j2se";
      String username = null;
      String password = null;

      Class.forName(driverClass);
      connection =
        DriverManager.getConnection(url, username, password);
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
  public static synchronized MyConnection getInstance() {
    if (theInstance == null) {
      theInstance = new MyConnection();
    }
    return theInstance;
  }
  public synchronized Connection getConnection() {
    return connection;
  }
}
