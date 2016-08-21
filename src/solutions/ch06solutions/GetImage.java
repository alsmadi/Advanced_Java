package solutions.ch06solutions;

// File: GetImage.java

import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class GetImage {
  public static void main(String args[]) {
    if (args.length == 0) {
      System.err.println("usage: java GetImage image_URL");
      System.exit(1);
    }

    URL imgURL = null;
    URLConnection imgConn = null;
    String imgType = null;
    try {
      imgURL = new URL(args[0]);
      imgConn = imgURL.openConnection();

      // connect explicitly to catch connection problem exceptions
      imgConn.connect();

      // Check the content-type to make sure it is an image
      imgType = imgConn.getContentType();
      if (! imgType.startsWith("image/")) {
        System.err.println(args[0] + ": not an image");
        System.exit(2);
      }
      // extract the specific image type from the content-type value
      imgType = imgType.substring(imgType.indexOf('/') + 1);
    }
    catch (IOException e) {
      System.err.println("Error establishing URL connection: " + e);
      System.exit(3);
    }

    String fileName = "image." + imgType;
    byte[] buffer = new byte[1000];
    FileOutputStream imgFile = null;
    InputStream imgStream = null;
    try {
      imgFile = new FileOutputStream(fileName);
      imgStream = imgConn.getInputStream();
      int len = -1;
      while ((len = imgStream.read(buffer)) != -1) {
        imgFile.write(buffer, 0, len);
      }
    }
    catch (IOException ioex) {
      System.err.println("Error copying image: " + ioex);
      System.exit(3);
    }
    finally {
      if (imgFile != null) {
        try {
          imgFile.close();
        }
        catch (IOException ignore) {}
      }
      if (imgStream != null) {
        try {
          imgStream.close();
        }
        catch (IOException ignore) {}
      }
    }
  }
}
