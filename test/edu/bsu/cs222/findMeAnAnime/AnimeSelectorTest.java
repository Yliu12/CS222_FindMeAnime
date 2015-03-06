package edu.bsu.cs222.findMeAnAnime;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class AnimeSelectorTest {

	// Tests that AnimeSelector can get disable all anime except for 
	// Slice of Life. 
	@Test
	public void TestDisableAllThatAreNot() throws SAXException, IOException,
			ParserConfigurationException {

		AnimeSelector.disableAllThatAreNot("sliceOfLife");

		int actual = AnimeSelector.getEnabledFiles().size();

		// Number of Slice of life anime available
		int expected = 25;

		Assert.assertEquals(expected, actual);
	}

	// Tests if AnimeSelector can enable all anime
	@Test
	public void TestFailSafeEnableAll() throws SAXException, IOException,
			ParserConfigurationException {

		AnimeSelector.disableAllThatAreNot("action");

		AnimeSelector.failSafeEnableAll();

		int actual = AnimeSelector.getEnabledFiles().size();

		// Number of all anime available
		int expected = 126;

		Assert.assertEquals(expected, actual);
	}

	// Tests that anime Selector can disable a selected anime
	@Test
	public void TestDisable() throws SAXException, IOException,
			ParserConfigurationException {

		AnimeSelector.failSafeEnableAll();

		AnimeSelector.disable("Naruto");

		int actual = AnimeSelector.getEnabledFiles().size();

		// Number of all anime available minus Naurto
		int expected = 125;

		Assert.assertEquals(expected, actual);
	}

}
