// File: CountServerFactory.java
package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;

public class CountServerFactory extends UnicastRemoteObject
    implements CounterFactory {
  public CountServerFactory() throws RemoteException {
  }
  public Counter getCounter() throws RemoteException {
    return new CountServer();
  }
  public static void main(String args[]) {
    CountServerFactory factory;
    try {
      factory = new CountServerFactory();
      Naming.rebind("///CountFactory", factory);
    }
    catch(MalformedURLException mue) {
      System.err.println(mue);
    }
    catch(RemoteException re) {
      System.err.println(re);
    }
  }
}