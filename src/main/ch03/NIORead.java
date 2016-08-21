// File: NIORead.java

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIORead {
  public static void main(String[] args) {
    try {
      String fileName = "access_log";
      RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
      FileChannel fc = raf.getChannel();
      ByteBuffer buf = ByteBuffer.allocate(1024);
      byte[] bytes = null;
      int count=-1;

      while ((count = fc.read(buf)) != -1) {
        bytes = new byte[count];
        buf.flip();
        buf.get(bytes);
        for (byte b: bytes) {
          System.out.print((char) b);
        }
        buf.clear();
      }

      // write to file
      buf.put("Hello".getBytes());
      buf.flip();
      fc.write(buf);
      System.out.println("Wrote string \"Hello\" to access_log.");
      fc.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
