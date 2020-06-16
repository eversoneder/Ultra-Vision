package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
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

	private ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

	private JFrame rentScreen = new JFrame();
	private KeyController listenerController = new KeyController(rentScreen);

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private int tfCount;
	private JTextField customerIDtf, titleIDtf1, titleIDtf2, titleIDtf3, titleIDtf4;

	private MembershipCard card = new MembershipCard();
	private Customer customer = new Customer();

	private ArrayList<Title> titleList = new ArrayList<>();
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

		plusBtn(120);

		JLabel customerIcon = new JLabel();
		customerIcon.setIcon(new ImageIcon("img\\icons\\custiconbluesmall.png"));
		customerIcon.setBounds(25, 20, 100, 100);
		backRectangle.add(customerIcon);

		setTitleIcon(405, 20);

		tfCount = 1;
		customerIDtf = setTextField(140, 45, "enter customer id");
		titleIDtf1 = setTextField(520, 45, "enter title id");

		buttons();
	}

	public void plusBtn(int y) {

		plusBtn = new JButton();
		plusBtn.setIcon(new ImageIcon("img\\btn\\plusbtn.png"));
		plusBtn.setBounds(590, y, 80, 80);
		plusBtn.setBorderPainted(false);
		plusBtn.setContentAreaFilled(false);
		plusBtn.setFocusPainted(false);
		backRectangle.add(plusBtn);
		plusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfCount < 3) {
					btnsPlus100();
					addTitleField();

					rentScreen.setSize(800, rentScreen.getHeight() + 100);
					rentScreen.setLocationRelativeTo(null);
					backRectangle.setBounds(0, 90, rentScreen.getWidth(), rentScreen.getHeight() - 120);

				} else {
					tfCount++;
					addTitleField();
					backRectangle.remove(plusBtn);

				}
				validation();
			}
		});
		plusBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				plusBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				plusBtn.setIcon(new ImageIcon("img\\btn\\hover\\plusbtnhover.png"));
				plusBtn.setBounds(587, y - 3, 86, 86);
			}

			public void mouseExited(MouseEvent evt) {
				plusBtn.setIcon(new ImageIcon("img\\btn\\plusbtn.png"));
				plusBtn.setBounds(590, y, 80, 80);
			}
		});
	}

	public void addTitleField() {

		switch (tfCount) {
		case 2:
			titleIcon2 = setTitleIcon(405, 120);
			titleIDtf2 = setTextField(520, titleIcon2.getY() + 25, "enter title id");
			removeBtn2 = setRemoveBtn(740, titleIcon2.getY() - 5);

			removeBtn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// remove title field

					switch (tfCount) {
					case 2:
						removeTitleField(titleIcon2, titleIDtf2, removeBtn2);
						btnsMinus100();
						rentScreen.setSize(800, rentScreen.getHeight() - 100);
						rentScreen.setLocationRelativeTo(null);
						backRectangle.setBounds(0, 90, rentScreen.getWidth(), rentScreen.getHeight() - 120);
						break;
					case 3:
						if (!titleIDtf3.getText().matches("enter title id")) {
							titleIDtf2.setText(titleIDtf3.getText());
						}
						removeTitleField(titleIcon3, titleIDtf3, removeBtn3);
						btnsMinus100();
						rentScreen.setSize(800, rentScreen.getHeight() - 100);
						rentScreen.setLocationRelativeTo(null);
						backRectangle.setBounds(0, 90, rentScreen.getWidth(), rentScreen.getHeight() - 120);
						break;
					case 4:
						if (!titleIDtf3.getText().matches("enter title id")) {
							titleIDtf2.setText(titleIDtf3.getText());
						}
						if (!titleIDtf4.getText().matches("enter title id")) {
							titleIDtf3.setText(titleIDtf4.getText());
						}
						removeTitleField(titleIcon4, titleIDtf4, removeBtn4);
						plusBtn(320);
						validation();
						break;
					}
				}
			});
			break;
		case 3:
			titleIcon3 = setTitleIcon(405, 220);
			titleIDtf3 = setTextField(520, titleIcon3.getY() + 25, "enter title id");
			removeBtn3 = setRemoveBtn(740, titleIcon3.getY() - 5);

			removeBtn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// remove title field

					switch (tfCount) {
					case 3:
						removeTitleField(titleIcon3, titleIDtf3, removeBtn3);
						btnsMinus100();
						rentScreen.setSize(800, rentScreen.getHeight() - 100);
						rentScreen.setLocationRelativeTo(null);
						backRectangle.setBounds(0, 90, rentScreen.getWidth(), rentScreen.getHeight() - 120);
						break;
					case 4:
						if (!titleIDtf4.getText().matches("enter title id")) {
							titleIDtf3.setText(titleIDtf4.getText());
						}
						removeTitleField(titleIcon4, titleIDtf4, removeBtn4);
						plusBtn(320);
						validation();
						break;
					}
				}
			});
			break;
		case 4:
			titleIcon4 = setTitleIcon(405, 320);
			titleIDtf4 = setTextField(520, titleIcon4.getY() + 25, "enter title id");
			removeBtn4 = setRemoveBtn(740, titleIcon4.getY() - 5);

			removeBtn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {// remove title field
					removeTitleField(titleIcon4, titleIDtf4, removeBtn4);
					plusBtn(320);
					validation();
				}
			});
			break;
		}
	}

	public void btnsPlus100() {

		int oldPlusY = plusBtn.getY();
		backRectangle.remove(plusBtn);
		plusBtn(oldPlusY + 103);
//		plusBtn.setLocation(new Point(plusBtn.getX(), plusBtn.getY()+103));//?

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
	}

	public void removeTitleField(JLabel icon, JTextField tf, JButton btn) {

		backRectangle.remove(icon);
		backRectangle.remove(tf);
		backRectangle.remove(btn);
		tfCount--;
	}

	public void btnsMinus100() {

		int oldPlusY = plusBtn.getY();
		backRectangle.remove(plusBtn);
		plusBtn(oldPlusY - 100);

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

	public JTextField setTextField(int x, int y, String text) {

		JTextField tf = new JTextField();
		tf.setText(text);
		tf.setForeground(new Color(180, 180, 180));
		tf.addFocusListener(this);
		tf.setBounds(x, y, 250, 45);
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

				// validate 3 digit integer number (customer id field)
				checkNumberField(customerIDtf);

				// validate 3 digit integer number (title id field)
				switch (tfCount) {
				case 1:
					checkNumberField(titleIDtf1);
					break;
				case 2:
					checkNumberField(titleIDtf1);
					checkNumberField(titleIDtf2);
					break;
				case 3:
					checkNumberField(titleIDtf1);
					checkNumberField(titleIDtf2);
					checkNumberField(titleIDtf3);
					break;
				case 4:
					checkNumberField(titleIDtf1);
					checkNumberField(titleIDtf2);
					checkNumberField(titleIDtf3);
					checkNumberField(titleIDtf4);
					break;
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

				switch (tfCount) {
				case 1:// GET TITLE 1 INFO TO DO VALIDATIONS
					validateTitle(titleIDtf1);
					break;
				case 2:// GET TITLE 1&2 INFO TO DO VALIDATIONS
					validateTitle(titleIDtf1);
					validateTitle(titleIDtf2);
					break;
				case 3:// GET TITLE 1,2&3 INFO TO DO VALIDATIONS
					validateTitle(titleIDtf1);
					validateTitle(titleIDtf2);
					validateTitle(titleIDtf3);
					break;
				case 4:// GET TITLE 1,2,3&4 INFO TO DO VALIDATIONS
					validateTitle(titleIDtf1);
					validateTitle(titleIDtf2);
					validateTitle(titleIDtf3);
					validateTitle(titleIDtf4);
					break;
				}

				// for loop validations: availability, subscription match & card rent limit
				for (Title t : titleList) {

					if (t.getAvailable() == 0) {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null,
								"The Title of ID number " + t.getId() + " is already being rented.",
								"Can't Rent A Rented Title.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
								logoIcon, btns, btns[0]);
						return;

					} else {// title is available
						if (card.getTitleTypeDB() == t.getSubscriptionID() || card.getTitleTypeDB() == 4) {

							boolean isLessThan4 = card.hasLessThan4OngoingRents();

							if (!isLessThan4) {// has 4 ongoing rents
								Object[] ongoing = { "Ok" };
								JOptionPane.showOptionDialog(null,
										"Can't proceed, customer has 4 ongoing rents \nregistered in the Membership Card.",
										"Maximum ongoing rents.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
										logoIcon, ongoing, ongoing[0]);
								return;

							} else {// can rent the title

								int a = card.getOngoingRents() + tfCount;
								if (card.getOngoingRents() + tfCount <= 4) {

									// if title validation reaches here, this title is all good to be rented

								} else {// card ongoing rents + tfCount <= 4
									Object[] ongoing = { "Ok" };
									JOptionPane.showOptionDialog(null,
											"Customer has " + card.getOngoingRents()
													+ " ongoing rents \nand can't rent " + tfCount
													+ " more as the maximum rents allowed is 4 titles.",
											"Maximum ongoing rents will be exceeded.", JOptionPane.YES_NO_OPTION,
											JOptionPane.PLAIN_MESSAGE, logoIcon, ongoing, ongoing[0]);
									return;
								}
							}

						} else {// not the same access level
							Object[] btns = { "Ok" };
							JOptionPane.showOptionDialog(null,
									"Customer is not allowed to rent " + title.getTitleTypeGUI()
											+ " \nas the Customer's subscription is " + card.getSubscriptionPlan()
											+ ".",
									"Title Access Level Error.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
									logoIcon, btns, btns[0]);
							return;
						}
					}
				}
				new CustomerAuthenticationScreen(customer, card, titleList);
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

	public int getFieldNumber(JTextField tf) {

		int fieldNumber = 0;
		switch (tf.getY()) {
		case 45:
			fieldNumber = 1;
			break;
		case 145:
			fieldNumber = 2;
			break;
		case 245:
			fieldNumber = 3;
			break;
		case 345:
			fieldNumber = 4;
			break;
		}

		return fieldNumber;
	}

	public void checkNumberField(JTextField tf) {

		int fieldNumber = getFieldNumber(tf);

		String custOrTitle = "";
		switch (tf.getX()) {
		case 140:
			custOrTitle = "Customer";
			break;
		case 520:
			custOrTitle = "Title";
			break;
		}

		if (!tf.getText().matches("[0-9]{1,3}")) {
			Object[] btns = { "Ok" };
			JOptionPane.showOptionDialog(null,
					custOrTitle + " Field " + fieldNumber + " Error.\nEnter an existing " + custOrTitle + " ID please.",
					custOrTitle + " ID Error.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
					btns[0]);
			return;
		}
	}

	/**
	 * adds title to titleList
	 * 
	 * @param textField to check in DB
	 */
	public void validateTitle(JTextField textField) {

		int fieldNumber = getFieldNumber(textField);

		ArrayList<Object> temp = getTitle(Integer.parseInt(textField.getText()));

		if (temp.isEmpty()) {
			Object[] btns = { "Ok" };
			JOptionPane.showOptionDialog(null,
					"Title Field " + fieldNumber + " Error.\nThere's no Title ID " + textField.getText()
							+ " in the System.",
					"Non-Existent ID.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
			return;
		} else {
			titleList.add((Title) temp.get(0));
		}
	}

	public ArrayList<Object> getTitle(int titleID) {

		ArrayList<Object> UnknownTitleType = null;
		try {
			UnknownTitleType = managementSystem.getTitleInfoByID(titleID);

		} catch (Exception exc) {
			exc.getMessage();
			Object[] btns = { "Ok" };
			JOptionPane.showOptionDialog(null, "There's no Title ID " + titleID + " in the System.", "Non-Existent ID.",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
		}

		return UnknownTitleType;
	}

	public void buttons() {
		setSearchCustomerBtn(35, 253);
		setSearchTitleBtn(225, 253);
		setCancelBtn(410, 253);
		setConfirmBtn(595, 253);
	}

	public JLabel setTitleIcon(int x, int y) {
		JLabel titleIcon = new JLabel();
		titleIcon.setIcon(new ImageIcon("img\\icons\\titleiconbluesmall.png"));
		titleIcon.setBounds(x, y, 100, 100);
		backRectangle.add(titleIcon);

		return titleIcon;
	}

	public JButton setRemoveBtn(int x, int y) {
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon("img\\btn\\removebtnsmall.png"));
		btn.setBounds(x, y, 30, 30);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		backRectangle.add(btn);

		btn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn.setIcon(new ImageIcon("img\\btn\\hover\\removebtnsmallhover.png"));
				btn.setBounds(x - 3, y - 3, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				btn.setIcon(new ImageIcon("img\\btn\\removebtnsmall.png"));
				btn.setBounds(x, y, 30, 30);
			}
		});
		return btn;
	}

	public void validation() {
		rentScreen.repaint();
		rentScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {

		JTextField clickedTF = (JTextField) e.getComponent();

		switch (clickedTF.getText()) {

		case "enter customer id":
			clickedTF.setText("");
			clickedTF.setForeground(new Color(0, 80, 110));
			break;

		case "enter title id":
			clickedTF.setText("");
			clickedTF.setForeground(new Color(0, 80, 110));
			break;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {

		JTextField clickedTF = (JTextField) e.getComponent();

		if (!clickedTF.hasFocus()) {
			if (clickedTF.getText().matches("")) {

				if (clickedTF.getX() == 520) {// X:520 are only title text fields
					clickedTF.setText("enter title id");
					clickedTF.setForeground(new Color(180, 180, 180));
				} else {// means any other text field that isn't 520 which is customer tf
					clickedTF.setText("enter customer id");
					clickedTF.setForeground(new Color(180, 180, 180));
				}
			}

		}
		// TODO Auto-generated method stub

	}
}
