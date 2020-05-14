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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.KeyController;
import controller.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;

public class UpdateCustomerScreen implements FocusListener {

	private JFrame updateCustomerScreen = new JFrame();
	private KeyController keyListener = new KeyController(updateCustomerScreen);

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField customerNametf;
	private JTextField customerPhonetf;
	private JTextField customerEmailtf;
	private JPasswordField customerPasswordtf;

	private int oldPass;

	private Customer customer;
	private MembershipCard card;

	public UpdateCustomerScreen(Customer customer, MembershipCard card) {
		this.customer = customer;
		this.card = card;
		oldPass = card.getPassword();
		setAttributes();
		setComponents();
		updateCustomerScreen.setIconImage(new ImageIcon("img\\icons\\logo.png").getImage());
		validation();
	}

	public void setAttributes() {
		updateCustomerScreen.setSize(800, 550);
		updateCustomerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateCustomerScreen.setVisible(true);
		updateCustomerScreen.setResizable(false);
		updateCustomerScreen.setTitle("Ultra-Vision | Customer Information Update");
		updateCustomerScreen.setLocationRelativeTo(null);

		updateCustomerScreen.addKeyListener(keyListener);
		updateCustomerScreen.addWindowListener(keyListener);
	}

	private void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
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
		backRectangle.setBounds(0, 110, updateCustomerScreen.getWidth(), updateCustomerScreen.getHeight() - 180);
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
	}

	public void textFields(JPanel backRectangle) {

		customerNametf = new JTextField();
		customerNametf.setText(customer.getCustomer_name());
		customerNametf.setForeground(new Color(180, 180, 180));
		customerNametf.addFocusListener(this);
		customerNametf.setBounds(350, 25, 390, 45);
		customerNametf.setBorder(null);
		customerNametf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(customerNametf);

		customerPhonetf = new JTextField();
		customerPhonetf.setText(Long.toString(customer.getCustomer_phone()));
		customerPhonetf.setForeground(new Color(180, 180, 180));
		customerPhonetf.addFocusListener(this);
		customerPhonetf.setBounds(350, 85, 390, 45);
		customerPhonetf.setBorder(null);
		customerPhonetf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(customerPhonetf);

		customerEmailtf = new JTextField();
		customerEmailtf.setText(customer.getEmail());
		customerEmailtf.setForeground(new Color(180, 180, 180));
		customerEmailtf.addFocusListener(this);
		customerEmailtf.setBounds(350, 145, 390, 45);
		customerEmailtf.setBorder(null);
		customerEmailtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(customerEmailtf);

		customerPasswordtf = new JPasswordField();
		customerPasswordtf.setText("set new password");
		customerPasswordtf.setForeground(new Color(180, 180, 180));
		customerPasswordtf.addFocusListener(this);
		customerPasswordtf.setBounds(350, 215, 390, 45);
		customerPasswordtf.setBorder(null);
		customerPasswordtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
		cancelBtn.setBounds(375, 278, 170, 80);
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
				cancelBtn.setBounds(371, 276, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
				cancelBtn.setBounds(375, 278, 170, 80);
			}
		});
		// ---------------------------CONFIRM BUTTON-------------------------------
		JButton confirmBtn = new JButton();
		confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
		confirmBtn.setBackground(backRectangle.getBackground());
		confirmBtn.setBounds(550, 278, 170, 80);
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
						JOptionPane.showOptionDialog(null, "Password must be 8 digit numbers.",
								"Password Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btns, btns[0]);
						return;
					}
				}

				Long phonelong = Long.parseLong(customerPhonetf.getText());
//------------------IF ONLY CUSTOMER INFO CHANGED only name, email & phone (pass is card info)
				if ((!customer.getCustomer_name().matches(name)) || (customer.getCustomer_phone() != phonelong)
						|| (!customer.getEmail().matches(email))) {
					// set new customer info to execute update
					customer.setCustomer_name(name);
					customer.setCustomer_phone(phonelong);
					customer.setEmail(email);

					int custUpdate = managementSystem.updateCustomer(customer);//register DB

					switch (custUpdate) {
					case 0:// fail case name, phone, address
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Couldn't update customer information",
								"Customer Info Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btns, btns[0]);
						return;

					case 1:// succeeded update all info
						//check if changed pass as well
						if (Integer.parseInt(password) != oldPass) {

							card.setPassword(Integer.parseInt(password));
							int passUpdate = managementSystem.updateCard(card);

							switch (passUpdate) {
							case 0:
								Object[] btn = { "Ok" };
								JOptionPane.showOptionDialog(null, "Name, Phone & Email updated but password couldn't be modified.",
										"Changes", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btn,
										btn[0]);
								return;
							case 1:// 1 message for customer info updated AND pass updated
								Object[] btnss = { "Ok" };
								JOptionPane.showOptionDialog(null,
										"Customer Info and Password changed successfully.", "Customer Info Changed.",
										JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btnss,
										btnss[0]);
								break;
							}
						} else {// if password wasn't modified just prompt the customer info updated
							Object[] btnss = { "Ok" };
							JOptionPane.showOptionDialog(null, "Customer Information changed successfully.",
									"Customer Info Changed.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
									logoIcon, btnss, btnss[0]);
							break;
						}
					}

				} else if (Integer.parseInt(password) != oldPass) {//if only pass was modified

					card.setPassword(Integer.parseInt(password));
					int passUpdate = managementSystem.updateCard(card);

					switch (passUpdate) {
					case 0:
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Couldn't update password", "Password Field Error",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
						return;
					case 1:
						Object[] btnss = { "Ok" };
						JOptionPane.showOptionDialog(null, "Password changed successfully.",
								"Password Changed.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btnss, btnss[0]);

						break;
					}
				}

				updateCustomerScreen.dispose();

			}

		});
		confirmBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				confirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				confirmBtn.setIcon(new ImageIcon("img\\btn\\hover\\confirmbtnhover.png"));
				confirmBtn.setBounds(546, 276, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
				confirmBtn.setBounds(550, 278, 170, 80);
			}
		});
	}

	public void validation() {
		updateCustomerScreen.repaint();
		updateCustomerScreen.validate();
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
