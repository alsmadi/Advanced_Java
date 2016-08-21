Here are the instructions for building and running the activatable 
BankAccount object example.  The specified directories may be 
different on your system depending on your setup.

A. First, run the services in two separate command windows:

  1. Change to the root directory or your home directory.

  2. Run rmiregistry in one command window:
      rmiregistry

  3. Run rmid in the other command window - make sure you specify the 
     proper path to the rmid.policy file:
      rmid -J-Djava.security.policy=c:/advj2se/ch08/bank/rmid.policy

B. Now build the classes:

  1. Change to the chapter directory.

  2. Compile the source files: 
      javac bank/*.java

  3. (optional) compile the stub class:
      rmic bank.BankAccountImpl

C. Now run the server and the client:

  1. Change to the chapter directory.

  2. Run the BankSetup program to register the activatable object - 
     make sure the paths for the activation group policy file and 
     the codebase (don't forget the trailing slash) are set properly 
     for your environment:
       java -Djava.rmi.server.codebase=file:///C:/advj2se/ch08/ bank.BankSetup C:/advj2se/ch08/bank/group.policy

  3. Run the client to connect to the BankAccount object:
       java -Djava.security.policy=bank/bankclient.policy bank.BankClient

