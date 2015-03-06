package edu.bsu.cs222.findMeAnAnime;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParsing {

	public static NodeList setNodeList(Document selectedDoc, String tagName) {

		NodeList result = selectedDoc.getElementsByTagName(tagName);

		return result;

	}

	public static boolean setBooleanInVariable(NodeList listValue, boolean tag) {

		for (int temp = 0; temp < listValue.getLength(); temp++) {
			Node nNode = listValue.item(temp);
			tag = Boolean.valueOf(nNode.getTextContent());
		}
		return tag;

	}

	static public String setStringInVariable(NodeList listValue, String tag) {

		for (int temp = 0; temp < listValue.getLength(); temp++) {
			Node nNode = listValue.item(temp);
			tag = nNode.getTextContent();
		}

		return tag;
	}
}
