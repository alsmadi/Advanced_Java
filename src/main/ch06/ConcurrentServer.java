// File: ConcurrentServer.java

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class ConcurrentServer implements Runnable {
  private Socket client;
  private Thread theThread;
  private static int count;
  private static ThreadGroup threadGroup;

  public ConcurrentServer(Socket s) {
    client = s;
    theThread = new Thread(threadGroup, this, "Socket" + count);
    System.out.println("Client connected to server: " + count +
      ",  Current active threads: " + threadGroup.activeCount());
    count++;
    theThread.start();
  }

  public void run(){
    BufferedReader sockin = null;
    PrintWriter sockout = null;
    try {
      sockin = new BufferedReader(
        new InputStreamReader(client.getInputStream()) );
      sockout = new PrintWriter( client.getOutputStream(), true);

      // loop, reading input from the socket and writing
      // the data to the client socket till client closes socket
      String linein = null;
      while( (linein = sockin.readLine()) != null ) {
        sockout.println( linein );
      }
    }
    catch (IOException e) {
      System.err.println(e);
    }
    finally {
      try {
        if (client != null) {
          client.close();
        }
      }
      catch (IOException e) {
        System.err.println(e);
      }
    }
  }

  public static void main(String[] args) {
    threadGroup = new ThreadGroup("Sockets");
    try {
      ServerSocket ss = new ServerSocket(7777);

      while(true) {
        // wait for the connection
        Socket s = ss.accept();
        // create a threaded object to handle the client
        new ConcurrentServer(s);
      }
    }
    catch (IOException e) {
      System.err.println(e);
    }
  }
}
