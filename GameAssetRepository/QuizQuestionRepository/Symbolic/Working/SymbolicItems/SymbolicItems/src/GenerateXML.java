
import generated.ImageList;
import generated.Item;
import generated.LearningTaxonomyList;
import generated.ObjectFactory;
import generated.ItemList;
import generated.QuestionList;
import generated.QuestionList.Question;
import generated.QuestionList.Question.OptionList;
import generated.TopicList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



import java.io.FileOutputStream;
import java.math.BigInteger;

public class GenerateXML {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			ObjectFactory factory = new ObjectFactory();
			
			
			
			
			Item item = factory.createItem();
			item.setId(new BigInteger("1"));
			item.setArea("");
			item.setExpression("");
			
			ImageList imageList = new ImageList();
			imageList.getImage().add("");
			item.setImageList(imageList);
			
			item.setKnowledge("");
			
			LearningTaxonomyList learningTaxonomyList = new LearningTaxonomyList();
			learningTaxonomyList.getLearningTaxonomy().add("");
			learningTaxonomyList.getLearningTaxonomy().add("");
			learningTaxonomyList.getLearningTaxonomy().add("");
			item.setLearningTaxonomyList(learningTaxonomyList);
			
			TopicList topicList = new TopicList();
			topicList.getTopic().add("");
			topicList.getTopic().add("");
			topicList.getTopic().add("");
			item.setTopicList(topicList);
			
			QuestionList questionList = new QuestionList();
			Question question = new Question();
			question.setQuestionId(new BigInteger("1"));
			question.setDepth("");
				TopicList questiontopicList = new TopicList();
				questiontopicList.getTopic().add("");
				questiontopicList.getTopic().add("");
				question.setTopicList(questiontopicList);
			questionList.getQuestion().add(question);
			question.setStemLeadInQuestions("");
				OptionList optionList = new OptionList();
				optionList.setCorrect("");
				optionList.setPartialllyCorrectOption("");
				optionList.getIncorrectOption().add("");
				optionList.getIncorrectOption().add("");
			question.setOptionList(optionList);
			question.setHint("");
			question.setCorrectFeedback("");
			question.setIncorrectFeedback("");
			question.setCorrectFollowUpQuestionList(new BigInteger("2"));
			question.setIncorrectFollowUpQuestionList(new BigInteger("3"));
			item.setQuestionList(questionList);
			
			ItemList itemlist = factory.createItemList();
			itemlist.getItem().add(item);
			
			
			JAXBContext context = JAXBContext.newInstance("generated");
			JAXBElement element = factory.createItemList(itemlist) ; 
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
			marshaller.marshal(element,System.out);
			System.out.println();
			
		}catch(Exception e)
		{
			System.out.println("Exception occured when generating xmls : "+e.getMessage());
			e.printStackTrace();
		}
	}

}
