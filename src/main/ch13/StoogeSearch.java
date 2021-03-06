// File: StoogeSearch.java

import javax.naming.Context;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.SearchResult;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import java.util.Hashtable;

public class StoogeSearch {
  public static void main(String args[]) {
    Hashtable<String, String> env = new Hashtable<String, String>();
    env.put(Context.INITIAL_CONTEXT_FACTORY,
        "com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL,
        "ldap://ldap.yo-linux.com/o=stooges");
    try {
      InitialDirContext ctx = new InitialDirContext(env);

      BasicAttributes searchParms = new BasicAttributes();
      searchParms.put(new BasicAttribute("sn", "Howard"));

      NamingEnumeration<SearchResult> results =
          ctx.search("ou=MemberGroupA", searchParms);
      while (results.hasMore()) {
        StringBuilder buf = new StringBuilder();
        SearchResult aResult = results.next();
        buf.append(aResult.getName()).append('\n');

        NamingEnumeration<? extends Attribute> attrs =
              aResult.getAttributes().getAll();
        while (attrs.hasMore()) {
          buf.append("   ").append(attrs.next()).append('\n');
        }

        System.out.println(buf.toString());
      }
    }
    catch (NamingException ne) {
      System.err.println(ne);
    }
  }
}
