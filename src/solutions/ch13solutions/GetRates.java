package solutions.ch13solutions;

// File: GetRates.java

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Hashtable;

public class GetRates {
  public static void main(String[] args) {
    Hashtable<String, String> env = new Hashtable<String, String>();
    env.put(Context.INITIAL_CONTEXT_FACTORY,
        "com.sun.jndi.rmi.registry.RegistryContextFactory");
    env.put(Context.PROVIDER_URL, "rmi:///");

    try {
      InitialContext ctx = new InitialContext(env);
      RateInfo rates = (RateInfo) ctx.lookup("RateInfo");
      System.out.println(rates.getInfo());
    }
    catch (RemoteException re) {
      System.err.println(re);
    }
    catch (NamingException ne) {
      System.err.println(ne);
    }
  }
}
