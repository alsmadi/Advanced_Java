package solutions.ch06solutions;

// File: EchoServer.java

import java.io.*;
import java.net.*;

public class EchoServer {
  public static void main(String[] args) {
    Socket clientSocket = null;
    BufferedReader sockin = null;
    PrintWriter sockout = null;
    try {
      ServerSocket listenSocket = new ServerSocket(7777);

      while(true) {
        clientSocket = listenSocket.accept();

        sockin = new BufferedReader(
          new InputStreamReader(clientSocket.getInputStream()));
        sockout =
          new PrintWriter(clientSocket.getOutputStream(), true);

        String linein;
        // Read from socket until client closes its end
        while ((linein = sockin.readLine()) != null) {
          sockout.println(linein);
          System.err.println("Server DEBUG: " + linein);
        }
        System.err.println("Server DEBUG: Connection closed");
        sockin.close();
        sockout.close();
        clientSocket.close();
      }
    }
    catch (IOException e) {
      System.err.println(e.getMessage());
    }
    finally {
      try {
        if (clientSocket != null)
          clientSocket.close();
      }
      catch (IOException e) {}
    }
  }
}
