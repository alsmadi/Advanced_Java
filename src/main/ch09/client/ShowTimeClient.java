// File:  ShowTimeClient.java

import solutions.ch09solutions.Time;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;

public class ShowTimeClient {
  public static void main(String args[]) {
    new ShowTimeClient();
  }

  public ShowTimeClient() {
    Time t;
    try {
      t = (Time) Naming.lookup("///Time");
      System.out.println("The time is: " + t.getSystemTime());
    }
    catch (NotBoundException e) {
      System.err.println(e);
    }
    catch (MalformedURLException e) {
      System.err.println(e);
    }
    catch (UnknownHostException e) {
      System.err.println(e);
    }
    catch (RemoteException e) {
      System.err.println(e);
    }
  }
}
