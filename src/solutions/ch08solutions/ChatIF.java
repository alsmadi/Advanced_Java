package solutions.ch08solutions;

// File: ChatIF.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatIF extends Remote {
  public void postChat(String msg, String sender)
    throws RemoteException;
  public void registerForNotification(Notifiable n)
    throws RemoteException;
}
