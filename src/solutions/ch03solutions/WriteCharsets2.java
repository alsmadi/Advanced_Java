package solutions.ch03solutions;

// File: WriteCharsets2.java

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Map;

public class WriteCharsets2 {
  public static void main(String[] args) {
    try {
      String fileName = "charsets2";
      RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
      FileChannel channel = raf.getChannel();
      ByteBuffer buf = ByteBuffer.allocate(1024);
      CharBuffer cbuf = buf.asCharBuffer();

      Map<String, Charset> charsets = Charset.availableCharsets();
      for (String csName : charsets.keySet()) {
        if (csName.length() + 1 > (cbuf.limit() - cbuf.position())) {
          cbuf.flip();
          channel.write(buf);
          buf.clear();
          cbuf.clear();
        }
        cbuf.put(csName);
        cbuf.put('\n');
      }
      cbuf.flip();
      channel.write(buf);
      channel.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
