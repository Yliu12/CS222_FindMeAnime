package edu.bsu.cs222.ui;

import java.awt.Font;
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

public class StartFrame extends JFrame {

	private static final long serialVersionUID = 834570065890776803L;

	private final JButton quickRecButton = new JButton();
	private final JButton luckyButton = new JButton();
	private final JButton startButton = new JButton();
	private final JLabel startBackground = new JLabel();

	public static boolean quickRecomendation = false;
	private static Random myRandomizer = new Random();
	private final JButton instructionButton = new JButton();

	static Logger log = Logger.getLogger(StartFrame.class.getName());

	public StartFrame() throws IOException {

		setResizable(false);
		getContentPane().setLayout(null);

		// Quick recommendation button
		quickRecButton.setBounds(357, 287, 260, 38);
		quickRecButton.setIcon(new ImageIcon(StartFrame.class
				.getResource("/images/Quick.png")));
		quickRecButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				quickRecButton.setBounds(357, 295, 260, 38);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				quickRecButton.setBounds(357, 287, 260, 38);
			}
		});
		quickRecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				quickRecomendation = true;
				log.debug("quickRecomendation is set to true");
				try {
					AnimeSelector.failSafeEnableAll();
				} catch (SAXException | IOException
						| ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				log.info("all anime have been enabled");
				try {
					GenreSelectorFrame.showGenreFrame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
				log.info("StartFrame disposed");

			}
		});
		getContentPane().add(quickRecButton);

		// I'm feelin' Lucky Button
		luckyButton.setBounds(427, 336, 190, 38);
		luckyButton.setIcon(new ImageIcon(StartFrame.class
				.getResource("/images/Feelin lucky.png")));
		luckyButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				luckyButton.setBounds(427, 344, 190, 38);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				luckyButton.setBounds(427, 336, 190, 38);
			}
		});

		luckyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> listOfAnime = new ArrayList<String>();

				try {
					AnimeSelector.failSafeEnableAll();
				} catch (SAXException | IOException
						| ParserConfigurationException e) {
					e.printStackTrace();
				}
				log.info("all anime have been enabled");
				listOfAnime = AnimeSelector.getEnabledFiles();

				String selectedAnime = listOfAnime.get(myRandomizer
						.nextInt(listOfAnime.size()));

				AnimeInformationPanel.showInfoPanel(selectedAnime);

				dispose();
				log.info("StartFrame disposed");

			}
		});
		getContentPane().add(luckyButton);

		// Start Button
		startButton.setIcon(new ImageIcon(StartFrame.class
				.getResource("/images/start.png")));
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				startButton.setBounds(527, 246, 90, 38);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				startButton.setBounds(527, 238, 90, 38);
			}
		});

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				QuestionFrame.questionNumber = 1;
				changeQuickRecomendation();

				log.debug("quickRecomendation is set to false");
				try {
					AnimeSelector.failSafeEnableAll();
				} catch (SAXException | IOException
						| ParserConfigurationException e) {
					e.printStackTrace();
				}
				log.info("all anime have been enabled");
				try {
					GenreSelectorFrame.showGenreFrame();
				} catch (IOException e) {
					e.printStackTrace();
				}
				dispose();
				log.info("StartFrame disposed");
			}
		});
		startButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		startButton.setBounds(527, 238, 90, 38);
		getContentPane().add(startButton);

		// Instruction Button
		instructionButton.setIcon(new ImageIcon(StartFrame.class
				.getResource("/images/instuctions.png")));
		instructionButton.setBounds(464, 389, 153, 38);
		instructionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				instructionButton.setBounds(464, 397, 153, 38);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				instructionButton.setBounds(464, 389, 153, 38);
			}
		});
		instructionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructionsFrame.setInstructionPageToOne();
				log.info("instruction page set to page 1");
				InstructionsFrame.showInstructionPanel();
			}
		});
		instructionButton.setIcon(new ImageIcon(StartFrame.class
				.getResource("/images/instuctions.png")));
		instructionButton.setBounds(464, 389, 153, 38);

		getContentPane().add(instructionButton);

		// Background image
		startBackground.setIcon(new ImageIcon(StartFrame.class
				.getResource("/images/StartBack.jpg")));
		startBackground.setBounds(0, 0, 660, 438);
		getContentPane().add(startBackground);
	}

	public static boolean checkIfQuickRecomendation() {
		return quickRecomendation;
	}

	public static void changeQuickRecomendation() {
		quickRecomendation = false;
	}

	public static void runStartFrame() throws SAXException, IOException,
			ParserConfigurationException {

		AnimeSelector.failSafeEnableAll();
		log.info("all anime have been enabled");
		StartFrame frame = new StartFrame();
		frame.setSize(658, 466);
		frame.setTitle("Home");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		log.info("StartFrame opened");

	}

	public static void main(String[] args) throws SAXException, IOException,
			ParserConfigurationException {

		runStartFrame();
	}

}
