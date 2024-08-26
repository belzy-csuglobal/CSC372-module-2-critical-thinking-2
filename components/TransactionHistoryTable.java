
package components;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TransactionHistoryTable extends JTable {
  String[] columns = { "Date", "Amount", "Balance" };
  DefaultTableModel tableModel = null;

  public TransactionHistoryTable() {
    this.setFillsViewportHeight(true);
  }

  /**
   * Add a new row to the table.
   */
  public void addRow(TransactionRow transactionRow) {
    // Create a new row data array based on the new transaction data.
    Object[] row = {
      transactionRow.date,
      transactionRow.amount,
      transactionRow.balance
    };

    if (this.tableModel == null) {
      // Initialize the table and the table model if one does not
      // exist and add the new row.
      Object[][] rows = { row };
      this.tableModel = new DefaultTableModel(rows, this.columns);
      this.setModel(this.tableModel);
    } else {
      // If table model exists, insert the new row.
      this.tableModel.insertRow(0, row);
    }
  }
}