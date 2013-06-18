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
		SearchGUI searchgui = new SearchGUI();
		
		xmlCharacters="Characters.xml";
		xmlLessons="Lesson.xml";
		xmlChallenges="Challenge.xml";
		xmlLocale="Locale.xml";
		xmlSubject="Subject.xml";
		xmlTheme="Theme.xml";
		
	}
	
	private String searchAlgo(){
		return null;
	}
	
	private void findCharacters(){
		xmlCharacters=this.searchAlgo();
	}
	private void findLesson(){
		xmlLessons=this.searchAlgo();
	}
	private void findChallenges(){
		xmlChallenges=this.searchAlgo();
	}
	private void findLocale(){
		xmlLocale=this.searchAlgo();
	}
	private void findSubject(){
		xmlSubject=this.searchAlgo();
	}
	private void findTheme(){
		xmlTheme=this.searchAlgo();
	}
	public void findGroupXML(){
		
	}
	public void findAllXML(){
		this.findCharacters();
		this.findLesson();
		this.findChallenges();
		this.findLocale();
		this.findSubject();
		this.findTheme();
		
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
