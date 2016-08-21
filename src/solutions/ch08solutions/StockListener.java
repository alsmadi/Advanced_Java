package solutions.ch08solutions;

// File: StockListener.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockListener extends Remote {
  public void stockEvent(String ticker, float value)
    throws RemoteException;
}
