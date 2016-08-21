// File: LockTest.java

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockTest {
  public static void main(String[] args) {
    try {
      String fileName = "access_log";

      RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
      FileChannel fc = raf.getChannel();

      System.out.print("Press <Enter> to obtain the exclusive lock");
      System.in.read();
      if (System.in.available() == 1)
        System.in.read(); //for Windows

      FileLock lock = fc.lock();
      System.out.println("\nObtained an exclusive lock on " + fileName);
      Thread.sleep(3000);
      lock.release();
      System.out.println("Released exclusive lock");

      System.out.print("Press <Enter> to obtain the shared lock");
      System.in.read();

      lock = fc.lock(0, Long.MAX_VALUE, true);
      System.out.println("\nObtained a shared lock on " + fileName);
      Thread.sleep(3000);
      lock.release();
      System.out.println("Released shared lock");

      fc.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
