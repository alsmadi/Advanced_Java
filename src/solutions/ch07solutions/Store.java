package solutions.ch07solutions;

// File: Store.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Store extends Remote {
  public Attendant getAttendant() throws RemoteException;
}
