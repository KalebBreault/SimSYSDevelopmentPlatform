package edu.utdallas.gamegenerator.Search;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

//Control Class- Prompts the user for the search criteria input.
//Validates the input by calling the SearchComponents class.
public class SearchInput {
	private LinkedList<String> inputList;
	private SearchCriteriaList criteriaList;
	private double[][] searchInputMatrix;  
	int numberOfChoices;
	int numberOfCriteria;
	
	public SearchInput(){
		criteriaList = new SearchCriteriaList();
		
		String userInput="null";
//		Scanner input= new Scanner(System.in);
//		inputList= new LinkedList<String>();
//		
//		while(!userInput.equals("done")){
//			System.out.println("What are your search preferences?(type 'done' when finished.)");
//			userInput=input.nextLine();
//				
//			if(criteriaList.componentValidate(userInput)){			
//				inputList.add(userInput);
//			} else if(userInput.equals("done")) {
//				System.out.println("Searching...");		
//			} else {
//				System.out.println("Unable to find that Criteria, please try again.");
//			}
//		}
//		input.close();
//	
		
		receiveInput();
		assembleInput();
	}
	//get input from user
	public void receiveInput()
	{
		//TODO
		try {
			//BufferedReader input = new BufferedReader(new FileReader(type+".txt"));
			Scanner input = new Scanner(new FileReader("input"));
			numberOfChoices= input.nextInt();
			numberOfCriteria = numberOfChoices;
			searchInputMatrix = new double[numberOfChoices][numberOfCriteria];
			int choiceCounter=0;
	/**
	 * do not uncomment the print statements without commenting out the input.next() statements 
	 * that immediately follow them. (one needs to be commented out at all times.)
	 */
//			System.out.println("#"+input.next()); //list type name
			input.next(); //ignore type name
<<<<<<< HEAD
//			System.out.println("#"+input.nextLine()+input.nextLine());
			input.nextLine(); 
=======
>>>>>>> 43bdde482c48996a5b7fe99a5a1ac553adc73af8
			input.nextLine();
			while (input.hasNextLine()) {
//				System.out.println("#"+input.next()); //list choice name
				input.next(); //ignore choice name
				for(int i=0; i<numberOfCriteria; i++)
					{
//					System.out.println("#"+input.next()); //list criteria name
					input.next(); //ignore criteria name
					searchInputMatrix[choiceCounter][i]=input.nextDouble();
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
	//assemble input from user into square matrix
	public void assembleInput()
	{
		//TODO
	}
	//return input from square matrix
	public double[][] getInput()
	{
		return searchInputMatrix;
	}
	public LinkedList<String> getSearchCriteria(){
		return criteriaList.getCriteriaList();
	}
	public LinkedList<String> getInputList(){
		return inputList;
	}
	
	
}
