package edu.utdallas.gamegenerator.Search;

import java.util.LinkedList;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;
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
		String[] gameComponents = {"Characters", "Lesson", "Challange", "Locale", "Subect", "Theme"};
	/*	for(int x=0; x<gameComponents.length; x++)
		{
			SearchSpace search= new SearchSpace(gameComponents[x]); 
			//searchSpace which should be from the metadata tags
			Matrix componentInput = new Matrix(search.getSearchSpace());
			//changes the SearchSpace array into a Matrix object
			SearchInput input = new SearchInput(); 
			//The input from the user 
			Matrix searchInput = new Matrix(input.getInput());
			//brings the input into this class
			EigenvalueDecomposition eigenDecomp= searchInput.eig();
			//creates new object that contains the eigenvector
			Matrix weightedMatrix = eigenDecomp.getV();
			//makes the eigenvector matrix of the input
			Matrix criteriaScore = componentInput.times(weightedMatrix);
			//multiplies the weighted score matrix by the input matrix. 
			allFiles[x]=gameComponents[x]+getLargestValue(criteriaScore);
		}*/
		//Get rid of this vvvv when SearchInput is working. 
		allFiles[0]=xmlCharacters;
		allFiles[1]=xmlLessons;
		allFiles[2]=xmlChallenges;
		allFiles[3]=xmlLocale;
		allFiles[4]=xmlSubject;
		allFiles[5]=xmlTheme;
	}
	public int getLargestValue(Matrix in)
	{
		double[][] inputArray = in.getArray();
		double largestValue=0;
		int largestIndex=0;
		for(int x = 0; x<inputArray.length; x++)
		{	
			if(inputArray[x][0]>largestValue)
			{
				largestValue = inputArray[x][0];
				largestIndex = x;
			}
		}
		return largestIndex;
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
