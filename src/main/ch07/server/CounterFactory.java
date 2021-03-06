// File: CounterFactory.java
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CounterFactory extends Remote {
  public Counter getCounter() throws RemoteException;
}
