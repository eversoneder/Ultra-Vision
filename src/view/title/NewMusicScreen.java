package view.title;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.KeyController;
import controller.UltraVisionManagementSystem;
import model.enums.Media;
import model.titles.MusicOrLive;
import model.titles.Title;

public class NewMusicScreen implements FocusListener {

	private JButton cancelBtn;
	private JFrame newMusicScreen = new JFrame();
	private KeyController keyListener = new KeyController(newMusicScreen, cancelBtn);

	private MusicOrLive newMusic;
	
	private UltraVisionManagementSystem managementSystem;

	private JTextField musicnametf;
	private JTextField musicsingertf;
	private JTextField musicbandtf;
	private JTextField musicgenretf;
	private JTextField yearofreleasetf;
	private JTextField pricetf;
	private JComboBox mediaComboBox;

//	private Media mediaformattf;

	public NewMusicScreen() {
		setAttributes();
		setComponents();
		validation();
	}

//	public static void main(String[] args) {
//		new NewMusic();
//	}

	public void setAttributes() {
		newMusicScreen.setSize(1000, 650);
		newMusicScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newMusicScreen.setVisible(true);
		newMusicScreen.setResizable(false);
		newMusicScreen.setTitle("Title Registration");
		newMusicScreen.setLocationRelativeTo(null);
		newMusicScreen.addKeyListener(keyListener);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		newMusicScreen.add(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, newMusicScreen.getWidth(), newMusicScreen.getHeight() - 200);
		backPanel.add(backRectangle);

		JLabel newCustomerLabel = new JLabel("New Music");
		newCustomerLabel.setFont(new Font("Tahoma", Font.PLAIN, 42));
		newCustomerLabel.setBounds(110, 60, 300, 35);
		newCustomerLabel.setForeground(Color.WHITE);
		backPanel.add(newCustomerLabel);

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img\\icons\\logobluecircle.png"));
		logo.setBounds(560, 0, 300, 120);
		backPanel.add(logo);

//		JLabel pressQ = new JLabel();
//		pressQ.setIcon(new ImageIcon("img\\btn\\pressclose.png"));
//		pressQ.setBounds(backRectangle.getWidth() - 210, 20, 195, 65);
//		backPanel.add(pressQ);

		textFields(backRectangle);

		JLabel bigCustomerIcon = new JLabel();
		bigCustomerIcon.setIcon(new ImageIcon("img\\icons\\musiciconbig.png"));
		bigCustomerIcon.setBounds(70, 50, 280, 350);
		backRectangle.add(bigCustomerIcon);

		buttons(backRectangle, backPanel);

	}

	public void textFields(JPanel backRectangle) {

		musicnametf = new JTextField();
		musicnametf.setText("music name");
		musicnametf.setForeground(new Color(180, 180, 180));
		musicnametf.addFocusListener(this);
		musicnametf.setBounds(400, 65, 225, 45);
		musicnametf.setBorder(null);
		musicnametf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(musicnametf);

		musicsingertf = new JTextField();
		musicsingertf.setText("music singer");
		musicsingertf.setForeground(new Color(180, 180, 180));
		musicsingertf.addFocusListener(this);
		musicsingertf.setBounds(400, 120, 225, 45);
		musicsingertf.setBorder(null);
		musicsingertf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(musicsingertf);

		musicbandtf = new JTextField();
		musicbandtf.setText("music band");
		musicbandtf.setForeground(new Color(180, 180, 180));
		musicbandtf.addFocusListener(this);
		musicbandtf.setBounds(400, 175, 225, 45);
		musicbandtf.setBorder(null);
		musicbandtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(musicbandtf);

		musicgenretf = new JTextField();
		musicgenretf.setText("music genre");
		musicgenretf.setForeground(new Color(180, 180, 180));
		musicgenretf.addFocusListener(this);
		musicgenretf.setBounds(400, 230, 225, 45);
		musicgenretf.setBorder(null);
		musicgenretf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(musicgenretf);

		yearofreleasetf = new JTextField();
		yearofreleasetf.setText("year of release");
		yearofreleasetf.setForeground(new Color(180, 180, 180));
		yearofreleasetf.addFocusListener(this);
		yearofreleasetf.setBounds(655, 65, 225, 45);
		yearofreleasetf.setBorder(null);
		yearofreleasetf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(yearofreleasetf);

		pricetf = new JTextField();
		pricetf.setText("price");
		pricetf.setForeground(new Color(180, 180, 180));
		pricetf.addFocusListener(this);
		pricetf.setBounds(655, 120, 225, 45);
		pricetf.setBorder(null);
		pricetf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(pricetf);

		Media[] mediaformats = Media.values();

		mediaComboBox = new JComboBox<Media>(mediaformats);
		mediaComboBox.setBounds(655, 175, 225, 45);
		backRectangle.add(mediaComboBox);

	}

	public void buttons(JPanel backRectangle, JPanel backPanel) {

// ---------------------------PRESS CLOSE BUTTON-------------------------------
		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\goback.png"));
//		pressClose.setIcon(new ImageIcon("img\\btn\\goback.png"));
		closeBtn.setBounds(backRectangle.getWidth() - 220, 20, 222, 65);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newMusicScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\gobackhover.png"));
				closeBtn.setBounds(backRectangle.getWidth() - 224, 14, 230, 75);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\goback.png"));
				closeBtn.setBounds(backRectangle.getWidth() - 220, 20, 222, 65);
			}
		});
// ---------------------------CANCEL BUTTON-------------------------------
		cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtn.png"));
		cancelBtn.setBackground(backRectangle.getBackground());
		cancelBtn.setBounds(420, 295, 230, 106);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		backRectangle.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newMusicScreen.dispose();
			}
		});
		cancelBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cancelBtn.setIcon(new ImageIcon("img\\btn\\hover\\cancelbtnhover.png"));
				cancelBtn.setBounds(416, 293, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtn.png"));
				cancelBtn.setBounds(420, 295, 230, 106);
			}
		});
// ---------------------------CREATE BUTTON-------------------------------
		JButton createBtn = new JButton();
		createBtn.setIcon(new ImageIcon("img\\btn\\createbtn.png"));
		createBtn.setBackground(backRectangle.getBackground());
		createBtn.setBounds(632, 295, 230, 106);
		createBtn.setBorderPainted(false);
		createBtn.setContentAreaFilled(false);
		createBtn.setFocusPainted(false);
		backRectangle.add(createBtn);
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

				String name = musicnametf.getText();
				String singer = musicsingertf.getText();
				String band = musicbandtf.getText();
				String genre = musicgenretf.getText();
				String yor = yearofreleasetf.getText();
				String price = pricetf.getText();

				if (name.equals("music name") || singer.equals("music singer") || band.equals("music band")
						|| genre.equals("music genre") || yor.equals("year of release") || price.equals("price")) {

					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null, "All fields are required.",
							"Error, missing information.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}
				if (!yor.matches("(18|19|20)[0-9]{2}")) {
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null,
							"Invalid year of release number. \nEnter a valid year please.",
							"Year of Release Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}
				if (!price.matches("(^([0-9]{1,2})[.]([0-9]{2})$)")) {
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null, "Invalid price number. \nEnter a valid price please.",
							"Price Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}

				int selectedMediaIndex = mediaComboBox.getSelectedIndex();
				Media medias[] = Media.values();
				Media selectedFormat = null;
				for (Media i : medias) {
					if (i.getDiscFormatID() - 1 == selectedMediaIndex) {
						selectedFormat = i;
						break;
					}
				}
				{// new title upload
//					Double twoDecimalPrice = Double.parseDouble(String.format("%.2f", new BigDecimal(price)));
//					DecimalFormat df = new DecimalFormat("#.00"); 

					double pricedouble = Double.parseDouble(price);
					int yorint = Integer.parseInt(yor);

					newMusic = new MusicOrLive(1, selectedFormat, name, pricedouble, genre, yorint, singer, band, 1);
					managementSystem = new UltraVisionManagementSystem(0);
					int insertNewMusic = managementSystem.addNewTitle(newMusic);

					if (insertNewMusic == 0) {

//						Object[] btns = { "Ok" };
//						int i = JOptionPane.showOptionDialog(null, "Invalid price number. \nEnter a valid price please.",
//								"Price Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
//								btns[0]);

//						Object[] btns = { "Ok" };
//						int i = JOptionPane.showOptionDialog(null, "Couldn't register Title.",
//								"Music Registration Failed.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
//								logoIcon, btns, btns[0]);
					} else {
						Object[] btns = { "Ok" };
						int i = JOptionPane.showOptionDialog(null, "Music: " + name + ", Successfully registered!",
								"Registered Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btns, btns[0]);

					}
					// reset text fields
					newMusicScreen.dispose();
					new NewMusicScreen();
				}
			}
		});
		createBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				createBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				createBtn.setIcon(new ImageIcon("img\\btn\\hover\\createbtnhover.png"));
				createBtn.setBounds(628, 293, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				createBtn.setIcon(new ImageIcon("img\\btn\\createbtn.png"));
				createBtn.setBounds(632, 295, 230, 106);
			}
		});
	}

	public void validation() {
		newMusicScreen.repaint();
		newMusicScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {

//------------------music name TextField-------------------------
		if (musicnametf.getText().matches("music name")) {
			musicnametf.setText("");
			musicnametf.setForeground(new Color(0, 80, 110));
		}
		if (!musicnametf.hasFocus()) {
			if (musicnametf.getText().matches("")) {
				musicnametf.setText("music name");
				musicnametf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------music singer TextField-------------------------
		if (musicsingertf.getText().matches("music singer")) {
			musicsingertf.setText("");
			musicsingertf.setForeground(new Color(0, 80, 110));
		}
		if (!musicsingertf.hasFocus()) {
			if (musicsingertf.getText().matches("")) {
				musicsingertf.setText("music singer");
				musicsingertf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------music band TextField-------------------------
		if (musicbandtf.getText().matches("music band")) {
			musicbandtf.setText("");
			musicbandtf.setForeground(new Color(0, 80, 110));
		}
		if (!musicbandtf.hasFocus()) {
			if (musicbandtf.getText().matches("")) {
				musicbandtf.setText("music band");
				musicbandtf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------music genre TextField-------------------------
		if (musicgenretf.getText().matches("music genre")) {
			musicgenretf.setText("");
			musicgenretf.setForeground(new Color(0, 80, 110));
		}
		if (!musicgenretf.hasFocus()) {
			if (musicgenretf.getText().matches("")) {
				musicgenretf.setText("music genre");
				musicgenretf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------year of release TextField-------------------------
		if (yearofreleasetf.getText().matches("year of release")) {
			yearofreleasetf.setText("");
			yearofreleasetf.setForeground(new Color(0, 80, 110));
		}
		if (!yearofreleasetf.hasFocus()) {
			if (yearofreleasetf.getText().matches("")) {
				yearofreleasetf.setText("year of release");
				yearofreleasetf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------year of release TextField-------------------------
		if (pricetf.getText().matches("price")) {
			pricetf.setText("");
			pricetf.setForeground(new Color(0, 80, 110));
		}
		if (!pricetf.hasFocus()) {
			if (pricetf.getText().matches("")) {
				pricetf.setText("price");
				pricetf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
