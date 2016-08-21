package solutions.ch08solutions;

// File: ISBNSetup.java

import java.rmi.Naming;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationGroup;
import java.rmi.activation.ActivationGroupDesc;
import java.rmi.activation.ActivationGroupID;
import java.util.Properties;

public class ISBNSetup {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.err.println(
        "usage: java -Djava.rmi.server.codebase=codebase_url" +
        "ISBNSetup activation_group_policy_file");
      System.exit(1);
    }

    String policy = args[0];
    Properties props = new Properties();
    props.put("java.security.policy", policy);

    ActivationGroupDesc group = new ActivationGroupDesc(props, null);
    ActivationGroupID groupId =
      ActivationGroup.getSystem().registerGroup(group);

    // copy the activation group's codebase from the system property
    String codebase = System.getProperty("java.rmi.server.codebase");

    ActivationDesc desc =
      new ActivationDesc (groupId, "ISBN_Impl", codebase, null);

    // Register the interface with the activation system (rmid)
    ISBN_IF isbn = (ISBN_IF)Activatable.register(desc);
    System.out.println("Got stub for ISBN");

    // Bind it in the registry (rmiregistry)
    Naming.rebind("ISBNImpl", isbn);
    System.out.println("Exported ISBN_Impl");
  }
}
