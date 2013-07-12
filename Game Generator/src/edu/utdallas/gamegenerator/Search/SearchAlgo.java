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

	public SearchAlgo()//LinkedList<String> CriteriaList, LinkedList<String>inputedCriteriaList)
	{

		xmlCharacters="Characters0";
		xmlLessons="Lesson0";
		xmlChallenges="Challenge0";
		xmlLocale="Locale0";
		xmlSubject="Subject0";
		xmlTheme="Theme0";
		String[] gameComponents = {"Characters", "Lesson", "Challenge", "Locale", "Subject", "Theme"};
		///////////////////////////
		System.out.println("Test1, Start of SearchAlgo");
		for(int x=0; x<gameComponents.length; x++)
		{
			SearchSpace search= new SearchSpace(gameComponents[x]); }/*
			//searchSpace which should be from the metadata tags
			Matrix componentInput = new Matrix(search.getSearchSpace());
			//changes the SearchSpace array into a Matrix object
			SearchInput input = new SearchInput(gameComponents[x]); 
			//The input from the user 
			Matrix searchInput = new Matrix(input.getInput());
			printMatrix(searchInput);
			//brings the input into this class
			EigenvalueDecomposition eigenDecomp= searchInput.eig();
			//creates new object that contains the eigenvector
			Matrix weightedMatrix = eigenDecomp.getV();
			//makes the eigenvector matrix of the input
			System.out.println("weightedMatrix");
			printMatrix(weightedMatrix);
			System.out.println("componentInput");
			printMatrix(componentInput);
			Matrix criteriaScore = componentInput.times(getFirstColumn(weightedMatrix));
//			Matrix criteriaScore = weightedMatrix.times(componentInput);
			//multiplies the weighted score matrix by the input matrix. 
			allFiles[x]=gameComponents[x]+getLargestValue(criteriaScore);
			System.out.println(allFiles[x]);
			printMatrix(criteriaScore);
		}// end of loop with x 
*/
		//Get rid of this when SearchInput is working. 
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
		double largestValue=inputArray[0][0];
		int largestIndex=0;
		for(int x = 0; x<inputArray.length; x++)
		{	
			if(inputArray[x][0]<largestValue)
			{
				largestValue = inputArray[x][0];
				largestIndex = x;
			}
		}//end of looop with x
		return largestIndex;
	}
	public Matrix getFirstColumn(Matrix inputMatrix)
	{
		double[][] inputArray = inputMatrix.getArray();
		double[][] outputArray = new double[inputArray[0].length][1];
		for(int x =0; x<inputArray[0].length;x++ )
		{
			outputArray[x][0]=inputArray[x][0];
		}
		return new Matrix(outputArray);
	}
	public void printMatrix(Matrix  inputMatrix)
	{
		double[][] inputArray = inputMatrix.getArray();
		for(int x=0; x < inputArray.length; x++)
		{
			for (int y =0; y <  inputArray[x].length; y++)
			{
				System.out.print(inputArray[x][y]+" ");
			}
			System.out.println("");
		}
	}
	// Getter Methods
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
