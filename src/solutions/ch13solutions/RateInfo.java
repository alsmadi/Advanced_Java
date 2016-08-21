package solutions.ch13solutions;

// File: RateInfo.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RateInfo extends Remote {
  public String getInfo() throws RemoteException;
}
