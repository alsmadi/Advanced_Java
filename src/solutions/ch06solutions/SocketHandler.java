package solutions.ch06solutions;

// File: SocketHandler.java

import java.io.*;
import java.net.*;

public class SocketHandler {
  public static String echo(String host, int port, String input) {
    String receive = "";
    try {
      Socket s = new Socket(host, port);

      BufferedReader in = new BufferedReader(
        new InputStreamReader(s.getInputStream()));

      PrintWriter out =
        new PrintWriter(s.getOutputStream(), true);

      out.println(input);
      out.println("\u0004");

      String line = in.readLine();
      while (!line.equals("\u0004") ) {
        receive += line + "\n";
        System.err.println("Client DEBUG: " + line);
        line = in.readLine();
      }
      in.close();
      out.close();
      s.close();
    }
    catch (UnknownHostException e) {
      System.err.println("UnknownHost" + e.getMessage());
      System.exit(1);
    }
    catch (IOException e) {
      System.err.println(e.getMessage());
      System.exit(2);
    }
    return receive;
  }
}
