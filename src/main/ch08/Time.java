// File: Time.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Time extends Remote {
  public String getTime() throws RemoteException;
}
