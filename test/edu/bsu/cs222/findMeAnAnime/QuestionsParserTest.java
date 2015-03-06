package edu.bsu.cs222.findMeAnAnime;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class QuestionsParserTest {
	
	// Tests that QuestionParser can get correct question information
	@Test
	public void TestGetAnswer1() throws SAXException, IOException,
			ParserConfigurationException {

		QuestionsParser questionParsing = new QuestionsParser();
		
		questionParsing.getQuestionInformation("resources/questions/question1.xml");
		

		String actual = questionParsing.getAnswer1();
		String expected = "Male";

		Assert.assertEquals(expected, actual);
	}

}
