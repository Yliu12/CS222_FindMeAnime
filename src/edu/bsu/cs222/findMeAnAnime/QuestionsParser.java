package edu.bsu.cs222.findMeAnAnime;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class QuestionsParser {
	private String question, answer1, answer2;

	public void getQuestionInformation(String fileName) {

		try {

			File fXmlFile = new File(fileName);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			Document doc = documentBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
			question = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "question"), question);
			answer1 = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "answer1"), answer1);
			answer2 = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "answer2"), answer2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer1() {
		return answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

}
