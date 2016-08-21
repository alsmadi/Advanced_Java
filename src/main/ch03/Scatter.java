// File: Scatter.java

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
import java.nio.channels.FileChannel;

public class Scatter {
  public static void main(String[] args) {
    try {
      String fileName = "mixed";

      FileInputStream fin = new FileInputStream(fileName);
      FileChannel fc = fin.getChannel();
      ByteBuffer[] bufs = new ByteBuffer[2];

      // set up the temps buffer
      bufs[0] = ByteBuffer.allocate(16);
      FloatBuffer fbuf = bufs[0].asFloatBuffer();

      // set up the cities buffer
      bufs[1] = ByteBuffer.allocate(100);
      CharBuffer cbuf = bufs[1].asCharBuffer();

      int bytes = (int) fc.read(bufs);

      // read the temps
      float[] temps = new float[4];
      bufs[0].flip();
      fbuf.get(temps);

      // read the cities
      char[] cCities = new char[(bytes - 16)/2];
      bufs[1].flip();
      cbuf.get(cCities);
      String sCities = new String(cCities);
      String[] cities = sCities.split("\\s");

      for (int i = 0; i < temps.length; i++) {
        System.out.println(cities[i] + ": " + temps[i]);
      }
      fc.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
