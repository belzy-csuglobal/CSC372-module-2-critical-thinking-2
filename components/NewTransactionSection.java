
package components;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BorderFactory;

public class NewTransactionSection extends JPanel {
  NewTransactionRadioGroup radioGroup = new NewTransactionRadioGroup();
  JPanel amountInput = null;
  JPanel inputPanel = new JPanel();

  public NewTransactionSection(ButtonListener listener) {
    this.amountInput = new NewTransactionInput(listener);
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setBorder(BorderFactory.createTitledBorder("New Transaction"));

    this.inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
    this.inputPanel.add(Box.createHorizontalStrut(5));
    this.inputPanel.add(this.radioGroup);
    this.inputPanel.add(Box.createHorizontalGlue());
    this.inputPanel.add(Box.createHorizontalStrut(80));
    this.inputPanel.add(this.amountInput);
    this.inputPanel.add(Box.createHorizontalStrut(5));

    this.add(Box.createVerticalStrut(4));
    this.add(this.inputPanel);
    this.add(Box.createVerticalStrut(10));
  }

  /**
   * Get the value of the currently selected radio button. 
   */
  public Transaction getRadioValue() {
    return this.radioGroup.getValue();
  }
}