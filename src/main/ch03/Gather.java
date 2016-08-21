// File: Gather.java

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
import java.nio.channels.FileChannel;

public class Gather {
  public static void main(String[] args) {
    try {
      float[] temps = {42.0f, 56.0f, 80.0f, 80.0f};
      String[] cities = {"Juneau","Denver","Fresno","Helena"};

      String fileName = "mixed";
      FileOutputStream fout = new FileOutputStream(fileName);
      FileChannel fc = fout.getChannel();
      ByteBuffer[] bufs = new ByteBuffer[2];

      // write the temps
      bufs[0] = ByteBuffer.allocate(temps.length * 4);
      FloatBuffer fbuf = bufs[0].asFloatBuffer();
      fbuf.put(temps);
      fbuf.flip();

      // write the cities
      bufs[1] = ByteBuffer.allocate(cities.length * 2 * 7);
      CharBuffer cbuf = bufs[1].asCharBuffer();
      for (String city : cities) {
        cbuf.put(city + " ");
      }
      cbuf.flip();

      fc.write(bufs);
      System.out.println("Wrote the data to mixed file.");
      fc.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
