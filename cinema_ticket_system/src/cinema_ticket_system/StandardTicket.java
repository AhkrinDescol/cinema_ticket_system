package cinema_ticket_system;

public class StandardTicket extends Ticket 
{
	private static final int STANDARD_TICKET_PRICE = 8;
	
	public StandardTicket()
	{
		super(STANDARD_TICKET_PRICE);
	}
}
