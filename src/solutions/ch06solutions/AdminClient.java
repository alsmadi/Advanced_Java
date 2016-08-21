package solutions.ch06solutions;

// File: AdminClient.java

import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;

public class AdminClient {
  public static void main(String args[]) {
    Socket s = null;
    ObjectInputStream sockin = null;

    try {
      // Connect to the server's admin port
      s = new Socket(InetAddress.getLocalHost(), 9000);

      sockin = new ObjectInputStream(s.getInputStream());

      // Tell the user that we've connected
      System.out.println("Connected to " +
        s.getInetAddress() + ":" + s.getPort());

      // get the statistics object
      ServerStatistics stats = (ServerStatistics)sockin.readObject();
      System.out.println(stats);
    }
    catch (IOException ioe) {
      System.err.println("Error connecting to server: " + ioe);
    }
    catch (ClassNotFoundException e) {
      System.err.println(
        "Error reading ServerStatistics obj from admin server " + e);
    }
    finally {
      if (s != null) {
        try {
          s.close();
        }
        catch (IOException ignore) {}
      }
    }
  }
}

