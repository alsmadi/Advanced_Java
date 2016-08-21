// File: TimeImpl.java

import solutions.ch09solutions.Time;
import java.rmi.RemoteException;
import java.util.Date;
import javax.rmi.PortableRemoteObject;

public class TimeImpl extends PortableRemoteObject implements Time {
  public TimeImpl() throws RemoteException {
  }
  public String getTime() {
    Date d = new Date();
    return d.toString();
  }
}
