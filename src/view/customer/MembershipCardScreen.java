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

public class MembershipCardScreen implements FocusListener {

	private JButton cancelBtn;
	private JFrame customerCardScreen = new JFrame();
	private KeyController keyListener = new KeyController(customerCardScreen, cancelBtn);

	private UltraVisionManagementSystem managementSystem;

	private MembershipCard newMembershipCard;
	private Customer newCustomer;

	private JTextField accounttf;
	private JPasswordField memberCardPasstf;
	private int[] accAndCardPass;

//	public static void main(String[] args) {
//		new MembershipCardScreen();
//	}

	public MembershipCardScreen(Customer newCustomer, MembershipCard newMembershipCard) {
		this.newCustomer = newCustomer;
		this.newMembershipCard = newMembershipCard;
		setAttributes();
		setComponents();
		validation();
	}

	public MembershipCardScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public void setAttributes() {
		customerCardScreen.setSize(700, 435);
		customerCardScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		customerCardScreen.setVisible(true);
		customerCardScreen.setResizable(false);
		customerCardScreen.setTitle("Card Issue");
		customerCardScreen.setLocationRelativeTo(null);
		customerCardScreen.addKeyListener(keyListener);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		customerCardScreen.add(backPanel);

		JLabel customerScreen = new JLabel("Customer Screen");
		customerScreen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		customerScreen.setBounds(15, 30, 300, 35);
		customerScreen.setForeground(new Color(0, 80, 110));
		backPanel.add(customerScreen);

		JLabel membershipIssue = new JLabel("Membership Card Issue");
		membershipIssue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		membershipIssue.setBounds(15, 60, 300, 35);
		membershipIssue.setForeground(Color.WHITE);
		backPanel.add(membershipIssue);

		accounttf = new JTextField();
		accounttf.setText("enter debit/credit account number");
		accounttf.setForeground(new Color(180, 180, 180));
		accounttf.addFocusListener(this);
		accounttf.setBounds(260, 180, 390, 45);
		accounttf.setBorder(null);
		accounttf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backPanel.add(accounttf);

		memberCardPasstf = new JPasswordField();
		memberCardPasstf.setText("create a password for your membership card");
		memberCardPasstf.setForeground(new Color(180, 180, 180));
		memberCardPasstf.addFocusListener(this);
		memberCardPasstf.setBounds(260, 235, 390, 45);
		memberCardPasstf.setBorder(null);
		memberCardPasstf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backPanel.add(memberCardPasstf);

		if (!memberCardPasstf.hasFocus()) {
			memberCardPasstf.setEchoChar((char) 0);
		}

		JLabel cardIcon = new JLabel();
		cardIcon.setIcon(new ImageIcon("img\\icons\\customercardicon.png"));
		cardIcon.setBounds(340, 40, 320, 120);
		backPanel.add(cardIcon);

		JLabel bigCustomerIcon = new JLabel();
		bigCustomerIcon.setIcon(new ImageIcon("img\\icons\\customerscreenbig.png"));
		bigCustomerIcon.setBounds(20, 75, 280, 350);
		backPanel.add(bigCustomerIcon);

		buttons(backPanel);

		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("img\\customerscreenbackground.jpg"));
		background.setBounds(0, 0, 700, 435);
		backPanel.add(background);

	}

	public void buttons(JPanel backPanel) {

//---------------------------CANCEL BUTTON-------------------------------
		cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
		cancelBtn.setBackground(backPanel.getBackground());
		cancelBtn.setBounds(250, 275, 230, 106);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		backPanel.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerCardScreen.dispose();
			}
		});
		cancelBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cancelBtn.setIcon(new ImageIcon("img\\btn\\hover\\cancelbtnsmallhover.png"));
				cancelBtn.setBounds(246, 273, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
				cancelBtn.setBounds(250, 275, 230, 106);
			}
		});
//---------------------------CREATE BUTTON-------------------------------
		JButton createBtn = new JButton();
		createBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
		createBtn.setBackground(backPanel.getBackground());
		createBtn.setBounds(422, 275, 230, 106);
		createBtn.setBorderPainted(false);
		createBtn.setContentAreaFilled(false);
		createBtn.setFocusPainted(false);
		backPanel.add(createBtn);
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon logoIcon;

				String account = accounttf.getText();
				String memberpass = String.valueOf(memberCardPasstf.getPassword());

				if (account.equals("enter debit/credit account number")
						|| memberpass.equals("create a password for your membership card")) {

					logoIcon = new ImageIcon("img\\logopane.png");
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null, "All fields are required.",
							"Error, missing information.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}
				// -----------------VALIDATE ACCOUNT NUMBER--------------------
				if (!account.matches("(\\d{4}[-. ]?){4}|\\d{4}[-. ]?\\d{6}[-. ]?\\d{5}")) {
					logoIcon = new ImageIcon("img\\icons\\logopane.png");
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null,
							"Invalid account number. \nEnter a valid account please.", "Account Field Error",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}
				// --------------VALIDATE PASSWORD TO BE 8 DIGITS INT--------------------
				if (!memberpass.matches("[0-9]{8}")) {
					logoIcon = new ImageIcon("img\\icons\\logopane.png");
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null, "Password must be 8 digit numbers.",
							"Membership Card Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}

				newCustomer.setAccountNumber(Long.parseLong(account));

				// ---UPLOAD CUSTOMER TO DB TO GET IT'S ID TO ATTACH TO ACCOUNT & MEMBERSHIP
				// CARD ---
				// newCustomer will be updated with customer_id in return
				newCustomer = managementSystem.addNewCustomer(newCustomer);

				// ---UPLOAD CUSTOMER ACCOUNT TO DB---
				// newCustomer will be updated with account_id in return
				newCustomer = managementSystem.addNewAccount(newCustomer);

				// ---UPLOAD MEMBERSHIP CARD TO DB---
				// newMembershipCard will be updated with card_id in return
				newMembershipCard = managementSystem.addNewMembershipCard(newMembershipCard,
						newCustomer.getAccountID());
			}
		});
		createBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				createBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				createBtn.setIcon(new ImageIcon("img\\btn\\hover\\confirmbtnhover.png"));
				createBtn.setBounds(418, 273, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				createBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
				createBtn.setBounds(422, 275, 230, 106);
			}
		});
	}

	public void validation() {
		customerCardScreen.repaint();
		customerCardScreen.validate();
	}

	public int[] getCardInfo(int cardnumber, int cardpass) {
		accAndCardPass = new int[2];
		accAndCardPass[0] = cardnumber;
		accAndCardPass[1] = cardpass;
		return accAndCardPass;
	}

	@Override
	public void focusGained(FocusEvent e) {

//------------------account TextField-------------------------
		if (accounttf.getText().matches("enter debit/credit account number")) {
			accounttf.setText("");
			accounttf.setForeground(new Color(0, 80, 110));
		}
		if (!accounttf.hasFocus()) {
			if (accounttf.getText().matches("")) {
				accounttf.setText("enter debit/credit account number");
				accounttf.setForeground(new Color(180, 180, 180));
			}
		}
// ------------------membership card TextField-------------------------
		if (memberCardPasstf.getText().matches("create a password for your membership card")) {
			memberCardPasstf.setText("");
			memberCardPasstf.setEchoChar((char) '*');
			memberCardPasstf.setForeground(new Color(0, 80, 110));
		}
		if (!memberCardPasstf.hasFocus()) {
			if (memberCardPasstf.getText().matches("")) {
				memberCardPasstf.setText("create a password for your membership card");
				memberCardPasstf.setEchoChar((char) 0);
				memberCardPasstf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
