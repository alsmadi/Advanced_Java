package solutions.ch08solutions;

// File: ChatClient.java

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ChatClient extends UnicastRemoteObject
    implements Notifiable {

  public ChatClient() throws RemoteException{
    BufferedReader in =
      new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Please enter alias: ");
    try {
      String alias = in.readLine();

      ChatIF c = (ChatIF)Naming.lookup("//localhost:1099/chat");
      c.registerForNotification(this);

      while (true) {
        System.out.print("Enter a chat message, '##' to quit: ");
        String line = in.readLine();
        if (line.equalsIgnoreCase("##")) {
          System.exit(0);
        }
        c.postChat(line, alias);
      }
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
  public void notify(String msg, String sender) {
    System.out.println("\n" + sender + ": " + msg);
  }
  public static void main(String[] args) {
    try {
      new ChatClient();
    }
    catch (RemoteException e) {
      System.err.println(e);
    }
  }
}
