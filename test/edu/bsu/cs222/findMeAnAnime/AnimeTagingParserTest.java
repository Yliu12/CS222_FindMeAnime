package edu.bsu.cs222.findMeAnAnime;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class AnimeTagingParserTest {

	// Tests that AnimeTagingParser can Switch the enabled tag of a anime
	@Test
	public void TestEnabledSwitcher() throws SAXException, IOException,
			ParserConfigurationException {

		// The file DeathNote
		AnimeTagingParser animeParsing = new AnimeTagingParser(
				"resources/xmlFiles/xml1.xml");
		animeParsing.getAnimeInformation();

		// Turns DeathNote to False
		animeParsing.enabledSwitcher("false");

		boolean actual = animeParsing.getBooleanValue("enabled");
		boolean expected = false;

		Assert.assertEquals(expected, actual);
	}

	// Tests that AnimeTagingParser can get the anime's filename
	@Test
	public void TestReturnFileName() throws SAXException, IOException,
			ParserConfigurationException {

		AnimeTagingParser animeParsing = new AnimeTagingParser(
				"resources/xmlFiles/xml1.xml");
		animeParsing.getAnimeInformation();

		String actual = animeParsing.returnFileName();
		String expected = "resources/xmlFiles/xml1.xml";

		Assert.assertEquals(expected, actual);
	}

	// Tests that AnimeTagingParser can get the anime name
	@Test
	public void TestGetAnimeName() throws SAXException, IOException,
			ParserConfigurationException {

		AnimeTagingParser animeParsing = new AnimeTagingParser(
				"resources/xmlFiles/xml1.xml");
		animeParsing.getAnimeInformation();

		String actual = animeParsing.getAnimeName();
		String expected = "DeathNote";

		Assert.assertEquals(expected, actual);
	}

	// Tests that AnimeTagingParser can get the correct boolean value from anime
	// tag
	@Test
	public void TestGetBooleanValue() throws SAXException, IOException,
			ParserConfigurationException {

		AnimeTagingParser animeParsing = new AnimeTagingParser(
				"resources/xmlFiles/xml1.xml");
		animeParsing.getAnimeInformation();

		boolean actual = animeParsing.getBooleanValue("drama");
		boolean expected = true;

		Assert.assertEquals(expected, actual);
	}

	// Tests that AnimeTagingParser can get the correct information from anime
	// file
	@Test
	public void TestGetStringValue() throws SAXException, IOException,
			ParserConfigurationException {

		AnimeTagingParser animeParsing = new AnimeTagingParser(
				"resources/xmlFiles/xml1.xml");
		animeParsing.getAnimeInformation();

		String actual = animeParsing.getStringValue("episodes");
		String expected = "37";

		Assert.assertEquals(expected, actual);
	}

}
