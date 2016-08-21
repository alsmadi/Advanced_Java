package solutions.ch17solutions;

// File: IOFacade2.java

import java.io.*;

public class IOFacade2 {
  private static IOFacade2 theInstance = null;

  private IOFacade2() {
  }

  public static IOFacade2 getInstance() {
    if (theInstance == null) {
      theInstance  = new IOFacade2();
    }
    return theInstance;
  }
  public void writeToSerializedObjectFile(String filename, Object obj)
      throws IOException {

    ObjectOutputStream out = null;
    boolean append = true;

    try {
      File file = new File(filename);
      out = new ObjectOutputStream(
        new FileOutputStream(file, append));
      out.writeObject(obj);
    }
    catch (IOException e) {
      log(e);
      throw e;
    }
    finally {
      out.close();
    }
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