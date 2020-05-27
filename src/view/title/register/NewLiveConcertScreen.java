package view.title.register;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import model.enums.AccessLevel;
import model.enums.Media;
import model.titles.MusicOrLive;

public class NewLiveConcertScreen implements FocusListener {

	private JFrame newLiveConcertScreen = new JFrame();
	private KeyController listenerController = new KeyController(newLiveConcertScreen);

	private MusicOrLive newLiveConcert;

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField liveconcertnametf;
	private JTextField liveconcertsingertf;
	private JTextField liveconcertbandtf;
	private JTextField liveconcertgenretf;
	private JTextField yearofreleasetf;
	private JTextField pricetf;
	private JComboBox<Media> mediaComboBox;

	public NewLiveConcertScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public void setAttributes() {
		newLiveConcertScreen.setSize(1000, 650);
		newLiveConcertScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newLiveConcertScreen.setUndecorated(true);
		newLiveConcertScreen.setVisible(true);
		newLiveConcertScreen.setResizable(false);
		newLiveConcertScreen.setTitle("Title Registration");
		newLiveConcertScreen.setLocationRelativeTo(null);
		newLiveConcertScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		
		newLiveConcertScreen.addKeyListener(listenerController);
		newLiveConcertScreen.addWindowListener(listenerController);
		newLiveConcertScreen.addMouseListener(listenerController);
		newLiveConcertScreen.addMouseMotionListener(listenerController);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		newLiveConcertScreen.add(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, newLiveConcertScreen.getWidth(), newLiveConcertScreen.getHeight() - 200);
		backPanel.add(backRectangle);

		JLabel newCustomerLabel = new JLabel("New Live Concert");
		newCustomerLabel.setFont(new Font("Tahoma", Font.PLAIN, 42));
		newCustomerLabel.setBounds(100, 60, 350, 35);
		newCustomerLabel.setForeground(Color.WHITE);
		backPanel.add(newCustomerLabel);

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img\\icons\\logobluecircle.png"));
		logo.setBounds(560, 0, 300, 120);
		backPanel.add(logo);

		textFields(backRectangle);

		JLabel bigCustomerIcon = new JLabel();
		bigCustomerIcon.setIcon(new ImageIcon("img\\icons\\liveiconbig.png"));
		bigCustomerIcon.setBounds(70, 50, 280, 350);
		backRectangle.add(bigCustomerIcon);

		buttons(backRectangle, backPanel);

	}

	public void textFields(JPanel backRectangle) {

		liveconcertnametf = new JTextField();
		liveconcertnametf.setText("music name");
		liveconcertnametf.setForeground(new Color(180, 180, 180));
		liveconcertnametf.addFocusListener(this);
		liveconcertnametf.setBounds(400, 65, 225, 45);
		liveconcertnametf.setBorder(null);
		liveconcertnametf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(liveconcertnametf);

		liveconcertsingertf = new JTextField();
		liveconcertsingertf.setText("music singer");
		liveconcertsingertf.setForeground(new Color(180, 180, 180));
		liveconcertsingertf.addFocusListener(this);
		liveconcertsingertf.setBounds(400, 120, 225, 45);
		liveconcertsingertf.setBorder(null);
		liveconcertsingertf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(liveconcertsingertf);

		liveconcertbandtf = new JTextField();
		liveconcertbandtf.setText("music band");
		liveconcertbandtf.setForeground(new Color(180, 180, 180));
		liveconcertbandtf.addFocusListener(this);
		liveconcertbandtf.setBounds(400, 175, 225, 45);
		liveconcertbandtf.setBorder(null);
		liveconcertbandtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(liveconcertbandtf);

		liveconcertgenretf = new JTextField();
		liveconcertgenretf.setText("music genre");
		liveconcertgenretf.setForeground(new Color(180, 180, 180));
		liveconcertgenretf.addFocusListener(this);
		liveconcertgenretf.setBounds(400, 230, 225, 45);
		liveconcertgenretf.setBorder(null);
		liveconcertgenretf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(liveconcertgenretf);

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

		mediaComboBox = new JComboBox<>(mediaformats);
		mediaComboBox.setBounds(655, 175, 225, 45);
		backRectangle.add(mediaComboBox);

	}

	public void buttons(JPanel backRectangle, JPanel backPanel) {

// ---------------------------PRESS CLOSE BUTTON-------------------------------
		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\goback.png"));
		closeBtn.setBounds(backRectangle.getWidth() - 220, 20, 222, 65);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newLiveConcertScreen.dispose();
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
		JButton cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtn.png"));
		cancelBtn.setBackground(backRectangle.getBackground());
		cancelBtn.setBounds(420, 295, 230, 106);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		backRectangle.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newLiveConcertScreen.dispose();
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

				String name = liveconcertnametf.getText();
				String singer = liveconcertsingertf.getText();
				String band = liveconcertbandtf.getText();
				String genre = liveconcertgenretf.getText();
				String yor = yearofreleasetf.getText();
				String price = pricetf.getText();

				if (name.equals("music name") || genre.equals("music genre") || yor.equals("year of release") || price.equals("price")) {

					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "All fields are required.",
							"Error, missing information.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}
				if(singer.equals("music singer") && band.equals("music band")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "A music should at least have one singer or one band.",
							"Error, missing information.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}
				
				if (!yor.matches("(18|19|20)[0-9]{2}")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Invalid year of release number. \nEnter a valid year please.",
							"Year of Release Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}
				if (!price.matches("(^([0-9]{1,2})[.]([0-9]{2})$)")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Invalid price number. \nEnter a valid price please.",
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
				if (selectedFormat.equals(Media.CD)) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Live Concerts can't to be recorded in CD's. \nChoose DVD or BLU-RAY only.",
							"Title Media Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}

				{
					double pricedouble = Double.parseDouble(price);
					int yorint = Integer.parseInt(yor);

					int planID = AccessLevel.ML.getSubscriptionID();

					newLiveConcert = new MusicOrLive(2, selectedFormat, name, pricedouble, genre, yorint,
							singer, band, planID);
					int musicInsert = managementSystem.addNewTitle(newLiveConcert);

					if (musicInsert == 0) {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Registration of: " + name + ", couldn't be done.",
								"Error Registering Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
								logoIcon, btns, btns[0]);
					} else {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null,
								"Live Concert: " + name + ", Successfully registered!", "Registered Title",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					}
					newLiveConcertScreen.dispose();
					new NewLiveConcertScreen();
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
		newLiveConcertScreen.repaint();
		newLiveConcertScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {

//------------------live concert name TextField-------------------------
		if (liveconcertnametf.getText().matches("music name")) {
			liveconcertnametf.setText("");
			liveconcertnametf.setForeground(new Color(0, 80, 110));
		}
		if (!liveconcertnametf.hasFocus()) {
			if (liveconcertnametf.getText().matches("")) {
				liveconcertnametf.setText("music name");
				liveconcertnametf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------live concert singer TextField-------------------------
		if (liveconcertsingertf.getText().matches("music singer")) {
			liveconcertsingertf.setText("");
			liveconcertsingertf.setForeground(new Color(0, 80, 110));
		}
		if (!liveconcertsingertf.hasFocus()) {
			if (liveconcertsingertf.getText().matches("")) {
				liveconcertsingertf.setText("music singer");
				liveconcertsingertf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------live concert band TextField-------------------------
		if (liveconcertbandtf.getText().matches("music band")) {
			liveconcertbandtf.setText("");
			liveconcertbandtf.setForeground(new Color(0, 80, 110));
		}
		if (!liveconcertbandtf.hasFocus()) {
			if (liveconcertbandtf.getText().matches("")) {
				liveconcertbandtf.setText("music band");
				liveconcertbandtf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------live concert genre TextField-------------------------
		if (liveconcertgenretf.getText().matches("music genre")) {
			liveconcertgenretf.setText("");
			liveconcertgenretf.setForeground(new Color(0, 80, 110));
		}
		if (!liveconcertgenretf.hasFocus()) {
			if (liveconcertgenretf.getText().matches("")) {
				liveconcertgenretf.setText("music genre");
				liveconcertgenretf.setForeground(new Color(180, 180, 180));
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
	}
}
