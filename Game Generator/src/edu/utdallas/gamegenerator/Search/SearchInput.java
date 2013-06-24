package edu.utdallas.gamegenerator.Search;

import java.util.LinkedList;
import java.util.Scanner;
//Control Class- Prompts the user for the search criteria input.
//Validates the input by calling the SearchComponents class.
public class SearchInput {
	private LinkedList<String> inputList;
	private SearchCriteriaList criteriaList;
	
	public SearchInput(){
		criteriaList = new SearchCriteriaList();
		
		String userInput="null";
		Scanner input= new Scanner(System.in);
		inputList= new LinkedList<String>();
		
		while(!userInput.equals("done")){
			System.out.println("What are your search preferences?(type 'done' when finished.)");
			userInput=input.nextLine();
				
			if(criteriaList.componentValidate(userInput)){			
				inputList.add(userInput);
			} else if(userInput.equals("done")) {
				System.out.println("Searching...");		
			} else {
				System.out.println("Unable to find that Criteria, please try again.");
			}
		}
		input.close();
	
	}
	
	public LinkedList<String> getSearchCriteria(){
		return criteriaList.getCriteriaList();
	}
	public LinkedList<String> getInputList(){
		return inputList;
	}
	
	
}
