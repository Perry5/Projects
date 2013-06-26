package proj4;
/**
 * @author Perry Ogwuche
 * @version April 16th 2011
 */
public class Memo extends Document {
	
	// Instance variables for the Memo class. 
	private String subject;
	private String recipient;
	private String distributionList;


	/**
	 * @Name: Memo
	 * @Description: Constructor for the memo class, this constructor gets the input given by the user and
	 * 			   uses them to create a memo document. It calls the super class'constructor which 
	 * 			   handles the input string gotten from the user as the author's name. It then initializes
	 * 			   its instance variables
	 * @param email
	 * @param memo
	 * @param report
	 */
	public Memo(String author,String subject, String recipient, String distributionList, String textBody, int ID)
	{
		super(author, textBody,ID);
		
		this.subject= subject;
		this.recipient = recipient;
		this.distributionList = distributionList;
	}
	
	
	/**
	 * @Name: getSubject
	 * @Description:  Gets the subject for the Memo class.
	 * @Postcondition: Returns the subject. 
	 */
	public String getSubject()
	{
		return subject;
	}
	
	
	/**
	 * @Name: getRecipient
	 * @Description: This method gets the recipient. 
	 * @Postcondition: Returns the recipient
	 */
	public String getRecipient()
	{
		return recipient;
	}
	
	
	/**
	 * @Name: getDistributionList
	 * @Description: This method gets the distribution list
	 * @Postcondition: Returns the distribution list.
	 */
	public String getDistributionList()
	{
		return  distributionList;
	}

	

	/**
	 * Name: toString
	 * Description: This method invokes the super's toSting method and that already prints the document number
	 * 				date, and author. It then adds the subject, recipient, distribution list and text body. So when a user creates
	 * 				a new memo document and views it, the order will be unique.
	 * postcondition: Returns the string representation of the user's input. 
	 */
	public String toString()
	{
		return super.toString() + "\nRecipient: " + recipient + "\nSubject: " + subject + "\nDistribution List: " + distributionList;

	}

	/**
	 * @Name: main
	 * @Description: This method handles the testing of all the public methods in the Memo class. 
	 * @Precondition:
	 * @Postcondition:
	 */
	public static void main(String[] args) {
		
		Project4 test = new Project4();
		test.newMemoDocument();

	}

}
