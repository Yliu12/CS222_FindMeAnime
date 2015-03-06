package edu.bsu.cs222.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import edu.bsu.cs222.findMeAnAnime.AnimeSelector;
import edu.bsu.cs222.findMeAnAnime.QuestionsParser;

public class QuestionFrame extends JFrame {

	private static final long serialVersionUID = 6254269700186398626L;

	private final JButton answerButton1 = new JButton();
	private final JButton answerButton2 = new JButton();
	private final JButton doesntMatterButton = new JButton();

	private AnimeSelector animeList = new AnimeSelector();
	private ArrayList<String> finalList = new ArrayList<String>();
	public static int questionNumber = 1;
	private String anime;
	public boolean inQuestions = true;

	private static Logger log = Logger.getLogger(GenreSelectorFrame.class
			.getName());

	public QuestionFrame() throws IOException {
		setResizable(false);

		finalList.addAll(AnimeSelector.getEnabledFiles());

		getContentPane().setLayout(null);

		final QuestionsParser selectedQuestion = new QuestionsParser();
		selectedQuestion.getQuestionInformation("resources/questions/question"
				+ questionNumber + ".xml");

		// Answer 1
		answerButton1.setText(selectedQuestion.getAnswer1());
		answerButton1.setBounds(214, 257, 373, 52);
		answerButton1.setFont(new Font("Calibri", Font.BOLD, 16));
		getContentPane().add(answerButton1);

		// Answer 2
		answerButton2.setText(selectedQuestion.getAnswer2());
		answerButton2.setBounds(214, 320, 373, 52);
		answerButton2.setFont(new Font("Calibri", Font.BOLD, 16));
		getContentPane().add(answerButton2);

		// Doesn't Matter answer
		doesntMatterButton.setText("Doesn't Matter\r\n");
		doesntMatterButton.setBounds(214, 383, 373, 52);
		doesntMatterButton.setFont(new Font("Calibri", Font.BOLD, 16));
		getContentPane().add(doesntMatterButton);

		// Back to Home button
		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					StartFrame.runStartFrame();
				} catch (SAXException | IOException
						| ParserConfigurationException e) {
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(QuestionFrame.class
				.getResource("/images/restart.png")));
		btnNewButton.setBounds(582, 22, 206, 38);
		getContentPane().add(btnNewButton);

		// Question
		JLabel question = new JLabel(selectedQuestion.getQuestion());
		question.setBackground(Color.BLUE);
		question.setBounds(38, 130, 727, 38);
		question.setFont(new Font("DialogInput", Font.BOLD, 16));
		question.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(question);

		// Background
		JLabel background = new JLabel("New label");
		background.setBounds(0, 0, 800, 507);
		getContentPane().add(background);
		background.setIcon(new ImageIcon(QuestionFrame.class
				.getResource("/images/Q" + questionNumber + ".png")));

		// Answer 1 button action
		answerButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				log.info("answer one chosen, Disabling invalid anime....");

				if (questionNumber == 1) {
					ifQuestion(animeList, "q1a1");
				}
				if (questionNumber == 2) {
					ifQuestion(animeList, "q2a1");
				}
				if (questionNumber == 3) {
					ifQuestion(animeList, "q3a1");
				}
				if (questionNumber == 4) {
					ifQuestion(animeList, "q4a1");
				}
				if (questionNumber == 5) {
					ifQuestion(animeList, "q5a1");
				}
				if (questionNumber == 6) {
					ifQuestion(animeList, "q6a1");
				}
				if (questionNumber == 7) {
					ifQuestion(animeList, "q7a1");
				}
				if (questionNumber == 8) {
					ifQuestion(animeList, "q8a1");
				}
				if (questionNumber == 9) {
					ifQuestion(animeList, "q9a1");
				}
				if (questionNumber == 10) {
					ifQuestion(animeList, "q10a1");
				}
				try {
					getAnimeInformation();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				log.info("invalid anime disabled");
			}
		});

		// Answer 2 button action
		answerButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log.info("answer one chosen, Disabling invalid anime....");
				if (questionNumber == 1) {
					questionNumber = 1;
					ifQuestion(animeList, "q1a2");
				}
				if (questionNumber == 2) {
					ifQuestion(animeList, "q2a2");
				}
				if (questionNumber == 3) {
					ifQuestion(animeList, "q3a2");
				}
				if (questionNumber == 4) {
					ifQuestion(animeList, "q4a2");
				}
				if (questionNumber == 5) {
					ifQuestion(animeList, "q5a2");
				}
				if (questionNumber == 6) {
					ifQuestion(animeList, "q6a2");
				}
				if (questionNumber == 7) {
					ifQuestion(animeList, "q7a2");
				}
				if (questionNumber == 8) {
					ifQuestion(animeList, "q8a2");
				}
				if (questionNumber == 9) {
					ifQuestion(animeList, "q9a2");
				}
				if (questionNumber == 10) {
					ifQuestion(animeList, "q10a2");
				}
				try {
					getAnimeInformation();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				log.info("invalid anime disabled");
			}
		});

		// Doesn't matter button action
		doesntMatterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					getAnimeInformation();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void ifQuestion(AnimeSelector list, String tag) {
		try {
			AnimeSelector.disableAllThatAreNot(tag);
		} catch (SAXException | IOException | ParserConfigurationException e1) {
			e1.printStackTrace();
		}

	}

	public void getAnimeInformation() throws IOException {

		questionNumber++;
		if (questionNumber == 11) {
			log.info("fetching valid anime.....");
			questionNumber = 1;

			anime = GenreSelectorFrame.getRandomAnime(finalList, anime);

			if (anime == "none") {
				log.info("none found!");
				NoMoreAnimeFrame.showNoMoreAnimeFrame();
				answerButton1.setEnabled(false);
				answerButton2.setEnabled(false);
				doesntMatterButton.setEnabled(false);
			} else {

				log.info("anime found!");
				AnimeInformationPanel.showInfoPanel(anime);

				dispose();
				log.info("QuestionFrame disposed");
			}
		} else {
			log.info("getting next Question...");
			dispose();
			QuestionFrame.showQuestionFrame();
		}

	}

	public static void showQuestionFrame() throws IOException {
		QuestionFrame frame = new QuestionFrame();
		frame.setSize(805, 535);
		frame.setTitle("Question");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		log.info("QuestionFrame opened");

	}
}
