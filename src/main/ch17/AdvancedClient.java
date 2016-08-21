// File: AdvancedClient.java

import java.io.*;

public class AdvancedClient {
  public static void main(String[] args) {
    String s = "To sleep: perchance to dream: ay, there's the rub;\n";
    insertTextInFile("hamlet.txt", s, 395);
  }

  private static void insertTextInFile(String filename,
    String textToInsert, int position) {

    RandomAccessFile rac = null;
    try {
      rac = new RandomAccessFile(new File(filename), "rw");

      int currentFileLength = (int)rac.length();
      int numCharsInRestOfFile = currentFileLength - position;
      byte[] savedText = new byte[numCharsInRestOfFile];

      rac.seek(position);
      rac.readFully(savedText);

      rac.seek(position);
      rac.writeBytes(textToInsert);
      rac.writeBytes(new String(savedText));
    }
    catch (Exception e) {
      e.printStackTrace();
      System.err.println(e);
    }
    finally {
      try {
        rac.close();
      }
      catch (Exception e) {
        System.err.println(e);
      }
    }
  }
}