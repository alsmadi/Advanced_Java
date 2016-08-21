package solutions.ch18solutions;

// File: ModifyBalancePanel.java

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModifyBalancePanel extends JPanel {
  private BankAccount bankAccount;
  private JButton addButton;
  private JButton subtractButton;
  private JTextField amountTextField;
  private JLabel amountLabel;

  public ModifyBalancePanel(Subject subject) {
    bankAccount = (BankAccount) subject;

    initializeComponents();

    GridLayout grid = new GridLayout(2, 2, 5, 5);
    this.setLayout(grid);
    this.add(amountLabel);
    this.add(amountTextField);
    this.add(addButton);
    this.add(subtractButton);
  }

  private void initializeComponents() {
    amountLabel = new JLabel("Amount: ");
    amountTextField = new JTextField("100.00");
    addButton = new JButton("Deposit");
    subtractButton = new JButton("Withdraw");

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        double amount = getAmount();
        double currentBalance = bankAccount.getBalance();
        bankAccount.setBalance(currentBalance + amount);
      }
    });

    subtractButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        double amount = getAmount();
        double currentBalance = bankAccount.getBalance();
        bankAccount.setBalance(currentBalance - amount);
      }
    });
  }

  private double getAmount() {
    String sAmount = amountTextField.getText();
    double amount = 0.0;
    try {
      amount = Double.parseDouble(sAmount);
    }
    catch (NumberFormatException e) {
      amountTextField.setText("0");
    }
    return amount;
  }
}