// File: ImageFromFile.java

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class ImageFromFile {
  public static void main(String args[]) {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      String url = "jdbc:derby://localhost:1527/j2se";
      Connection conn = DriverManager.getConnection(url);

      String sqltxt = "UPDATE employee SET mugshot = ? WHERE id = ?";
      PreparedStatement pstmt = conn.prepareStatement(sqltxt);

      String filepath[] = {"emp1.gif","emp2.gif","emp3.gif"};
      int idArray[] = {9883, 6881, 6644};

      for (int i = 0; i < filepath.length; i++) {
        FileInputStream istream = new FileInputStream(filepath[i]);
        int length = (int) (new File(filepath[i])).length();
        byte[] image = new byte[length];
        istream.read(image, 0, length);

        pstmt.setBytes(1, image);
        pstmt.setInt(2, idArray[i]);
        int uc = pstmt.executeUpdate();

        istream.close();
      }
      pstmt.close();
      conn.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
