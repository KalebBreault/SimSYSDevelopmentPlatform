package edu.utdallas.gamegenerator.Search;
import java.io.FileReader;
import java.util.Scanner;
//Entity Class- reads in the search space from a file
public class SearchSpace {
	/**
	 * @param String type : type of game component search. 
	 */
	int[][] searchSpace;
	int numberOfChoices;
	int numberOfCriteria;
	public SearchSpace(String type){
		
		try {
			//BufferedReader input = new BufferedReader(new FileReader(type+".txt"));
			Scanner input = new Scanner(new FileReader(type+".txt"));
			numberOfChoices= input.nextInt();
			numberOfCriteria = input.nextInt();
			searchSpace = new int[numberOfChoices][numberOfCriteria];
			int choiceCounter=0;
	/**
	 * do not uncomment the print statements without commenting out the input.next() statements 
	 * that immediately follow them. (one needs to be commented out at all times.)
	 */
			//System.out.println("@@@@"+input.next()); //list type name
			input.next(); //ignore type name
			while (input.hasNextLine()) {
				//System.out.println("@@@@"+input.next()); //list choice name
				input.next(); //ignore choice name
				for(int i=0; i<numberOfCriteria; i++)
					{
				//	System.out.println("@@@@"+input.next()); //list criteria name
					input.next(); //ignore criteria name
					searchSpace[choiceCounter][i]=input.nextInt();
					}
				choiceCounter++;
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public int[][] getSearchSpace()
	{
		return searchSpace;
	}
}

