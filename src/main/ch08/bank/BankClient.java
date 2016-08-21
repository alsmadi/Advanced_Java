// File: BankClient.java
package bank;

import java.rmi.Naming;

public class BankClient {
  public static void main(String args[]) {
    System.setSecurityManager(new SecurityManager());
    try {
      String loc = "rmi://localhost/BankAccountImpl";
      BankAccount bank = (BankAccount)Naming.lookup(loc);
      double result = bank.getBalance("156");
      System.out.println("Balance: " + result);
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
}

