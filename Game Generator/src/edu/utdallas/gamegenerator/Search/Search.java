package edu.utdallas.gamegenerator.Search;

/* Boundary Class-
 * 
 * 1) Initializes SearchComponents - LinkedList of criteria that can be searched.
 * 2) Initializes SearchInput - Creates a LinkedList of desired criteria.
 * 3) Initializes SearchAlgo - Uses SearchComponents List and SearchInput List for SearchAlgo
 * 4) Returns the Search Results as an array. 
 * 
 * 
 * */
public class Search {
	
	
	private SearchInput searchInput;
	private SearchAlgo searchAlgo;
	private String[] allFiles = new String[6];
	

	public Search(){
		
		
		searchInput = new SearchInput();
		searchAlgo = new SearchAlgo(searchInput.getSearchCriteria(), searchInput.getInputList());
		allFiles=searchAlgo.searchResults();
		
	}

	public String[] getAllFiles(){
		
		return allFiles;
	}

}
