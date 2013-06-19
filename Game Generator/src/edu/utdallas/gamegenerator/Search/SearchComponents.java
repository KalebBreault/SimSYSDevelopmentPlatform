package edu.utdallas.gamegenerator.Search;

import java.util.LinkedList;

public class SearchComponents {
	private String Criteria_1="Criteria_1";
	private String Criteria_2="Criteria_2";
	private String Criteria_3="Criteria_3";
	private String Criteria_4="Criteria_4";
	private String Criteria_5="Criteria_5";
	private String Criteria_6="Criteria_6";
	private LinkedList<String> SearchComponentsList;
	
	public SearchComponents(){
		SearchComponentsList= new LinkedList<String>();
		SearchComponentsList.add(Criteria_1);
		SearchComponentsList.add(Criteria_2);
		SearchComponentsList.add(Criteria_3);
		SearchComponentsList.add(Criteria_4);
		SearchComponentsList.add(Criteria_5);
		SearchComponentsList.add(Criteria_6);
	}
	public Boolean componentValidate(String component){
		return SearchComponentsList.contains(component);
	}

}
