package solutions.ch16solutions;

// File: PropertyFile.java

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

public class PropertyFile implements OutputFile {
  private Properties props = new Properties();
  private Pattern pattern = Pattern.compile("=");

  public void append(String s) {
    String[] tokens = pattern.split(s);
    props.setProperty(tokens[0], tokens[1]);
  }
  public void write(String file) {
    try {
      FileOutputStream fos = new FileOutputStream(file);
      props.store(fos, null);
    }
    catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
