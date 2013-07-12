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
		   JAXBContext jaxbContext = null;
	        File file = null;
	        Unmarshaller unmarshaller = null;
		
		 try {
//			jaxbContext = JAXBContext.newInstance();
//		
//	        file = new File("XMLmetadata\\"+type+".xml");
//	        unmarshaller = jaxbContext.createUnmarshaller();

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document component = docBuilder.parse (new File("XMLmetadata//"+type+".xml"));
            

            // normalize text representation
            component.getDocumentElement ().normalize ();
            System.out.println ("Root element of the doc is " + 
            		component.getDocumentElement().getNodeName() +" with type: "+type);


            NodeList listOfComponents = component.getElementsByTagName(type);
            int totalPersons = listOfComponents.getLength();
            System.out.println("Total no of people : " + totalPersons);   
	        NodeList listOfCriteria = component.getElementsByTagName("SearchMetaData");
            for(int i=0; i<listOfCriteria.getLength() ; i++)
            {
            	Node tempNode = listOfCriteria.item(i);
            	System.out.println("Metadata"+i+": "+tempNode.getNodeName());
            	NodeList tempNodeChildren= tempNode.getChildNodes();
                for(int j=0; j<tempNodeChildren.getLength(); j++)
                {
                	System.out.println("\tCriteria"+j+": "+tempNodeChildren.item(j).getNodeName());
                }

            }
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
					}
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
	
	public double[][] getSearchSpace()
	{
		return searchSpace;
	}
}

