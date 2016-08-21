package solutions.ch13solutions;

// File: NSLookup2.java

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class NSLookup2 {
  public static void main(String[] arg) {
    String host = "";
    String[] rrtypes = new String[] {"A"};

    if (arg.length > 0) {
      host = arg[0];
      if (arg.length > 1) {
        rrtypes = new String[arg.length - 1];
        for (int i = 1; i < arg.length; i++) {
          rrtypes[i - 1] = arg[i];
        }
      }
    }
    else {
      System.out.println("Usage: java NSLookup2 hostname RRtype(s)");
      System.exit(1);
    }

    Hashtable<String, String> env = new Hashtable<String, String>();
    env.put(Context.INITIAL_CONTEXT_FACTORY,
            "com.sun.jndi.dns.DnsContextFactory");
    env.put(Context.PROVIDER_URL, "dns://128.107.241.185/");

    try {
      DirContext ctxt = new InitialDirContext(env);
      Attributes att = ctxt.getAttributes(host, rrtypes);

      NamingEnumeration attlist = att.getAll();
      while (attlist.hasMore()) {
        Attribute a = (Attribute)attlist.next();
        // Normally we would iterate through attribure values.
        // Attribute.toString() gives nice enough output.
        System.out.println(a);
      }
    }
    catch (NamingException ne) {
      System.out.println(ne);
    }

  }
}
