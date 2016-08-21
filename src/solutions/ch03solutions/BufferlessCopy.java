package solutions.ch03solutions;

// File: BufferlessCopy.java

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class BufferlessCopy {
  public static void main(String[] args) {
    try {
      FileInputStream fin = new FileInputStream("Scatter.java");
      FileChannel fcin = fin.getChannel();
      FileOutputStream fout = new FileOutputStream("JavaSource");
      FileChannel fcout = fout.getChannel();

      fcin.transferTo(0, fcin.size(), fcout);

      fcin.close();
      fcout.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
