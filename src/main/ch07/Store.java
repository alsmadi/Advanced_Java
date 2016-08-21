// File: Store.java

import solutions.ch07solutions.Attendant;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Store extends Remote {
  public Attendant getAttendant() throws RemoteException;
}
