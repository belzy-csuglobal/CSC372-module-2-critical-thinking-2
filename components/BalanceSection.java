
package components;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Box;

public class BalanceSection extends JPanel {
  JLabel imageLabel = new JLabel("", SwingConstants.LEFT);
  JLabel balanceLabel = new JLabel("", SwingConstants.RIGHT);
  JLabel accountLabel = new JLabel("", SwingConstants.RIGHT);
  JPanel balancePanel = new JPanel();
  String balanceText = "";
  String accountText = "";
  
  public BalanceSection(String account, double balance) {
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    this.imageLabel.setIcon(new ImageIcon("./credit-card-icon.png"));

    this.balancePanel.add(this.balanceLabel);
    this.balancePanel.add(this.accountLabel);
    this.balancePanel.setLayout(new BoxLayout(this.balancePanel, BoxLayout.Y_AXIS));

    this.setBalanceText(balance);
    this.setAccountText(account);

    this.add(imageLabel);
    this.add(Box.createHorizontalGlue());
    this.add(balancePanel);
  }

  /**
   * Set the text value for the balance label. 
   */
  public void setBalanceText(double balance) {
    this.balanceText = String.format(
      "<html><h1 style=\"margin: 0 0 4px 0; font-size: 20px;\">$%,.2f</h1></html>", balance);
    this.balanceLabel.setText(this.balanceText);
  }

  /**
   * Set the text value for the account type label. 
   */
  public void setAccountText(String account) {
    this.accountText = String.format(
      "<html><h2 style=\"margin: 0; font-size: 9px;\">%s</h2></html>", account);
    this.accountLabel.setText(this.accountText);
  }
}