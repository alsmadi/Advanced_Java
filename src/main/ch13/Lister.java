// File: Lister.java

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.util.Hashtable;

public class Lister {
  public static void main(String args[]) {
    String name = "";
    if (args.length > 0) {
      name = args[0];
    }

    Hashtable<String, String> env = new Hashtable<String, String>();
    env.put(Context.INITIAL_CONTEXT_FACTORY,
        "com.sun.jndi.rmi.registry.RegistryContextFactory");
    env.put(Context.PROVIDER_URL, "rmi:///");
    try {
      InitialContext ctx = new InitialContext(env);

      NamingEnumeration<NameClassPair> list = ctx.list(name);
      while (list.hasMore()) {
        NameClassPair ncp = list.next();
        System.out.println(ncp.getName());
      }
    }
    catch (NamingException ne) {
      System.err.println(ne);
    }
  }
}
