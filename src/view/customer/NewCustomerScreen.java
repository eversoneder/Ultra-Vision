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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.KeyController;
import controller.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;

public class NewCustomerScreen implements FocusListener {

	private JButton cancelBtn;
	private JFrame newCustomerScreen = new JFrame();

	private UltraVisionManagementSystem managementSystem;

	private JTextField nametf;
	private JTextField emailtf;
	private JTextField phonetf;

	private Customer newCustomer;
	private MembershipCard newMembershipCard;

//	public static void main(String[] args) {
//		new NewCustomerScreen();
//	}

	public NewCustomerScreen(MembershipCard newMembershipCard) {
		this.newMembershipCard = newMembershipCard;
		setAttributes();
		setComponents();
		validation();
	}

	public NewCustomerScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public void setAttributes() {
		newCustomerScreen.setSize(1000, 650);
		newCustomerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newCustomerScreen.setVisible(true);
		newCustomerScreen.setResizable(false);
		newCustomerScreen.setTitle("Customer Registration");
		newCustomerScreen.setLocationRelativeTo(null);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		newCustomerScreen.add(backPanel);

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img\\icons\\logobluecirclebig.png"));
		logo.setBounds(470, 20, 400, 230);
		backPanel.add(logo);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, newCustomerScreen.getWidth(), newCustomerScreen.getHeight() - 200);
		backPanel.add(backRectangle);

		JLabel subscriptionLabel = new JLabel();
		subscriptionLabel.setText("Subscription: "+newMembershipCard.getTitleTypeGUI());
		subscriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		subscriptionLabel.setBounds(110, 20, 300, 35);
		subscriptionLabel.setForeground(new Color(0,80,110));
		backPanel.add(subscriptionLabel);
		
		JLabel newCustomerLabel = new JLabel("New Customer");
		newCustomerLabel.setFont(new Font("Tahoma", Font.PLAIN, 42));
		newCustomerLabel.setBounds(110, 60, 300, 35);
		newCustomerLabel.setForeground(Color.WHITE);
		backPanel.add(newCustomerLabel);

		buttons(backRectangle, backPanel);

		JLabel pressQ = new JLabel();
//		pressQ.setIcon(new ImageIcon("img\\icons\\goback.png"));
		pressQ.setIcon(new ImageIcon("img\\icons\\press.png"));
		pressQ.setBounds(backRectangle.getWidth() - 210, 20, 195, 65);
		backPanel.add(pressQ);

		textFields(backRectangle);

		JLabel bigCustomerIcon = new JLabel();
		bigCustomerIcon.setIcon(new ImageIcon("img\\icons\\customericonbig.png"));
		bigCustomerIcon.setBounds(70, 50, 280, 350);
		backRectangle.add(bigCustomerIcon);

	}

	public void textFields(JPanel backRectangle) {

		nametf = new JTextField();
		nametf.setText("customer name");
		nametf.setForeground(new Color(180, 180, 180));
		nametf.addFocusListener(this);
		nametf.setBounds(400, 150, 470, 45);
		nametf.setBorder(null);
		nametf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(nametf);

		phonetf = new JTextField();
		phonetf.setText("customer phone");
		phonetf.setForeground(new Color(180, 180, 180));
		phonetf.addFocusListener(this);
		phonetf.setBounds(400, 210, 470, 45);
		phonetf.setBorder(null);
		phonetf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(phonetf);

		emailtf = new JTextField();
		emailtf.setText("customer email");
		emailtf.setForeground(new Color(180, 180, 180));
		emailtf.addFocusListener(this);
		emailtf.setBounds(400, 270, 470, 45);
		emailtf.setBorder(null);
		emailtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(emailtf);

	}

	public void buttons(JPanel backRectangle, JPanel backPanel) {

// ---------------------------PRESS CLOSE BUTTON-------------------------------
		JButton goBackBtn = new JButton();
		goBackBtn.setIcon(new ImageIcon("img\\btn\\goback.png"));
//				pressClose.setIcon(new ImageIcon("img\\btn\\goback.png"));
		goBackBtn.setBounds(780, 20, 222, 65);
		goBackBtn.setBorderPainted(false);
		goBackBtn.setContentAreaFilled(false);
		goBackBtn.setFocusPainted(false);
		backPanel.add(goBackBtn);
		goBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newCustomerScreen.dispose();
			}
		});
		goBackBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				goBackBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				goBackBtn.setIcon(new ImageIcon("img\\btn\\hover\\gobackhover.png"));
				goBackBtn.setBounds(778, 14, 230, 75);
			}

			public void mouseExited(MouseEvent evt) {
				goBackBtn.setIcon(new ImageIcon("img\\btn\\goback.png"));
				goBackBtn.setBounds(780, 20, 222, 65);
			}
		});

//---------------------------CANCEL BUTTON-------------------------------

		cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtn.png"));
		cancelBtn.setBackground(backRectangle.getBackground());
		cancelBtn.setBounds(420, 335, 230, 106);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		backRectangle.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newCustomerScreen.dispose();
			}
		});
		cancelBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cancelBtn.setIcon(new ImageIcon("img\\btn\\hover\\cancelbtnhover.png"));
				cancelBtn.setBounds(416, 333, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtn.png"));
				cancelBtn.setBounds(420, 335, 230, 106);
			}
		});
//---------------------------CREATE BUTTON-------------------------------
		JButton createBtn = new JButton();
		createBtn.setIcon(new ImageIcon("img\\btn\\createbtn.png"));
		createBtn.setBackground(backRectangle.getBackground());
		createBtn.setBounds(632, 335, 230, 106);
		createBtn.setBorderPainted(false);
		createBtn.setContentAreaFilled(false);
		createBtn.setFocusPainted(false);
		backRectangle.add(createBtn);
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");;

				String name = nametf.getText();
				String email = emailtf.getText();
				String phone = phonetf.getText();

//----------------------VALIDATE IF NOTHING MISSING---------------------
				if (name.equals("customer name") || phone.equals("customer phone")
						|| email.equals("customer email")) {
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null, "All fields are required.",
							"Error, missing information.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}
//----------------------VALIDATE PHONE NUMBER---------------------
				if (!phone.matches("[0-9]{7,16}")) {
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null, "Invalid phone number. \nEnter a valid number please.",
							"Phone Number Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
							btns, btns[0]);
					return;
				}
//----------------------VALIDATE EMAIL ADDRESS---------------------
				if (!email.matches("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b")) {
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null, "Invalid email addres. \nEnter a valid email please.",
							"Email Address Field Error", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
							btns, btns[0]);
					return;
				}
//---------PARSE PHONE TO UPLOAD DB AFTER GETTING ACC NUM & MEMBERCARD PASS----------
					Long phonelong = Long.parseLong(phone);
				
				newCustomer = new Customer(name, phonelong, email);
//------SEND CUSTOMER TO MEMBERCARDSCREEN TO GATHER INFO WITH ACC NUM & MEMBER PASS TO UPLOAD DB
				new MembershipCardScreen(newCustomer, newMembershipCard);
				
				
			}
		});
		createBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				createBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				createBtn.setIcon(new ImageIcon("img\\btn\\hover\\createbtnhover.png"));
				createBtn.setBounds(628, 333, 239, 110);
			}
			public void mouseExited(MouseEvent evt) {
				createBtn.setIcon(new ImageIcon("img\\btn\\createbtn.png"));
				createBtn.setBounds(632, 335, 230, 106);
			}
		});
	}

	public void validation() {
		newCustomerScreen.repaint();
		newCustomerScreen.validate();
	}
	
	@Override
	public void focusGained(FocusEvent e) {

//------------------name TextField-------------------------
		if (nametf.getText().matches("customer name")) {
			nametf.setText("");
			nametf.setForeground(new Color(0, 80, 110));
		}
		if (!nametf.hasFocus()) {
			if (nametf.getText().matches("")) {
				nametf.setText("customer name");
				nametf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------address TextField-------------------------
		if (emailtf.getText().matches("customer email")) {
			emailtf.setText("");
			emailtf.setForeground(new Color(0, 80, 110));
		}
		if (!emailtf.hasFocus()) {
			if (emailtf.getText().matches("")) {
				emailtf.setText("customer email");
				emailtf.setForeground(new Color(180, 180, 180));
			}
		}
//------------------phone TextField-------------------------
		if (phonetf.getText().matches("customer phone")) {
			phonetf.setText("");
			phonetf.setForeground(new Color(0, 80, 110));
		}
		if (!phonetf.hasFocus()) {
			if (phonetf.getText().matches("")) {
				phonetf.setText("customer phone");
				phonetf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the nametf
	 */
	public JTextField getNametf() {
		return nametf;
	}

	/**
	 * @return the addresstf
	 */
	public JTextField getAddresstf() {
		return emailtf;
	}

	/**
	 * @return the phonetf
	 */
	public JTextField getPhonetf() {
		return phonetf;
	}
}
