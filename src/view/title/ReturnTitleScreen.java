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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ListenerController;
import model.Rent;
import model.UltraVisionManagementSystem;
import model.customer.MembershipCard;
import model.titles.Title;

public class ReturnTitleScreen implements FocusListener {

	private JFrame returnTitleScreen = new JFrame();
	private ListenerController listenerController = new ListenerController(returnTitleScreen);

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField titleIDtf;
	private JButton confirmBtn;

	private MembershipCard card = new MembershipCard();

	private Title title = new Title();
	private Rent rent = new Rent(0);

	public ReturnTitleScreen() {
		setAttributes();
		setComponents();
		listenerController.getButton(confirmBtn);
		validation();
	}

	public void setAttributes() {
		returnTitleScreen.setSize(640, 300);
		returnTitleScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		returnTitleScreen.setUndecorated(true);
		returnTitleScreen.setVisible(true);
		returnTitleScreen.setResizable(false);
		returnTitleScreen.setTitle("Ultra-Vision | Return Title");
		returnTitleScreen.setLocationRelativeTo(null);
		returnTitleScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		
		returnTitleScreen.addKeyListener(listenerController);
		returnTitleScreen.addWindowListener(listenerController);
		returnTitleScreen.addMouseListener(listenerController);
		returnTitleScreen.addMouseMotionListener(listenerController);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		returnTitleScreen.add(backPanel);

		JLabel logobluecircle = new JLabel();
		logobluecircle.setIcon(new ImageIcon("img\\icons\\logobluecircle.png"));
		logobluecircle.setBounds(320, 5, 150, 110);
		backPanel.add(logobluecircle);

		closeBtn(backPanel);

		JLabel issueRentalLabel = new JLabel("Return Title");
		issueRentalLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		issueRentalLabel.setBounds(30, 15, 200, 30);
		issueRentalLabel.setForeground(Color.WHITE);
		backPanel.add(issueRentalLabel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 60, returnTitleScreen.getWidth(), returnTitleScreen.getHeight() - 80);
		backPanel.add(backRectangle);

		JLabel titleIcon = new JLabel();
		titleIcon.setIcon(new ImageIcon("img\\icons\\titleiconshadow.png"));
		titleIcon.setBounds(40, 10, 170, 220);
		backRectangle.add(titleIcon);

		textFields(backRectangle);
		buttons(backRectangle);

	}

	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
		closeBtn.setBounds(590, 14, 30, 30);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnTitleScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closebtnsmallhover.png"));
				closeBtn.setBounds(587, 10, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
				closeBtn.setBounds(590, 14, 30, 30);
			}
		});
	}

	public void textFields(JPanel backRectangle) {

		titleIDtf = new JTextField();
		titleIDtf.setText("enter title id");
		titleIDtf.setForeground(new Color(180, 180, 180));
		titleIDtf.addFocusListener(this);
		titleIDtf.setBounds(280, 65, 250, 45);
		titleIDtf.setBorder(null);
		titleIDtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		titleIDtf.addKeyListener(listenerController);
		backRectangle.add(titleIDtf);
	}

	public void buttons(JPanel backRectangle) {

		// ---------------------------CANCEL BUTTON-------------------------------
		JButton cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
		cancelBtn.setBackground(backRectangle.getBackground());
		cancelBtn.setBounds(235, 123, 170, 80);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		backRectangle.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnTitleScreen.dispose();
			}
		});
		cancelBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cancelBtn.setIcon(new ImageIcon("img\\btn\\hover\\cancelbtnsmallhover.png"));
				cancelBtn.setBounds(231, 121, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
				cancelBtn.setBounds(235, 123, 170, 80);
			}
		});
		// ---------------------------CONFIRM BUTTON-------------------------------
		confirmBtn = new JButton();
		confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
		confirmBtn.setBackground(backRectangle.getBackground());
		confirmBtn.setBounds(415, 123, 170, 80);
		confirmBtn.setBorderPainted(false);
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.setFocusPainted(false);
		backRectangle.add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

				if (!titleIDtf.getText().matches("[0-9]{1,3}")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Enter an existing Title ID please.", "Title ID Error.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}
				// -----------GET RENT INFO TO PERFORM RETURN----------
				try {
					rent = managementSystem.getRentByTitleID(Integer.parseInt(titleIDtf.getText()));
				} catch (Exception exc) {
					exc.getMessage();
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"The Title of ID " + rent.getRentID() + " is not being rented or doesn't exist.",
							"Non-Existent Title ID in Rent Section.", JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}

				// -----------GET TITLE JUST TO CHECK IF IT EXISTS----------
				ArrayList<Object> UnknownTitleType;

				try {// try/catch in case it is null not to pause the program
					UnknownTitleType = managementSystem.getTitleInfoByID(Integer.parseInt(titleIDtf.getText()));

					if (UnknownTitleType.isEmpty()) {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null,
								"There's no Title ID " + titleIDtf.getText() + " in the System.", "Non-Existent ID.",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
						return;
					}
				} catch (Exception exc) {
					exc.getMessage();
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Title of ID " + titleIDtf.getText() + " is not being rented or doesn't exist.",
							"Non-Existent Title ID in Rent Section.", JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}

				unwrapTitle(UnknownTitleType);

				if (rent == null) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"The Title: " + title.getName() + " of ID " + title.getId() + " is not being rented.",
							"Title" + title.getName() + " is available.", JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}

				// -----------GET CARD TO UPDATE----------
				try {
					card = managementSystem.getCardInfoByID(rent.getCardID());
				} catch (Exception ex) {
					ex.getMessage();
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Error class ReturnTitle, GET CARD INFO section",
							"Card Doesn't Exist", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}
				// subtract 1 from ongoing titles
				card.removeOngoingRents();

				int check = managementSystem.returnTitle(rent, card);
				switch (check) {
				case 1:
					Object[] btnz = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Title: " + title.getName() + ", ID: " + title.getId() + " returned successfully",
							"Title Returned.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btnz,
							btnz[0]);
					returnTitleScreen.dispose();
					break;
				case 2:
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Error while setting back Title to available",
							"Error Title Availability.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
							btns, btns[0]);
					return;
				case 3:
					Object[] btnss = { "Ok" };
					JOptionPane.showOptionDialog(null, "Error while setting back return Title on Card",
							"Error Card Ongoing Rents.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
							btnss, btnss[0]);
					return;
				case 4:
					Object[] btnsss = { "Ok" };
					JOptionPane.showOptionDialog(null, "Error while deleting Rent from system",
							"Error Rent Deletion.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
							btnsss, btnsss[0]);
					return;
				}
			}

		});
		confirmBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				confirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				confirmBtn.setIcon(new ImageIcon("img\\btn\\hover\\confirmbtnhover.png"));
				confirmBtn.setBounds(411, 125, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
				confirmBtn.setBounds(415, 123, 170, 80);
			}
		});
	}

	/**
	 * @param unknowntitletype the ArrayList of object title types
	 */
	public void unwrapTitle(ArrayList<Object> unknowntitletype) {

		for (Object obj : unknowntitletype) {
			switch (obj.getClass().getName()) {// or filter.getName()
			case "model.titles.MusicOrLive":
				title = (Title) obj;
				break;
			case "model.titles.Movie":
				title = (Title) obj;
				break;
			case "model.titles.BoxSet":
				title = (Title) obj;
				break;
			}
		}
	}

	public void validation() {
		returnTitleScreen.repaint();
		returnTitleScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {
//------------------movie genre TextField-------------------------
		if (titleIDtf.getText().matches("enter title id")) {
			titleIDtf.setText("");
			titleIDtf.setForeground(new Color(0, 80, 110));
		}
		if (!titleIDtf.hasFocus()) {
			if (titleIDtf.getText().matches("")) {
				titleIDtf.setText("enter title id");
				titleIDtf.setForeground(new Color(180, 180, 180));
			}
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
