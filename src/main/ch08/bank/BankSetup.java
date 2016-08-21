// File: BankSetup.java
package bank;

import java.io.File;
import java.rmi.MarshalledObject;
import java.rmi.Naming;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationGroup;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.util.Properties;

public class BankSetup {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.err.println(
        "usage: java -Djava.rmi.server.codebase=codebase_url" +
        "BankSetup activation_group_policy_file");
      System.exit(1);
    }

    String policy = args[0];
    Properties props = new Properties();
    props.put("java.security.policy", policy);

    ActivationGroupDesc group = new ActivationGroupDesc(props, null);

    ActivationGroupID groupId =
      ActivationGroup.getSystem().registerGroup(group);

    System.out.println("registered group: security policy: "+ policy);

    // copy the activation group's codebase from the system property
    String codebase = System.getProperty("java.rmi.server.codebase");

    File accountFile = new File("bank/accounts.tab").getCanonicalFile();
    MarshalledObject mo = new MarshalledObject(accountFile);

    ActivationDesc desc = new ActivationDesc (
	  groupId, "bank.BankAccountImpl", codebase, mo);

    // Register the interface with the activation system (rmid)
    BankAccount stub = (BankAccount) Activatable.register(desc);
    System.out.println("Got stub for the BankAccount");

    // Bind it in the registry (rmiregistry)
    Naming.rebind("BankAccountImpl", stub);
    System.out.println("Bound stub to \"BankAccountImpl\"");
  }
}
