package edu.bsu.cs222.findMeAnAnime;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class AnimeTagingParser {

	private String category, episodes, creator, director, studio, year, rating,
			summary, name, link, fileName;

	private boolean enabled, action, adventure, comedy, romance, mecha,
			sliceOfLife, drama, scifi, q1a1, q1a2, q2a1, q2a2, q3a1, q3a2,
			q4a1, q4a2, q5a1, q5a2, q6a1, q6a2, q7a1, q7a2, q8a1, q8a2, q9a1,
			q9a2, q10a1, q10a2, recomended;

	public AnimeTagingParser(String fileName) {

		this.fileName = fileName;
	}

	public void getAnimeInformation() {

		try {

			File fXmlFile = new File(fileName);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			Document doc = documentBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			name = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "name"), name);
			enabled = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "enabled"), enabled);
			action = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "action"), action);
			adventure = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "adventure"), adventure);
			comedy = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "comedy"), comedy);
			romance = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "romance"), romance);
			mecha = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "mecha"), mecha);
			sliceOfLife = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "sliceoflife"), sliceOfLife);
			drama = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "drama"), drama);
			scifi = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "scifi"), scifi);
			q1a1 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q1a1"), q1a1);
			q1a2 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q1a2"), q1a2);
			q2a1 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q2a1"), q2a1);
			q2a2 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q2a2"), q2a2);
			q3a1 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q3a1"), q3a1);
			q3a2 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q3a2"), q3a2);
			q4a1 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q4a1"), q4a1);
			q4a2 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q4a2"), q4a2);
			q5a1 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q5a1"), q5a1);
			q5a2 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q5a2"), q5a2);
			q6a1 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q6a1"), q6a1);
			q6a2 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q6a2"), q6a2);
			q7a1 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q7a1"), q7a1);
			q7a2 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q7a2"), q7a2);
			q8a1 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q8a1"), q8a1);
			q8a2 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q8a2"), q8a2);
			q9a1 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q9a1"), q9a1);
			q9a2 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q9a2"), q9a2);
			q10a1 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q10a1"), q10a1);
			q10a2 = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "Q10a2"), q10a2);
			recomended = XmlParsing.setBooleanInVariable(
					XmlParsing.setNodeList(doc, "urating"), recomended);
			category = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "category"), category);
			episodes = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "episodes"), episodes);
			creator = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "creator"), creator);
			director = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "director"), director);
			studio = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "studio"), studio);
			year = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "year"), year);
			rating = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "srating"), rating);
			summary = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "summary"), summary);
			link = XmlParsing.setStringInVariable(
					XmlParsing.setNodeList(doc, "link"), link);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getAnimeName() {
		return name;
	}

	public boolean getBooleanValue(String variableName) {
		Map<String, Boolean> map = new HashMap<>();

		map.put("enabled", enabled);
		map.put("action", action);
		map.put("adventure", adventure);
		map.put("comedy", comedy);
		map.put("romance", romance);
		map.put("mecha", mecha);
		map.put("sliceOfLife", sliceOfLife);
		map.put("drama", drama);
		map.put("scifi", scifi);
		map.put("q1a1", q1a1);
		map.put("q1a2", q1a2);
		map.put("q2a1", q2a1);
		map.put("q2a2", q2a2);
		map.put("q3a1", q3a1);
		map.put("q3a2", q3a2);
		map.put("q4a1", q4a1);
		map.put("q4a2", q4a2);
		map.put("q5a1", q5a1);
		map.put("q5a2", q5a2);
		map.put("q6a1", q6a1);
		map.put("q6a2", q6a2);
		map.put("q7a1", q7a1);
		map.put("q7a2", q7a2);
		map.put("q8a1", q8a1);
		map.put("q8a2", q8a2);
		map.put("q9a1", q9a1);
		map.put("q9a2", q9a2);
		map.put("q10a1", q10a1);
		map.put("q10a2", q10a2);
		map.put("devRating", recomended);
		boolean result = map.get(variableName);

		return result;

	}

	public String getStringValue(String variableName) {
		Map<String, String> map = new HashMap<>();

		map.put("category", category);
		map.put("episodes", episodes);
		map.put("creator", creator);
		map.put("director", director);
		map.put("studio", studio);
		map.put("year", year);
		map.put("rating", rating);
		map.put("summary", summary);
		map.put("name", name);
		map.put("link", link);

		String result = map.get(variableName);

		return result;

	}

	public void enabledSwitcher(String value) throws SAXException, IOException,
			ParserConfigurationException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(fileName);

		Node staff = doc.getElementsByTagName("enabled").item(0);

		staff.setTextContent(value);

		enabled = Boolean.valueOf(value);
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e1) {
			e1.printStackTrace();
		}
		DOMSource source = new DOMSource(doc);
		StreamResult modifiedXML = new StreamResult(new File(fileName));
		try {
			transformer.transform(source, modifiedXML);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	public String returnFileName() {

		return fileName;
	}

}
