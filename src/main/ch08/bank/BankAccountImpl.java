// File: BankAccountImpl.java
package bank;

import java.io.File;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationID;
import java.util.Scanner;

public class BankAccountImpl extends Activatable
    implements BankAccount {
  private File accountFile = null;

  public BankAccountImpl(ActivationID id, MarshalledObject data)
      throws RemoteException {
    super(id, 0);
    try {
      accountFile = (File)data.get();
    }
    catch (Exception e) {
      throw new RemoteException(
        "Failed unmarshalling File object", e);
    }
  }

  // scan a tab delimited file for the balance for the given id
  public double getBalance(String id) throws RemoteException {
    double result = 0;
    Scanner scanner = null;
    try {
      scanner = new Scanner(accountFile);
      while (scanner.hasNextInt()) {
        String accountId = scanner.next();
        double balance = scanner.nextDouble();
        if (accountId.equals(id)) {
          result = balance;
          break;
        }
      }
    }
    catch (Exception e) {
      throw new RemoteException(
        "Exception occurred while scanning file: " + accountFile, e);
    }
    finally {
      if (scanner != null) {
        scanner.close();
      }
    }
    return result;
  }
}
