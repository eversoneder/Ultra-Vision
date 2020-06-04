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

	private int tfCount;
	private JTextField customerIDtf, titleIDtf1, titleIDtf2, titleIDtf3, titleIDtf4;

	private MembershipCard card = new MembershipCard();
	private Customer customer = new Customer();

	private Title title;
	private JPanel backPanel, backRectangle;

	private JButton plusBtn, removeBtn2, removeBtn3, removeBtn4, closeBtn, searchCustomerBtn, searchTitleBtn, cancelBtn,
			confirmBtn;

	private JLabel titleIcon2, titleIcon3, titleIcon4;

	public RentScreen() {
		setFrameAttributes();
		setComponents();
		validation();
	}

	public void setFrameAttributes() {
		rentScreen.setSize(800, 460);
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

		backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		rentScreen.add(backPanel);

		JLabel logobluecircle = new JLabel();
		logobluecircle.setIcon(new ImageIcon("img\\icons\\logobluecircle.png"));
		logobluecircle.setBounds(320, 5, 150, 110);
		backPanel.add(logobluecircle);

		closeBtn();

		JLabel issueRentalLabel = new JLabel("Issue Title Rental");
		issueRentalLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		issueRentalLabel.setBounds(30, 15, 200, 30);
		issueRentalLabel.setForeground(Color.WHITE);
		backPanel.add(issueRentalLabel);

		backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 90, rentScreen.getWidth(), rentScreen.getHeight() - 120);
		backPanel.add(backRectangle);

		plusBtn(590, 120);

		JLabel customerIcon = new JLabel();
		customerIcon.setIcon(new ImageIcon("img\\icons\\custiconbluesmall.png"));
		customerIcon.setBounds(25, 20, 100, 100);
		backRectangle.add(customerIcon);

		JLabel titleIcon1 = setTitleIcon(405, 20);

		tfCount = 1;
		customerIDtf = tfInstantiation(140, 45, "enter customer id");
		titleIDtf1 = tfInstantiation(520, 45, "enter title id");

		buttons();
	}

	public void plusBtn(int x, int y) {

		plusBtn = new JButton();
		plusBtn.setIcon(new ImageIcon("img\\btn\\plusbtn.png"));
		plusBtn.setBounds(x, y, 80, 80);
		plusBtn.setBorderPainted(false);
		plusBtn.setContentAreaFilled(false);
		plusBtn.setFocusPainted(false);
		backRectangle.add(plusBtn);
		plusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfCount < 4) {

					rentScreen.setSize(800, rentScreen.getHeight() + 100);
					rentScreen.setLocationRelativeTo(null);
					backRectangle.setBounds(0, 90, rentScreen.getWidth(), rentScreen.getHeight() - 120);

					int oldPlusY = plusBtn.getY();
					backRectangle.remove(plusBtn);
					plusBtn(590, oldPlusY + 103);

					int oldscBtnY = searchCustomerBtn.getY();
					backRectangle.remove(searchCustomerBtn);
					setSearchCustomerBtn(35, oldscBtnY + 100);

					int oldstBtnY = searchTitleBtn.getY();
					backRectangle.remove(searchTitleBtn);
					setSearchTitleBtn(225, oldstBtnY + 100);

					int oldcancelBtnY = cancelBtn.getY();
					backRectangle.remove(cancelBtn);
					setCancelBtn(410, oldcancelBtnY + 100);

					int oldconfirmBtnY = confirmBtn.getY();
					backRectangle.remove(confirmBtn);
					setConfirmBtn(595, oldconfirmBtnY + 100);

					tfCount++;
					addTitleField();
					
					if(tfCount == 4) {
						backRectangle.remove(plusBtn);
					}

				} else {
					backRectangle.remove(plusBtn);
				}
			}
		});
		plusBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				plusBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				plusBtn.setIcon(new ImageIcon("img\\btn\\hover\\plusbtnhover.png"));
				plusBtn.setBounds(x - 3, y - 3, 86, 86);
			}

			public void mouseExited(MouseEvent evt) {
				plusBtn.setIcon(new ImageIcon("img\\btn\\plusbtn.png"));
				plusBtn.setBounds(x, y, 80, 80);
			}
		});
	}

	public void addTitleField() {

		switch (tfCount) {
		case 2:
			titleIcon2 = setTitleIcon(405, 120);
			titleIDtf2 = tfInstantiation(520, 145, "enter title id");
			removeBtn2 = setRemoveBtn(740, 115);

			removeBtn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// remove title field
					
					switch(tfCount) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					}
					
					backRectangle.remove(titleIcon2);
					backRectangle.remove(titleIDtf2);
					backRectangle.remove(removeBtn2);
					tfCount--;

					btnsMinus100();

					rentScreen.setSize(800, rentScreen.getHeight() - 100);
					rentScreen.setLocationRelativeTo(null);
					backRectangle.setBounds(0, 90, rentScreen.getWidth(), rentScreen.getHeight() - 120);
				}
			});
			break;
		case 3:
			titleIcon3 = setTitleIcon(405, 220);
			titleIDtf3 = tfInstantiation(520, 245, "enter title id");
			removeBtn3 = setRemoveBtn(740, 215);

			removeBtn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// remove title field
					backRectangle.remove(titleIcon3);
					backRectangle.remove(titleIDtf3);
					backRectangle.remove(removeBtn3);
					tfCount--;

					btnsMinus100();

					rentScreen.setSize(800, rentScreen.getHeight() - 100);
					rentScreen.setLocationRelativeTo(null);
					backRectangle.setBounds(0, 90, rentScreen.getWidth(), rentScreen.getHeight() - 120);
				}
			});
			break;
		case 4:
			titleIcon4 = setTitleIcon(405, 320);
			titleIDtf4 = tfInstantiation(520, 345, "enter title id");
			removeBtn4 = setRemoveBtn(740, 315);

			removeBtn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// remove title field
					backRectangle.remove(titleIcon4);
					backRectangle.remove(titleIDtf4);
					backRectangle.remove(removeBtn4);
					tfCount--;

					btnsMinus100();

					rentScreen.setSize(800, rentScreen.getHeight() - 100);
					rentScreen.setLocationRelativeTo(null);
					backRectangle.setBounds(0, 90, rentScreen.getWidth(), rentScreen.getHeight() - 120);
				}
			});
			break;
		}
	}

	public void btnsMinus100() {

		int oldPlusY = plusBtn.getY();
		backRectangle.remove(plusBtn);
		plusBtn(590, oldPlusY - 100);

		int oldscBtnY = searchCustomerBtn.getY();
		backRectangle.remove(searchCustomerBtn);
		setSearchCustomerBtn(35, oldscBtnY - 100);

		int oldstBtnY = searchTitleBtn.getY();
		backRectangle.remove(searchTitleBtn);
		setSearchTitleBtn(225, oldstBtnY - 100);

		int oldcancelBtnY = cancelBtn.getY();
		backRectangle.remove(cancelBtn);
		setCancelBtn(410, oldcancelBtnY - 100);

		int oldconfirmBtnY = confirmBtn.getY();
		backRectangle.remove(confirmBtn);
		setConfirmBtn(595, oldconfirmBtnY - 100);
	}

	public JTextField tfInstantiation(int w, int h, String text) {

		JTextField tf = new JTextField();
		tf.setText(text);
		tf.setForeground(new Color(180, 180, 180));
		tf.addFocusListener(this);
		tf.setBounds(w, h, 250, 45);
		tf.setBorder(null);
		tf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(tf);
		return tf;
	}

	public void closeBtn() {

		closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
		closeBtn.setBounds(750, 14, 30, 30);
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
				closeBtn.setBounds(747, 10, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
				closeBtn.setBounds(750, 14, 30, 30);
			}
		});
	}

	public void setSearchCustomerBtn(int x, int y) {

// ----------------Search Customer Button----------------------------------------------

		searchCustomerBtn = new JButton();
		searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\searchcustomerbtnsmall.png"));
		searchCustomerBtn.setBackground(backRectangle.getBackground());
		searchCustomerBtn.setBounds(x, y, 170, 80);
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
				searchCustomerBtn.setBounds(x - 3, y - 2, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\searchcustomerbtnsmall.png"));
				searchCustomerBtn.setBounds(x, y, 170, 80);
			}
		});
	}

	public void setSearchTitleBtn(int x, int y) {

// ----------------Search Title Button----------------------------------------------

		searchTitleBtn = new JButton();
		searchTitleBtn.setIcon(new ImageIcon("img\\btn\\searchtitlebtnsmall.png"));
		searchTitleBtn.setBackground(backRectangle.getBackground());
		searchTitleBtn.setBounds(x, y, 170, 80);
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
				searchTitleBtn.setBounds(x - 4, y - 2, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				searchTitleBtn.setIcon(new ImageIcon("img\\btn\\searchtitlebtnsmall.png"));
				searchTitleBtn.setBounds(x, y, 170, 80);
			}
		});
	}

	public void setCancelBtn(int x, int y) {

		// ---------------------------CANCEL BUTTON-------------------------------

		cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
		cancelBtn.setBackground(backRectangle.getBackground());
		cancelBtn.setBounds(x, y, 170, 80);
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
				cancelBtn.setBounds(x - 4, y - 2, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
				cancelBtn.setBounds(x, y, 170, 80);
			}
		});
	}

	public void setConfirmBtn(int x, int y) {

		// ---------------------------CONFIRM BUTTON-------------------------------

		confirmBtn = new JButton();
		confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
		confirmBtn.setBackground(backRectangle.getBackground());
		confirmBtn.setBounds(x, y, 170, 80);
		confirmBtn.setBorderPainted(false);
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.setFocusPainted(false);
		backRectangle.add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

				if (!customerIDtf.getText().matches("[0-9]{1,3}")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Enter an existing customer ID please.", "Customer ID Error.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}

				if (!titleIDtf1.getText().matches("[0-9]{1,3}")) {
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
					UnknownTitleType = managementSystem.getTitleInfoByID(Integer.parseInt(titleIDtf1.getText()));

					if (UnknownTitleType.isEmpty()) {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null,
								"There's no Title ID " + titleIDtf1.getText() + " in the System.", "Non-Existent ID.",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
						return;
					}
				} catch (Exception exc) {
					exc.getMessage();
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"There's no Title ID " + titleIDtf1.getText() + " in the System.", "Non-Existent ID.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}

				unwrapTitle(UnknownTitleType);

				if (title.getAvailable() == 0) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"The Title of ID number " + title.getId() + " is already being rented.",
							"Can't Rent A Rented Title.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}

				if (card.getTitleTypeDB() == title.getSubscriptionID() || card.getTitleTypeDB() == 4) {

					// -------CHECK RENT LIMIT---------
					int canRentMore = card.checkRentingLimit();

					switch (canRentMore) {

					case 0:// has 4 ongoing rents
						Object[] ongoing = { "Ok" };
						JOptionPane.showOptionDialog(null,
								"Can't proceed, customer has 4 ongoing rents \nregistered in the Membership Card.",
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
				confirmBtn.setBounds(x - 4, y - 2, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
				confirmBtn.setBounds(x, y, 170, 80);
			}
		});
	}

	public void buttons() {
		setSearchCustomerBtn(35, 253);
		setSearchTitleBtn(225, 253);
		setCancelBtn(410, 253);
		setConfirmBtn(595, 253);
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
		if (titleIDtf1.getText().matches("enter title id")) {
			titleIDtf1.setText("");
			titleIDtf1.setForeground(new Color(0, 80, 110));
		}
		if (!titleIDtf1.hasFocus()) {
			if (titleIDtf1.getText().matches("")) {
				titleIDtf1.setText("enter title id");
				titleIDtf1.setForeground(new Color(180, 180, 180));
			}
		}

	}

	public JLabel setTitleIcon(int w, int h) {
		JLabel titleIcon = new JLabel();
		titleIcon.setIcon(new ImageIcon("img\\icons\\titleiconbluesmall.png"));
		titleIcon.setBounds(w, h, 100, 100);
		backRectangle.add(titleIcon);

		return titleIcon;
	}

	public JButton setRemoveBtn(int w, int h) {
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon("img\\btn\\removebtnsmall.png"));
		btn.setBounds(w, h, 30, 30);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		backRectangle.add(btn);

		btn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn.setIcon(new ImageIcon("img\\btn\\hover\\removebtnsmallhover.png"));
				btn.setBounds(w - 3, h - 3, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				btn.setIcon(new ImageIcon("img\\btn\\removebtnsmall.png"));
				btn.setBounds(w, h, 30, 30);
			}
		});

		return btn;
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
