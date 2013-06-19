package edu.utdallas.gamegenerator.Search;

import java.util.LinkedList;

public class SearchAlgo {
	private String xmlCharacters;
	private String xmlLessons;
	private String xmlChallenges;
	private String xmlLocale;
	private String xmlSubject;
	private String xmlTheme;
	private String[] allFiles = new String[6];

	public SearchAlgo(LinkedList<String> inputedCriteriaList, SearchComponents searchcomponents){
		
	}
	
	public String getCharacters(){
		return xmlCharacters;
	}
	public String getLessons(){
		return xmlLessons;
	}
	public String getChallenges(){
		return xmlChallenges;
	}
	public String getLocale(){
		return xmlLocale;
	}
	public String getSubject(){
		return xmlSubject;
	}
	public String getTheme(){
		return xmlTheme;
	}
	
	public String[] searchResults(){
		return allFiles;
	}
}
