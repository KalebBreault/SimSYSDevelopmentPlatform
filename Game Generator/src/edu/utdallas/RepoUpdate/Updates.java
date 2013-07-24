package edu.utdallas.RepoUpdate;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Updates {
	
	String[] gameComponents = {"Characters", "Lesson", "Challenge", "Locale", "Subject", "Theme"};
	String[] repoGameComponents = {"characters", "lesson", "challenge", "locale", "subject", "theme"};
	String[] elements= {"</Character>", "</Lessons>", "</Challenges>", "</Locales>", "</Subjects>", "</Themes>"};
	Scanner input = new Scanner(System.in);
	
	public Updates(){
		
	}
	
	public void addGame(String newGamename){
		
		String textlocation;
		String nextInputLine;
		Integer gameNumb=-1;
		
		
		for(int x=0; x<gameComponents.length; x++)
		{
			gameNumb=-1;
			
			try{
				textlocation="New Games//"+newGamename+"//"+gameComponents[x]+"MetaData.xml";				
				File dataAddition = new File(textlocation);
				
				File original = new File("XMLmetadata//"+ repoGameComponents[x]+".xml");
				
				
				Scanner copy = new Scanner(original);
				PrintWriter writeTemp = new PrintWriter("XMLmetadata//temp.xml");
				while (copy.hasNext()){
					writeTemp.write(copy.nextLine()+"\n");
				}//end while
				
				copy.close();
				writeTemp.close();
				
				original.setWritable(true);
				original.delete();
				
				File temp = new File("XMLmetadata//temp.xml");
							
				String updatedfileloc="XMLmetadata//"+ repoGameComponents[x]+".xml"; 
				
				Scanner fileinput =new Scanner(temp);
				PrintWriter output = new PrintWriter(updatedfileloc);
				//System.out.println(fileinput.hasNext());
				while (fileinput.hasNext()){
					nextInputLine=fileinput.nextLine();
					//System.out.println(nextInputLine);
					
					if (nextInputLine.contains(gameComponents[x]+" id=")){
						gameNumb++;
					}
					//System.out.println(nextInputLine + elements[x]);
					//System.out.println(nextInputLine.compareTo(elements[x]));
					if (nextInputLine.compareTo(elements[x])==0){
						gameNumb++;
						Scanner addition = new Scanner(dataAddition);
						addition.nextLine();
						output.write("<"+gameComponents[x]+" id="+ gameNumb+ ">\n");
						while(addition.hasNext()){
							output.write(addition.nextLine()+"\n");
						}//end while
						addition.close();
					//All the addition has been outputed.
					}//end if
					
					output.write(nextInputLine+"\n");
					//System.out.println(fileinput.nextLine());
					
					temp.setWritable(true);
					temp.delete();
				}//end while
				
				System.out.println(repoGameComponents[x]+" XMLmetadata Updated.");
				output.close();
				fileinput.close();
				
				////////////////////////////////////////////////////////////////////////////////////////////////
				textlocation="New Games//"+newGamename+"//"+ gameComponents[x]+".xml";				
				File fileAddition = new File(textlocation);				
			
				Scanner addFile = new Scanner(fileAddition);
				PrintWriter writeNewFile = new PrintWriter("XMLrepo//"+gameComponents[x]+gameNumb+".xml");
				while (addFile.hasNext()){
					writeNewFile.write(addFile.nextLine()+"\n");
				}//end while
			    
				System.out.println(gameComponents[x]+ " XMLrepo Added.\n");
				addFile.close();
				writeNewFile.close();
				////////////////////////////////////////////////////////////////////////////////////////////////
			
			}//end try
			catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}//end catch		
			
		}//end for


	}//end addGame
	
	public void remakeRepo(){
		//TODO
	}
}
