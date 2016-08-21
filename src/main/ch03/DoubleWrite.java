// File: DoubleWrite.java

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.channels.FileChannel;

public class DoubleWrite {
  public static void main(String[] args) {
    try {
      String fileName = "constants";
      FileOutputStream fout = new FileOutputStream(fileName);
      FileChannel fc = fout.getChannel();
      ByteBuffer bbuf = ByteBuffer.allocate(16);
      DoubleBuffer dbuf = bbuf.asDoubleBuffer();

      dbuf.put(Math.PI);
      dbuf.put(Math.E);
      dbuf.flip();
      fc.write(bbuf);
      System.out.println("Wrote math constants to constants file.");
      fc.close();

      dbuf.clear();
      FileInputStream fin = new FileInputStream(fileName);
      fc = fin.getChannel();
      fc.read(bbuf);
      bbuf.flip();
      double pi = dbuf.get();
      double e = dbuf.get();
      fc.close();
      System.out.println("pi = " + pi + " e = " + e);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
