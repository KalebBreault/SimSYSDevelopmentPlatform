package edu.utdallas.gamegenerator.Search;

import javax.swing.*;
import java.awt.*;

public class InputWizard {
/**
 * @Author Kaleb Breault
 * This class makes a GUI interface for entering input. 
 */
	
	public static int WIDTH = 750;
	public static int HEIGHT = 600;
	
	public InputWizard()
	{
		JFrame window = new JFrame();
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(10,1));
        int x =0;
    //GenderButtons    
        ButtonGroup genderGroup = new ButtonGroup();
        	JRadioButton maleButton = new JRadioButton("Male");
        	JRadioButton femaleButton = new JRadioButton("Female");
        	JRadioButton noGenderPreference = new JRadioButton("No Preference",true);
        	genderGroup.add(maleButton);
        	genderGroup.add(femaleButton);
        	genderGroup.add(noGenderPreference);
        	JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        	JLabel genderLabel = new JLabel("Character Gender:");
        	genderPanel.add(genderLabel);
        	genderPanel.add(maleButton);
        	genderPanel.add(femaleButton);
        	genderPanel.add(noGenderPreference);
        window.add(genderPanel,x++);
        //ageButtons    
        ButtonGroup ageGroup = new ButtonGroup();
        	JRadioButton youngButton = new JRadioButton("Young");
        	JRadioButton oldButton = new JRadioButton("Old");
        	JRadioButton noAgePreference = new JRadioButton("No Preference",true);
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
        	JRadioButton fancyButton = new JRadioButton("Fancy Dress");
        	JRadioButton noDressPreference = new JRadioButton("No Preference",true);
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
     		JRadioButton dreamButton = new JRadioButton("Dream");
     		JRadioButton virtualTourButton = new JRadioButton("Virtual Tour");
     		JRadioButton workplaceButton= new JRadioButton("Workplace");
     		JRadioButton noThemePreference = new JRadioButton("No Preference",true);
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
    		JRadioButton englighButton = new JRadioButton("English");
    		JRadioButton mathButton = new JRadioButton("Math");
    		JRadioButton scienceButton = new JRadioButton("Science");
    		JRadioButton socialstudiesButton = new JRadioButton("Social Studies");
    		JRadioButton literatureButton = new JRadioButton("Literature");
    		JRadioButton professionalButton = new JRadioButton("Professional");
    		JRadioButton noSubjectPreference = new JRadioButton("No Preference",true);
    		subjectGroup.add(englighButton);
    		subjectGroup.add(mathButton);
    		subjectGroup.add(scienceButton);
    		subjectGroup.add(socialstudiesButton);
    		subjectGroup.add(literatureButton);
    		subjectGroup.add(professionalButton);
    		subjectGroup.add(noSubjectPreference);
    		JPanel subjectPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel subjectLabel = new JLabel("Game subject:");
           	subjectPanel.add(subjectLabel);
    		subjectPanel.add(englighButton);
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
     		JRadioButton casualSettingButton = new JRadioButton("Casual");
     		JRadioButton naturalSettingButton = new JRadioButton("Natural");
     		JRadioButton educationalSettingButton= new JRadioButton("Educational");
     		JRadioButton nonTerrestialSettingButton= new JRadioButton("Non-Terrestial");
     		JRadioButton noSettingPreference = new JRadioButton("No Preference",true);
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
        //difficulity Buttons
     	ButtonGroup difficulityGroup = new ButtonGroup();
     		JRadioButton easyButton = new JRadioButton("Easy");
     		JRadioButton mediumButton = new JRadioButton("Medium");
     		JRadioButton HardButton = new JRadioButton("Hard");
     		JRadioButton noDifficulityPreference = new JRadioButton("No Preference",true);
     		difficulityGroup.add(easyButton);
     		difficulityGroup.add(mediumButton);
     		difficulityGroup.add(HardButton);
     		difficulityGroup.add(noDifficulityPreference);
     		JPanel difficulityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel difficulityLabel = new JLabel("Challenge difficulity:");
        	difficulityPanel.add(difficulityLabel);
     		difficulityPanel.add(easyButton);
     		difficulityPanel.add(mediumButton);
     		difficulityPanel.add(HardButton);
     		difficulityPanel.add(noDifficulityPreference);
     	window.add(difficulityPanel,x++);
        
        
        
        window.setVisible(true);
        
        
	}
}
