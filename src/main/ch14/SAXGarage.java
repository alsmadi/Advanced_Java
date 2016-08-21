// File: SAXGarage.java

import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;

public class SAXGarage {
  public static void main(String args[]) {
    if (args.length != 1) {
      System.out.println("Usage: java SAXGarage garage.xml");
      System.exit(1);
    }
    SAXParserFactory factory = SAXParserFactory.newInstance();

    try {
      SAXParser parser = factory.newSAXParser();
      DefaultHandler handler = new SAXHandler();
      parser.parse(new File(args[0]), handler);
    }
    catch (Exception e) {
      System.err.println ("ERROR " + e);
    }
  }
}
