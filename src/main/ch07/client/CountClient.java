// File: CountClient.java
package client;

import java.rmi.Naming;
import server.CounterFactory;
import server.Counter;

public class CountClient {
  public static void main(String args[]) {
    try {
      CounterFactory factory =
        (CounterFactory) Naming.lookup("///CountFactory");
      Counter counter = factory.getCounter();

      for (int i = 0; i < 10; i++) {
        System.out.println("Count: " + counter.getCount());
      }
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
}
