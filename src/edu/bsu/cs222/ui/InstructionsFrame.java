package edu.bsu.cs222.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InstructionsFrame extends JFrame {

	private static final long serialVersionUID = -8157521579382269550L;

	private static int instructionPage = 1;

	private static String buttonImage = "nextInstr";

	public InstructionsFrame() {
		getContentPane().setLayout(null);

		JButton nextButton = new JButton();
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (instructionPage == 4) {

				} else {
					instructionPage++;
					showInstructionPanel();
				}
				dispose();

			}

		});
		nextButton.setIcon(new ImageIcon(InstructionsFrame.class
				.getResource("/images/" + buttonImage + ".jpg")));
		nextButton.setBounds(627, 570, 149, 30);
		getContentPane().add(nextButton);

		JLabel backgroundInstructions = new JLabel("New label");
		backgroundInstructions.setIcon(new ImageIcon(InstructionsFrame.class
				.getResource("/images/inst" + instructionPage + ".png")));
		backgroundInstructions.setBounds(0, 0, 800, 600);
		getContentPane().add(backgroundInstructions);

	}

	public static void setInstructionPageToOne() {

		instructionPage = 1;
	}

	public static void showInstructionPanel() {

		InstructionsFrame infopanel = new InstructionsFrame();
		infopanel.setSize(817, 638);
		infopanel.setTitle("Instructions");
		infopanel.setLocationRelativeTo(null);
		infopanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infopanel.setVisible(true);

	}
}
