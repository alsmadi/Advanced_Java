// File: DOMGarage.java

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMGarage {
  public static void main(String args[]) {
    if (args.length!=1) {
      System.out.println ("Usage: java DOMGarage garage.xml");
      System.exit(1);
    }

    DocumentBuilderFactory factory =
      DocumentBuilderFactory.newInstance();

    try {
      DocumentBuilder builder = factory.newDocumentBuilder( );
      Document document = builder.parse( new File(args[0]) );
      System.out.println("Vehicles In My Garage\n");
      searchForVehicles(document);
      System.out.println("Garage Door Closed");
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
  public static void searchForVehicles(Document doc) {
    NodeList list = doc.getElementsByTagName("car");
    processVehicleList(list);
    list = doc.getElementsByTagName("van");
    processVehicleList(list);
  }
  public static void processVehicleList(NodeList autoList) {
    for (int i = 0; i < autoList.getLength(); i++) {
      Node auto = autoList.item(i);
      NodeList autoFeatures = auto.getChildNodes();

      for (int j = 0; j < autoFeatures.getLength(); j++) {
        Node featureNode = autoFeatures.item(j);

        if (featureNode.getNodeType() == Node.ELEMENT_NODE) {
          Element feature = (Element) featureNode;
          String name = feature.getNodeName();

          if (name.equals("make") || name.equals("model"))
            System.out.println (name + " : " +
              feature.getFirstChild().getNodeValue());
        }
      }
      System.out.println();
    }
  }
}