package edu.utdallas.gamegenerator.Search;

import javax.swing.*;

import Jama.Matrix;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputWizard implements ActionListener {
/**
 * @Author Kaleb Breault
 * This class makes a GUI interface for entering input. 
 */
	
	private static int WIDTH = 750;
	private static int HEIGHT = 600;
	private Matrix[] componentInputs;
	private boolean submitClicked = false;
 	private JFrame window = new JFrame();
 	
 	private String playerGender= "none"; 
  	private String playerAge= "none";	
  	private String playerDress= "none";  	
   	private String gameTheme= "none";	
 	private String gameSubject= "none";  	
 	private String gameSetting= "none";   	
 	private String gameDifficulty= "none"; 

 
	public InputWizard(Matrix[] input)
	{
		componentInputs = input;
		initializeComponentInputs();
		
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(10,1));
        window.setVisible(true);
        int x =0;
        final String none = "no";
    //GenderButtons    
        ButtonGroup genderGroup = new ButtonGroup();
        	JRadioButton maleButton = new JRadioButton("Male");
            maleButton.setActionCommand("Male");
            maleButton.addActionListener(this);
        	JRadioButton femaleButton = new JRadioButton("Female");
            femaleButton.setActionCommand("Female");
            femaleButton.addActionListener(this);
        	JRadioButton noGenderPreference = new JRadioButton("No Preference",true);
            noGenderPreference.setActionCommand(none+" gender");
            noGenderPreference.addActionListener(this);
        	genderGroup.add(maleButton);
        	genderGroup.add(femaleButton);
        	genderGroup.add(noGenderPreference);
        	JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        	JLabel genderLabel = new JLabel("Player Gender:");
        	genderPanel.add(genderLabel);
        	genderPanel.add(maleButton);
        	genderPanel.add(femaleButton);
        	genderPanel.add(noGenderPreference);
        window.add(genderPanel,x++);
        //ageButtons    
        ButtonGroup ageGroup = new ButtonGroup();
        	JRadioButton youngButton = new JRadioButton("Young");
            youngButton.setActionCommand("Young");
            youngButton.addActionListener(this);
        	JRadioButton oldButton = new JRadioButton("Old");
        	oldButton.setActionCommand("Old");
        	oldButton.addActionListener(this);
        	JRadioButton noAgePreference = new JRadioButton("No Preference",true);
            noAgePreference.setActionCommand(none+" age");
            noAgePreference.addActionListener(this);
        	ageGroup.add(youngButton);
        	ageGroup.add(oldButton);
        	ageGroup.add(noAgePreference);
        	JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        	JLabel ageLabel = new JLabel("Character age:");
        	agePanel.add(ageLabel);
        	agePanel.add(youngButton);
        	agePanel.add(oldButton);
        	agePanel.add(noAgePreference);
        window.add(agePanel,x++);
        
        //dressButtons    
        ButtonGroup dressGroup = new ButtonGroup();
        	JRadioButton casualButton = new JRadioButton("Casual Dress");
        	casualButton.setActionCommand("Casual");
        	casualButton.addActionListener(this);
        	JRadioButton fancyButton = new JRadioButton("Fancy Dress");
        	fancyButton.setActionCommand("Fancy");
        	fancyButton.addActionListener(this);
        	JRadioButton noDressPreference = new JRadioButton("No Preference",true);
        	noDressPreference.setActionCommand(none+" dress");
        	noDressPreference.addActionListener(this);
        	dressGroup.add(casualButton);
        	dressGroup.add(fancyButton );
        	dressGroup.add(noDressPreference);
        	JPanel dressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        	JLabel dressLabel = new JLabel("Character dress:");
        	dressPanel.add(dressLabel);
        	dressPanel.add(casualButton);
        	dressPanel.add(fancyButton );
        	dressPanel.add(noDressPreference);
        window.add(dressPanel,x++);
        //Theme Buttons
     	ButtonGroup themeGroup = new ButtonGroup();
     		JRadioButton goobleButton = new JRadioButton("Gooble");
     		goobleButton.setActionCommand("Gooble");
     		goobleButton.addActionListener(this);
     		JRadioButton dreamButton = new JRadioButton("Dream");
     		dreamButton.setActionCommand("Dream");
     		dreamButton.addActionListener(this);
     		JRadioButton virtualTourButton = new JRadioButton("Virtual Tour");
     		virtualTourButton.setActionCommand("VirtualTour");
     		virtualTourButton.addActionListener(this);
     		JRadioButton workplaceButton= new JRadioButton("Workplace");
     		workplaceButton.setActionCommand("Workplace");
     		workplaceButton.addActionListener(this);
     		JRadioButton noThemePreference = new JRadioButton("No Preference",true);
     		noThemePreference.setActionCommand(none+" theme");
     		noThemePreference.addActionListener(this);
     		themeGroup.add(goobleButton);
     		themeGroup.add(dreamButton);
     		themeGroup.add(virtualTourButton);
     		themeGroup.add(workplaceButton);
     		themeGroup.add(noThemePreference);
     		JPanel themePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel themeLabel = new JLabel("Game Theme:");
        	themePanel.add(themeLabel);
     		themePanel.add(goobleButton);
     		themePanel.add(dreamButton);
     		themePanel.add(virtualTourButton);
     		themePanel.add(workplaceButton);
     		themePanel.add(noThemePreference);
     	window.add(themePanel,x++);
      //SubjectButtons
        ButtonGroup subjectGroup = new ButtonGroup();
    		JRadioButton englishButton = new JRadioButton("English");
    		englishButton.setActionCommand("English");
    		englishButton.addActionListener(this);
    		JRadioButton mathButton = new JRadioButton("Math");
    		mathButton.setActionCommand("Math");
    		mathButton.addActionListener(this);
    		JRadioButton scienceButton = new JRadioButton("Science");
    		scienceButton.setActionCommand("Science");
    		scienceButton.addActionListener(this);
    		JRadioButton socialstudiesButton = new JRadioButton("Social Studies");
    		socialstudiesButton.setActionCommand("Social Studies");
    		socialstudiesButton.addActionListener(this);
    		JRadioButton literatureButton = new JRadioButton("Literature");
    		literatureButton.setActionCommand("Literature");
    		literatureButton.addActionListener(this);
    		JRadioButton professionalButton = new JRadioButton("Professional");
    		professionalButton.setActionCommand("Professional");
    		professionalButton.addActionListener(this);
    		JRadioButton noSubjectPreference = new JRadioButton("No Preference",true);
    		noSubjectPreference.setActionCommand(none+" subject");
    		noSubjectPreference.addActionListener(this);
    		subjectGroup.add(englishButton);
    		subjectGroup.add(mathButton);
    		subjectGroup.add(scienceButton);
    		subjectGroup.add(socialstudiesButton);
    		subjectGroup.add(literatureButton);
    		subjectGroup.add(professionalButton);
    		subjectGroup.add(noSubjectPreference);
    		JPanel subjectPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel subjectLabel = new JLabel("Game subject:");
           	subjectPanel.add(subjectLabel);
    		subjectPanel.add(englishButton);
    		subjectPanel.add(mathButton);
    		subjectPanel.add(scienceButton);
    		subjectPanel.add(socialstudiesButton);
    		subjectPanel.add(literatureButton);
    		subjectPanel.add(professionalButton);
    		subjectPanel.add(noSubjectPreference);
    	window.add(subjectPanel,x++);
    //Setting Buttons	
     	ButtonGroup settingGroup = new ButtonGroup();
     		JRadioButton professionalSettingButton = new JRadioButton("Professional");
     		professionalSettingButton.setActionCommand("ProfessionalSetting");
     		professionalSettingButton.addActionListener(this);
     		JRadioButton casualSettingButton = new JRadioButton("Casual");
     		casualSettingButton.setActionCommand("CasualSetting");
     		casualSettingButton.addActionListener(this);
     		JRadioButton naturalSettingButton = new JRadioButton("Natural");
     		naturalSettingButton.setActionCommand("NaturalSetting");
     		naturalSettingButton.addActionListener(this);
     		JRadioButton educationalSettingButton= new JRadioButton("Educational");
     		educationalSettingButton.setActionCommand("EducationalSetting");
     		educationalSettingButton.addActionListener(this);
     		JRadioButton nonTerrestialSettingButton= new JRadioButton("Non-Terrestial");
     		nonTerrestialSettingButton.setActionCommand("Non-TerrestialSetting");
     		nonTerrestialSettingButton.addActionListener(this);
     		JRadioButton noSettingPreference = new JRadioButton("No Preference",true);
     		noSettingPreference.setActionCommand(none+" setting");
     		noSettingPreference.addActionListener(this);
     		settingGroup.add(professionalSettingButton);
     		settingGroup.add(casualSettingButton);
     		settingGroup.add(naturalSettingButton);
     		settingGroup.add(educationalSettingButton);
     		settingGroup.add(nonTerrestialSettingButton);
 			settingGroup.add(noSettingPreference);
 			JPanel settingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
 			JLabel settingLabel = new JLabel("Game Setting:");
 			settingPanel.add(settingLabel);
 			settingPanel.add(professionalSettingButton);
 			settingPanel.add(casualSettingButton);
 			settingPanel.add(naturalSettingButton);
 			settingPanel.add(educationalSettingButton);
 			settingPanel.add(nonTerrestialSettingButton);
 			settingPanel.add(noSettingPreference);
 		window.add(settingPanel,x++);
        //difficulty Buttons
     	ButtonGroup difficultyGroup = new ButtonGroup();
     		JRadioButton easyButton = new JRadioButton("Easy");
     		easyButton.setActionCommand("Easy");
     		easyButton.addActionListener(this);
     		JRadioButton mediumButton = new JRadioButton("Medium");
     		mediumButton.setActionCommand("Medium");
     		mediumButton.addActionListener(this);
     		JRadioButton hardButton = new JRadioButton("Hard");
     		hardButton.setActionCommand("Hard");
     		hardButton.addActionListener(this);
     		JRadioButton noDifficultyPreference = new JRadioButton("No Preference",true);
     		noDifficultyPreference.setActionCommand(none+" difficulty");
     		noDifficultyPreference.addActionListener(this);
     		difficultyGroup.add(easyButton);
     		difficultyGroup.add(mediumButton);
     		difficultyGroup.add(hardButton);
     		difficultyGroup.add(noDifficultyPreference);
     		JPanel difficultyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel difficultyLabel = new JLabel("Challenge difficulty:");
        	difficultyPanel.add(difficultyLabel);
     		difficultyPanel.add(easyButton);
     		difficultyPanel.add(mediumButton);
     		difficultyPanel.add(hardButton);
     		difficultyPanel.add(noDifficultyPreference);
     	window.add(difficultyPanel,x++);
        //ADD MORE BUTTON SETS HERE
     	
        
     	
     	
     	//Submit Button on bottom
     	
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        submitButton.setActionCommand("Submit");
        window.add(submitButton, x++);
	}
	private void initializeComponentInputs()
	{
		for(int x=0; x<componentInputs.length;x++)
		{
			componentInputs[x]= initializeMatrix(componentInputs[x], 1);
		}
		
	}
	private Matrix initializeMatrix(Matrix inputMatrix, double initValue)
	{
		double[][] inputMatrixArray = inputMatrix.getArray();
		for(int y=0; y<inputMatrixArray.length;y++)
		{
			for(int z=0; z<inputMatrixArray[y].length;z++)
			{
				inputMatrixArray[y][z] = initValue;
			}
		}
		
		return inputMatrix;		
	}
	private double[][] initializeArray(double[][] inputMatrixArray, double initValue)
	{
		for(int y=0; y<inputMatrixArray.length;y++)
		{
			for(int z=0; z<inputMatrixArray[y].length;z++)
			{
				inputMatrixArray[y][z] = initValue;
			}
		}
		
		return inputMatrixArray;		
	}
	private void printMatrix(Matrix  inputMatrix)
	{
		double[][] inputArray = inputMatrix.getArray();
		for(int x=0; x < inputArray.length; x++)
		{
			for (int y =0; y <  inputArray[x].length; y++)
			{
				System.out.printf("%.2f ",inputArray[x][y]);
			}
			System.out.println("");
		}
	}
	public Matrix[] getWizardInputs() {
		while(!submitClicked)
		{
			//WAIT!!!!
		}
		return componentInputs;
	}
	// a way to weight the options for each component against each other (ie age v gender) on which is more important
	// add a third input to this method called weight and replace the optionTotal in the assignment statement with it. 
	private Matrix optionMatrix(int optionNumber, int optionTotal)
	{
		double[][] outputArray = new double[optionTotal][optionTotal];
		outputArray = initializeArray(outputArray,1);
		for(int x=0; x<optionTotal; x++)
		{
			if(x!=optionNumber-1)
			{
				outputArray[optionNumber-1][x]=optionTotal; //replace optionTotal here with weight
				outputArray[x][optionNumber-1]=(1.0 / optionTotal); //replace optionTotal here with weight
			}							
		}						
		return new Matrix(outputArray);
	}
	private void distributeInputs() {
							//start with character component
		int socialRating = 0;
		int professionalRating =0;
		int educationalRating =0;
		System.out.println("distributing Inputs");
		switch(playerAge){
		case "Young":
			componentInputs[0].setMatrix(0,1,0,1,optionMatrix(1,2));
			break;
		case "Old":
			componentInputs[0].setMatrix(0,1,0,1,optionMatrix(2,2));
			break;
		case "none":
			break;
		default:
			break;
		}
		switch(playerGender){
		case "Male":
			componentInputs[0].setMatrix(2,3,2,3,optionMatrix(1,2));
			break;
		case "Female":
			componentInputs[0].setMatrix(2,3,2,3,optionMatrix(2,2));
			break;
		case "none":
			break;
		default:
			break;
		}

		switch(playerDress){
		case "Casual":
			componentInputs[0].setMatrix(4,5,4,5,optionMatrix(1,2));
//			socialRating++;
			break;
		case "Fancy":
			componentInputs[0].setMatrix(4,5,4,5,optionMatrix(2,2));
			break;
		case "none":
			break;
		default:
			break;
		}
		switch(gameTheme){
				case "Gooble":
					componentInputs[5].setMatrix(0,2,0,2,optionMatrix(1,3));
					educationalRating++;
					break;
				case "Dream":
					componentInputs[5].setMatrix(0,2,0,2,optionMatrix(3,3));
					socialRating++;
					break;
				case "VirtualTour":
					componentInputs[5].setMatrix(0,2,0,2,optionMatrix(3,3));
					professionalRating++;
					break;
				case "Workplace":
					componentInputs[5].setMatrix(0,2,0,2,optionMatrix(2,3));
					professionalRating++;
					break;
				case "no theme":
					break;
				default:
					System.out.println("Something went terribly terribly wrong...." + gameTheme);
					break;
		}
		switch(gameSubject)
		{
		//Subject
				case "English":
					componentInputs[4].setMatrix(0,5,0,5,optionMatrix(1,6));
					educationalRating++;
					break;
				case "Math":
					componentInputs[4].setMatrix(0,5,0,5,optionMatrix(2,6));
					educationalRating++;
					break;
				case "Science":
					componentInputs[4].setMatrix(0,5,0,5,optionMatrix(3,6));
					educationalRating++;
					break;
				case "Social Studies":
					componentInputs[4].setMatrix(0,5,0,5,optionMatrix(4,6));
					educationalRating++;
					break;
				case "Literature":
					componentInputs[4].setMatrix(0,5,0,5,optionMatrix(5,6));
					educationalRating++;
					break;
				case "Professional":
					componentInputs[4].setMatrix(0,5,0,5,optionMatrix(6,6));
					professionalRating++;
					break;
				case "no subject":
					gameSubject = "none";
					break;
				default:
					System.out.println("Something went terribly terribly wrong...." + gameSubject);
					break;
		}
		switch(gameSetting){
		//Setting
				case "ProfessionalSetting":
					professionalRating+=2;
					componentInputs[3].setMatrix(3,7,3,7,optionMatrix(1,5));
					break;
				case "CasualSetting":
					socialRating+=2;
					componentInputs[3].setMatrix(3,7,3,7,optionMatrix(2,5));
					break;
				case "NaturalSetting":
					componentInputs[3].setMatrix(3,7,3,7,optionMatrix(3,5));
					break;
				case "EducationalSetting":
					componentInputs[3].setMatrix(3,7,3,7,optionMatrix(4,5));
					educationalRating+=2;
					break;
				case "Non-TerrestialSetting":
					componentInputs[3].setMatrix(3,7,3,7,optionMatrix(5,5));
					break;
				case "no setting":
					break;
				default:
					System.out.println("Something went terribly terribly wrong...." + gameSetting);
					break;
		}
		switch(gameDifficulty){
		//Difficulty
				case "Easy":
					componentInputs[2].setMatrix(0,1,0,1,optionMatrix(1,2));
					componentInputs[2].setMatrix(2,3,2,3,optionMatrix(1,2));
					break;
				case "Medium":
					break;
				case "Hard":
					componentInputs[2].setMatrix(0,1,0,1,optionMatrix(2,2));
					componentInputs[2].setMatrix(2,3,2,3,optionMatrix(2,2));
					break;
				case "no difficulity":
					gameDifficulty = "none";
					break;
				default:
					System.out.println("Something went terribly terribly wrong...." + gameDifficulty);
					break;
		}
			if(socialRating>professionalRating && socialRating>educationalRating)
			{
				componentInputs[2].setMatrix(4,6,4,6,optionMatrix(1,3));
				componentInputs[1].setMatrix(0,2,0,2,optionMatrix(1,3));

			}
			if(professionalRating>socialRating && professionalRating>educationalRating)
			{
				componentInputs[2].setMatrix(4,6,4,6,optionMatrix(2,3));
				componentInputs[1].setMatrix(0,2,0,2,optionMatrix(3,3));

			}
			if(educationalRating>socialRating && educationalRating>professionalRating)
			{
				componentInputs[2].setMatrix(4,6,4,6,optionMatrix(3,3));
				componentInputs[1].setMatrix(0,2,0,2,optionMatrix(2,3));

			}
		
	}	
	public void printStrings()
	{
		System.out.println(playerGender);
		System.out.println(playerAge);
		System.out.println(playerDress);
		System.out.println(gameTheme);
		System.out.println(gameSetting);
		System.out.println(gameDifficulty);
		System.out.println(gameSubject);
	}
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand()) 
		{
		case "Submit":
			printStrings();
			distributeInputs();
			System.out.println("Submit Clicked");
			submitClicked = true;
			window.dispose();
			break;
//Gender			
		case "Male": 
			playerGender = "Male";
			break;
		case "Female":
			playerGender = "Female";
			break;
		case "no gender":
			playerGender = "none";
//Age					
		case "Young":
			playerAge = "Young";
		case "Old":
			playerAge = "Old";
			break;
		case "no age":
			playerAge = "none";
			break;
//Dress
		case "Casual":
			playerDress = "Casual";
			break;
		case "Fancy":
			playerDress = "Fancy";
			break;
		case "no dress":
			playerDress = "none";
			break;
//Theme
		case "Gooble":
			gameTheme = "Gooble";
			break;
		case "Dream":
			gameTheme = "Dream";
			break;
		case "VirtualTour":
			gameTheme = "VirtualTour";
			break;
		case "Workplace":
			gameTheme = "Workplace";
			break;
		case "no theme":
			gameTheme = "none";
			break;
//Subject
		case "English":
			gameSubject = "English";
			break;
		case "Math":
			gameSubject = "Math";
			break;
		case "Science":
			gameSubject = "Science";
			break;
		case "Social Studies":
			gameSubject = "Social Studies";
			break;
		case "Literature":
			gameSubject = "Literature";
			break;
		case "Professional":
			gameSubject = "Professional";
			break;
		case "no subject":
			gameSubject = "none";
			break;
//Setting
		case "ProfessionalSetting":
			gameSetting = "Professional";
			break;
		case "CasualSetting":
			gameSetting = "Casual";
			break;
		case "NaturalSetting":
			gameSetting = "Natural";
			break;
		case "EducationalSetting":
			gameSetting = "Educational";
			break;
		case "Non-TerrestialSetting":
			gameSetting = "Non-Terrestial";
			break;
		case "no setting":
			gameSetting = "none";
			break;
//Difficulty
		case "Easy":
			gameDifficulty = "Easy";
			break;
		case "Medium":
			gameDifficulty = "Medium";
			break;
		case "Hard":
			gameDifficulty = "Hard";
			break;
		case "no difficulity":
			gameDifficulty = "none";
			break;
		default:
		System.out.println("Something went terribly terribly wrong....");
		break;
		}
	}
		
}
