package solutions.ch11solutions;

// File: EncryptText.java

import java.io.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

public class EncryptText {
  public static void main(String args[]) {
    try {
      System.out.println("Enter data for encrypted file.");
      System.out.println("Type EOF on line to end.");
      BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));

      KeyGenerator keyGen = KeyGenerator.getInstance("DES");
      Key theKey = keyGen.generateKey();

      Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding");
      c.init(Cipher.ENCRYPT_MODE, theKey);

      // write encrypted input text to a file
      FileOutputStream fos = new FileOutputStream("EncFile.txt");
      CipherOutputStream cos = new CipherOutputStream(fos,c);
      PrintWriter pw = new PrintWriter(cos);

      String s;
      while(!(s = br.readLine()).equalsIgnoreCase("EOF")) {
        pw.println(s);
      }
      br.close();
      pw.close();

      // Save key to a file
      ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream("Keyfile.dat"));
      oos.writeObject(theKey);
      oos.close();
    }
    catch (Exception e) {
      System.err.println("Error : " + e.getMessage());
    }
  }
}
