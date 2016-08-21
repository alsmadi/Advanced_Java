package solutions.ch06solutions;

// File: SendFile2.java

import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendFile2 {

  public static void main(String[] args) {
    String file = "data.txt";
    int port = 8000;
    int adminPort = 9000;
    ServerStatistics statistics = new ServerStatistics(file, port, 0);

    ServerSocket ss = null;
    Socket s = null;
    OutputStream sockout = null;

    byte[] data = null; // contents of the file

    try {
      FileInputStream in = new FileInputStream(file);
      data = new byte[in.available()];
      in.read(data);
      in.close();
    }
    catch (IOException e) {
      System.err.println("Error reading " + file + ": " + e);
      System.exit(1);
    }

    // start a thread listening for admin requests
    new AdminThread(adminPort, statistics).start();

    try {
      ss = new ServerSocket(port);

      while (true) {
        // wait for the connection
        s = ss.accept();

        statistics.incrementConnectionCount();

        // build sockout from the socket's Output Stream
        sockout = s.getOutputStream();

        // Tell the user that we've connected
        System.out.println("Connected to " +
            s.getInetAddress() +
            ":"+ s.getPort());

        // Send the client the contents of the file
        sockout.write(data);

        s.close();
      }
    }
    catch (IOException e) {
      System.err.println(e) ;
    }
    finally {
      // Always be sure to close the sockets to release resources
      if (ss != null) {
        try {
          ss.close();
        }
        catch (IOException ignore) {}
      }
      if (s != null) {
        try {
          s.close();
        }
        catch (IOException ignore) {}
      }
    }
  }

}

class AdminThread extends Thread {
  private int adminPort;
  private ServerStatistics statistics;

  AdminThread(int adminPort, ServerStatistics statistics) {
    this.adminPort = adminPort;
    this.statistics = statistics;
  }

  public void run() {
    ServerSocket ss = null;
    Socket s = null;
    ObjectOutputStream sockout = null;
    try {
      ss = new ServerSocket(adminPort);

      while (true) {
        s = ss.accept();
        sockout = new ObjectOutputStream(s.getOutputStream());

        // Tell the user that we've connected
        System.out.println("Connected to admin client " +
          s.getInetAddress() + ":"+ s.getPort());

        sockout.writeObject(statistics);
        s.close();
      }
    }
    catch (IOException e) {
      System.err.println("Error in admin thread: " + e) ;
    }
    finally {
      // Always be sure to close the sockets to release resources
      if (ss != null) {
        try {
          ss.close();
        }
        catch (IOException ignore) {}
      }
      if (s != null) {
        try {
          s.close();
        }
        catch (IOException ignore) {}
      }
    }
  }
}
