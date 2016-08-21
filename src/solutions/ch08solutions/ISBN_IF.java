package solutions.ch08solutions;

// File: ISBN_IF.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISBN_IF extends Remote {
  public String getTitle(String isbn) throws RemoteException;
}
