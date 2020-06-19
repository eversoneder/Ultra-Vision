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
import model.titles.MusicOrLive;

public class NewMusicScreen implements FocusListener {

	private JFrame newMusicScreen = new JFrame();
	private ListenerController listenerController = new ListenerController(newMusicScreen);

	private MusicOrLive newMusic;

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField musicnametf;
	private JTextField musicsingertf;
	private JTextField musicbandtf;
	private JTextField musicgenretf;
	private JTextField yearofreleasetf;
	private JTextField pricetf;
	private JComboBox<Media> mediaComboBox;
	
	private JButton createBtn;

	public NewMusicScreen() {
		setAttributes();
		setComponents();
		listenerController.getButton(createBtn);
		validation();
	}

	public void setAttributes() {
		newMusicScreen.setSize(960, 550);
		newMusicScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newMusicScreen.setUndecorated(true);
		newMusicScreen.setVisible(true);
		newMusicScreen.setResizable(false);
		newMusicScreen.setTitle("Title Registration");
		newMusicScreen.setLocationRelativeTo(null);
		newMusicScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		
		newMusicScreen.addKeyListener(listenerController);
		newMusicScreen.addWindowListener(listenerController);
		newMusicScreen.addMouseListener(listenerController);
		newMusicScreen.addMouseMotionListener(listenerController);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		newMusicScreen.add(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, newMusicScreen.getWidth(), newMusicScreen.getHeight() - 140);
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
		musicnametf.addKeyListener(listenerController);
		backRectangle.add(musicnametf);

		musicsingertf = new JTextField();
		musicsingertf.setText("music singer");
		musicsingertf.setForeground(new Color(180, 180, 180));
		musicsingertf.addFocusListener(this);
		musicsingertf.setBounds(400, 120, 225, 45);
		musicsingertf.setBorder(null);
		musicsingertf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		musicsingertf.addKeyListener(listenerController);
		backRectangle.add(musicsingertf);

		musicbandtf = new JTextField();
		musicbandtf.setText("music band");
		musicbandtf.setForeground(new Color(180, 180, 180));
		musicbandtf.addFocusListener(this);
		musicbandtf.setBounds(400, 175, 225, 45);
		musicbandtf.setBorder(null);
		musicbandtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		musicbandtf.addKeyListener(listenerController);
		backRectangle.add(musicbandtf);

		musicgenretf = new JTextField();
		musicgenretf.setText("music genre");
		musicgenretf.setForeground(new Color(180, 180, 180));
		musicgenretf.addFocusListener(this);
		musicgenretf.setBounds(400, 230, 225, 45);
		musicgenretf.setBorder(null);
		musicgenretf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		musicgenretf.addKeyListener(listenerController);
		backRectangle.add(musicgenretf);

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
				newMusicScreen.dispose();
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

				String name = musicnametf.getText();
				String singer = musicsingertf.getText();
				String band = musicbandtf.getText();
				String genre = musicgenretf.getText();
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
				if(singer.equals("music singer") || singer.equals("")) {
					singer = "N/A";
				}
				if(band.equals("music band") || band.equals("")) {
					band = "N/A";
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
				if (!selectedFormat.equals(Media.CD)) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Music can't be recorded in DVD / BLU-RAY. \nChoose CD's only.",
							"Title Media Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}
				{
					double pricedouble = Double.parseDouble(price);
					int yorint = Integer.parseInt(yor);

					int planID = AccessLevel.ML.getSubscriptionID();
					
					newMusic = new MusicOrLive(1, selectedFormat, name, pricedouble, genre, yorint, singer, band, planID);
					int musicInsert = managementSystem.addNewTitle(newMusic);
			
					if (musicInsert == 0) {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Registration of: " + name + ", couldn't be done.",
								"Error Registering Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
								logoIcon, btns, btns[0]);
					} else {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Music: " + name + ", Successfully registered!",
								"Registered Title", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btns, btns[0]);
					}
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
	}
}
