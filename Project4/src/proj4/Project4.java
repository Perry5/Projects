package proj4;
/**
 * @author Perry Ogwuche
 * @version April 16th 2011
 * Class Invariants: 1. ID number passed in must be integers and not string.
 *
 * This project desings and implements a document storage system. This system stores
 * internal reports and correspondence, such as memos and emails. All relevant document information
 * will be input by the user. Documents are initially stored in an "active" document list. Upon
 * request, a document may be moved from the active list to the document "archive". 
 * An archive is a place where documents that are no longer used, or “active,” are stored, as 
 * opposed to disposing of them. Sort of like a recycle bin. Your system should also allow a 
 * user to reactivate a document by moving it back from the document archive to the active list.
 *
 * When a document is initially stored, the author and the date/time created are recorded. A unique 
 * document identification number is assigned to the document starting with 10001. The document 
 * number (its ID) is incremented for each subsequent document stored. Your document storage system must be able to store an unlimited number of documents.

 * In addition to author, date/time, and document ID, which are common to all documents, company reports include a title. 
 * Your system must also store memos, which are a kind of correspondence. Memos include the name of the person to whom the 
 * memo is being sent, a list of people who will receive a copy of the memo (the distribution list), and the subject of the 
 * memo. Email must be stored in your document storage system as well. Emails are electronic correspondence that include the 
 * email's subject, the name of the person to whom it is being sent, along with his/her email address.	  
 * 
 * This project really helps in understanding:
 * 1. Implemetaing clssesin an inheritance hierarchy
 * 2. Implementing polomorphism
 * 3. using one of the List classes
 * 
 * PLEASE REACH OUT TO ME IF YOU HAVE ANY QUESTIONS.
 */
import java.util.Scanner;
public class Project4 {
	
	// Scanner object used to getting user input
	static Scanner input = new Scanner(System.in);
	
	// Creating a new DSS object
	static DocumentStorageSystem dss = new DocumentStorageSystem();
	/**
	 * @Name: mainMenu
	 * @Description: Displays the main menu to the user, and allows user to make choice of specific
	 * 				 operation using an integer input to select choice 
	 * @Precondition:
	 * @Postcondition:
	 */
	public static void displayMainMenu()
	{
		System.out.println("");
		System.out.println("\tDocument Storage System Menu");
		System.out.println("1 - Create and store an e-mail");
		System.out.println("2 - Create and store a memo");
		System.out.println("3 - Create and store a report");
		System.out.println("4 - Display a document");
		System.out.println("5 - List all active documents");
		System.out.println("6 - List all archived documents");
		System.out.println("7 - Locate documents containing a specific word or phrase");
		System.out.println("8 - Archive a document");
		System.out.println("9 - Retrieve a document from the archive");
		System.out.println("10 - Clear the archive");
		System.out.println("99 - Quit");
		System.out.println("");
		System.out.println("Enter your choice: ");
	}


	/**
	 * 
	 * Name: createAuthor
	 * Description: Get the name of the author as an input from the using a scanner object
	 * precondition: takes in the name of the user as a string input 
	 * postcondition: Returns the name inputed by the user.
	 */
	public  String createAuthor()

	{
		System.out.println("Enter author: ");
		String  author = input.nextLine();

		return author;
	}


	/**
	 * 
	 * Name: createTextBody
	 * Description: This method allows the user to type the text body of the document being created.
	 * 				It uses a scanner object, and it exits when the user types "end"(case insensitive)
	 * 				on a separate line.
	 * 				
	 * precondition: Takes in the uses input as a sting with a scanner object
	 * postcondition: Returns the string inputed by the user as the text body of the document
	 */
	public String createTextBody()
	{
		System.out.println("Enter textBody (type END on a seperate line to stop): ");
		String textBody = "";
		String textLine = "";

		while(textLine.equalsIgnoreCase("End") == false )
		{
			textLine = input.nextLine();

			textBody += textLine + "\n";
		}
		return "\n" + textBody.substring(0, textBody.length()-4);
	}


	/**
	 * 
	 * Name: distributionList
	 * Description: This method allows the user to type the distribution list of the memo being created.
	 * 				It uses a scanner object, and it exits when the user types "end"(case insensitive)
	 * 				on a separate line.
	 * 				
	 * precondition:  Takes in the uses input as a sting with a scanner object
	 * postcondition: Returns the string inputed by the user as the distribution list of the memo.
	 */

	public String distributionList()
	{
		System.out.println("Enter Distribution List (type END on a seperate line to stop): ");

		String distributionList = "";
		String textLine = "";

		while(textLine.equalsIgnoreCase("End") == false )
		{
			textLine = input.nextLine();

			distributionList += textLine + "\n";

		}
		return "\n" + distributionList.substring(0, distributionList.length()-4);

	}

	/**
	 * 
	 * Name: newEmailDocument
	 * Description: This method calls certain method in order to get some input from the user, it also
	 * 				uses the scanner object in order to get some input from the user, and create a new
	 * 				email document
	 * precondition:
	 * postcondition:
	 */
	public void   newEmailDocument()
	{
		// Calling the createAuthor method in order to get the user's input of the author's name. 
		String emailAuthor = createAuthor();

		// Getting the subject from the user as a string input 
		System.out.println("Enter subject: ");
		String emailSubject = input.nextLine();

		// Getting the recipient from the user as string input
		System.out.println("Enter reciepient: ");
		String emailRecipient =  input.nextLine();

		// Getting the email from the user as a string input
		System.out.println("Enter recipient's e-mail address: ");
		String email = input.nextLine();

		// Calling the textBody method, in order to get the text body from the user.
		String emailTextBody = createTextBody();

		// Passing in all the input given by the user to the Email constructor.
		Email e = new Email(emailAuthor, emailTextBody, emailSubject, emailRecipient, email, 0);
		
		// Using the DSS object to add an email document 
		dss.addDocument(e);
		System.out.println("Email #" + e.getID() + " entered into the active documents list.");
	}


	/**
	 * Name: newMemoDocument
	 * Description: This method calls certain method in order to get some input from the user, it also
	 * 				uses the scanner object in order to get some input from the user, and create a new
	 * 				memo document
	 * precondition:
	 * postcondition:
	 */
	public void newMemoDocument()
	{
		// Calling the createAuthor method in order to get the user's input of the author's name.
		String memoAuthor = createAuthor();


		// Getting the subject from the user as a string input 
		System.out.println("Enter subject: ");
		String memoSubject = input.nextLine();


		// Getting the recipient from the user as string input
		System.out.println("Enter reciepient: ");
		String memoRecipient =  input.nextLine();


		// Calling the distribution list method, that takes in the list of people the user wants to 
		// send copies to. 
		String distributionList = distributionList();


		// Calling the textBody method, in order to get the text body from the user.
		String memoTextBody = createTextBody();
		
		
		Memo m = new Memo(memoAuthor, memoSubject, memoRecipient, distributionList, memoTextBody, 0);

		// Using the new DSS object to add a memo to the DSS.
		dss.addDocument(m);
		System.out.println("Memo #" + m.getID() + " entered into the active documents list.");


	}
	/**
	 * Name: newReportDocument
	 * Description: This method calls certain method in order to get some input from the user, it also
	 * 				uses the scanner object in order to get some input from the user, and create a new
	 * 				report document
	 * precondition:
	 * postcondition:
	 */
	public void newReportDocument()
	{
		// Getting input from the user as the author of the document. 
		String reportAuthor = createAuthor();

		// Getting input from the user as the title of the report.
		System.out.println("Enter title: ");
		String reportTitle = input.nextLine();

		// Getting the text body input from the user. Calling the createTextBody method
		String reportTextBody = createTextBody();

		Report r = new Report(reportAuthor, reportTitle, reportTextBody, 0);

		// Using the DSS object to add a report document to the DSS
		dss.addDocument(r);
		System.out.println("Report #" + r.getID() + " entered into the active documents list.");


	}


	/**
	 * 
	 * @Name: Main menu.
	 * @Description: Controls the main functions of the program.
	 * @Precondition:
	 * @Postcondition:
	 */
	public static void main(String[] args){
		displayMainMenu();

		// creating a new project4 object, to call the various methods on.
		Project4 proj4 = new Project4();

		String choice = "";
		while(choice.equalsIgnoreCase("99")== false)
		{
			choice = input.next();
			input.nextLine();

			if(choice.equalsIgnoreCase("1"))
			{
				// Using the proj4 object to create a new email document
				proj4.newEmailDocument();
				
				// Displaying the main menu after a new email document has been created and stored.
				displayMainMenu();

			}else if(choice.equalsIgnoreCase("2"))
			{
				
				// Using the proj4 object to create a new memo document  
				proj4.newMemoDocument();
		
				// Displaying the main menu after a new memo document has been created and stored.
				displayMainMenu();


			}else if(choice.equalsIgnoreCase("3"))
			{
				// Using the proj4 object to create a new report document
				proj4.newReportDocument();
			
				// Displaying the main menu after a new report document has been created and stored. 
				displayMainMenu();


			}else if(choice.equalsIgnoreCase("4"))
			{
				// Getting the ID number of document to be displayed from the user, and passing it into the
				// displayDocument method into the DocumentStorageSystem class.
				System.out.println("Enter ID number: ");
				int ID = input.nextInt();
				dss.displayDocument(ID);
				
				// Displaying the main menu after the view menu operation is over. 
				displayMainMenu();
				
			}else if(choice.equalsIgnoreCase("5"))
			{
				// Using the dss object to display all the active documents in the Document storage system
				dss.displayAllActiveDocument();

				// Displaying the main menu after the display active documents operation is over. 
				displayMainMenu();
			
			}else if(choice.equalsIgnoreCase("6"))
			{
				// Using the dss object to display all the archived documents in the Document Storage System
				dss.displayAllArchivedDocuments();
				
				// Displaying the main menu after the display archived documents operation is over
				displayMainMenu();
				
				
			}else if(choice.equalsIgnoreCase("7"))
			{
				// Getting the user input for the word or phrase to locate in the active document list.
				System.out.println("Get search phrase: ");
				String phrase = input.nextLine();
				dss.locatePhrase(phrase);
				
				// Displaying the main menu after the locatePhrase operation is over
				displayMainMenu();
				
			}else if(choice.equalsIgnoreCase("8"))
			{
				// Getting the ID number of the document to be archived from the user and passing it into the
				// archiveDocument method is the document storage system.
				System.out.println("Enter the Document ID: ");
				int ID = input.nextInt();
				dss.archiveDocument(ID);
				
				// Displaying the main menu after the archive document operation is over.
				displayMainMenu();
				
			}else if(choice.equalsIgnoreCase("9"))
			{
				// Getting the ID number of the document to be retrieved from the archived list from the user
				// and passing it into the retrieveArchive method in the document storage system. 
				System.out.println("Enter the Document ID");
				int ID = input.nextInt();
				dss.retrieveArchive(ID);
				
				// Displaying the main menu after the retrieveArchive operation is over,	
				displayMainMenu();
				
			}else if(choice.equalsIgnoreCase("10"))
			{	
				// Calling the clearArchive method using the dss object. 
				dss.clearArchive();
				
				// Displaying the main menu after the clearArchive operation is over.
				displayMainMenu();
				
			}else if(choice.equalsIgnoreCase("99"))
			{
				System.out.println("Thank you for using the document storage system. The program has exit.");
				System.exit(-1);
			}else
			{
				System.out.println("That is an invalid option, please select from the list of options.");
			}
		}
	}
}