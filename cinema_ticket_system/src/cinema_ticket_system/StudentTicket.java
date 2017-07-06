package cinema_ticket_system;

public class StudentTicket extends Ticket 
{
	private static final int STUDENT_TICKET_PRICE = 6;
	
	public StudentTicket()
	{
		super(STUDENT_TICKET_PRICE);
	}
}
