// File: TellerGUI.java

import solutions.ch18solutions.CurrentBalancePanel;
import solutions.ch18solutions.StatusPanel;
import solutions.ch18solutions.BankAccount;
import solutions.ch18solutions.Subject;
import solutions.ch18solutions.ModifyBalancePanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TellerGUI extends JFrame {
  private JPanel currentBalancePanel;
  private JPanel modifyBalancePanel;
  private JPanel statusPanel;

  public TellerGUI() {
    this.setTitle("Teller");
    BankAccount account = new BankAccount(0);
    initializePanels(account);

    this.setLayout(new BorderLayout(10, 10));
    this.add(modifyBalancePanel, BorderLayout.CENTER);
    this.add(currentBalancePanel, BorderLayout.NORTH);
    this.add(statusPanel, BorderLayout.SOUTH);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
    // trigger first notify
    account.setBalance(0);
  }
  private void initializePanels(Subject subject) {
    currentBalancePanel = new CurrentBalancePanel(subject);
    modifyBalancePanel = new ModifyBalancePanel(subject);
    statusPanel = new StatusPanel(subject);
  }
  public static void main(String[] args) {
    new TellerGUI();
  }
}