package solutions.ch03solutions;

// File: CopyScatter.java

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyScatter {
  public static void main(String[] args) {
    try {
      FileInputStream fin = new FileInputStream("Scatter.java");
      FileChannel fcin = fin.getChannel();
      FileOutputStream fout = new FileOutputStream("JavaSource");
      FileChannel fcout = fout.getChannel();

      ByteBuffer buf = ByteBuffer.allocate(1024);
      while ((fcin.read(buf)) != -1) {
        buf.flip();
        fcout.write(buf);
        buf.clear();
      }
      fcin.close();
      fcout.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
