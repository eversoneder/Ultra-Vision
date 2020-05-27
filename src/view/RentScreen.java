package view;

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

import controller.KeyController;
import model.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.Title;
import view.customer.CustomerAuthenticationScreen;
import view.customer.SearchCustomerScreen;
import view.title.SearchTitleScreen;

public class RentScreen implements FocusListener {

	private JFrame rentScreen = new JFrame();
	private KeyController listenerController = new KeyController(rentScreen);

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);
	
	private JTextField customerIDtf;
	private JTextField titleIDtf;

	private MembershipCard card = new MembershipCard();
	private Customer customer = new Customer();

	private Title title;
	
	public RentScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public void setAttributes() {
		rentScreen.setSize(800, 330);
		rentScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		rentScreen.setUndecorated(true);
		rentScreen.setVisible(true);
		rentScreen.setResizable(false);
		rentScreen.setTitle("Rental Issue");
		rentScreen.setLocationRelativeTo(null);
		rentScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		
		rentScreen.addKeyListener(listenerController);
		rentScreen.addWindowListener(listenerController);
		rentScreen.addMouseListener(listenerController);
		rentScreen.addMouseMotionListener(listenerController);
	}

	private void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		rentScreen.add(backPanel);
		
		closeBtn(backPanel);

		JLabel issueRentalLabel = new JLabel("Issue Title Rental");
		issueRentalLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		issueRentalLabel.setBounds(30, 15, 200, 30);
		issueRentalLabel.setForeground(Color.WHITE);
		backPanel.add(issueRentalLabel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 60, rentScreen.getWidth(), rentScreen.getHeight() - 115);
		backPanel.add(backRectangle);

		JLabel customerIcon = new JLabel();
		customerIcon.setIcon(new ImageIcon("img\\icons\\custiconbluesmall.png"));
		customerIcon.setBounds(25, 5, 100, 100);
		backRectangle.add(customerIcon);

		JLabel titleIcon = new JLabel();
		titleIcon.setIcon(new ImageIcon("img\\icons\\titleiconbluesmall.png"));
		titleIcon.setBounds(25, 105, 100, 100);
		backRectangle.add(titleIcon);

		textFields(backRectangle);
		buttons(backRectangle);
	}
	
	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
		closeBtn.setBounds(740, 14, 30, 30);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closebtnsmallhover.png"));
				closeBtn.setBounds(737, 10, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
				closeBtn.setBounds(740, 14, 30, 30);
			}
		});
	}

	public void textFields(JPanel backRectangle) {

		customerIDtf = new JTextField();
		customerIDtf.setText("enter customer id");
		customerIDtf.setForeground(new Color(180, 180, 180));
		customerIDtf.addFocusListener(this);
		customerIDtf.setBounds(140, 30, 250, 45);
		customerIDtf.setBorder(null);
		customerIDtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(customerIDtf);

		titleIDtf = new JTextField();
		titleIDtf.setText("enter title id");
		titleIDtf.setForeground(new Color(180, 180, 180));
		titleIDtf.addFocusListener(this);
		titleIDtf.setBounds(140, 130, 250, 45);
		titleIDtf.setBorder(null);
		titleIDtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(titleIDtf);
	}

	public void buttons(JPanel backRectangle) {

//----------------Search Customer Button----------------------------------------------
		JButton searchCustomerBtn = new JButton();
		searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\searchcustomerbtnsmall.png"));
		searchCustomerBtn.setBackground(backRectangle.getBackground());
		searchCustomerBtn.setBounds(405, 13, 170, 80);
		searchCustomerBtn.setBorderPainted(false);
		searchCustomerBtn.setContentAreaFilled(false);
		searchCustomerBtn.setFocusPainted(false);
		backRectangle.add(searchCustomerBtn);
		searchCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchCustomerScreen();
			}
		});
		searchCustomerBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				searchCustomerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\hover\\searchcustomerbtnsmallhover.png"));
				searchCustomerBtn.setBounds(402, 11, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\searchcustomerbtnsmall.png"));
				searchCustomerBtn.setBounds(405, 13, 170, 80);
			}
		});
// ----------------Search Title Button----------------------------------------------
		JButton searchTitleBtn = new JButton();
		searchTitleBtn.setIcon(new ImageIcon("img\\btn\\searchtitlebtnsmall.png"));
		searchTitleBtn.setBackground(backRectangle.getBackground());
		searchTitleBtn.setBounds(405, 114, 170, 80);
		searchTitleBtn.setBorderPainted(false);
		searchTitleBtn.setContentAreaFilled(false);
		searchTitleBtn.setFocusPainted(false);
		backRectangle.add(searchTitleBtn);
		searchTitleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchTitleScreen();
			}
		});
		searchTitleBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				searchTitleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				searchTitleBtn.setIcon(new ImageIcon("img\\btn\\hover\\searchtitlebtnsmallhover.png"));
				searchTitleBtn.setBounds(401, 112, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				searchTitleBtn.setIcon(new ImageIcon("img\\btn\\searchtitlebtnsmall.png"));
				searchTitleBtn.setBounds(405, 114, 170, 80);
			}
		});
// ---------------------------CANCEL BUTTON-------------------------------
		JButton cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
		cancelBtn.setBackground(backRectangle.getBackground());
		cancelBtn.setBounds(595, 13, 170, 80);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		backRectangle.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentScreen.dispose();
			}
		});
		cancelBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cancelBtn.setIcon(new ImageIcon("img\\btn\\hover\\cancelbtnsmallhover.png"));
				cancelBtn.setBounds(591, 11, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
				cancelBtn.setBounds(595, 13, 170, 80);
			}
		});
// ---------------------------CONFIRM BUTTON-------------------------------
		JButton confirmBtn = new JButton();
		confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
		confirmBtn.setBackground(backRectangle.getBackground());
		confirmBtn.setBounds(595, 113, 170, 80);
		confirmBtn.setBorderPainted(false);
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.setFocusPainted(false);
		backRectangle.add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

				if (!customerIDtf.getText().matches("[0-9]{1,3}")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Enter an existing customer ID please.",
							"Customer ID Error.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}

				if (!titleIDtf.getText().matches("[0-9]{1,3}")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Enter an existing Title ID please.", "Title ID Error.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}

				// -----------GET CUSTOMER INFO TO DO VALIDATIONS----------
				customer = new Customer();
				try {
					customer = managementSystem.getCustomerInfoByID(Integer.parseInt(customerIDtf.getText()));
				} catch (Exception exx) {
					exx.getMessage();
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"There's no customer ID " + customerIDtf.getText() + " in the System.", "Non-Existent ID.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}
				
				

				// -----------GET CARD INFO TO DO VALIDATIONS----------
				card = new MembershipCard();
				try {
					card = managementSystem.getCardInfoByID(customer.getCardID());
				} catch (Exception ex) {
					ex.getMessage();
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"There's no customer ID " + customerIDtf.getText() + " in the System.", "Non-Existent ID.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}

				// -----------GET TITLE INFO TO DO VALIDATIONS----------
				ArrayList<Object> UnknownTitleType;
				try {
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
							"There's no Title ID " + titleIDtf.getText() + " in the System.", "Non-Existent ID.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}

				unwrapTitle(UnknownTitleType);

				if(title.getAvailable() == 0) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"The Title of ID number "+title.getId()+" is already being rented.", "Can't Rent A Rented Title.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}
				
				if (card.getTitleTypeDB() == title.getSubscriptionID() || card.getTitleTypeDB() == 4) {

					// -------CHECK RENT LIMIT---------
					int canRentMore = card.checkRentingLimit();

					switch (canRentMore) {
					
					case 0:// has 4 ongoing rents
						Object[] ongoing = { "Ok" };
						JOptionPane.showOptionDialog(null, "Can't proceed, customer has 4 ongoing rents \nregistered in the Membership Card.",
								"Maximum ongoing rents.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
								logoIcon, ongoing, ongoing[0]);
						return;
						
					case 1:// can rent more titles
						new CustomerAuthenticationScreen(customer, card, UnknownTitleType);
						break;
					}

				} else {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Customer is not allowed to rent " + title.getTitleTypeGUI()
									+ " \nas the Customer's subscription is " + card.getSubscriptionPlan() + ".",
							"Title Access Level Error.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
							btns, btns[0]);
					return;
				}
			}
		});
		confirmBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				confirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				confirmBtn.setIcon(new ImageIcon("img\\btn\\hover\\confirmbtnhover.png"));
				confirmBtn.setBounds(591, 115, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
				confirmBtn.setBounds(595, 113, 170, 80);
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
		rentScreen.repaint();
		rentScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {
//------------------movie genre TextField-------------------------
		if (customerIDtf.getText().matches("enter customer id")) {
			customerIDtf.setText("");
			customerIDtf.setForeground(new Color(0, 80, 110));
		}
		if (!customerIDtf.hasFocus()) {
			if (customerIDtf.getText().matches("")) {
				customerIDtf.setText("enter customer id");
				customerIDtf.setForeground(new Color(180, 180, 180));
			}
		}
		// ------------------movie genre TextField-------------------------
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
