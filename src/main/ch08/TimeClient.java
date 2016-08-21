// File: TimeClient.java
package main.ch08;
import solutions.ch09solutions.Time;
import javax.rmi.PortableRemoteObject;
import javax.naming.InitialContext;
import javax.naming.Context;

public class TimeClient {
  public static void main(String args[]) {
    try {
      Context ctx = new InitialContext();
      Object objref = ctx.lookup("TimeService");
      Time time =
        (Time) PortableRemoteObject.narrow(objref, Time.class);
      System.out.println(time.getTime());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}
