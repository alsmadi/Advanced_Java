package solutions.ch10solutions;

// File: ShowDates.java

import java.io.*;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class ShowDates {
  public static void main(String[] args) {
    try {
      String keyStoreLocation = System.getProperty("user.home");
      String keyStoreFile = ".keystore";
//      String password = "Hello, I must be going";
      String password = "password";

      KeyStore keyStore = KeyStore.getInstance("jks");
      FileInputStream fis = new FileInputStream(
        keyStoreLocation + File.separator + keyStoreFile);
      keyStore.load(fis, password.toCharArray());

      Enumeration aliases = keyStore.aliases();
      while (aliases.hasMoreElements()) {
        String a = aliases.nextElement().toString();
        System.out.println(a);

        if (keyStore.isKeyEntry(a)) {
          System.out.println(a + " is a key.");
          Key key = keyStore.getKey(a, password.toCharArray());
          System.out.println("Private Key:");
          System.out.println(key);
        }
        else if (keyStore.isCertificateEntry(a)) {
          System.out.println(a + " is a certificate.");
        }

        Certificate cert = keyStore.getCertificate(a);

        if (cert instanceof X509Certificate) {
          X509Certificate x509cert = (X509Certificate) cert;
          System.out.println("Not valid before: " +
            x509cert.getNotBefore());
          System.out.println("Not valid after: " +
            x509cert.getNotAfter());
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
