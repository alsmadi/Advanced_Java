
import solutions.ch18solutions.DatabaseAccessTemplate;

// File TemplateClient.java

public class TemplateClient {
  public static void main(String[] args) {
    String driverClass = "org.apache.derby.jdbc.ClientDriver";
    String url = "jdbc:derby://localhost:1527/j2se";
    String username = null;
    String password = null;
    DatabaseAccessTemplate db = new DML();
    String sql = "UPDATE Employee SET lastname='Smith' WHERE id=9883";
    db.executeSQL(driverClass, url, sql, username, password);
  }
}