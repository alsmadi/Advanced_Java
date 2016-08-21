// File: ShowAliases.java

import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Enumeration;

public class ShowAliases {
  public static void main(String[] args) {
    try {
      String keyStoreLocation = System.getProperty("user.home");
      String keyStoreFile = ".keystore";
      String password = "Hello, I must be going";

      KeyStore keyStore = KeyStore.getInstance("jks");
      FileInputStream fis = new FileInputStream(
        keyStoreLocation + File.separator + keyStoreFile);
      keyStore.load(fis, password.toCharArray());

      Enumeration aliases = keyStore.aliases();
      while (aliases.hasMoreElements()) {
        System.out.println(aliases.nextElement());
      }
    }
    catch (KeyStoreException e) {
      System.err.println(e);
    }
    catch (IOException e) {
      System.err.println(e);
    }
    catch (NoSuchAlgorithmException e) {
      System.err.println(e);
    }
    catch (CertificateException e) {
      System.err.println(e);
    }
  }
}
