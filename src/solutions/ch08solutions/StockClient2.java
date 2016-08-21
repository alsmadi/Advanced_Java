package solutions.ch08solutions;

// File: StockClient2.java

import java.rmi.RemoteException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class StockClient2 extends PortableRemoteObject
    implements StockListener {
  private String[] stocks = {"OATS", "MSFT", "AUO"};

  public StockClient2() throws RemoteException {
    try {
      Context context = new InitialContext();
      Object o = context.lookup("StockService");
      Stock s = (Stock) PortableRemoteObject.narrow(o, Stock.class);

      for (int i = 0; i < stocks.length; i++) {
        s.registerForStockEvents(stocks[i], this);
        System.out.println(stocks[i] + "=" + s.getQuote(stocks[i]));
      }
    }
    catch(Exception e) {
      System.err.println(e);
    }
  }

  public void stockEvent(String ticker, float value) {
    System.out.println();
    System.out.println(ticker + " has changed value to " + value);
  }
  public static void main(String[] args) throws Exception {
    new StockClient2();
  }
}
