package solutions.ch03solutions;

// File: WriteCharsets.java

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Map;

public class WriteCharsets {
  public static void main(String[] args) {
    try {
      String fileName = "charsets";
      RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
      FileChannel channel = raf.getChannel();
      ByteBuffer buf = ByteBuffer.allocate(1024);

      Map<String, Charset> charsets = Charset.availableCharsets();
      for (String csName : charsets.keySet()) {
        if (csName.length() + 1 > buf.limit() - buf.position()) {
          buf.flip();
          channel.write(buf);
          buf.clear();
        }
        buf.put(csName.getBytes());
        buf.put((byte) '\n');
      }
      buf.flip();
      channel.write(buf);
      channel.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
