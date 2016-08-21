// File: TimeServer.java
package main.ch08;
import javax.naming.InitialContext;
import javax.naming.Context;

public class TimeServer {
  public static void main(String[] args) {
    try {
      TimeImpl time = new TimeImpl();
      Context initialNamingContext = new InitialContext();
      initialNamingContext.rebind("TimeService", time );
      System.out.println("Time Server is ready...");
    }
    catch (Exception e) {
      System.out.println("Trouble contacting TimeService: " + e);
    }
  }
}
