package solutions.ch07solutions;

// File: Customer1.java

import java.rmi.Naming;

public class Customer1 {
  public static void main(String[] args) {
    try {
      Store store = (Store) Naming.lookup("///Store");
      Attendant attendant = store.getAttendant();
      int orderNumber = attendant.submitOrder("hdw123", 5);
      System.out.println("The order number is: " + orderNumber);
      attendant.release();
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
}
