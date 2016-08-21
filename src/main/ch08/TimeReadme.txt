1. Compile all source files:
     javac Time*.java

2. Create IIOP stub and tie:
     rmic -iiop TimeImpl

3. In a separate command window, start a COSNaming server:
     tnameserv -ORBInitialPort 1050

4. In another command window, start the server. Make sure the port 
   matches the value used to start the COSNaming server:
     java -Djava.naming.factory.initial=com.sun.jndi.cosnaming.CNCtxFactory 
          -Djava.naming.provider.url=iiop://localhost:1050/ TimeServer

5. Run the client:
     java -Djava.naming.factory.initial=com.sun.jndi.cosnaming.CNCtxFactory 
          -Djava.naming.provider.url=iiop://localhost:1050/ TimeClient 

