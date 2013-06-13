
import java.io.FileOutputStream;
import java.io.ObjectInputStream.GetField;
import java.math.BigInteger;
import java.sql.Types;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import generated.FollowUp;
import generated.FollowUpQuestion;
import generated.ImageList;
import generated.Item;
import generated.ItemList;
import generated.ItemXML;
import generated.LearningTaxonomy;

import generated.ConditionsList;
import generated.InputList;
import generated.MechanicsList;
import generated.Music;
import generated.ObjectFactory;
import generated.ObjectiveList;
import generated.Option;
import generated.OptionList;
import generated.PathList;
import generated.QuestionList;
import generated.Quiz;
import generated.Reward;
import generated.TimerEvent;
import generated.TimerEventList;
import generated.TopicList;
import generated.TypeList;

public class GenerateXML {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rnd = new Random();

	public static ObjectFactory factory = new ObjectFactory();
	
	public static String randomString( int len ) 
	{
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}


	
	public Quiz getQuiz(){
		
		//Create quiz xml
		Quiz quiz = new Quiz();
		
			PathList pathList = new PathList();
			pathList.getPath().add(randomString(4));
		quiz.setPathList(pathList);
		
		quiz.setQuizArea(randomString(4));
		
			ObjectiveList objectiveList = new ObjectiveList();
			objectiveList.getObjective().add(randomString(4));
		quiz.setObjectiveList(objectiveList);
		
			ConditionsList conditionList = new ConditionsList();
			conditionList.setTimed(true);
			conditionList.setLimitedResources(false);
			conditionList.setCompetetive(true);
			conditionList.setPlayer(randomString(4));
			conditionList.setAntogonist(randomString(4));
		quiz.setConditionList(conditionList);
		
			MechanicsList mechanics = new MechanicsList();
		
				Music music = new Music();
				music.setPath(randomString(4));
			mechanics.setMusic(music);
		
				InputList inputList = new InputList();
				inputList.getInput().add(randomString(4));
			mechanics.setInputList(inputList);
		
			mechanics.setEnvironment(randomString(4));
		quiz.setMechanicsList(mechanics);
		quiz.setItemList(getRandomItemList());
		
		return quiz;
		
	}
	
	public ItemXML getItemsXml(){
		
		//Create items xml
		ItemXML itemXml = new ItemXML();
		itemXml.setItemList(getRandomItemList());
		
		return itemXml;

	}
	
	public ItemList getRandomItemList(){
		
		ItemList itemlist = new ItemList();
		
		Item item = new Item();
		item.setId(new BigInteger("1"));
		item.setKnowledge(randomString(4));
		item.setArea(randomString(4));
		TopicList topicList = new TopicList();
		topicList.getTopic().add(randomString(4));
		topicList.getTopic().add(randomString(4));
		topicList.getTopic().add(randomString(4));
		item.setTopicList(topicList);
	
		LearningTaxonomy learningTaxonomy = new LearningTaxonomy();
		learningTaxonomy.setExpression(randomString(4));
		TypeList typeList = new TypeList();
		typeList.getType().add(randomString(4));
		typeList.getType().add(randomString(4));
		learningTaxonomy.setTypeList(typeList);
		
		item.setLearningTaxonomy(learningTaxonomy);
		
		//item.setStemDescription(randomString(4));

		ImageList imageList = new ImageList();
		imageList.getImage().add(randomString(4));
		item.setImageList(imageList);
		
	
		
		QuestionList questionList = new QuestionList();
		QuestionList.Question question = new QuestionList.Question();
		question.setQuestionId(new BigInteger(((Integer)rnd.nextInt(5)).toString()));
		
			TopicList questiontopicList = new TopicList();
			questiontopicList.getTopic().add(randomString(4));
			questiontopicList.getTopic().add(randomString(4));
		question.setTopicList(questiontopicList);
		question.setDepth(randomString(4));
		question.setTimer(new BigInteger(((Integer)rnd.nextInt(5)).toString()));
			TimerEventList timerList = new TimerEventList();
				TimerEvent timerEvent = new TimerEvent();
				timerEvent.setTime(randomString(4));
				timerEvent.setEventMsg(randomString(4));
			timerList.getTimerEvent().add(timerEvent);
		question.setTimerEventList(timerList);
		question.setMaxNoOfAttempts(new BigInteger(((Integer)rnd.nextInt(5)).toString()));
		
		Reward	reward =new Reward();
		reward.setCorrect(new BigInteger(((Integer)rnd.nextInt(5)).toString()));
		reward.setPartiallyCorrect(new BigInteger(((Integer)rnd.nextInt(5)).toString()));
		reward.setIncorrect(new BigInteger(((Integer)rnd.nextInt(5)).toString()));
		question.setReward(reward);
		question.setStemLeadInQuestions(randomString(4));
		
			OptionList optionList = new OptionList();
			Option option = new Option();
			option.setChoice(randomString(4));
			option.setText(randomString(4));
			option.setFeedback(randomString(4));
			option.setHint(randomString(4));
			optionList.getOption().add(option);
						
		question.setOptionList(optionList);
			FollowUp followUp = new FollowUp();
			
				FollowUpQuestion correctFollowUpQuestion = new FollowUpQuestion();
				correctFollowUpQuestion.setStemLeadInQuestions(randomString(4));
				
					OptionList correctFollowUpOptionList = new OptionList();
				
					Option correctFollowUpOption1 = new Option();
					correctFollowUpOption1.setChoice(randomString(4));
					correctFollowUpOption1.setText(randomString(4));
					correctFollowUpOption1.setFeedback(randomString(4));
					correctFollowUpOption1.setHint(randomString(4));
					correctFollowUpOptionList.getOption().add(correctFollowUpOption1);
					
					Option correctFollowUpOption2 = new Option();
					correctFollowUpOption2.setChoice(randomString(4));
					correctFollowUpOption2.setText(randomString(4));
					correctFollowUpOption2.setFeedback(randomString(4));
					correctFollowUpOption2.setHint(randomString(4));
					correctFollowUpOptionList.getOption().add(correctFollowUpOption2);				
				
				correctFollowUpQuestion.setOptionList(correctFollowUpOptionList);
			followUp.setCorrectFollowUpQuestion(correctFollowUpQuestion);
			

			FollowUpQuestion inCorrectFollowUpQuestion = new FollowUpQuestion();
			inCorrectFollowUpQuestion.setStemLeadInQuestions(randomString(4));
			
				OptionList inCorrectFollowUpOptionList = new OptionList();
			
				Option inCorrectFollowUpOption1 = new Option();
				inCorrectFollowUpOption1.setChoice(randomString(4));
				inCorrectFollowUpOption1.setText(randomString(4));
				inCorrectFollowUpOption1.setFeedback(randomString(4));
				inCorrectFollowUpOption1.setHint(randomString(4));
				inCorrectFollowUpOptionList.getOption().add(inCorrectFollowUpOption1);
				
				Option inCorrectFollowUpOption2 = new Option();
				inCorrectFollowUpOption2.setChoice(randomString(4));
				inCorrectFollowUpOption2.setText(randomString(4));
				inCorrectFollowUpOption2.setFeedback(randomString(4));
				inCorrectFollowUpOption2.setHint(randomString(4));
				inCorrectFollowUpOptionList.getOption().add(inCorrectFollowUpOption2);				
			
			inCorrectFollowUpQuestion.setOptionList(inCorrectFollowUpOptionList);
			followUp.setIncorrectFollowUpQuestion(inCorrectFollowUpQuestion);
			
		question.setFollowUp(followUp);
		
	
		questionList.getQuestion().add(question);
		
			
		item.setQuestionList(questionList);
		itemlist.getItem().add(item);

		return itemlist;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try{
			
			GenerateXML generate = new GenerateXML();
			
			JAXBContext context = JAXBContext.newInstance("generated");
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
			
						
			JAXBElement items = factory.createItemXml(generate.getItemsXml());
			//marshaller.marshal(items,System.out);
			marshaller.marshal(items,new FileOutputStream(System.getProperty( "user.dir" )+"//sample_xmls//items.xml"));
			
			
			JAXBElement quizxml = factory.createQuiz(generate.getQuiz());
			//marshaller.marshal(quizxml,System.out);
			marshaller.marshal(quizxml,new FileOutputStream(System.getProperty( "user.dir" )+"//sample_xmls//quiz.xml"));
			
			System.out.println();
			
		}catch(Exception e)
		{
			System.out.println("Exception occured when generating xmls : "+e.getMessage());
			e.printStackTrace();
		}
	}

}
