package edu.utdallas.gamegenerator.Search;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchInput {
	private LinkedList<String> inputList;
	private String[] inputListArray;

	public SearchInput(SearchComponents searchcomponents){
		String userInput="null";
		Scanner input= new Scanner(System.in);
		inputList= new LinkedList<String>();
		
		while(!userInput.equals("done")){
			System.out.println("What are your search preferences?(type 'done' when finished.)");
			userInput=input.nextLine();
			
	
			if(searchcomponents.componentValidate(userInput)){
				inputList.add(userInput);
			} else if(userInput.equals("done")) {
				System.out.println("Searching...");		
			} else {
				System.out.println("Unable to find that Criteria, please try again.");
			}
		}

		
	}
	
	public LinkedList<String> getSearchCriteria(){
		return inputList;
	}
	
	
}
