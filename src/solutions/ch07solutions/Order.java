package solutions.ch07solutions;

// File: Order.java

import java.util.HashMap;

public class Order implements java.io.Serializable {
  private HashMap<String, Integer> orderItems;

  public Order() {
    orderItems = new HashMap<String, Integer>();
  }

  public void add(String itemCode, int quantity) {
    orderItems.put(itemCode, new Integer(quantity));
  }
  public HashMap<String, Integer> getItems() {
    return orderItems;
  }
}
