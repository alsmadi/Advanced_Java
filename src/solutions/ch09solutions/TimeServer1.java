package solutions.ch09solutions;

// File:  TimeServer1.java

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeServer1 extends UnicastRemoteObject implements Time {
  public TimeServer1() throws RemoteException {
  }
  public String getSystemTime() {
    DateFormat df = DateFormat.getTimeInstance();
    df.setTimeZone(TimeZone.getDefault());
    return df.format(new Date());
  }
  public static void main(String args[]) {
    System.setSecurityManager(new SecurityManager());
    try {
      TimeServer1 ts = new TimeServer1();
      Naming.rebind("///Time", ts);
    }
    catch (MalformedURLException e) {
      System.err.println(e);
    }
    catch (RemoteException e) {
      System.err.println(e);
    }
  }
}
