// File: ManagerFlatFile.java

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ManagerFlatFile implements ManagerFile {
  private StringBuilder content = new StringBuilder();

  public void append(String s) {
    content.append(s);
  }
  public void write(String file) {
    try {
      OutputStreamWriter osw =
        new OutputStreamWriter(new FileOutputStream(file));
      BufferedWriter bw = new BufferedWriter(osw);
      bw.write(content.toString());
      bw.close();
    }
    catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
