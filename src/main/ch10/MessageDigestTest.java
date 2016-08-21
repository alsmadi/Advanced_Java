// File: MessageDigestTest.java

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {
  public static void main(String[] args) {
    try {
      byte[] messageByteArray = args[0].getBytes();
      MessageDigest digest = MessageDigest.getInstance("MD5");
      digest.reset();
      digest.update(messageByteArray);
      byte[] digestByteArray = digest.digest();
      System.out.println("Message: " + args[0]);

      StringBuffer hexString = new StringBuffer();
      for (int i=0; i<messageByteArray.length; i++) {
        hexString.append(
          Integer.toHexString(0xFF & messageByteArray[i]));
        hexString.append(" ");
      }
      System.out.println("Message byte array: " +
        hexString.toString());

      hexString = new StringBuffer();
      for (int i=0; i<digestByteArray.length; i++) {
        hexString.append(
          Integer.toHexString(0xFF & digestByteArray[i]));
        hexString.append(" ");
      }
      System.out.println("Digest byte array: " +
        hexString.toString());
    }
    catch (NoSuchAlgorithmException e) {
      System.out.println(e.getMessage());
    }
  }
}
