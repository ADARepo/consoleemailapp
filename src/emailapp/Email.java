package emailapp;
import java.util.Random;
import java.util.Scanner;

public class Email 
{
	private String firstName; // First name on the e-mail account.
	private String lastName; // Last name on the e-mail account.
	private String company; // Company name.
	private String department; // Department for the company.
	private int mailboxCap; // Capacity for the e-mails. Static for a global cap.
	private int currMailCount; // The number of e-mails in the inbox.
	private String password; // Unsecure storage for an e-mail password. Not initialized in constructor.
	private String emailAddress;
	private String altEmailAddress; // alternate email address.
	
	// Constructor for an email. Only accepting first name and last name. Asks for other details.
	public Email (String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDepartment();
		setCompany();
	}
	
	// Return the e-mail.
	public String getEmail()
	{
		return emailAddress;
	}
	
	// Sets the company instead of returning it. Normally this would be uniform with how department is set.
	private void setCompany()
	{
		System.out.println("Enter the company name: ");
		Scanner in = new Scanner(System.in);
		
		in.close();
		this.company = in.nextLine();
	}
	
	private String setDepartment()
	{
		System.out.print("Enter the corresponding department number:\n1. Sales\n2. Development\n3. N/A\nInput: ");
		Scanner in = new Scanner(System.in);
		
		while (true)
		{
			try
			{
				int dpNum = in.nextInt();
				
				if (dpNum == 1) return "sales";
				else if (dpNum == 2) return "development";
				else if (dpNum == 3) return "";
				else 
				{
					System.out.println("Incorrect entry for department.");
					System.out.print("Enter the corresponding department number:\n1. Sales\n2. Development\n3. N/A\nInput: ");
					continue;
				}
				
			} catch (Exception ime)
			{
				System.out.println("Incorrect entry for department.");
				System.out.print("Enter the corresponding department number:\n1. Sales\n2. Development\n3. N/A\nInput: ");
			}
		}
		
	}
	
	// Get the name for the account.
	public String getFullName()
	{
		return "First name: " + firstName + "\n" + "Last name: " + lastName;
	}
	
	// Showing the email capacity.
	public String getCapacity()
	{
		return "Mailbox capacity: " + mailboxCap;
	}
	
	public void setPassword()
	{
		// Random 10 character password containing numbers and letters only.
		// 97 - 122: lowercase alphabet, 65 - 90: uppercase alphabet, 48 - 57: numbers.
		Random r = new Random();
		String pw = "";
		
		// generates a pseudo-random lowercase or uppercase letter in g1 and g2 respectively, and number in g3.
		// then another pseudo-random pick from one of the 3 groups.
		int g1, g2, g3, group;
		
		for (int i = 0; i < 10; i++)
		{
			g1 = r.nextInt(97, 123);
			g2 = r.nextInt(65, 91);
			g3 = (r.nextInt(48, 58));
			group = (r.nextInt() % 3);
			
			if (group == 1) pw += (char) g1;
			else if (group == 2) pw += (char) g2;
			else pw += (char) g3;
		}
		
		password = pw;
	}
	
	// New capacity for this email.
	public void setCapacity(int newCap)
	{
		mailboxCap = newCap;
	}
	
	// department and company remain the same.
	public void setAltEmail(String newEmailPrefix)
	{
		// Sets alternate email but with same suffix as company for now.
		if (department == "")
		{
			altEmailAddress = newEmailPrefix + "@" + company + ".com";
		}
		else
		{
			altEmailAddress = newEmailPrefix + "@" + department + "." + company + ".com";
		}
	}
	
	// Sets main email.
	private void setEmail()
	{
		// Sets alternate email but with same suffix as company for now.
		if (department == "")
		{
			emailAddress = firstName + "." + lastName + "@" + company + ".com";
		}
		else
		{
			emailAddress = firstName + "." + lastName + "@" + department + "." + company + ".com";
		}
	}
}
