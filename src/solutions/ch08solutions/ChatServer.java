package solutions.ch08solutions;

// File: ChatServer.java

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Iterator;

public class ChatServer extends UnicastRemoteObject
    implements ChatIF {

  private HashSet<Notifiable> listeners = null;

  public ChatServer() throws RemoteException {
    listeners = new HashSet<Notifiable>();
  }

  public void postChat(String msg, String sender) {
    System.out.println(sender + ": " + msg);
    Iterator<Notifiable> it = listeners.iterator();
    while (it.hasNext()) {
      Notifiable not = it.next();
      try {
        not.notify(msg, sender);
      }
      catch (Exception e) {
        System.err.println(e);
      }
    }
  }
  public void registerForNotification(Notifiable n) {
    if (!listeners.contains(n)) {
      listeners.add(n);
    }
  }
  public static void main(String[] args) {
    try {
      ChatServer c = new ChatServer();
      Naming.rebind("//localhost:1099/chat", c);
      System.out.println("Chat bound.");
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
}
