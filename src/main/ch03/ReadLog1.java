// File: ReadLog1.java

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class ReadLog1 {
  public static void main(String[] args) {
    try {
      String fileName = "access_log";
      RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
      FileChannel channel = raf.getChannel();

      ByteBuffer bbuf = ByteBuffer.allocate(1024);
      CharBuffer cbuf = bbuf.asCharBuffer();
      int count = channel.read(bbuf);
      bbuf.flip();
      char[] chars = new char[count / 2];
      cbuf.get(chars);
      for (char c : chars) {
        System.out.print(c);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
