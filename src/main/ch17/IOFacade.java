// File: IOFacade.java

import java.io.*;

public class IOFacade {
  private static IOFacade theInstance = null;

  private IOFacade() {
  }

  public static IOFacade getInstance() {
    if (theInstance == null) {
      theInstance  = new IOFacade();
    }
    return theInstance;
  }
  public void writeToTextFile(String filename, String text)
      throws IOException {

    PrintWriter out = null;
    boolean append = true;

    try {
      File file = new File(filename);
      out = new PrintWriter(new BufferedWriter(
        new FileWriter(file, append)));
      out.println(text);
    }
    catch (IOException e) {
      log(e);
      throw e;
    }
    finally {
      out.close();
    }
  }
  public void writeToBinaryFile(String filename, byte[] bytes)
      throws IOException {

    BufferedOutputStream out = null;
    boolean append = true;

    try {
      File file = new File(filename);
      out = new BufferedOutputStream(
        new FileOutputStream(file, append));
      out.write(bytes);
    }
    catch (IOException e) {
      log(e);
      throw e;
    }
    finally {
      try {
        out.close();
      }
      catch (IOException ioe) {
        log(ioe);
        throw ioe;
      }
    }
  }
  private void log(Exception e) {
    try {
      writeToTextFile("log.txt", e.toString());
    }
    catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}