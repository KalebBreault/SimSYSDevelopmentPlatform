package edu.utdallas.RepoUpdate;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserInterface {
	
	public UserInterface() {

		Boolean done =false;
		
		
		Scanner input = new Scanner(System.in);
		Updates update= new Updates();
		
		while (done==false){
			Integer inputNumb=-1;
			System.out.print("What would you like to do:\n1 - Add Game to XMLmetadata. \n\n2 - Remake XMLmetadata. \n\n0 - Done.\n");
			inputNumb=input.nextInt();
			
			if (inputNumb==1){
				String newGamename;
				System.out.println("What is the folder name of your new game?(New Games//????)");
				newGamename=input.next();
				update.addGame(newGamename);
				
				

			} else if (inputNumb==2){
				System.out.println("Still under development...");
				update.remakeRepo();
				
			}else if (inputNumb==0){
				done=true;
			}else if (inputNumb==-1){
				System.out.println("Unidentified input, please try again.");
			}
		
		}//end while
		
		input.close();

	}//end UserInterface
}
