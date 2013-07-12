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
			//			System.out.println("NodeValue: "+component.getDocumentElement());

			NodeList listOfComponents = component.getElementsByTagName(type);
			int totalPersons = listOfComponents.getLength();
			System.out.println("Total no of people : " + totalPersons);   
			//			NodeList listOfCriteria = component.getElementsByTagName("SearchMetaData");
			XMLInputRecurr(listOfComponents,0);
			//			for(int i=1; i<listOfComponents.getLength() ; i++)
			//			{
			//				System.out.println("i: "+i);
			//				int depthLevel=0;
			//				System.out.println(listOfComponents.item(i).getNodeName());
			//				NodeList leafNodes = listOfComponents.item(i).getChildNodes();
			//
			//				//				Node tempNode = listOfCriteria.item(i);
			//				//				System.out.println(type+i+": "+tempNode.getNodeName());
			//				//				NodeList tempNodeChildren= tempNode.getChildNodes();
			//				//				for(int j=0; j<tempNodeChildren.getLength(); j++)
			//				//				{		
			//				//					NodeList tempNodeChildrensChildren = tempNodeChildren.item(j).getChildNodes();
			//				//					for(int k=0; k<tempNodeChildrensChildren.getLength();k++)
			//				//					{
			//				//						if(k%2==1)
			//				//							System.out.println("\tCriteria"+k+": "+tempNodeChildrensChildren.item(k).getNodeName() + 
			//				//								"\n\t\t Value:"+ tempNodeChildrensChildren.item(k).getChildNodes().item(0).getChildNodes().item(0).getNodeName());
			//				//					}//end of loop with j
			//				//				}
			//			}//end of loop with i
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
	public NodeList XMLInputRecurr(NodeList inList, int depthLevel)
	{
		int start=0;
		if(depthLevel>0)
		{
			start =1;
		}
		for(int j=start; j<inList.getLength(); j++)
		{
			if(j%2==1){
				for(int i =0; i<depthLevel;i++) //for depth tabs
				{
					System.out.print("\t");
				}
				System.out.println("inList.item("+j+").getNodeName(): "+ inList.item(j).getNodeName());
				if(inList.item(j).getChildNodes()!=null)
				{
					XMLInputRecurr(inList.item(j).getChildNodes(), depthLevel+1);
				}
				else
				{
					System.out.println("#####################################");
					for(int i =0; i<depthLevel;i++) //for depth tabs
					{
						System.out.print("\t");
					}
					System.out.println("inList.item("+j+").getNodeValue(): "+inList.item(j).getTextContent().trim());
				}
			}
		}
		return inList;
	}
	public double[][] getSearchSpace()
	{
		return searchSpace;
	}
}

