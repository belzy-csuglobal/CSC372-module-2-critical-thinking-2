
package components;

/**
 * A model to represents the data of a new transaction.
 */
public class TransactionRow {
  String date;
  String amount;
  String balance;

  TransactionRow(String date, String amount, String balance) {
    this.date = date;
    this.amount = amount;
    this.balance = balance;
  }
}