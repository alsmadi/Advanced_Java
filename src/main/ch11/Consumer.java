// File: Consumer.java

import java.io.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class Consumer {
  public static void main(String[] args) {
    try {
      ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream("keyfile.dat"));
      Key key = (Key) ois.readObject();
      ois.close();

      DataInputStream dis = new DataInputStream(
        new FileInputStream("WrappedKey.dat"));
      byte[] encodedKey = new byte[dis.available()];
      dis.read(encodedKey, 0, dis.available());

      Cipher c = Cipher.getInstance("DES/ECB/NoPadding");
      c.init(Cipher.UNWRAP_MODE, key);

      Key k = c.unwrap(encodedKey, "DES", Cipher.SECRET_KEY);

      Cipher c2 = Cipher.getInstance("DES/ECB/PKCS5Padding");
      c2.init(Cipher.DECRYPT_MODE, k);

      FileInputStream fis = new FileInputStream("Enc.dat");
      CipherInputStream cis = new CipherInputStream(fis, c2);
      BufferedReader br2 = new BufferedReader(
        new InputStreamReader(cis));
      String s;
      while((s = br2.readLine()) != null)
        System.out.println(s);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}

