// File: ShowCert.java

import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class ShowCert {
  public static void main(String[] args) {
    try {
      String keyStoreLocation = System.getProperty("user.home");
      String keyStoreFile = ".keystore";
      String password = "Hello, I must be going";
      String alias = "firefly";

      KeyStore keyStore = KeyStore.getInstance("jks");
      FileInputStream fis = new FileInputStream(
        keyStoreLocation + File.separator + keyStoreFile);
      keyStore.load(fis, password.toCharArray());

      Certificate cert = keyStore.getCertificate(alias);
      if (cert instanceof X509Certificate) {
        X509Certificate x509cert = (X509Certificate) cert;
        System.out.println("Certificate subject: " +
          x509cert.getSubjectX500Principal());
        System.out.println("Certificate issuer: " +
          x509cert.getIssuerX500Principal());
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
