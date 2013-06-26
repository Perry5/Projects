package proj4;
/**
 * @author Perry Ogwuche
 * @version April 16th 2011
 * Class invariants: 
 * 1: 
 * 
 */
public class Email extends Document {

	// Instance variables for the Email class. 
	private String subject;
	private String recipient;
	private String email;
	

	/**
	 * Name: Email
	 * Description: Constructor for the email class, this constructor gets the input given by the user and
	 * 			   uses them to create a new email document. It calls the super class' constructor which 
	 * 			   handles the input string gotten from the user as the author's name. It then initializes
	 * 			   its instance variables. 
	 * @param author
	 * @param textBody
	 * @param subject
	 * @param recipient
	 * @param email
	 * @param ID
	 */
	public Email(String author,String textBody, String subject, String recipient, String email, int ID)
	{
		super(author, textBody, ID);


		this.recipient = recipient;
		this.subject = subject;
		this.email = email;
	}

	/**
	 * 
	 * Name: getSubject
	 * Description: This method gets the subject
	 * postcondition: Returns the subject
	 */
	public String getSubject()
	{
		return subject;
	}

	
	/**
	 * 
	 * Name: getRecipient  
	 * Description: The method gets the recipient.
	 * postcondition: Returns the recipient.
	 */
	public String getRecipient()
	{
		return recipient;
	}

	
	/**
	 * 
	 * Name: getEmail 
	 * Description: This method gets the email 
	 * postcondition: Returns the email
	 */
	public String getEmail()
	{
		return email;
	}

	

	/**
	 * 
	 * Name: toString
	 * Description: This method invokes the super's toSting method and that already prints the document number
	 * 				date, and author. It then adds the subject, recipient and email. So when a user creates
	 * 				a new email document and views it, the order will be unique.
	 * postcondition: Returns the string representation of the user's input. 
	 */
	public String toString()
	{
		return super.toString() + "\nRecipient: " + recipient + "\nSubject: " + subject  + "\nE-mail Address: " + email;

	}

	/**
	 * @Name: main
	 * @Description: This method handles the testing of all the public methods in the Email class. 
	 * @Precondition:
	 * @Postcondition:
	 */
	public static void main(String[] args) {

		Project4 test = new Project4();
		test.newEmailDocument();

	}

}
