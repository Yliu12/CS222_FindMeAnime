package edu.bsu.cs222.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import edu.bsu.cs222.findMeAnAnime.AnimeSelector;

public class GenreSelectorFrame extends JFrame {

	private static final long serialVersionUID = 4870514433478067637L;

	private final JButton sliceOfLifeButton = new JButton();
	private final JButton adventureButton = new JButton();
	private final JButton scifiButton = new JButton();
	private final JButton comedyButton = new JButton();
	private final JButton mechaButton = new JButton();
	private final JButton romanceButton = new JButton();
	private final JButton actionButton = new JButton();
	private final JButton dramaButton = new JButton();

	private final JButton continueButton = new JButton();
	private final JButton resetButton = new JButton();
	private final JButton backToStart = new JButton();

	private JLabel genresbackground = new JLabel();

	private int buttonPressedCounter = 0;
	private String anime;

	static Logger log = Logger.getLogger(GenreSelectorFrame.class.getName());

	public GenreSelectorFrame() throws IOException {
		setResizable(false);
		getContentPane().setLayout(null);

		// Adventure Button
		adventureButton.setBounds(47, 116, 150, 150);
		adventureButton.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/AdventureIcon.jpg")));
		adventureButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				adventureButton.setBounds(47, 110, 150, 150);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				adventureButton.setBounds(47, 116, 150, 150);
			}
		});
		adventureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adventureButton.setEnabled(false);
				try {
					AnimeSelector.disableAllThatAreNot("adventure");
				} catch (SAXException | IOException
						| ParserConfigurationException e) {
					e.printStackTrace();
				}
				log.info("disabled all anime that arent adventure");
				buttonFunctionWhenPressed();
			}
		});
		getContentPane().add(adventureButton);

		// Slice of Life Button
		sliceOfLifeButton.setBounds(204, 116, 150, 150);
		sliceOfLifeButton.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/SliceofLifeIcon.jpg")));
		sliceOfLifeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				sliceOfLifeButton.setBounds(204, 110, 150, 150);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				sliceOfLifeButton.setBounds(204, 116, 150, 150);
			}
		});
		sliceOfLifeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sliceOfLifeButton.setEnabled(false);
				try {
					AnimeSelector.disableAllThatAreNot("sliceOfLife");
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				log.info("disabled all anime that arent slice of life");
				buttonFunctionWhenPressed();
			}
		});
		getContentPane().add(sliceOfLifeButton);

		// Sci-Fi Button
		scifiButton.setBounds(360, 116, 150, 150);
		scifiButton.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/ScifiIcon.jpg")));
		scifiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				scifiButton.setBounds(360, 110, 150, 150);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				scifiButton.setBounds(360, 116, 150, 150);
			}
		});
		scifiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scifiButton.setEnabled(false);
				try {
					AnimeSelector.disableAllThatAreNot("scifi");
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				log.info("disabled all anime that arent scifi");

				buttonFunctionWhenPressed();
			}
		});
		getContentPane().add(scifiButton);

		// Comedy Button
		comedyButton.setBounds(47, 278, 150, 150);
		comedyButton.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/ComedyIcon.jpg")));
		comedyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				comedyButton.setBounds(47, 284, 150, 150);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				comedyButton.setBounds(47, 278, 150, 150);
			}
		});
		comedyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comedyButton.setEnabled(false);
				try {
					AnimeSelector.disableAllThatAreNot("comedy");
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				log.info("disabled all anime that arent comedy");
				buttonFunctionWhenPressed();
			}
		});
		getContentPane().add(comedyButton);

		// Mecha Button
		mechaButton.setBounds(204, 278, 150, 150);
		mechaButton.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/MechaIcon.jpg")));
		mechaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				mechaButton.setBounds(204, 284, 150, 150);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mechaButton.setBounds(204, 278, 150, 150);
			}
		});
		mechaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mechaButton.setEnabled(false);
				try {
					AnimeSelector.disableAllThatAreNot("mecha");
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				log.info("disabled all anime that arent mecha");
				buttonFunctionWhenPressed();
			}
		});
		getContentPane().add(mechaButton);

		// Romance Button
		romanceButton.setBounds(516, 116, 150, 150);
		romanceButton.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/RomanceIcon.jpg")));
		romanceButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				romanceButton.setBounds(516, 110, 150, 150);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				romanceButton.setBounds(516, 116, 150, 150);
			}
		});
		romanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				romanceButton.setEnabled(false);
				try {
					AnimeSelector.disableAllThatAreNot("romance");
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				log.info("disabled all anime that arent romance");
				buttonFunctionWhenPressed();
			}
		});
		getContentPane().add(romanceButton);

		// Action Button
		actionButton.setBounds(360, 278, 150, 150);
		actionButton.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/ActionIcon.jpg")));
		actionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				actionButton.setBounds(360, 284, 150, 150);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				actionButton.setBounds(360, 278, 150, 150);
			}
		});
		actionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionButton.setEnabled(false);
				try {
					AnimeSelector.disableAllThatAreNot("action");
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				log.info("disabled all anime that arent action");
				buttonFunctionWhenPressed();
			}
		});
		getContentPane().add(actionButton);

		// Drama Button
		dramaButton.setBounds(516, 278, 150, 150);
		dramaButton.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/DramaIcon.jpg")));
		dramaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				dramaButton.setBounds(516, 284, 150, 150);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				dramaButton.setBounds(516, 278, 150, 150);
			}
		});
		dramaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dramaButton.setEnabled(false);
				try {
					AnimeSelector.disableAllThatAreNot("drama");
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				log.info("disabled all anime that arent drama");
				buttonFunctionWhenPressed();
			}
		});
		getContentPane().add(dramaButton);

		// Reset Button
		resetButton.setBounds(289, 460, 130, 26);
		resetButton.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/Reset.jpg")));
		resetButton.setEnabled(false);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				continueButton.setEnabled(false);
				makeAllButtonsEnabledAndVisible();
				buttonPressedCounter = 0;
				resetButton.setEnabled(false);
				AnimeSelector.getEnabledFiles().clear();
				try {
					AnimeSelector.failSafeEnableAll();
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				log.info("all anime have been enabled");
			}
		});
		getContentPane().add(resetButton);

		// Continue Button
		continueButton.setBounds(57, 460, 130, 26);
		continueButton.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/Continue.jpg")));
		continueButton.setEnabled(false);
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<String> finalList = new ArrayList<String>();

				finalList = AnimeSelector.getEnabledFiles();

				if (finalList.size() == 0) {

					NoMoreAnimeFrame.showNoMoreAnimeFrame();
				} else {
					if (StartFrame.checkIfQuickRecomendation()) {
						StartFrame.changeQuickRecomendation();

						finalList = AnimeSelector.getEnabledFiles();

						anime = getRandomAnime(finalList, anime);

						AnimeInformationPanel.showInfoPanel(anime);
						dispose();
						log.info("GenreSelectorFrame disposed");
					} else {

						try {
							QuestionFrame.showQuestionFrame();
						} catch (IOException e) {
							e.printStackTrace();
						}
						dispose();
						log.info("GenreSelectorFrame disposed");
					}
				}
			}
		});
		getContentPane().add(continueButton);
		backToStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					StartFrame.runStartFrame();
				} catch (SAXException | IOException
						| ParserConfigurationException e) {
					e.printStackTrace();
				}
				dispose();
				log.info("GenreSelectorFrame disposed");
			}
		});
		backToStart.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/backtostart.png")));
		backToStart.setBounds(508, 460, 158, 26);

		getContentPane().add(backToStart);

		// Background image
		genresbackground.setIcon(new ImageIcon(GenreSelectorFrame.class
				.getResource("/images/GenreBack.jpg")));
		genresbackground.setBounds(0, 0, 712, 497);
		getContentPane().add(genresbackground);

	}

	public void makeAllButtonsInvisible() {

		sliceOfLifeButton.setVisible(checkForEnabledButtons(sliceOfLifeButton));
		scifiButton.setVisible(checkForEnabledButtons(scifiButton));
		comedyButton.setVisible(checkForEnabledButtons(comedyButton));
		mechaButton.setVisible(checkForEnabledButtons(mechaButton));
		romanceButton.setVisible(checkForEnabledButtons(romanceButton));
		actionButton.setVisible(checkForEnabledButtons(actionButton));
		adventureButton.setVisible(checkForEnabledButtons(adventureButton));
		dramaButton.setVisible(checkForEnabledButtons(dramaButton));

	}

	public boolean checkForEnabledButtons(JButton button) {

		return !button.isEnabled();

	}

	public void buttonFunctionWhenPressed() {
		buttonPressedCounter++;
		if (buttonPressedCounter == 1) {
			resetButton.setEnabled(true);
			continueButton.setEnabled(true);
		}
		if (buttonPressedCounter == 2) {

			makeAllButtonsInvisible();
			buttonPressedCounter = 0;
			resetButton.setEnabled(true);
		}
	}

	public static String getRandomAnime(ArrayList<String> list, String anime) {
		Random myRandomizer = new Random();
		list = AnimeSelector.getEnabledFiles();

		if (list.size() > 1) {

			anime = list.get(myRandomizer.nextInt(list.size()));
		} else if (list.size() == 1) {
			anime = list.get(0);
		}

		else {
			anime = "none";
		}

		return anime;
	}

	public void makeAllButtonsEnabledAndVisible() {

		adventureButton.setEnabled(true);
		actionButton.setEnabled(true);
		romanceButton.setEnabled(true);
		mechaButton.setEnabled(true);
		comedyButton.setEnabled(true);
		scifiButton.setEnabled(true);
		sliceOfLifeButton.setEnabled(true);
		dramaButton.setEnabled(true);

		sliceOfLifeButton.setVisible(true);
		scifiButton.setVisible(true);
		comedyButton.setVisible(true);
		mechaButton.setVisible(true);
		romanceButton.setVisible(true);
		actionButton.setVisible(true);
		adventureButton.setVisible(true);
		dramaButton.setVisible(true);

	}

	public static void showGenreFrame() throws IOException {

		GenreSelectorFrame frame = new GenreSelectorFrame();
		frame.setSize(718, 525);
		frame.setTitle("Genres");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		log.info("GenreSelectorFrame opened");

	}

}
