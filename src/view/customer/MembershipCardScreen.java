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

import controller.ListenerController;
import model.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;

public class MembershipCardScreen implements FocusListener {

	
	private JFrame membershipCardScreen = new JFrame();
	private ListenerController listenerController = new ListenerController(membershipCardScreen);

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private MembershipCard newMembershipCard;
	private Customer newCustomer;
	
	private JTextField accounttf;
	private JPasswordField memberCardPasstf;
	private JButton createBtn;
	
	private int[] accAndCardPass;

	public MembershipCardScreen(Customer newCustomer, MembershipCard newMembershipCard) {
		this.newCustomer = newCustomer;
		this.newMembershipCard = newMembershipCard;
		setAttributes();
		setComponents();
		listenerController.getButton(createBtn);
		validation();
	}

	public void setAttributes() {
		membershipCardScreen.setSize(690, 415);
		membershipCardScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		membershipCardScreen.setUndecorated(true);
		membershipCardScreen.setVisible(true);
		membershipCardScreen.setResizable(false);
		membershipCardScreen.setTitle("Card Issue");
		membershipCardScreen.setLocationRelativeTo(null);
		membershipCardScreen.setIconImage(new ImageIcon("img\\icons\\logo.png").getImage());
		
		membershipCardScreen.addKeyListener(listenerController);
		membershipCardScreen.addWindowListener(listenerController);
		membershipCardScreen.addMouseListener(listenerController);
		membershipCardScreen.addMouseMotionListener(listenerController);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		membershipCardScreen.add(backPanel);
		
		closeBtn(backPanel);

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
		accounttf.addKeyListener(listenerController);
		backPanel.add(accounttf);

		memberCardPasstf = new JPasswordField();
		memberCardPasstf.setText("create a password for your membership card");
		memberCardPasstf.setForeground(new Color(180, 180, 180));
		memberCardPasstf.addFocusListener(this);
		memberCardPasstf.setBounds(260, 235, 390, 45);
		memberCardPasstf.setBorder(null);
		memberCardPasstf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		memberCardPasstf.addKeyListener(listenerController);
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
		
		JLabel cardBackRect = new JLabel();//card background
		cardBackRect.setIcon(new ImageIcon("img\\cardbackrect.png"));
		cardBackRect.setBounds(0, 0, 690, 415);
		backPanel.add(cardBackRect);
		
		JLabel backgroundStrip = new JLabel();
		backgroundStrip.setIcon(new ImageIcon("img\\backgroundstrip.png"));
		backgroundStrip.setBounds(0, 0, 690, 415);
		backPanel.add(backgroundStrip);
	}
	
	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
		closeBtn.setBounds(645, 10, 30, 30);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				membershipCardScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closebtnsmallhover.png"));
				closeBtn.setBounds(642, 6, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
				closeBtn.setBounds(645, 10, 30, 30);
			}
		});
	}

	public void buttons(JPanel backPanel) {

//---------------------------CANCEL BUTTON-------------------------------
		JButton cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
		cancelBtn.setBackground(backPanel.getBackground());
		cancelBtn.setBounds(250, 275, 230, 106);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		backPanel.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				membershipCardScreen.dispose();
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
		createBtn = new JButton();
		createBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
		createBtn.setBackground(backPanel.getBackground());
		createBtn.setBounds(422, 275, 230, 106);
		createBtn.setBorderPainted(false);
		createBtn.setContentAreaFilled(false);
		createBtn.setFocusPainted(false);
		backPanel.add(createBtn);
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon logoIcon  = new ImageIcon("img\\icons\\logopane.png");

				String account = accounttf.getText();
				String memberpass = String.valueOf(memberCardPasstf.getPassword());

				if (account.equals("enter debit/credit account number")
						|| memberpass.equals("create a password for your membership card")) {

					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "All fields are required.",
							"Error, missing information.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}
				// -----------------VALIDATE ACCOUNT NUMBER--------------------
				if (!account.matches("(\\d{4}[-. ]?){4}|\\d{4}[-. ]?\\d{6}[-. ]?\\d{5}")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Invalid account number. \nEnter a valid account please.\n format: 1111.2222.3333.4444", "Account Field Error",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}
				// --------------VALIDATE PASSWORD TO BE 8 DIGITS INT--------------------
				if (!memberpass.matches("[0-9]{8}")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Password must be 8 digit numbers.",
							"Membership Card Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}

// ---UPLOAD CUSTOMER TO DB TO GET IT'S ID TO ATTACH TO ACCOUNT & MEMBERSHIP CARD ---
// newCustomer will be updated with customer_id in return
				newCustomer = managementSystem.addNewCustomer(newCustomer);
			
// ---UPLOAD CUSTOMER ACCOUNT TO DB---
// newCustomer will be updated with account_id in return
				newCustomer.setAccountNumber(account);
				newCustomer = managementSystem.addNewAccount(newCustomer);
// ---UPLOAD MEMBERSHIP CARD TO DB---
// newMembershipCard will be updated with card_id in return
				newMembershipCard.setPassword(Integer.parseInt(memberpass));
				newMembershipCard.setAccountID(newCustomer.getAccountID());
				newMembershipCard = managementSystem.addNewMembershipCard(newMembershipCard);
				
				Object[] btns = { "Ok" };
				int i = JOptionPane.showOptionDialog(null,
						"Customer registered successfully.", "Customer Added to System",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
				
				if(i == 0 || i == -1) {
					membershipCardScreen.dispose();
				}
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
		membershipCardScreen.repaint();
		membershipCardScreen.validate();
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
		if (String.valueOf(memberCardPasstf.getPassword()).matches("create a password for your membership card")) {
			memberCardPasstf.setText("");
			memberCardPasstf.setEchoChar((char) '*');
			memberCardPasstf.setForeground(new Color(0, 80, 110));
		}
		if (!memberCardPasstf.hasFocus()) {
			if (String.valueOf(memberCardPasstf.getPassword()).matches("")) {
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
