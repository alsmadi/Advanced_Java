package solutions.ch08solutions;

// File: Stock.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Stock extends Remote {
  public float getQuote(String ticker) throws RemoteException;
  public void registerForStockEvents(String ticker, StockListener n)
    throws RemoteException;
}
