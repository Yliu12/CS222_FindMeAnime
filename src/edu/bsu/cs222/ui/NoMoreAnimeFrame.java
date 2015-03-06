package edu.bsu.cs222.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

public class NoMoreAnimeFrame extends JFrame {

	private static final long serialVersionUID = 6277778249583955873L;

	private static Logger log = Logger.getLogger(GenreSelectorFrame.class
			.getName());

	public NoMoreAnimeFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setType(Type.UTILITY);
		getContentPane().setLayout(null);

		JLabel noMoreAnime = new JLabel(
				"We have no other anime that fits this critireia :(");

		noMoreAnime.setFont(new Font("DialogInput", Font.BOLD, 12));
		noMoreAnime.setHorizontalAlignment(SwingConstants.CENTER);
		noMoreAnime.setBounds(12, 13, 408, 121);
		getContentPane().add(noMoreAnime);

		JButton backToFrame = new JButton();
		backToFrame.setIcon(new ImageIcon(NoMoreAnimeFrame.class
				.getResource("/images/okfrownface.png")));
		backToFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		backToFrame.setBounds(156, 157, 113, 25);
		getContentPane().add(backToFrame);

		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(NoMoreAnimeFrame.class
				.getResource("/images/noMoreAnimeFrame.jpg")));
		background.setBounds(0, 0, 434, 264);
		getContentPane().add(background);
	}

	public static void showNoMoreAnimeFrame() {
		log.error("No more anime Available");
		NoMoreAnimeFrame infopanel = null;
		infopanel = new NoMoreAnimeFrame();
		infopanel.setSize(450, 260);
		infopanel.setLocationRelativeTo(null);
		infopanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		infopanel.setVisible(true);

	}

}
