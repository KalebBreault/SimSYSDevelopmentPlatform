package edu.utdallas.gamegenerator.Search;

import java.util.LinkedList;
/*Control Class
*/
public class SearchAlgo {
	private String xmlCharacters;
	private String xmlLessons;
	private String xmlChallenges;
	private String xmlLocale;
	private String xmlSubject;
	private String xmlTheme;
	private String[] allFiles = new String[6];

	public SearchAlgo(LinkedList<String> CriteriaList, LinkedList<String>inputedCriteriaList){
		
		xmlCharacters="Characters.xml";
		xmlLessons="Lesson.xml";
		xmlChallenges="Challenge.xml";
		xmlLocale="Locale.xml";
		xmlSubject="Subject.xml";
		xmlTheme="Theme.xml";
		
		allFiles[0]=xmlCharacters;
		allFiles[1]=xmlLessons;
		allFiles[2]=xmlChallenges;
		allFiles[3]=xmlLocale;
		allFiles[4]=xmlSubject;
		allFiles[5]=xmlTheme;
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
