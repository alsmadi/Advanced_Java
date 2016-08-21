// File: BankAccount.java

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankAccount implements Subject {
  private double balance;
  private List<Observer> listOfObservers;

  public BankAccount(double initialBalance) {
    balance = initialBalance;
    listOfObservers = new ArrayList<Observer>();
  }

  public void addObserver(Observer observer) {
    listOfObservers.add(observer);
  }
  public void removeObserver(Observer observer) {
    if (listOfObservers.contains(observer)) {
      listOfObservers.remove(observer);
    }
  }
  public void notifyObservers() {
    Iterator<Observer> it = listOfObservers.iterator();
    while (it.hasNext()) {
      Observer observer = it.next();
      observer.update();
    }
  }
  public double getBalance() {
    return balance;
  }
  public void setBalance(double b) {
    balance = b;
    notifyObservers();
  }
}