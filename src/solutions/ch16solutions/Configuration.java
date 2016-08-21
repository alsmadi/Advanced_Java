package solutions.ch16solutions;

// File: Configuration.java

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
  private static boolean valid;
  private static int next;

  static {
    Properties p = new Properties();
    try {
      FileInputStream inputStream =
        new FileInputStream("hrapp.properties");

      if (inputStream != null) {
        p.load(inputStream);
        String value = p.getProperty("next");
        Integer i = new Integer(value);
        valid = true;
        next = i.intValue();
      }
    }
    catch (NumberFormatException nfe) {
      valid = false;
    }
    catch (IOException e) {
      valid = false;
    }
  }

  public static boolean isConfigValid() {
    return valid;
  }
  public static int getNext() {
    return next;
  }
}
