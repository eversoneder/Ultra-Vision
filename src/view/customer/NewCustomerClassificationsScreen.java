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

import controller.ListenerController;
import model.customer.MembershipCard;
import model.enums.AccessLevel;

public class NewCustomerClassificationsScreen {

	private JFrame customerClassifications = new JFrame();
	private ListenerController listenerController = new ListenerController(customerClassifications);

	public NewCustomerClassificationsScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public void setAttributes() {
		customerClassifications.setSize(950, 280);
		customerClassifications.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		customerClassifications.setUndecorated(true);
		customerClassifications.setVisible(true);
		customerClassifications.setResizable(false);
		customerClassifications.setTitle("Subscription Plan");
		customerClassifications.setLocationRelativeTo(null);
		customerClassifications.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		
		customerClassifications.addKeyListener(listenerController);
		customerClassifications.addWindowListener(listenerController);
		customerClassifications.addMouseListener(listenerController);
		customerClassifications.addMouseMotionListener(listenerController);
	}

	private void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		customerClassifications.add(backPanel);

		closeBtn(backPanel);
		
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
				customerClassifications.dispose();
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
		customerClassifications.repaint();
		customerClassifications.validate();
	}
}
