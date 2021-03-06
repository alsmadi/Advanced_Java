package solutions.ch07solutions;

// File: StoreServer2.java

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class StoreServer2 extends UnicastRemoteObject
    implements Store2 {
  private HashMap<String, Item> items;
  private static int nextOrder=1;

  public StoreServer2() throws RemoteException {
    items = new HashMap<String, Item>();
    items.put("hdw123", new ItemImpl("hdw123", "1 GB SIM", 50));
    items.put("hdw124", new ItemImpl("hdw124", "60 GB HD", 30));
    items.put("hdw125", new ItemImpl("hdw125", "80 GB HD", 25));
    items.put("per456", new ItemImpl("per456", "InkJet Printer", 36));
    items.put("per457", new ItemImpl("per457", "Laser Printer", 4));
  }
  public Attendant2 getAttendant() throws RemoteException {
    return new AttendantServer2(this);
  }
  public Set<String> getCodes() {
    return items.keySet();
  }
  public Collection<Item> getItems() {
    return items.values();
  }
  public Item getItem(String code) {
    return items.get(code);
  }
  public static synchronized int getOrderNumber() {
    return nextOrder++;
  }
  public static void main(String[] args) {
    try {
      StoreServer2 store = new StoreServer2();
      Naming.rebind("///Store2", store);
    }
    catch (java.net.MalformedURLException e) {
      System.err.println(e);
    }
    catch (RemoteException e) {
      System.err.println(e);
    }
  }
}
