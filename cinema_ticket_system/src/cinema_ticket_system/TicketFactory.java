package cinema_ticket_system;

import java.util.LinkedHashSet;
import java.util.Arrays;

// Uninstantiable.
public final class TicketFactory
{
	private TicketFactory() {}
	private static final LinkedHashSet<String> TICKET_TYPES =
		new LinkedHashSet<String>(Arrays.asList
				(
					"Standard",
					"OAP",
					"Student",
					"Child"
				)
		);
	
	public static Ticket getTicket(String ticketType)
	{
		if (null == ticketType) { return null; }
		
		if (ticketType.equals("Standard"))
		{
			return new StandardTicket();
		}
		else if (ticketType.equals("OAP"))
		{
			return new OAPTicket();
		}
		else if (ticketType.equals("Student"))
		{
			return new StudentTicket();
		}
		else
		{
			return new ChildTicket();
		}
	}
	
	public static LinkedHashSet<String> getTicketTypes()
	{
		return TICKET_TYPES;
	}
	
}
