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
import model.titles.BoxSet;
import model.titles.Title;

public class NewBoxSetScreen implements FocusListener {

	private JFrame newBoxSetScreen = new JFrame();
	private ListenerController listenerController = new ListenerController(newBoxSetScreen);

	private BoxSet newBoxSet;

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField boxSetnametf;
	private JTextField numberoffilmstf;
	private JTextField boxsetgenretf;
	private JTextField yearofreleasetf;
	private JTextField pricetf;
	private JComboBox<Media> mediaComboBox;
	
	private JButton createBtn;

	public NewBoxSetScreen() {
		setAttributes();
		setComponents();
		listenerController.getButton(createBtn);
		validation();
	}

	public void setAttributes() {
		newBoxSetScreen.setSize(960, 550);
		newBoxSetScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newBoxSetScreen.setUndecorated(true);
		newBoxSetScreen.setVisible(true);
		newBoxSetScreen.setResizable(false);
		newBoxSetScreen.setTitle("Title Registration");
		newBoxSetScreen.setLocationRelativeTo(null);
		newBoxSetScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		
		newBoxSetScreen.addKeyListener(listenerController);
		newBoxSetScreen.addWindowListener(listenerController);
		newBoxSetScreen.addMouseListener(listenerController);
		newBoxSetScreen.addMouseMotionListener(listenerController);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		newBoxSetScreen.add(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, newBoxSetScreen.getWidth(), newBoxSetScreen.getHeight() - 140);
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

		boxSetnametf = new JTextField();
		boxSetnametf.setText("box set name");
		boxSetnametf.setForeground(new Color(180, 180, 180));
		boxSetnametf.addFocusListener(this);
		boxSetnametf.setBounds(400, 65, 225, 45);
		boxSetnametf.setBorder(null);
		boxSetnametf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		boxSetnametf.addKeyListener(listenerController);
		backRectangle.add(boxSetnametf);

		numberoffilmstf = new JTextField();
		numberoffilmstf.setText("number of films");
		numberoffilmstf.setForeground(new Color(180, 180, 180));
		numberoffilmstf.addFocusListener(this);
		numberoffilmstf.setBounds(400, 120, 225, 45);
		numberoffilmstf.setBorder(null);
		numberoffilmstf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		numberoffilmstf.addKeyListener(listenerController);
		backRectangle.add(numberoffilmstf);

		boxsetgenretf = new JTextField();
		boxsetgenretf.setText("box set genre");
		boxsetgenretf.setForeground(new Color(180, 180, 180));
		boxsetgenretf.addFocusListener(this);
		boxsetgenretf.setBounds(400, 175, 225, 45);
		boxsetgenretf.setBorder(null);
		boxsetgenretf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		boxsetgenretf.addKeyListener(listenerController);
		backRectangle.add(boxsetgenretf);

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

		mediaComboBox = new JComboBox<>(mediaformats);
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
				newBoxSetScreen.dispose();
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
				newBoxSetScreen.dispose();
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

				String name = boxSetnametf.getText();
				String numoffilms = numberoffilmstf.getText();
				String genre = boxsetgenretf.getText();
				String yor = yearofreleasetf.getText();
				String price = pricetf.getText();

				if (name.equals("movie name") || genre.equals("box set genre") || numoffilms.equals("number of films")
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
				if (!numoffilms.matches("[0-9]{1,2}|50")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Invalid number of films. \nEnter a valid number please.", "Film Number Field Error",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
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
					JOptionPane.showOptionDialog(null,
							"Box Sets can't be recorded in CD's. \nChoose DVD or BLU-RAY only.", "Title Media Error",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}
				{
					double pricedouble = Double.parseDouble(price);
					int yorint = Integer.parseInt(yor);
					int numdiscs = Integer.parseInt(numoffilms);

					int planID = AccessLevel.TV.getSubscriptionID();
					int titleType = new Title().getTitleTypeDB(AccessLevel.TV);
//					
//					int titleType, Media discFormat, int available, String name, double price, int yor,
//					int numOfDiscs, int plan) {
					newBoxSet = new BoxSet(titleType, selectedFormat, 1, name, pricedouble, yorint, numdiscs, genre, planID);
					int musicInsert = managementSystem.addNewTitle(newBoxSet);

					if (musicInsert == 0) {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Registration of: " + name + ", couldn't be done.",
								"Error Registering Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
								logoIcon, btns, btns[0]);
					} else {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Box Set: " + name + ", Successfully registered!",
								"Registered Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btns, btns[0]);
					}
					newBoxSetScreen.dispose();
					new NewBoxSetScreen();
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
		newBoxSetScreen.repaint();
		newBoxSetScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {

//------------------box set name TextField-------------------------
		if (boxSetnametf.getText().matches("box set name")) {
			boxSetnametf.setText("");
			boxSetnametf.setForeground(new Color(0, 80, 110));
		}
		if (!boxSetnametf.hasFocus()) {
			if (boxSetnametf.getText().matches("")) {
				boxSetnametf.setText("box set name");
				boxSetnametf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------number of films TextField-------------------------
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
//------------------box set genre TextField-------------------------
		if (boxsetgenretf.getText().matches("box set genre")) {
			boxsetgenretf.setText("");
			boxsetgenretf.setForeground(new Color(0, 80, 110));
		}
		if (!boxsetgenretf.hasFocus()) {
			if (boxsetgenretf.getText().matches("")) {
				boxsetgenretf.setText("box set genre");
				boxsetgenretf.setForeground(new Color(180, 180, 180));
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
//------------------price TextField-------------------------
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
