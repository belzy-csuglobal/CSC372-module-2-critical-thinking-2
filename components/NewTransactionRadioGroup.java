
package components;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewTransactionRadioGroup extends JPanel implements ActionListener {
  JRadioButton depositRadio = new JRadioButton();
  JRadioButton withdrawRadio = new JRadioButton();
  String depositRadioText = "Deposit";
  String withdrawRadioText = "Withdraw"; 
  ButtonGroup radioGroup = new ButtonGroup();
  Transaction value = Transaction.DEPOSIT;
  ButtonListener listener;

  public NewTransactionRadioGroup() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.depositRadio.setSelected(true);

    this.depositRadio.setText(this.depositRadioText);
    this.withdrawRadio.setText(this.withdrawRadioText);

    this.radioGroup.add(depositRadio);
    this.radioGroup.add(withdrawRadio);

    this.add(depositRadio);
    this.add(Box.createVerticalStrut(3));
    this.add(withdrawRadio);
    this.depositRadio.addActionListener(this);
    this.withdrawRadio.addActionListener(this);
  }

  /**
   * Get the value of the currently selected radio button.
   */
  public Transaction getValue() {
    return this.value;
  }

  /**
   * Action event listener for the radio buttons. Sets the value 
   * to the value of the selected radio button.
   */
  public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();

    if (source == this.depositRadio) {
      this.value = Transaction.DEPOSIT;
    }

    if (source == this.withdrawRadio) {
      this.value = Transaction.WITHDRAW;
    }
  }
}