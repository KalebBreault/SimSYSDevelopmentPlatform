package edu.utdallas.gamegenerator.Search;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

import edu.utdallas.gamegenerator.Characters.Characters;
//Entity Class- reads in the search space from a file
public class SearchSpace {
	/**
	 * @param String type : type of game component search. 
	 */
	double[][] searchSpace;
	int numberOfChoices;
	int numberOfCriteria;

	public SearchSpace(String type){
		//READ FROM XML FILES
		try {
			System.out.println("SearchSpace Start");
			//			jaxbContext = JAXBContext.newInstance();
			//		
			//	        file = new File("XMLmetadata\\"+type+".xml");
			//	        unmarshaller = jaxbContext.createUnmarshaller();

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document component = docBuilder.parse (new File("XMLmetadata//"+type+".xml"));


			// normalize text representation
			component.getDocumentElement ().normalize ();
			System.out.println ("Root element of the file is \"" + 
								component.getDocumentElement().getNodeName() +"\" with type: "+type);
			NodeList listOfComponents = component.getElementsByTagName(type);
			int totalComponents= listOfComponents.getLength();
			System.out.println("Total num of "+type+" : " + totalComponents );   
			System.out.println("StartRowCalc$$");
			NodeList listOfMetadata = component.getElementsByTagName("SearchMetaData");
			int totalMetadata=0; 
			for(int i=1; i <listOfMetadata.getLength();i+=2)
				{
				totalMetadata+=rowSizeCalculator(listOfMetadata.item(i).getChildNodes(),0,0);
				}
			System.out.println(totalMetadata);
			System.out.println("EndRowCalc$$");
			XMLInputRecurr(listOfComponents,0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		/**READ FROM TXT FILES	
		try {
			//BufferedReader input = new BufferedReader(new FileReader(type+".txt"));
			Scanner input = new Scanner(new FileReader(type+".txt"));
			numberOfChoices= input.nextInt();
			numberOfCriteria = input.nextInt();
			searchSpace = new double[numberOfChoices][numberOfCriteria];
			int choiceCounter=0;

	 // do not uncomment the print statements without commenting out the input.next() statements 
	 // that immediately follow them. (one needs to be commented out at all times.)

			System.out.println("#"+input.next()); //list type name
			//input.next(); //ignore type name
			while (input.hasNextLine()) {
				System.out.println("#"+input.next()); //list choice name
				//input.next(); //ignore choice name
				for(int i=0; i<numberOfCriteria; i++)
					{
					System.out.println("#"+input.next()); //list criteria name
					//input.next(); //ignore criteria name
					searchSpace[choiceCounter][i]=input.nextInt();
					}// end of loop with i
				choiceCounter++;
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		 */
	}
	/**
	 * @param String the input integer in string form
	 * takes input string, parses it and adds it to a matrix. 
	 */
	private void matrixHandoff(String input)
	{
		int inputInteger = Integer.parseInt(input);
	//	System.out.println("InputNumber:"+ inputInteger);
	}
	private int rowSizeCalculator(NodeList inList, int depthLevel, int counter)
	{
		System.out.print(counter+", ");
		int start=0;
		if(depthLevel>0)
		{
			start =1;
		}
		for(int j=0; j<inList.getLength(); j++)
		{
			if(j%2==1 || depthLevel==0){
				if(inList.item(j).getChildNodes().item(1)!=null) 
				{
					return rowSizeCalculator(inList.item(j).getChildNodes(), depthLevel+1, counter);
				}
				else
				{
					System.out.println("CounterIncreased");
					counter++;					
				}
			}
		}		
	return counter;
	}
	/**
	 * @Param NodeList the list of components, depth level of 0
	 * This method takes the text context from the XML files in tree format and hands them off to be put in a matrix
	 */
	private void XMLInputRecurr(NodeList inList, int depthLevel)
	{
		int start=0;
		if(depthLevel>0)
		{
			start =1;
		}
		for(int j=0; j<inList.getLength(); j++)
		{
			if(j%2==1 || depthLevel==0){
				//VERBOSE
//				for(int i =0; i<depthLevel;i++) //for depth tabs
//				{
//					System.out.print("\t");
//				}
//				System.out.println("inList.item("+j+").getNodeName(): "
//									+ inList.item(j).getNodeName());
				//END VERBOSE
				if(inList.item(j).getChildNodes().item(1)!=null) 
				{
					XMLInputRecurr(inList.item(j).getChildNodes(), depthLevel+1);
				}
				else
				{
					String output = inList.item(j).getTextContent().trim();
//					for(int i =0; i<depthLevel;i++) //for depth tabs
//					{
//						System.out.print("\t");
//					}
//					System.out.println("inList.item("+j+").getTextContext(): "+ output);
					matrixHandoff(output);
				}
			}
		}
	}
	public double[][] getSearchSpace()
	{
		return searchSpace;
	}
}

