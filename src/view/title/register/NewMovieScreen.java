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

import controller.ListenerController;
import model.UltraVisionManagementSystem;
import model.enums.AccessLevel;
import model.enums.Media;
import model.titles.Movie;
import model.titles.Title;

public class NewMovieScreen implements FocusListener {

	private JFrame newMovieScreen = new JFrame();
	private ListenerController listenerController = new ListenerController(newMovieScreen);

	private Movie newMovie;

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField movienametf;
	private JTextField moviedirectortf;
	private JTextField moviegenretf;
	private JTextField yearofreleasetf;
	private JTextField pricetf;
	private JComboBox<Media> mediaComboBox;
	
	private JButton createBtn;

	public NewMovieScreen() {
		setAttributes();
		setComponents();
		listenerController.getButton(createBtn);
		validation();
	}

	public void setAttributes() {
		newMovieScreen.setSize(960, 550);
		newMovieScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newMovieScreen.setUndecorated(true);
		newMovieScreen.setVisible(true);
		newMovieScreen.setResizable(false);
		newMovieScreen.setTitle("Title Registration");
		newMovieScreen.setLocationRelativeTo(null);
		newMovieScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		
		newMovieScreen.addKeyListener(listenerController);
		newMovieScreen.addWindowListener(listenerController);
		newMovieScreen.addMouseListener(listenerController);
		newMovieScreen.addMouseMotionListener(listenerController);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		newMovieScreen.add(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, newMovieScreen.getWidth(), newMovieScreen.getHeight() - 140);
		backPanel.add(backRectangle);

		JLabel newCustomerLabel = new JLabel("New Movie");
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
		bigCustomerIcon.setIcon(new ImageIcon("img\\icons\\movieiconbig.png"));
		bigCustomerIcon.setBounds(70, 50, 280, 350);
		backRectangle.add(bigCustomerIcon);

		buttons(backRectangle, backPanel);

	}

	public void textFields(JPanel backRectangle) {

		movienametf = new JTextField();
		movienametf.setText("movie name");
		movienametf.setForeground(new Color(180, 180, 180));
		movienametf.addFocusListener(this);
		movienametf.setBounds(400, 65, 225, 45);
		movienametf.setBorder(null);
		movienametf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		movienametf.addKeyListener(listenerController);
		backRectangle.add(movienametf);

		moviegenretf = new JTextField();
		moviegenretf.setText("movie genre");
		moviegenretf.setForeground(new Color(180, 180, 180));
		moviegenretf.addFocusListener(this);
		moviegenretf.setBounds(400, 120, 225, 45);
		moviegenretf.setBorder(null);
		moviegenretf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		moviegenretf.addKeyListener(listenerController);
		backRectangle.add(moviegenretf);
		
		moviedirectortf = new JTextField();
		moviedirectortf.setText("movie director");
		moviedirectortf.setForeground(new Color(180, 180, 180));
		moviedirectortf.addFocusListener(this);
		moviedirectortf.setBounds(400, 175, 225, 45);
		moviedirectortf.setBorder(null);
		moviedirectortf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		moviedirectortf.addKeyListener(listenerController);
		backRectangle.add(moviedirectortf);

		yearofreleasetf = new JTextField();
		yearofreleasetf.setText("year of release");
		yearofreleasetf.setForeground(new Color(180, 180, 180));
		yearofreleasetf.addFocusListener(this);
		yearofreleasetf.setBounds(655, 65, 225, 45);
		yearofreleasetf.setBorder(null);
		yearofreleasetf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		yearofreleasetf.addKeyListener(listenerController);
		backRectangle.add(yearofreleasetf);

		pricetf = new JTextField();
		pricetf.setText("price");
		pricetf.setForeground(new Color(180, 180, 180));
		pricetf.addFocusListener(this);
		pricetf.setBounds(655, 120, 225, 45);
		pricetf.setBorder(null);
		pricetf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pricetf.addKeyListener(listenerController);
		backRectangle.add(pricetf);

		Media[] mediaformats = Media.values();

		mediaComboBox = new JComboBox<Media>(mediaformats);
		mediaComboBox.setBounds(655, 175, 225, 45);
		mediaComboBox.addKeyListener(listenerController);
		backRectangle.add(mediaComboBox);
	}

	public void buttons(JPanel backRectangle, JPanel backPanel) {

// ---------------------------PRESS CLOSE BUTTON-------------------------------
		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closepagebtn.png"));
		closeBtn.setBounds(backRectangle.getWidth() - 210, 20, 222, 65);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newMovieScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closepagebtnhover.png"));
				closeBtn.setBounds(backRectangle.getWidth() - 214, 14, 230, 75);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closepagebtn.png"));
				closeBtn.setBounds(backRectangle.getWidth() - 210, 20, 222, 65);
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
				newMovieScreen.dispose();
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
		createBtn = new JButton();
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
				String director = moviedirectortf.getText();
				String genre = moviegenretf.getText();
				String yor = yearofreleasetf.getText();
				String price = pricetf.getText();

				if (name.equals("movie name") || genre.equals("movie genre") || director.equals("movie director")
						|| yor.equals("year of release") || price.equals("price")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "All fields are required.",
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
					JOptionPane.showOptionDialog(null, "Movies can't be recorded in CD's. \nChoose DVD or BLU-RAY only.",
							"Title Media Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}
				{
					double pricedouble = Double.parseDouble(price);
					int yorint = Integer.parseInt(yor);
					
					int planID = AccessLevel.VL.getSubscriptionID();
					int titleType = new Title().getTitleTypeDB(AccessLevel.VL);
					
					newMovie = new Movie(titleType, selectedFormat, 1, name, pricedouble, genre, yorint, director, planID);
					int musicInsert = managementSystem.addNewTitle(newMovie);
					
					if (musicInsert == 0) {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Registration of: " + name + ", couldn't be done.",
								"Error Registering Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
								logoIcon, btns, btns[0]);
					} else {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Movie: " + name + ", Successfully registered!",
								"Registered Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btns, btns[0]);
					}
					newMovieScreen.dispose();
					new NewMovieScreen();
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
		newMovieScreen.repaint();
		newMovieScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {

//------------------movie name TextField-------------------------
		if (movienametf.getText().matches("movie name")) {
			movienametf.setText("");
			movienametf.setForeground(new Color(0, 80, 110));
		}
		if (!movienametf.hasFocus()) {
			if (movienametf.getText().matches("")) {
				movienametf.setText("movie name");
				movienametf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------movie genre TextField-------------------------
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
//------------------movie director TextField-------------------------
		if (moviedirectortf.getText().matches("movie director")) {
			moviedirectortf.setText("");
			moviedirectortf.setForeground(new Color(0, 80, 110));
		}
		if (!moviedirectortf.hasFocus()) {
			if (moviedirectortf.getText().matches("")) {
				moviedirectortf.setText("movie director");
				moviedirectortf.setForeground(new Color(180, 180, 180));
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
