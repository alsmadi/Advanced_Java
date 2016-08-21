package solutions.ch18solutions;

// File: StatusPanel.java

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel implements Observer {
  private Subject subject;
  private JLabel okBalanceLabel;
  private JLabel lowBalanceLabel;
  private JLabel negBalanceLabel;

  public StatusPanel(Subject subject) {
    this.subject = subject;

    okBalanceLabel = new JLabel();
    okBalanceLabel.setFont(new Font("DIALOG", Font.BOLD, 18));
    okBalanceLabel.setText("OK");
    lowBalanceLabel = new JLabel();
    lowBalanceLabel.setFont(new Font("DIALOG", Font.BOLD, 18));
    lowBalanceLabel.setText("LOW");
    negBalanceLabel = new JLabel();
    negBalanceLabel.setFont(new Font("DIALOG", Font.BOLD, 18));
    negBalanceLabel.setText("NEG");

    this.setBackground(Color.BLACK);
    this.add(okBalanceLabel);
    this.add(lowBalanceLabel);
    this.add(negBalanceLabel);
    subject.addObserver(this);
  }

  public void update() {
    double currentBalance = ((BankAccount)subject).getBalance();

    if (currentBalance < 0) {
      okBalanceLabel.setForeground(Color.GREEN.darker());
      lowBalanceLabel.setForeground(Color.YELLOW.darker());
      negBalanceLabel.setForeground(Color.RED);
    }
    else if (currentBalance < 100) {
      okBalanceLabel.setForeground(Color.GREEN.darker());
      lowBalanceLabel.setForeground(Color.YELLOW);
      negBalanceLabel.setForeground(Color.RED.darker());
    }
    else {
      okBalanceLabel.setForeground(Color.GREEN);
      lowBalanceLabel.setForeground(Color.YELLOW.darker());
      negBalanceLabel.setForeground(Color.RED.darker());
    }
  }
}