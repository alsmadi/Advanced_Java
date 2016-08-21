package solutions.ch07solutions;

// File: Store3.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Store3 extends Remote {
  public Attendant3 getAttendant() throws RemoteException;
}
