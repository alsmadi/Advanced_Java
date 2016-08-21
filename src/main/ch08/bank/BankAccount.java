// File: BankAccount.java
package bank;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankAccount extends Remote {
  public double getBalance(String id) throws RemoteException;
}
