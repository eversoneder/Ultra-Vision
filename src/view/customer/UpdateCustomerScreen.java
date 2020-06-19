package view.customer;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ListenerController;
import model.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;
import model.enums.AccessLevel;

public class UpdateCustomerScreen implements FocusListener {

	private JFrame updateCustomerScreen = new JFrame();
	private ListenerController listenerController = new ListenerController(updateCustomerScreen);

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField customerNametf;
	private JTextField customerPhonetf;
	private JTextField customerEmailtf;
	private JPasswordField customerPasswordtf;
	private JComboBox<AccessLevel> subscription;

	private int oldPass;

	private Customer customer;
	private MembershipCard card;
	private JButton confirmBtn;

	public UpdateCustomerScreen(Customer customer, MembershipCard card) {
		this.customer = customer;
		this.card = card;
		oldPass = card.getPassword();
		setAttributes();
		setComponents();
		listenerController.getButton(confirmBtn);
		validation();
	}

	public void setAttributes() {
		updateCustomerScreen.setSize(780, 530);
		updateCustomerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateCustomerScreen.setUndecorated(true);
		updateCustomerScreen.setVisible(true);
		updateCustomerScreen.setResizable(false);
		updateCustomerScreen.setTitle("Ultra-Vision | Customer Information Update");
		updateCustomerScreen.setLocationRelativeTo(null);
		updateCustomerScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());

		updateCustomerScreen.addKeyListener(listenerController);
		updateCustomerScreen.addWindowListener(listenerController);
		updateCustomerScreen.addMouseListener(listenerController);
		updateCustomerScreen.addMouseMotionListener(listenerController);
	}

	private void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		updateCustomerScreen.add(backPanel);

		closeBtn(backPanel);

		JLabel issueRentalLabel = new JLabel("Update Customer Info");
		issueRentalLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		issueRentalLabel.setBounds(50, 70, 300, 30);
		issueRentalLabel.setForeground(Color.WHITE);
		backPanel.add(issueRentalLabel);

		JLabel customerScreenLabel = new JLabel("Customer Screen");
		customerScreenLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		customerScreenLabel.setBounds(50, 40, 200, 30);
		customerScreenLabel.setForeground(new Color(0, 80, 110));
		backPanel.add(customerScreenLabel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, updateCustomerScreen.getWidth(), updateCustomerScreen.getHeight() - 135);
		backPanel.add(backRectangle);

		JLabel logoIcon = new JLabel();
		logoIcon.setIcon(new ImageIcon("img\\icons\\logobluecircle.png"));
		logoIcon.setBounds(470, 5, 200, 110);
		backPanel.add(logoIcon);

		JLabel customerScreenIcon = new JLabel();
		customerScreenIcon.setIcon(new ImageIcon("img\\icons\\customerscreeniconshadow.png"));
		customerScreenIcon.setBounds(40, 20, 300, 350);
		backRectangle.add(customerScreenIcon);

		JLabel passLabel = new JLabel("(if no new password is given, old is retained)");
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passLabel.setBounds(350, 190, 250, 30);
		passLabel.setForeground(Color.WHITE);
		backRectangle.add(passLabel);

		textFields(backRectangle);
		buttons(backRectangle);
		setComboBox(backRectangle);
	}

	public void textFields(JPanel backRectangle) {

		customerNametf = new JTextField();
		customerNametf.setText(customer.getCustomer_name());
		customerNametf.setForeground(new Color(180, 180, 180));
		customerNametf.addFocusListener(this);
		customerNametf.setBounds(350, 25, 390, 45);
		customerNametf.setBorder(null);
		customerNametf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		customerNametf.addKeyListener(listenerController);
		backRectangle.add(customerNametf);

		customerPhonetf = new JTextField();
		customerPhonetf.setText(Long.toString(customer.getCustomer_phone()));
		customerPhonetf.setForeground(new Color(180, 180, 180));
		customerPhonetf.addFocusListener(this);
		customerPhonetf.setBounds(350, 85, 390, 45);
		customerPhonetf.setBorder(null);
		customerPhonetf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		customerPhonetf.addKeyListener(listenerController);
		backRectangle.add(customerPhonetf);

		customerEmailtf = new JTextField();
		customerEmailtf.setText(customer.getEmail());
		customerEmailtf.setForeground(new Color(180, 180, 180));
		customerEmailtf.addFocusListener(this);
		customerEmailtf.setBounds(350, 145, 390, 45);
		customerEmailtf.setBorder(null);
		customerEmailtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		customerEmailtf.addKeyListener(listenerController);
		backRectangle.add(customerEmailtf);

		customerPasswordtf = new JPasswordField();
		customerPasswordtf.setText("set new password");
		customerPasswordtf.setForeground(new Color(180, 180, 180));
		customerPasswordtf.addFocusListener(this);
		customerPasswordtf.setBounds(350, 215, 390, 45);
		customerPasswordtf.setBorder(null);
		customerPasswordtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		customerPasswordtf.addKeyListener(listenerController);
		backRectangle.add(customerPasswordtf);

		if (!customerPasswordtf.hasFocus()) {
			customerPasswordtf.setEchoChar((char) 0);
		}

	}

	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
		closeBtn.setBounds(735, 14, 30, 30);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCustomerScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closebtnsmallhover.png"));
				closeBtn.setBounds(732, 10, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
				closeBtn.setBounds(735, 14, 30, 30);
			}
		});
	}

	public void buttons(JPanel backRectangle) {

		// ---------------------------CANCEL BUTTON-------------------------------
		JButton cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
		cancelBtn.setBackground(backRectangle.getBackground());
		cancelBtn.setBounds(375, 308, 170, 80);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		backRectangle.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCustomerScreen.dispose();
			}
		});
		cancelBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cancelBtn.setIcon(new ImageIcon("img\\btn\\hover\\cancelbtnsmallhover.png"));
				cancelBtn.setBounds(371, 306, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
				cancelBtn.setBounds(375, 308, 170, 80);
			}
		});
		// ---------------------------CONFIRM BUTTON-------------------------------
		confirmBtn = new JButton();
		confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
		confirmBtn.setBackground(backRectangle.getBackground());
		confirmBtn.setBounds(550, 308, 170, 80);
		confirmBtn.setBorderPainted(false);
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.setFocusPainted(false);
		backRectangle.add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

				String name = customerNametf.getText().trim();
				String phone = customerPhonetf.getText().trim();
				String email = customerEmailtf.getText().trim();
				String password = String.valueOf(customerPasswordtf.getPassword()).trim();

//----------------------VALIDATE NAME---------------------
				if (!name.matches("[a-zA-Z]+")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Enter letters only please.", "Name Field Error.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}
//----------------------VALIDATE PHONE NUMBER---------------------
				if (!phone.matches("[0-9]{7,16}")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Invalid phone number. \nEnter a valid number please.",
							"Phone Number Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
							btns, btns[0]);
					return;
				}
//----------------------VALIDATE EMAIL ADDRESS---------------------
				if (!email.matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Invalid email addres. \nEnter a valid email please.",
							"Email Address Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
							btns, btns[0]);
					return;
				}
//----------------------VALIDATE PASSWORD---------------------
				if (!password.equals("set new password")) {
					if (!password.matches("[0-9]{8}")) {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Password must be 8 digit numbers.", "Password Field Error",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
						return;
					}
				}
				Long phonelong = Long.parseLong(customerPhonetf.getText());

				ArrayList<String> changedFieldsList = new ArrayList<>();

				boolean cardFlag = false;

				if (!password.equals("set new password")) {

					if (Integer.parseInt(password) != oldPass) {
						card.setPassword(Integer.parseInt(password));
						changedFieldsList.add("password");
						cardFlag = true;

					} else {// SAME PASSWORD
						Object[] btnss = { "Ok" };
						JOptionPane.showOptionDialog(null, "This password is in use, to update set a new password.",
								"Password Matching.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btnss, btnss[0]);
						return;
					}
				}

				boolean custFlag = false;

				if (!customer.getCustomer_name().matches(name)) {
					customer.setCustomer_name(name);
					changedFieldsList.add("name");
					custFlag = true;
				}
				if (customer.getCustomer_phone() != phonelong) {
					customer.setCustomer_phone(phonelong);
					changedFieldsList.add("phone");
					custFlag = true;
				}
				if (!customer.getEmail().matches(email)) {
					customer.setEmail(email);
					changedFieldsList.add("email");
					custFlag = true;
				}

				if (!subscription.getSelectedItem().toString().equals(card.getTitleTypeGUI())) {

					switch (subscription.getSelectedItem().toString()) {
					case "ML":
						card.setTitleTypeGUI(AccessLevel.ML);
						break;
					case "VL":
						card.setTitleTypeGUI(AccessLevel.VL);
						break;
					case "TV":
						card.setTitleTypeGUI(AccessLevel.TV);
						break;
					case "PR":
						card.setTitleTypeGUI(AccessLevel.PR);
						break;
					}
					changedFieldsList.add("subscription");
					cardFlag = true;
				}

				// UPDATE CUSTOMER DB
				if (custFlag) {
					int custUpdate = managementSystem.updateCustomer(customer);// register DB

					switch (custUpdate) {
					case 0:// fail case name, phone, address
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Couldn't update customer information",
								"Customer Info Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btns, btns[0]);
						return;
					}
				}

				if (cardFlag) {
					int cardUpdate = managementSystem.updateCard(card);

					switch (cardUpdate) {
					case 0:
						Object[] btnz = { "Ok" };
						JOptionPane.showOptionDialog(null, "Card information couldn't be changed.",
								"Card Update Error.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btnz, btnz[0]);
						return;
					}
				}

				String allChangedFields = "";
				for (int i = 0; i < changedFieldsList.size(); i++) {

					if (i == 0) {
						String firstWordWithFirstCharUpper = changedFieldsList.get(0).substring(0, 1).toUpperCase();
						String restOfWord = changedFieldsList.get(0).substring(1, changedFieldsList.get(0).length());

						firstWordWithFirstCharUpper += restOfWord;
						changedFieldsList.remove(0);
						changedFieldsList.add(0, firstWordWithFirstCharUpper);

						allChangedFields = changedFieldsList.get(0);
					} else {

						if (i == changedFieldsList.size() - 1) {
							allChangedFields += " & " + changedFieldsList.get(i);

						} else {
							allChangedFields += ", " + changedFieldsList.get(i);
						}
					}
				}

				Object[] btn = { "Ok" };
				JOptionPane.showOptionDialog(null, allChangedFields + " has been changed.", "Changes Made",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btn, btn[0]);
				updateCustomerScreen.dispose();
			}

		});
		confirmBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				confirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				confirmBtn.setIcon(new ImageIcon("img\\btn\\hover\\confirmbtnhover.png"));
				confirmBtn.setBounds(546, 306, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
				confirmBtn.setBounds(550, 308, 170, 80);
			}
		});
	}

	public void validation() {
		updateCustomerScreen.repaint();
		updateCustomerScreen.validate();
	}

	public void setComboBox(JPanel backRectangle) {

		JLabel planLabel = new JLabel("Subscription Plan:");
		planLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		planLabel.setBounds(350, 272, 200, 30);
		planLabel.setForeground(Color.WHITE);
		backRectangle.add(planLabel);

		AccessLevel[] subsPlans = AccessLevel.values();

		subscription = new JComboBox<AccessLevel>(subsPlans);
		subscription.setSelectedIndex(card.getTitleTypeDB() - 1);
		subscription.setBounds(520, 274, 65, 25);
		subscription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		backRectangle.add(subscription);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// --------CUSTOMER NAME TEXTFIELD-----------
		if (customerNametf.getText().matches(customer.getCustomer_name())) {
			customerNametf.setText("");
			customerNametf.setForeground(new Color(0, 80, 110));
		}
		if (!customerNametf.hasFocus()) {
			if (customerNametf.getText().matches("")) {
				customerNametf.setText(customer.getCustomer_name());
				customerNametf.setForeground(new Color(180, 180, 180));
			}
		}
		// --------CUSTOMER PHONE TEXTFIELD-----------
		if (customerPhonetf.getText().matches(Long.toString(customer.getCustomer_phone()))) {
			customerPhonetf.setText("");
			customerPhonetf.setForeground(new Color(0, 80, 110));
		}
		if (!customerPhonetf.hasFocus()) {
			if (customerPhonetf.getText().matches("")) {
				customerPhonetf.setText(Long.toString(customer.getCustomer_phone()));
				customerPhonetf.setForeground(new Color(180, 180, 180));
			}
		}
		// --------CUSTOMER EMAIL TEXTFIELD-----------
		if (customerEmailtf.getText().matches(customer.getEmail())) {
			customerEmailtf.setText("");
			customerEmailtf.setForeground(new Color(0, 80, 110));
		}
		if (!customerEmailtf.hasFocus()) {
			if (customerEmailtf.getText().matches("")) {
				customerEmailtf.setText((customer.getEmail()));
				customerEmailtf.setForeground(new Color(180, 180, 180));
			}
		}
		// --------CUSTOMER PASSWORD TEXTFIELD-----------
		if (String.valueOf(customerPasswordtf.getPassword()).matches("set new password")) {
			customerPasswordtf.setText("");
			customerPasswordtf.setEchoChar((char) '*');
			customerPasswordtf.setForeground(new Color(0, 80, 110));
		}
		if (!customerPasswordtf.hasFocus()) {
			if (String.valueOf(customerPasswordtf.getPassword()).matches("")) {
				customerPasswordtf.setText("set new password");
				customerPasswordtf.setEchoChar((char) 0);
				customerPasswordtf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
