// File: AttendantServer.java

import solutions.ch07solutions.Attendant;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AttendantServer extends UnicastRemoteObject
    implements Attendant {
  private DateFormat tf;
  private StoreServer store;

  public AttendantServer(StoreServer store) throws RemoteException {
    this.store = store;
    tf = DateFormat.getTimeInstance();
    tf.setTimeZone(TimeZone.getDefault());
  }

  public int submitOrder(String itemCode, int quantity) {
    int orderNum = StoreServer.getOrderNumber();
    System.out.println("Order #" + orderNum + " for item code: " +
      itemCode + " quantity: " + quantity + " received at " +
      tf.format(new Date()));
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
