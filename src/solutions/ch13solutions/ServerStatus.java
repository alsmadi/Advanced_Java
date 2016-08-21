package solutions.ch13solutions;

// File: ServerStatus.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerStatus extends Remote {
  public String getStatus() throws RemoteException;
}
