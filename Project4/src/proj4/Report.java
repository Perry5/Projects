package proj4;
/**
 * @author Perry Ogwuche
 * @version April 16th 2011
 */
public class Report extends Document {
	
	// Instance variables for the Report class.
	private String title;
	
	
	
	/**@Name: Report
	 * @Description:  Constructor for the report class, this constructor gets the input given by the user and
	 * 			   uses them to create a report document. It calls the super class'constructor which 
	 * 			   handles the input string gotten from the user as the author's name. It then initializes
	 * 			   its instance variables
	 * @param email
	 * @param memo
	 * @param report
	 */
	public Report(String author, String title, String textBody, int ID)
	{
		super(author,textBody, ID);
	
		this.title = title;
		
	}

	/**
	 * Name: getTitle
	 * Description: Gets the tile for the report class
	 * postcondition: Returns the title
	 */
	public String getTitle()
	{
		return title;
	}

	
	/**
	 * Name: toString
	 * Description: This method invokes the super's toSting method and that already prints the document number
	 * 				date, and author. It then adds the title and the text body. So when a user creates
	 * 				a new report document and views it, the order will be unique.
	 * postcondition: Returns the string representation of the user's input. 
	 */
	public String toString()
	{
		return super.toString() +  "\nTitle: " + title;
	}
}
