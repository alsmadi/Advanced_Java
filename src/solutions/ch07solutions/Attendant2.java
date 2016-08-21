package solutions.ch07solutions;

// File: Attendant2.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Attendant2 extends Remote {
  public int submitOrder(Order order) throws RemoteException;
  public boolean release() throws RemoteException;
}
