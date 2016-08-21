// File: ImageToFile.java

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ImageToFile {
  public static void main(String args[]) {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      Connection conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();

      ResultSet rs = stmt.executeQuery("SELECT lastname, mugshot " +
        "FROM employee " +
        "WHERE mugshot IS NOT NULL");

      while (rs.next()) {
        String filepath = rs.getString(1) + ".gif";
        Blob b = rs.getBlob(2);

        FileOutputStream ostream = new FileOutputStream(filepath);
        ostream.write(b.getBytes(1, (int)b.length()));
        ostream.close();

        System.out.println("Image saved as " + filepath);
      }
      stmt.close();
      conn.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
