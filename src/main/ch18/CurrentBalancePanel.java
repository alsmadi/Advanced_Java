// File: CurrentBalancePanel.java

import solutions.ch18solutions.BankAccount;
import solutions.ch18solutions.Subject;
import solutions.ch18solutions.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CurrentBalancePanel extends JPanel implements Observer {
  private Subject subject;
  private JLabel balanceLabel;

  public CurrentBalancePanel(Subject subject) {
    this.subject = subject;
    balanceLabel = new JLabel();
    this.add(new JLabel("Current Balance: "));
    this.add(balanceLabel);
    subject.addObserver(this);
  }

  public void update() {
    double currentBalance = ((BankAccount)subject).getBalance();
    balanceLabel.setText("" + currentBalance);
  }
}