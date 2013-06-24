import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This program takes in a list of names, stores them
 * and gives you a pair of random names, until the list
 * is exhausted. 
 * @author Perry Ogwuche
 * @date 6/24/13
 *
 */

public class Mixer {

	public static void main(String[] args) {

		String name = "";


		ArrayList<String> names = new ArrayList<String>();

		Scanner userInput = new Scanner(System.in);

		while(!(name.equalsIgnoreCase("q")))
		{
			System.out.print("Enter a name or 'q' when you are done: ");
			name = userInput.next();

			names.add(name);

			if(name.equals("q"))
			{	
				System.out.println("\n"+"Thank you for entering the names");
				names.remove(names.size()-1);
			}	
		}
		
		Random randomNumGenerator = new Random();
		
//		for(int i = 0; i<10; i++)
//		{
//			System.out.println(randomNumGenerator.nextInt(10));
//		}
		
			System.out.println(names.get(randomNumGenerator.nextInt(9)) + " , " +  names.get(randomNumGenerator.nextInt(9)) );
			System.out.println(names.get(randomNumGenerator.nextInt(9)) + " , " +  names.get(randomNumGenerator.nextInt(9)) );
			System.out.println(names.get(randomNumGenerator.nextInt(9)) + " , " +  names.get(randomNumGenerator.nextInt(9)) );
			System.out.println(names.get(randomNumGenerator.nextInt(9)) + " , " +  names.get(randomNumGenerator.nextInt(9)) );
			System.out.println(names.get(randomNumGenerator.nextInt(9)) + " , " +  names.get(randomNumGenerator.nextInt(9)) );
			System.out.println(names.get(randomNumGenerator.nextInt(9)) + " , " +  names.get(randomNumGenerator.nextInt(9)) );
			System.out.println(names.get(randomNumGenerator.nextInt(9)) + " , " +  names.get(randomNumGenerator.nextInt(9)) );
			System.out.println(names.get(randomNumGenerator.nextInt(9)) + " , " +  names.get(randomNumGenerator.nextInt(9)) );
			
		//	System.out.println("\n" +"The array now contains:" + "\n" + names);	
	}
}