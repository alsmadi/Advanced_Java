// File: StockClient.java

import solutions.ch08solutions.Stock;
import solutions.ch08solutions.StockListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StockClient extends UnicastRemoteObject
    implements StockListener {
  private String[] stocks = {"OATS", "MSFT", "AUO"};

  public StockClient() throws RemoteException {
    try {
      Stock s = (Stock) Naming.lookup("//localhost:1099/stock");
      for (int i = 0; i < stocks.length; i++) {
        s.registerForStockEvents(stocks[i], this);
        System.out.println(stocks[i] + "=" + s.getQuote(stocks[i]));
      }
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }

  public void stockEvent(String ticker, float value) {
    System.out.println();
    System.out.println(ticker + " has changed value to " + value);
  }
  public static void main(String[] args) throws Exception {
    new StockClient();
  }
}
