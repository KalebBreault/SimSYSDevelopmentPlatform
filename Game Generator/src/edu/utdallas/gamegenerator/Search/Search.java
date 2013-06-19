package edu.utdallas.gamegenerator.Search;

public class Search {
	private String xmlCharacters;
	private String xmlLessons;
	private String xmlChallenges;
	private String xmlLocale;
	private String xmlSubject;
	private String xmlTheme;
	private String[] allFiles = new String[6];
	
	public Search(){
		
		SearchComponents searchcomponents = new SearchComponents();
		SearchInput searchinput = new SearchInput(searchcomponents);
		SearchAlgo searchalgo = new SearchAlgo(searchinput.getSearchCriteria(), searchcomponents);
		allFiles=searchalgo.searchResults();
		
		xmlCharacters="Characters.xml";
		xmlLessons="Lesson.xml";
		xmlChallenges="Challenge.xml";
		xmlLocale="Locale.xml";
		xmlSubject="Subject.xml";
		xmlTheme="Theme.xml";
		
	}

	public String[] getAllFiles(){
		allFiles[0]=xmlCharacters;
		allFiles[1]=xmlLessons;
		allFiles[2]=xmlChallenges;
		allFiles[3]=xmlLocale;
		allFiles[4]=xmlSubject;
		allFiles[5]=xmlTheme;
		
		return allFiles;
	}

}
