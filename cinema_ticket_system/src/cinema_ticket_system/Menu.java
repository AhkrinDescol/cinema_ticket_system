package cinema_ticket_system;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Singleton.
public class Menu
{
	private static final int NUMBER_OF_CHOICES_AVAILABLE = 3;
	private static final int START_NEW_TRANSACTION = 1, PRINT_ALL_RECORDED_TRANSACTIONS = 2,
			QUIT = NUMBER_OF_CHOICES_AVAILABLE;

	private static Menu menu;
	private Records records;
	
	private Menu()
	{
		records = Records.getInstance();
	}
	
	public static Menu getInstance()
	{
		if (null == menu)
		{
			menu = new Menu();
		}
		return menu;
	}
	
	public void displayUserInterface()
	{
		boolean keepMenuActive = true;
		int choice;
		displayWelcomeText();
		while (keepMenuActive)
		{
			choice = -1;
			promptUserAction();
			choice = retrieveUserChoice();
			keepMenuActive = performSelectedAction(choice);
		}
	}
	
	private void displayWelcomeText()
	{
		System.out.println("Welcome to the QA Cinemas ticket booking system!");
	}
	
	private void promptUserAction()
	{
		System.out.print
		(
			"Actions available:\n" +
			"1) Start a new transaction.\n" +
			"2) Print all recorded transactions.\n" +
			"3) Quit.\n" +
			"Please type the number of the action you would like to take, and then press <Return>: "
		);
	}
	
	private int retrieveUserChoice()
	{
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(inStream);
		String buffer = new String();
		int choice = -1;
		boolean validChoiceMade = false;
		while (!validChoiceMade)
		{
			try
			{
				buffer = stdin.readLine();
				choice = Integer.parseInt(buffer);
				if (!isValidChoice(choice))
				{
					throw new Exception();
				};
				validChoiceMade = true;
			}
			catch (Exception e)
			{
				choice = -1;
				System.out.print("Invalid choice, please type the number corresponding with the choice " +
					"you would like to make: ");
			}
		}
		return choice;
	}
	
	private boolean isValidChoice(int choice)
	{
		return (choice > 0 && choice < NUMBER_OF_CHOICES_AVAILABLE + 1);
	}
	
	private boolean performSelectedAction(int choice)
	{
		boolean permitSucceedingAction = true;
		switch (choice)
		{
		case START_NEW_TRANSACTION:
			records.initialiseNewTransaction();
			break;
		case PRINT_ALL_RECORDED_TRANSACTIONS:
			records.printAllRecordedTransactions();
			break;
		case QUIT:
			permitSucceedingAction = false;
			break;
		}
		return permitSucceedingAction;
	}
}
