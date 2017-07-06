package cinema_ticket_system;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;

public class Transaction 
{
	private static final char POUND_SYMBOL = '\u00A3';
	private static int ticketId = 1;
	private int transactionId;
	private Date dateOfTransaction;
	private int totalPrice = 0;
	private HashMap<Integer, Ticket> ticketsPurchased = new HashMap<Integer, Ticket>();
	
	public Transaction(int transactionId)
	{
		setTransactionId(transactionId);
		dateOfTransaction = new Date();
	}
	
	public void initialise()
	{
		gatherTickets();
		sumTicketCosts();
		printTransactionTotal();
	}
	
	private void gatherTickets()
	{
		int amount;
		for (String currentTicketType : TicketFactory.getTicketTypes())
		{
			amount = -1;
			promptTicketType(currentTicketType);
			amount = retrieveTicketAmount();
			for (int i = 0; i < amount; ++i)
			{
				ticketsPurchased.put(ticketId++, TicketFactory.getTicket(currentTicketType));
			}
		}
	}

	private void sumTicketCosts()
	{
		for (Ticket ticket : ticketsPurchased.values())
		{
			setTotalPrice(totalPrice + ticket.getTicketPrice());
		}
	}
	
	private void printTransactionTotal()
	{
		System.out.print("\nThis transaction costs a total of " + POUND_SYMBOL + totalPrice + ".\n\n");
	}

	private void promptTicketType(String ticketType)
	{
		System.out.print("Please enter how many " + ticketType + " tickets you would like: ");
	}

	private int retrieveTicketAmount()
	{
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(inStream);
		String buffer = new String();
		int amount = -1;
		boolean validChoiceMade = false;
		while (!validChoiceMade)
		{
			try
			{
				buffer = stdin.readLine();
				amount = Integer.parseInt(buffer);
				if (!isAmountValid(amount))
				{
					throw new Exception();
				}
				validChoiceMade = true;
			}
			catch (Exception e)
			{
				amount = -1;
				System.out.print("Invalid amount of tickets specified, please type a number: ");
			}
		}
		return amount;
	}
	
	private boolean isAmountValid(int amount)
	{
		return (amount > -1 && amount <= Integer.MAX_VALUE);
	}
	
	private void setTransactionId(int transactionId)
	{
		this.transactionId = transactionId;
	}
	
	public int getTransactionId()
	{
		return transactionId;
	}

	public Date getDateOfTransaction()
	{
		return dateOfTransaction;
	}
	
	public void setTotalPrice(int totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	
	public int getTotalPrice()
	{
		return this.totalPrice;
	}
}
