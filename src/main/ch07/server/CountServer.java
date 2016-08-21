// File: CountServer.java
package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CountServer implements Counter {
  private int count=0;

  public CountServer() throws RemoteException {
    UnicastRemoteObject.exportObject(this);
  }
  public int getCount() {
    return ++count;
  }
}