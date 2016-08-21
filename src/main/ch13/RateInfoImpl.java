// File: RateInfoImpl.java

import solutions.ch13solutions.RateInfo;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RateInfoImpl extends UnicastRemoteObject
    implements RateInfo {

  public RateInfoImpl() throws RemoteException {
    super();
  }
  public String getInfo() {
    return "All rates are currently competitive. " +
      "Call the office for more details.";
  }
}
