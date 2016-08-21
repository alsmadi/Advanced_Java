package solutions.ch18solutions;

// File TemplateClient2.java

public class TemplateClient2 {
  public static void main(String[] args) {
    String driverClass = "org.apache.derby.jdbc.ClientDriver";
    String url = "jdbc:derby://localhost:1527/j2se";
    String username = null;
    String password = null;
    DatabaseAccessTemplate db = new Query();
    String sql = "SELECT * FROM Employee";
    db.executeSQL(driverClass, url, sql, username, password);
  }
}