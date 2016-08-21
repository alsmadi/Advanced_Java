// File: GetFile.java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GetFile {
  public static void main(String[] args) {
    String contents = null;
    BufferedReader buf = null;
    try {
      URL myPage = new URL("http://www.google.com/index.html");

      buf = new BufferedReader(new InputStreamReader(
        myPage.openStream()));

      while ((contents = buf.readLine()) != null) {
        System.out.println(contents);
      }
    }
    catch (MalformedURLException e) {
      System.err.println(e.getMessage());
    }
    catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }
}
