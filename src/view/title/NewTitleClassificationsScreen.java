package view.title;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.KeyController;
import view.title.register.NewLiveConcertScreen;
import view.title.register.NewMovieScreen;
import view.title.register.NewBoxSetScreen;
import view.title.register.NewMusicScreen;

public class NewTitleClassificationsScreen {

	private JFrame titleClassifications = new JFrame();
	private KeyController listenerController = new KeyController(titleClassifications);

	public NewTitleClassificationsScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public void setAttributes() {
		titleClassifications.setSize(950, 280);
		titleClassifications.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		titleClassifications.setUndecorated(true);
		titleClassifications.setVisible(true);
		titleClassifications.setResizable(false);
		titleClassifications.setTitle("Choose Title Classification");
		titleClassifications.setLocationRelativeTo(null);
		titleClassifications.setIconImage(new ImageIcon("img\\icons\\logo.png").getImage());
		
		titleClassifications.addKeyListener(listenerController);
		titleClassifications.addWindowListener(listenerController);
		titleClassifications.addMouseListener(listenerController);
		titleClassifications.addMouseMotionListener(listenerController);
	}

	private void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		titleClassifications.add(backPanel);
		
		closeBtn(backPanel);
		
		JLabel musicLabel = new JLabel("New Music");
		musicLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		musicLabel.setBounds(90, 15, 200, 30);
		musicLabel.setForeground(Color.WHITE);
		backPanel.add(musicLabel);

		JLabel liveConcertLabel = new JLabel("New Live Concert");
		liveConcertLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		liveConcertLabel.setBounds(288, 15, 250, 30);
		liveConcertLabel.setForeground(Color.WHITE);
		backPanel.add(liveConcertLabel);

		JLabel movieLabel = new JLabel("New Movie");
		movieLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		movieLabel.setBounds(537, 15, 250, 30);
		movieLabel.setForeground(Color.WHITE);
		backPanel.add(movieLabel);

		JLabel boxSetLabel = new JLabel("New Box Set");
		boxSetLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boxSetLabel.setBounds(755, 15, 250, 30);
		boxSetLabel.setForeground(Color.WHITE);
		backPanel.add(boxSetLabel);

		buttons(backPanel);
	}

	public void buttons(JPanel backPanel) {
		// ---------------------------MUSIC BUTTON-------------------------------
		JButton musicBtn = new JButton();
		musicBtn.setIcon(new ImageIcon("img\\btn\\musicbtn.png"));
//				pressClose.setIcon(new ImageIcon("img\\btn\\goback.png"));
		musicBtn.setBounds(30, 50, 200, 200);
		musicBtn.setBorderPainted(false);
		musicBtn.setContentAreaFilled(false);
		musicBtn.setFocusPainted(false);
		backPanel.add(musicBtn);
		musicBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleClassifications.dispose();
				new NewMusicScreen();
			}
		});
		musicBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				musicBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				musicBtn.setIcon(new ImageIcon("img\\btn\\hover\\musicbtnhover.png"));
				musicBtn.setBounds(25, 45, 210, 210);
			}

			public void mouseExited(MouseEvent evt) {
				musicBtn.setIcon(new ImageIcon("img\\btn\\musicbtn.png"));
				musicBtn.setBounds(30, 50, 200, 200);
			}
		});
		// ---------------------------LIVE CONCERT BUTTON-------------------------------
		JButton LiveConcertBtn = new JButton();
		LiveConcertBtn.setIcon(new ImageIcon("img\\btn\\liveconcertbtn.png"));
//				pressClose.setIcon(new ImageIcon("img\\btn\\goback.png"));
		LiveConcertBtn.setBounds(255, 50, 200, 200);
		LiveConcertBtn.setBorderPainted(false);
		LiveConcertBtn.setContentAreaFilled(false);
		LiveConcertBtn.setFocusPainted(false);
		backPanel.add(LiveConcertBtn);
		LiveConcertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleClassifications.dispose();
				new NewLiveConcertScreen();
			}
		});
		LiveConcertBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				LiveConcertBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				LiveConcertBtn.setIcon(new ImageIcon("img\\btn\\hover\\liveconcertbtnhover.png"));
				LiveConcertBtn.setBounds(250, 45, 210, 210);
			}

			public void mouseExited(MouseEvent evt) {
				LiveConcertBtn.setIcon(new ImageIcon("img\\btn\\liveconcertbtn.png"));
				LiveConcertBtn.setBounds(255, 50, 200, 200);
			}
		});
		// ---------------------------MOVIE BUTTON-------------------------------
		JButton movieBtn = new JButton();
		movieBtn.setIcon(new ImageIcon("img\\btn\\moviebtn.png"));
//				pressClose.setIcon(new ImageIcon("img\\btn\\goback.png"));
		movieBtn.setBounds(480, 50, 200, 200);
		movieBtn.setBorderPainted(false);
		movieBtn.setContentAreaFilled(false);
		movieBtn.setFocusPainted(false);
		backPanel.add(movieBtn);
		movieBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleClassifications.dispose();
				new NewMovieScreen();
			}
		});
		movieBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				movieBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				movieBtn.setIcon(new ImageIcon("img\\btn\\hover\\moviebtnhover.png"));
				movieBtn.setBounds(475, 45, 210, 210);
			}

			public void mouseExited(MouseEvent evt) {
				movieBtn.setIcon(new ImageIcon("img\\btn\\moviebtn.png"));
				movieBtn.setBounds(480, 50, 200, 200);
			}
		});
		// ---------------------------BOX SET BUTTON-------------------------------
		JButton boxSetBtn = new JButton();
		boxSetBtn.setIcon(new ImageIcon("img\\btn\\boxsetbtn.png"));
//						pressClose.setIcon(new ImageIcon("img\\btn\\goback.png"));
		boxSetBtn.setBounds(705, 50, 200, 200);
		boxSetBtn.setBorderPainted(false);
		boxSetBtn.setContentAreaFilled(false);
		boxSetBtn.setFocusPainted(false);
		backPanel.add(boxSetBtn);
		boxSetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleClassifications.dispose();
				new NewBoxSetScreen();
			}
		});
		boxSetBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				boxSetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				boxSetBtn.setIcon(new ImageIcon("img\\btn\\hover\\boxsetbtnhover.png"));
				boxSetBtn.setBounds(700, 45, 210, 210);
			}

			public void mouseExited(MouseEvent evt) {
				boxSetBtn.setIcon(new ImageIcon("img\\btn\\boxsetbtn.png"));
				boxSetBtn.setBounds(705, 50, 200, 200);
			}
		});
	}

	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
		closeBtn.setBounds(900, 14, 30, 30);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleClassifications.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closebtnsmallhover.png"));
				closeBtn.setBounds(897, 10, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
				closeBtn.setBounds(900, 14, 30, 30);
			}
		});
	}
	
	public void validation() {
		titleClassifications.repaint();
		titleClassifications.validate();
	}
}
