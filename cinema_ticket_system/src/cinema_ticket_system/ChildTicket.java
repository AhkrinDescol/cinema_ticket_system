package cinema_ticket_system;

public class ChildTicket extends Ticket 
{
	private static final int CHILD_TICKET_COST = 4;
	
	public ChildTicket()
	{
		super(CHILD_TICKET_COST);
	}
}
