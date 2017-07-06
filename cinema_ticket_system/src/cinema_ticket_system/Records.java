package cinema_ticket_system;

import java.util.HashMap;

// Singleton.
public class Records 
{
	private static final char POUND_SYMBOL = '\u00A3';

	private static Records records;
	
	private static int transactionId = 1;
	private HashMap<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();
	
	private Records() {}
	
	public static Records getInstance()
	{
		if (null == records)
		{
			records = new Records();
		}
		return records;
	}
	
	public void initialiseNewTransaction()
	{
		Transaction newTransaction = new Transaction(transactionId);
		newTransaction.initialise();
		transactions.put(transactionId, newTransaction); 
		++transactionId;
	}
	
	public void printAllRecordedTransactions()
	{
		for (Transaction transaction : transactions.values())
		{
			printSingleTransaction(transaction);
		}
	}
	
	public void printSingleTransaction(Transaction transaction)
	{
		System.out.print
		(
			"\n" +
			"Transaction ID: " + transaction.getTransactionId() + "\n" +
			"Transaction Date: " + transaction.getDateOfTransaction() + "\n" +
			"Total Cost: " + POUND_SYMBOL + transaction.getTotalPrice() + "\n" +
			"\n"
		);
	}
}
