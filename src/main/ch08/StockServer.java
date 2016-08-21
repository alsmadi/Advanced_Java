// File: StockServer.java

import solutions.ch08solutions.Stock;
import solutions.ch08solutions.StockListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StockServer extends UnicastRemoteObject implements Stock {
  Map<String, Set<StockListener>> clients;
  Map<String, Float> stocks = null;

  public StockServer() throws RemoteException {
    clients = new HashMap<String, Set<StockListener>>();
    stocks = new HashMap<String, Float>();
    stocks.put("ORCL", new Float(12.55));
    stocks.put("OATS", new Float(11.20));
    stocks.put("FLEX", new Float(14.12));
    stocks.put("MSFT", new Float(25.66));
    stocks.put("AUO", new Float(17.23));
    stocks.put("EBAY", new Float(99.55));
  }
  public float getQuote(String ticker) throws RemoteException {
    if (stocks.containsKey(ticker)) {
      Float f = stocks.get(ticker);
      return f.floatValue();
    }
    else {
      return -1.0F;
    }
  }
  public void setQuote(String ticker, float value) throws Exception {
    System.out.println("Setting " + ticker + " to " + value);
    stocks.put(ticker, new Float(value));
    if (clients.containsKey(ticker)) {
      Set<StockListener> c = clients.get(ticker);
      Iterator<StockListener> it = c.iterator();
      while (it.hasNext()) {
        StockListener n = it.next();
        n.stockEvent(ticker, value);
      }
    }
  }
  public void registerForStockEvents(String ticker, StockListener n) {
    Set<StockListener> notifList = null;
    if (clients.containsKey(ticker)) {
      notifList = clients.get(ticker);
      notifList.add(n);
    } 
    else {
      notifList = new HashSet<StockListener>();
      notifList.add(n);
      clients.put(ticker,notifList);
    }
  }
  public static void main(String[] args) {
    try {
      StockServer s = new StockServer();
      Naming.rebind("//localhost:1099/stock", s);
      System.out.println("StockServer bound to registry.");
      for (int i = 0; i < 100; i++ ) {
        Thread.sleep(1000);
        s.setQuote("MSFT", s.getQuote("MSFT") * 1.03f);
        s.setQuote("OATS", s.getQuote("OATS") * 1.05f);
        s.setQuote("EBAY", s.getQuote("EBAY") * 1.08f);
      }
      Naming.unbind("//localhost:1099/stock");
      System.out.println("StockServer unbound from registry.");
      System.exit(0);
    }
    catch(Exception e) {
      System.err.println(e);
    }
  }
}
