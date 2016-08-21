package solutions.ch08solutions;

// File: Notifiable.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Notifiable extends Remote {
  public void notify(String msg, String sender)
    throws RemoteException;
}
