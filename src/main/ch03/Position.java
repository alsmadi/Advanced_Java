// File: Position.java

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Position {
  public static void main(String[] args) {
    try {
      RandomAccessFile raf = new RandomAccessFile("smallfile", "rw");
      FileChannel fc = raf.getChannel();

      ByteBuffer buf = ByteBuffer.allocate(8);

      // read from the file
      printInfo("after allocate:", buf);
      int count = fc.read(buf);
      printInfo("after read:", buf);
      System.out.println("count=" + count);
      buf.flip();
      printInfo("after flip:", buf);
      byte[] data = new byte[count];
      buf.get(data);
      printInfo("after get:", buf);
      System.out.print("The data: ");
      for (byte b : data) {
        System.out.print((char) b);
      }
      System.out.println();
      System.out.println();

      // write to the file
      buf.clear();
      printInfo("after clear:", buf);
      buf.put("Hello".getBytes());
      printInfo("after put(\"Hello\"):", buf);
      buf.flip();
      printInfo("after flip:", buf);
      fc.write(buf);
      printInfo("after write:", buf);
      fc.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void printInfo(String description, ByteBuffer buf) {
    System.out.println(description + " position=" + buf.position() + " limit=" +
      buf.limit() + " capacity=" + buf.capacity());
  }
}
