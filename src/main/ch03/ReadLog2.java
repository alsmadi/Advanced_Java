// File: ReadLog2.java

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ReadLog2 {
  public static void main(String[] args) {
    try {
      String fileName = "access_log";
      RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
      FileChannel channel = raf.getChannel();

      ByteBuffer bbuf = ByteBuffer.allocate(1024);
      int count = channel.read(bbuf);
      bbuf.flip();
      Charset ascii = Charset.forName("US-ASCII");
      CharBuffer cbuf = ascii.decode(bbuf);
      char[] chars = new char[cbuf.limit()];
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
