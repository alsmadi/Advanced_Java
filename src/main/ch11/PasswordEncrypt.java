// File: PasswordEncrypt.java

import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class PasswordEncrypt {
  public static void main(String args[]) {
    try {
      BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
      System.out.print("Enter Password for Encryption: ");
      String password = br.readLine();

      byte[] salt = {(byte)0xca, (byte)0xfe, (byte)0xba, (byte)0xbe,
                     (byte)0x32, (byte)0x9a, (byte)0xfa, (byte)0x71 };

      PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 10);

      PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
      SecretKeyFactory skf =
        SecretKeyFactory.getInstance("PBEWithMD5AndDES");
      SecretKey theKey = skf.generateSecret(keySpec);

      Cipher c = Cipher.getInstance("PBEWithMD5AndDES");
      c.init(Cipher.ENCRYPT_MODE, theKey, paramSpec);

      FileOutputStream fos = new FileOutputStream("EncFile.dat");
      CipherOutputStream cos = new CipherOutputStream(fos, c);
      PrintWriter pw = new PrintWriter(cos);

      System.out.println("Enter data for encrypted file.");
      System.out.println("Type EOF on line to end.");
      String s;
      while(!(s = br.readLine()).equals("EOF"))
        pw.println(s);

      br.close();
      pw.close();
    }
    catch (Exception e) {
      System.err.println("Error : " + e.getMessage());
    }
  }
}
