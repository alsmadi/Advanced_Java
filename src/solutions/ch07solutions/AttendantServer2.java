package solutions.ch07solutions;

// File: AttendantServer2.java

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class AttendantServer2 extends UnicastRemoteObject
    implements Attendant2 {
  private DateFormat tf;
  private StoreServer2 store;

  public AttendantServer2(StoreServer2 store) throws RemoteException {
    this.store = store;
    tf = DateFormat.getTimeInstance();
    tf.setTimeZone(TimeZone.getDefault());
  }

  public int submitOrder(Order order) {
    int orderNum = StoreServer2.getOrderNumber();

    System.out.println("Order #" + orderNum + " received at " +
      tf.format(new Date()));

    HashMap<String, Integer> items = order.getItems();
    for (Map.Entry<String, Integer> item : items.entrySet() ) {
      System.out.println("  Item: " + item.getKey() +
        " quantity: " + item.getValue());
    }

    return orderNum;
  }
  public boolean release() {
    boolean success = false;
    try {
      success = UnicastRemoteObject.unexportObject(this, false);
    }
    catch (NoSuchObjectException e) {
      System.err.println(e);
    }
    return success;
  }
}
