// File: ServerStatusImpl.java

import solutions.ch13solutions.ServerStatus;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerStatusImpl extends UnicastRemoteObject
    implements ServerStatus {

  private String name;

  public ServerStatusImpl(String name) throws RemoteException {
    this.name = name ;
  }
  public String getStatus() throws RemoteException {
    return "Server " + name + " is running.";
  }
}
