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
import model.titles.Movie;
import model.titles.MusicOrLive;
import model.titles.Title;

public class NewBoxSetScreen implements FocusListener {

	private JButton cancelBtn;
	private JFrame newLiveConcertScreen = new JFrame();
	private KeyController keyListener = new KeyController(newLiveConcertScreen, cancelBtn);

	private Movie newMovie;

	private UltraVisionManagementSystem managementSystem;

	private JTextField movienametf;
	private JTextField numberoffilmstf;
	private JTextField moviegenretf;
	private JTextField yearofreleasetf;
	private JTextField pricetf;
	private JComboBox mediaComboBox;

	public NewBoxSetScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public static void main(String[] args) {
		new NewBoxSetScreen();
	}

	public void setAttributes() {
		newLiveConcertScreen.setSize(1000, 650);
		newLiveConcertScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newLiveConcertScreen.setVisible(true);
		newLiveConcertScreen.setResizable(false);
		newLiveConcertScreen.setTitle("Title Registration");
		newLiveConcertScreen.setLocationRelativeTo(null);
		newLiveConcertScreen.addKeyListener(keyListener);
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

		JLabel newCustomerLabel = new JLabel("New TV Box Set");
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
		bigCustomerIcon.setIcon(new ImageIcon("img\\icons\\boxseticonbig.png"));
		bigCustomerIcon.setBounds(70, 50, 280, 350);
		backRectangle.add(bigCustomerIcon);

		buttons(backRectangle, backPanel);

	}

	public void textFields(JPanel backRectangle) {

		movienametf = new JTextField();
		movienametf.setText("box set name");
		movienametf.setForeground(new Color(180, 180, 180));
		movienametf.addFocusListener(this);
		movienametf.setBounds(400, 65, 225, 45);
		movienametf.setBorder(null);
		movienametf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(movienametf);

		moviegenretf = new JTextField();
		moviegenretf.setText("movie genre");
		moviegenretf.setForeground(new Color(180, 180, 180));
		moviegenretf.addFocusListener(this);
		moviegenretf.setBounds(400, 120, 225, 45);
		moviegenretf.setBorder(null);
		moviegenretf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(moviegenretf);
		
		numberoffilmstf = new JTextField();
		numberoffilmstf.setText("number of films");
		numberoffilmstf.setForeground(new Color(180, 180, 180));
		numberoffilmstf.addFocusListener(this);
		numberoffilmstf.setBounds(400, 175, 225, 45);
		numberoffilmstf.setBorder(null);
		numberoffilmstf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(numberoffilmstf);

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

				String name = movienametf.getText();
				String numoffilms = numberoffilmstf.getText();
				String genre = moviegenretf.getText();
				String yor = yearofreleasetf.getText();
				String price = pricetf.getText();

				if (name.equals("movie name") || genre.equals("movie genre") || numoffilms.equals("number of films") 
						|| yor.equals("year of release") || price.equals("price")) {

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
				if (!numoffilms.matches("[0-9]{1,2}|50")) {
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null, "Invalid number of films. \nEnter a valid number please.",
							"Film Number Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
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
				{
					double pricedouble = Double.parseDouble(price);
					int yorint = Integer.parseInt(yor);

					newMovie = new Movie(3, selectedFormat, 1, name, pricedouble, genre, yorint, numoffilms, 1);
					managementSystem = new UltraVisionManagementSystem(0);
					int musicInsert = managementSystem.addNewTitle(newMovie);

					if (musicInsert == 0) {
						Object[] btns = { "Ok" };
						int i = JOptionPane.showOptionDialog(null, "Registration of: " + name + ", couldn't be done.",
								"Error Registering Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
								logoIcon, btns, btns[0]);
					} else {
						Object[] btns = { "Ok" };
						int i = JOptionPane.showOptionDialog(null, "Music: " + name + ", Successfully registered!",
								"Registered Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btns, btns[0]);
					}
					newLiveConcertScreen.dispose();
					new NewLiveConcertScreen();
//				}
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

//------------------music name TextField-------------------------
		if (movienametf.getText().matches("box set name")) {
			movienametf.setText("");
			movienametf.setForeground(new Color(0, 80, 110));
		}
		if (!movienametf.hasFocus()) {
			if (movienametf.getText().matches("")) {
				movienametf.setText("box set name");
				movienametf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------music genre TextField-------------------------
		if (moviegenretf.getText().matches("movie genre")) {
			moviegenretf.setText("");
			moviegenretf.setForeground(new Color(0, 80, 110));
		}
		if (!moviegenretf.hasFocus()) {
			if (moviegenretf.getText().matches("")) {
				moviegenretf.setText("movie genre");
				moviegenretf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------music director TextField-------------------------
		if (numberoffilmstf.getText().matches("number of films")) {
			numberoffilmstf.setText("");
			numberoffilmstf.setForeground(new Color(0, 80, 110));
		}
		if (!numberoffilmstf.hasFocus()) {
			if (numberoffilmstf.getText().matches("")) {
				numberoffilmstf.setText("number of films");
				numberoffilmstf.setForeground(new Color(180, 180, 180));
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
