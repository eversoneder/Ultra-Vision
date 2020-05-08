package view.customer;

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

import model.customer.MembershipCard;
import model.enums.AccessLevel;
import model.titles.MusicOrLive;
import view.title.register.NewBoxSetScreen;

public class CustomerClassificationsScreen {

	private JFrame customerClassifications = new JFrame();

	private MembershipCard newMembershipCard;

	public CustomerClassificationsScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	private void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		customerClassifications.add(backPanel);

		JLabel musicLover = new JLabel("Music Lover");
		musicLover.setFont(new Font("Tahoma", Font.PLAIN, 18));
		musicLover.setBounds(87, 15, 200, 30);
		musicLover.setForeground(Color.WHITE);
		backPanel.add(musicLover);

		JLabel videoLover = new JLabel("Video Lover");
		videoLover.setFont(new Font("Tahoma", Font.PLAIN, 18));
		videoLover.setBounds(312, 15, 250, 30);
		videoLover.setForeground(Color.WHITE);
		backPanel.add(videoLover);

		JLabel tvLover = new JLabel("TV Lover");
		tvLover.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tvLover.setBounds(545, 15, 250, 30);
		tvLover.setForeground(Color.WHITE);
		backPanel.add(tvLover);

		JLabel premium = new JLabel("Premium");
		premium.setFont(new Font("Tahoma", Font.PLAIN, 18));
		premium.setBounds(770, 15, 250, 30);
		premium.setForeground(Color.WHITE);
		backPanel.add(premium);

		buttons(backPanel);
	}

	public void setAttributes() {
		customerClassifications.setSize(950, 300);
		customerClassifications.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		customerClassifications.setVisible(true);
		customerClassifications.setResizable(false);
		customerClassifications.setTitle("Subscription Plan");
		customerClassifications.setLocationRelativeTo(null);

	}

	public void buttons(JPanel backPanel) {

		// ---------------------------MUSIC BUTTON-------------------------------
		JButton musicLoverBtn = new JButton();
		musicLoverBtn.setIcon(new ImageIcon("img\\btn\\ml.png"));
		musicLoverBtn.setBounds(30, 50, 200, 200);
		musicLoverBtn.setBorderPainted(false);
		musicLoverBtn.setContentAreaFilled(false);
		musicLoverBtn.setFocusPainted(false);
		backPanel.add(musicLoverBtn);
		musicLoverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerClassifications.dispose();
				new NewCustomerScreen(new MembershipCard(AccessLevel.ML));
			}
		});
		musicLoverBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				musicLoverBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				musicLoverBtn.setIcon(new ImageIcon("img\\btn\\hover\\mlhover.png"));
				musicLoverBtn.setBounds(25, 45, 210, 210);
			}

			public void mouseExited(MouseEvent evt) {
				musicLoverBtn.setIcon(new ImageIcon("img\\btn\\ml.png"));
				musicLoverBtn.setBounds(30, 50, 200, 200);
			}
		});
		// ---------------------------LIVE CONCERT BUTTON-------------------------------
		JButton videoLoverBtn = new JButton();
		videoLoverBtn.setIcon(new ImageIcon("img\\btn\\vl.png"));
		videoLoverBtn.setBounds(255, 50, 200, 200);
		videoLoverBtn.setBorderPainted(false);
		videoLoverBtn.setContentAreaFilled(false);
		videoLoverBtn.setFocusPainted(false);
		backPanel.add(videoLoverBtn);
		videoLoverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerClassifications.dispose();
				new NewCustomerScreen(new MembershipCard(AccessLevel.VL));
			}
		});
		videoLoverBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				videoLoverBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				videoLoverBtn.setIcon(new ImageIcon("img\\btn\\hover\\vlhover.png"));
				videoLoverBtn.setBounds(250, 45, 210, 210);
			}

			public void mouseExited(MouseEvent evt) {
				videoLoverBtn.setIcon(new ImageIcon("img\\btn\\vl.png"));
				videoLoverBtn.setBounds(255, 50, 200, 200);
			}
		});
		// ---------------------------MOVIE BUTTON-------------------------------
		JButton tvLoverBtn = new JButton();
		tvLoverBtn.setIcon(new ImageIcon("img\\btn\\tv.png"));
		tvLoverBtn.setBounds(480, 50, 200, 200);
		tvLoverBtn.setBorderPainted(false);
		tvLoverBtn.setContentAreaFilled(false);
		tvLoverBtn.setFocusPainted(false);
		backPanel.add(tvLoverBtn);
		tvLoverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerClassifications.dispose();
				new NewCustomerScreen(new MembershipCard(AccessLevel.TV));
			}
		});
		tvLoverBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				tvLoverBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				tvLoverBtn.setIcon(new ImageIcon("img\\btn\\hover\\tvhover.png"));
				tvLoverBtn.setBounds(475, 45, 210, 210);
			}

			public void mouseExited(MouseEvent evt) {
				tvLoverBtn.setIcon(new ImageIcon("img\\btn\\tv.png"));
				tvLoverBtn.setBounds(480, 50, 200, 200);
			}
		});
		// ---------------------------BOX SET BUTTON-------------------------------
		JButton premiumBtn = new JButton();
		premiumBtn.setIcon(new ImageIcon("img\\btn\\pr.png"));
		premiumBtn.setBounds(705, 50, 200, 200);
		premiumBtn.setBorderPainted(false);
		premiumBtn.setContentAreaFilled(false);
		premiumBtn.setFocusPainted(false);
		backPanel.add(premiumBtn);
		premiumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerClassifications.dispose();
				new NewCustomerScreen(new MembershipCard(AccessLevel.PR));
			}
		});
		premiumBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				premiumBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				premiumBtn.setIcon(new ImageIcon("img\\btn\\hover\\prhover.png"));
				premiumBtn.setBounds(700, 45, 210, 210);
			}

			public void mouseExited(MouseEvent evt) {
				premiumBtn.setIcon(new ImageIcon("img\\btn\\pr.png"));
				premiumBtn.setBounds(705, 50, 200, 200);
			}
		});
	}

	public void validation() {
		customerClassifications.repaint();
		customerClassifications.validate();
	}
}
