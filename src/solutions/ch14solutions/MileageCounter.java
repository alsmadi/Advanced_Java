package solutions.ch14solutions;

// File: MileageCounter.java

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MileageCounter {
  public static void main(String args[]) {
    if (args.length != 1) {
      System.out.println("Usage: java MileageCounter garage.xml");
      System.exit(1);
    }

    SAXParserFactory factory = SAXParserFactory.newInstance();

    try {
      SAXParser parser = factory.newSAXParser();
      MileageHandler handler = new MileageHandler();
      parser.parse(new File(args[0]), handler);
      System.out.println("The number of cars with less than 20,000 " +
        "miles is " + handler.getCount());
    }
    catch (Exception e) {
      System.err.println ("ERROR " + e);
    }
  }
}

class MileageHandler extends DefaultHandler {
  private int counter = 0;

  public void startElement(String namespaceURI, String localName,
      String qName, Attributes atts) throws SAXException  {

    if (qName.equals("car") || qName.equals("van")) {
      String miles = atts.getValue("miles");
      if ( Integer.parseInt(miles) < 20000) {
        counter ++;
      }
    }
  }
  public int getCount() {
    return counter;
  }
}





