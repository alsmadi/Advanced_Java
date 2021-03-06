// File: KeyFileGen.java

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;

public class KeyFileGen {
  public static void main(String[] args) {
    try {
      KeyGenerator kg = KeyGenerator.getInstance("DES");
      kg.init(new SecureRandom());
      SecretKey key = kg.generateKey();

      ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream("keyfile.dat"));
      oos.writeObject(key);
      oos.close();
    }
    catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}

