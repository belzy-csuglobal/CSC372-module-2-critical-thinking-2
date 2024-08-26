
package components;

import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Random;

public class App extends JFrame implements ButtonListener {
    int frameWidth = 360;
    int frameHeight = 500;
    int frameX = (1920 / 2) - (this.frameWidth / 2);
    int frameY = 1080 - (this.frameHeight / 2);
    double balance = 0.00d;

    GridBagConstraints constraints = new GridBagConstraints();
    JPanel outerPanel = new JPanel();
    JPanel innerPanel = new JPanel();
    JPanel headingPanel = new JPanel();
    JLabel headingLabel = new JLabel("", SwingConstants.LEFT);
    String headingLabelText = 
      "<html><h1 style=\" margin: 0; font-size: 14px;\">My Account</h1></html>";

    BalanceSection balanceSection;
    NewTransactionSection newTransactionSection;
    TransactionHistorySection transactionHistorySection;

  public App() {
    super("Bank Balance App");

    this.balanceSection = new BalanceSection("Checking Account", this.balance);
    this.newTransactionSection = new NewTransactionSection(this);
    this.transactionHistorySection = new TransactionHistorySection();

    this.outerPanel.setLayout(new GridBagLayout());
    this.innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
    this.headingLabel.setText(this.headingLabelText);
    this.headingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    this.headingPanel.add(this.headingLabel);

    // Set the initial constraints for the GridBoxLayout.
    this.constraints.anchor = GridBagConstraints.PAGE_START;
    this.constraints.fill = GridBagConstraints.HORIZONTAL;
    this.constraints.gridx = 0;
    this.constraints.gridy = 0;
    this.constraints.weightx = 1;
    this.constraints.weighty = 1;
    this.constraints.insets = new Insets(8, 16, 8, 16);

    this.outerPanel.add(innerPanel, constraints);
    this.innerPanel.add(this.headingPanel);
    this.innerPanel.add(balanceSection);
    this.innerPanel.add(Box.createVerticalStrut(10));
    this.innerPanel.add(newTransactionSection);
    this.innerPanel.add(Box.createVerticalStrut(20));
    this.innerPanel.add(transactionHistorySection);

    this.setResizable(false);
    this.add(this.outerPanel);
    this.setSize(this.frameWidth, this.frameHeight);
    this.setLocation(this.frameX, this.frameY);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.seedTransactions();
  }

  public void onSubmit(double amount) {
    Transaction type = this.newTransactionSection.getRadioValue();

    if (type == Transaction.DEPOSIT) {
      this.balance += amount;
    }

    if (type == Transaction.WITHDRAW) {
      this.balance -= amount;
    }

    this.balanceSection.setBalanceText(this.balance);
    this.transactionHistorySection.addTransaction(type, amount, this.balance);
  }

  private void seedTransactions() {
    Random random = new Random();
    int totalTransactions = 15;
    double [] depositAmounts = new double[totalTransactions];
    double [] withdrawalAmounts = new double[totalTransactions];

    for (int i = 0; i < totalTransactions; i++) {
      depositAmounts[i] = random.nextDouble(2500) + 500;
      withdrawalAmounts[i] = random.nextDouble(1000);
    }

    for (double amount : depositAmounts) {
      this.balance += amount;
      this.balanceSection.setBalanceText(this.balance);
      this.transactionHistorySection.addTransaction(Transaction.DEPOSIT, amount, this.balance);
    }

    for (double amount : withdrawalAmounts) {
      this.balance -= amount;
      this.balanceSection.setBalanceText(this.balance);
      this.transactionHistorySection.addTransaction(Transaction.WITHDRAW, amount, this.balance);
    }
  }
}