package edu.bsu.cs222.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import edu.bsu.cs222.findMeAnAnime.AnimeSelector;
import edu.bsu.cs222.findMeAnAnime.AnimeTagingParser;

public class AnimeInformationPanel extends JFrame {

	private static final long serialVersionUID = -8903695070901721301L;

	private static Logger log = Logger.getLogger(GenreSelectorFrame.class
			.getName());

	public AnimeInformationPanel(final String anime) {
		setResizable(false);
		getContentPane().setLayout(null);

		final AnimeTagingParser animeTags = new AnimeTagingParser(anime);
		animeTags.getAnimeInformation();

		// Makes sure the anime cannot be brought up again in same instance
		try {
			AnimeSelector.disable(animeTags.getStringValue("name"));
		} catch (SAXException | IOException | ParserConfigurationException e1) {
			e1.printStackTrace();
		}

		// Gets the anime picture
		JLabel animePicture = new JLabel();
		animePicture.setBounds(708, 0, 342, 291);
		getContentPane().add(animePicture);
		animePicture.setIcon(new ImageIcon(AnimeInformationPanel.class
				.getResource("/pictures/" + animeTags.getStringValue("name")
						+ ".jpg")));

		// Get the name of the anime
		JLabel animeTitle = new JLabel(animeTags.getStringValue("name"));
		animeTitle.setForeground(Color.WHITE);
		animeTitle.setFont(new Font("DialogInput", Font.BOLD, 25));
		animeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		animeTitle.setBounds(84, 46, 593, 41);
		getContentPane().add(animeTitle);

		// Gets the studio of the anime
		JLabel animeStudio = new JLabel(animeTags.getStringValue("studio"));
		animeStudio.setForeground(Color.BLUE);
		animeStudio.setFont(new Font("DialogInput", Font.BOLD, 13));
		animeStudio.setBounds(145, 172, 247, 28);
		getContentPane().add(animeStudio);

		// Gets the creator of the series
		JLabel animeCreator = new JLabel(animeTags.getStringValue("creator"));
		animeCreator.setForeground(new Color(128, 0, 0));
		animeCreator.setFont(new Font("DialogInput", Font.BOLD, 13));
		animeCreator.setBounds(145, 258, 222, 28);
		getContentPane().add(animeCreator);

		// Gets the director of the anime
		JLabel animeDirector = new JLabel(animeTags.getStringValue("director"));
		animeDirector.setForeground(new Color(0, 128, 0));
		animeDirector.setFont(new Font("DialogInput", Font.BOLD, 13));
		animeDirector.setBounds(145, 211, 222, 28);
		getContentPane().add(animeDirector);

		// Gets the number of episodes of the anime
		JLabel numberOfEpisodes = new JLabel(
				animeTags.getStringValue("episodes"));
		numberOfEpisodes.setForeground(new Color(128, 0, 128));
		numberOfEpisodes.setFont(new Font("DialogInput", Font.BOLD, 13));
		numberOfEpisodes.setBounds(573, 172, 222, 28);
		getContentPane().add(numberOfEpisodes);

		// Gets the categories of the anime
		JLabel animeCategories = new JLabel(
				animeTags.getStringValue("category"));
		animeCategories.setHorizontalAlignment(SwingConstants.CENTER);
		animeCategories.setForeground(Color.WHITE);
		animeCategories.setFont(new Font("DialogInput", Font.BOLD, 10));
		animeCategories.setBounds(189, 113, 432, 28);
		getContentPane().add(animeCategories);

		// Gets the anime's summary
		JTextPane animeSummary = new JTextPane();
		animeSummary.setEditable(false);
		animeSummary.setText(animeTags.getStringValue("summary"));
		animeSummary.setFont(new Font("Calibri", Font.PLAIN, 11));
		animeSummary.setBounds(407, 351, 621, 195);
		getContentPane().add(animeSummary);

		// Gets the year the anime first aired
		JLabel firstYearAired = new JLabel(animeTags.getStringValue("year"));
		firstYearAired.setFont(new Font("DialogInput", Font.BOLD, 11));
		firstYearAired.setBounds(597, 219, 156, 28);
		getContentPane().add(firstYearAired);

		// Gets the My Anime List rating for the anime
		JLabel standardizedRating = new JLabel(
				animeTags.getStringValue("rating"));
		standardizedRating.setFont(new Font("DialogInput", Font.BOLD, 11));
		standardizedRating.setBounds(530, 258, 87, 28);
		getContentPane().add(standardizedRating);

		// exit button
		JButton exitButton = new JButton();
		exitButton.setIcon(new ImageIcon(AnimeInformationPanel.class
				.getResource("/images/thanks.png")));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				log.info("AnimeInformationPanel disposed");
			}
		});
		exitButton.setFont(new Font("pressStart2P", Font.PLAIN, 10));
		exitButton.setBounds(10, 358, 357, 36);
		getContentPane().add(exitButton);

		// Button that copies link of hulu stream or google search to user
		// clipboard
		JButton linkToStreamButton = new JButton();
		linkToStreamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log.info("Opening up browser....");
				String url = animeTags.getStringValue("link");
				try {
					java.awt.Desktop.getDesktop().browse(
							java.net.URI.create(url));
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		linkToStreamButton.setIcon(new ImageIcon(AnimeInformationPanel.class
				.getResource("/images/watch.png")));
		linkToStreamButton.setFont(new Font("pressStart2P", Font.PLAIN, 10));
		linkToStreamButton.setBounds(10, 405, 357, 36);
		getContentPane().add(linkToStreamButton);

		// back to start button
		JButton backToStartButton = new JButton();
		backToStartButton.setIcon(new ImageIcon(AnimeInformationPanel.class
				.getResource("/images/home.png")));
		backToStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					AnimeSelector.failSafeEnableAll();
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}

				try {
					StartFrame.runStartFrame();
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}

				dispose();
			}
		});
		backToStartButton.setBounds(10, 452, 357, 36);
		getContentPane().add(backToStartButton);

		// Gets another anime with same critieria
		final JButton getNextSimilarAnimeButton = new JButton();
		getNextSimilarAnimeButton.setIcon(new ImageIcon(
				AnimeInformationPanel.class.getResource("/images/next.png")));
		getNextSimilarAnimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				log.info("Checking if next anime available....");

				Random myRandomizer = new Random();
				String newAnime = null;

				if (AnimeSelector.getEnabledFiles().size() > 1) {

					newAnime = AnimeSelector.getEnabledFiles().get(
							myRandomizer.nextInt(AnimeSelector
									.getEnabledFiles().size()));

					try {
						AnimeSelector.disable(animeTags.getStringValue("name"));
					} catch (SAXException | IOException
							| ParserConfigurationException e) {
						e.printStackTrace();
					}

					AnimeInformationPanel.showInfoPanel(newAnime);

					dispose();
				} else if (AnimeSelector.getEnabledFiles().size() == 1) {
					newAnime = AnimeSelector.getEnabledFiles().get(0);

					try {
						AnimeSelector.disable(animeTags.getStringValue("name"));
					} catch (SAXException | IOException
							| ParserConfigurationException e) {

						e.printStackTrace();
					}

					AnimeInformationPanel.showInfoPanel(newAnime);

					dispose();
				}
				if (AnimeSelector.getEnabledFiles().size() == 0) {
					log.info("Next anime doesnt exist!");

					NoMoreAnimeFrame.showNoMoreAnimeFrame();
				}

			}

		});
		getNextSimilarAnimeButton.setFont(new Font("pressStart2P", Font.PLAIN,
				10));
		getNextSimilarAnimeButton.setBounds(10, 499, 357, 36);
		getContentPane().add(getNextSimilarAnimeButton);

		// frame background
		JLabel background = new JLabel();
		String recommended;
		if (animeTags.getBooleanValue("devRating")) {
			recommended = "AnimeInforec";
		} else {

			recommended = "AnimeInfo";
		}
		background.setIcon(new ImageIcon(AnimeInformationPanel.class
				.getResource("/images/" + recommended + ".png")));
		background.setBounds(0, 0, 1050, 565);
		getContentPane().add(background);

	}

	public static void showInfoPanel(String anime) {
		log.info("Bringing up anime info....");
		AnimeInformationPanel infopanel = new AnimeInformationPanel(anime);
		infopanel.setSize(1056, 593);
		infopanel.setTitle("Anime Information");
		infopanel.setLocationRelativeTo(null);
		infopanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infopanel.setVisible(true);
		log.info("Anime displayed! xml disabled.");

	}

}
