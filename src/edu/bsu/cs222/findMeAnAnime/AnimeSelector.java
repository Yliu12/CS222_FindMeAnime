package edu.bsu.cs222.findMeAnAnime;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class AnimeSelector {

	public static void disableAllThatAreNot(String tag) throws SAXException,
			IOException, ParserConfigurationException {

		for (int i = 1; i <= 126; i++) {

			AnimeTagingParser animeList = new AnimeTagingParser(
					"resources/xmlFiles/xml" + i + ".xml");

			animeList.getAnimeInformation();

			boolean value = animeList.getBooleanValue(tag);

			if (animeList.getBooleanValue("enabled")) {

				if (value == false) {

					animeList.enabledSwitcher("false");

				} else {

				}
			}

		}

	}

	public static void disable(String tag) throws SAXException, IOException,
			ParserConfigurationException {

		for (int i = 1; i <= 126; i++) {

			AnimeTagingParser animeList = new AnimeTagingParser(
					"resources/xmlFiles/xml" + i + ".xml");

			animeList.getAnimeInformation();

			String value = animeList.getStringValue("name");

			if (value.equals(tag)) {

				animeList.enabledSwitcher("false");

			}

		}

	}

	public static ArrayList<String> getEnabledFiles() {

		ArrayList<String> enabledAnime = new ArrayList<String>();

		for (int i = 1; i <= 126; i++) {

			AnimeTagingParser animeList = new AnimeTagingParser(
					"resources/xmlFiles/xml" + i + ".xml");

			animeList.getAnimeInformation();

			if (animeList.getBooleanValue("enabled")) {

				enabledAnime.add(animeList.returnFileName());

			}
		}

		return enabledAnime;

	}

	public static ArrayList<String> getEnabledFilesName() {

		ArrayList<String> enabledAnime = new ArrayList<String>();

		for (int i = 1; i <= 126; i++) {

			AnimeTagingParser animeList = new AnimeTagingParser(
					"resources/xmlFiles/xml" + i + ".xml");

			animeList.getAnimeInformation();

			if (animeList.getBooleanValue("enabled")) {

				enabledAnime.add(animeList.getAnimeName());

			}
		}

		return enabledAnime;

	}

	public static void failSafeEnableAll() throws SAXException, IOException,
			ParserConfigurationException {

		for (int i = 1; i <= 126; i++) {

			AnimeTagingParser animeList = new AnimeTagingParser(
					"resources/xmlFiles/xml" + i + ".xml");

			animeList.getAnimeInformation();

			animeList.enabledSwitcher("true");
		}
	}

}
