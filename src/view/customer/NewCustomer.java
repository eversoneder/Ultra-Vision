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

public class NewCustomer implements FocusListener {

	private JButton cancelBtn;
	private JFrame newCustomerScreen = new JFrame();

	private UltraVisionManagementSystem managementSystem;

	private JTextField nametf;
	private JTextField addresstf;
	private JTextField phonetf;
	

	public static void main(String[] args) {
		new NewCustomer();
	}

	public NewCustomer() {
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

		addresstf = new JTextField();
		addresstf.setText("customer address");
		addresstf.setForeground(new Color(180, 180, 180));
		addresstf.addFocusListener(this);
		addresstf.setBounds(400, 210, 470, 45);
		addresstf.setBorder(null);
		addresstf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(addresstf);

		phonetf = new JTextField();
		phonetf.setText("customer phone");
		phonetf.setForeground(new Color(180, 180, 180));
		phonetf.addFocusListener(this);
		phonetf.setBounds(400, 270, 470, 45);
		phonetf.setBorder(null);
		phonetf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(phonetf);
	}

	public void buttons(JPanel backRectangle, JPanel backPanel) {

// ---------------------------PRESS CLOSE BUTTON-------------------------------
		JButton pressClose = new JButton();
		pressClose.setIcon(new ImageIcon("img\\btn\\goback.png"));
//				pressClose.setIcon(new ImageIcon("img\\btn\\goback.png"));
		pressClose.setBounds(780, 20, 222, 65);
		pressClose.setBorderPainted(false);
		pressClose.setContentAreaFilled(false);
		pressClose.setFocusPainted(false);
		backPanel.add(pressClose);
		pressClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newCustomerScreen.dispose();
			}
		});
		pressClose.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				pressClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
				pressClose.setIcon(new ImageIcon("img\\btn\\hover\\gobackhover.png"));
				pressClose.setBounds(778, 14, 230, 75);
			}

			public void mouseExited(MouseEvent evt) {
				pressClose.setIcon(new ImageIcon("img\\btn\\goback.png"));
				pressClose.setBounds(780, 20, 222, 65);
			}
		});

////---------------------Music Lover----------------------------------
//		JRadioButton mlRadio = new JRadioButton();
//		mlRadio.setActionCommand("ML");
//		mlRadio.setBorder(null);
//		mlRadio.setBorderPainted(false);
//		mlRadio.setContentAreaFilled(false);
//		mlRadio.setForeground(Color.WHITE);
//		mlRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		mlRadio.setBounds(400, 260, 100, 100);
//		backRectangle.add(mlRadio);
//
//		JLabel mlIcon = new JLabel();
//		mlIcon.setIcon(new ImageIcon("img\\btn\\ml3.png"));
//		mlIcon.setBounds(420, 260, 100, 100);
//		backRectangle.add(mlIcon);
//
////---------------------Video Lover----------------------------------
//		JRadioButton vlRadio = new JRadioButton();
//		vlRadio.setActionCommand("VL");
//		vlRadio.setBorder(null);
//		vlRadio.setBorderPainted(false);
//		vlRadio.setContentAreaFilled(false);
//		vlRadio.setFocusPainted(false);
//		vlRadio.setForeground(Color.WHITE);
//		vlRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		vlRadio.setBounds(520, 260, 100, 100);
//		backRectangle.add(vlRadio);
//
//		JLabel vlIcon = new JLabel();
//		vlIcon.setIcon(new ImageIcon("img\\btn\\vl.png"));
//		vlIcon.setBounds(540, 260, 100, 100);
//		backRectangle.add(vlIcon);
//
////---------------------TV Lover----------------------------------
//
//		JRadioButton tvRadio = new JRadioButton();
//		tvRadio.setActionCommand("TV");
//		tvRadio.setBorder(null);
//		tvRadio.setBorderPainted(false);
//		tvRadio.setContentAreaFilled(false);
//		tvRadio.setFocusPainted(false);
//		tvRadio.setForeground(Color.WHITE);
//		tvRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		tvRadio.setBounds(640, 260, 100, 100);
//		backRectangle.add(tvRadio);
//
//		JLabel tvIcon = new JLabel();
//		tvIcon.setIcon(new ImageIcon("img\\btn\\tv.png"));
//		tvIcon.setBounds(660, 260, 100, 100);
//		backRectangle.add(tvIcon);
//
////---------------------Premium----------------------------------
//
//		JRadioButton prRadio = new JRadioButton();
//		prRadio.setActionCommand("PR");
//		prRadio.setBorder(null);
//		prRadio.setBorderPainted(false);
//		prRadio.setContentAreaFilled(false);
//		prRadio.setFocusPainted(false);
//		prRadio.setForeground(Color.WHITE);
//		prRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		prRadio.setBounds(760, 260, 100, 100);
//		backRectangle.add(prRadio);
//
//		JLabel prIcon = new JLabel();
//		prIcon.setIcon(new ImageIcon("img\\btn\\pr.png"));
//		prIcon.setBounds(780, 260, 100, 100);
//		backRectangle.add(prIcon);
//
//		ButtonGroup plans = new ButtonGroup();
//		plans.add(mlRadio);
//		plans.add(vlRadio);
//		plans.add(tvRadio);
//		plans.add(prRadio);

//		ButtonModel selected;
//		selected = plans.getSelection();
//		String command = selected.getActionCommand();

//		cancelBtn.setBorderPainted(false);
//		cancelBtn.setContentAreaFilled(false);
//		cancelBtn.setFocusPainted(false);

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

				ImageIcon logoIcon;

				String name = nametf.getText();
				String address = addresstf.getText();
				String phone = phonetf.getText();
				String plan = "";

				if (name.equals("name") || address.equals("address") || phone.equals("phone")
						|| account.equals("debit/credit account number") || plan.equals("null")
						|| membercardpass.equals("create membership card password")) {

					logoIcon = new ImageIcon("img\\logopane.png");
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null, "All fields are required.",
							"Error, missing information.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
							logoIcon, btns, btns[0]);
					return;
				}

				if (!account.matches("(\\d{4}[-. ]?){4}|\\d{4}[-. ]?\\d{6}[-. ]?\\d{5}")) {
					logoIcon = new ImageIcon("img\\icons\\logopane.png");
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null,
							"Invalid account number. \nEnter a valid account please.", "Account Field Error",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}

				managementSystem = new UltraVisionManagementSystem();

//						Customer newCustomer = new Customer(name, phone, address, account);
//						MembershipCard newCard = new MemberShipCard(newCustomer, plan, membercardpass);

//						managementSystem.addNewCustomer(newCustomer);
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
		if (addresstf.getText().matches("customer address")) {
			addresstf.setText("");
			addresstf.setForeground(new Color(0, 80, 110));
		}
		if (!addresstf.hasFocus()) {
			if (addresstf.getText().matches("")) {
				addresstf.setText("customer address");
				addresstf.setForeground(new Color(180, 180, 180));
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
		return addresstf;
	}

	/**
	 * @return the phonetf
	 */
	public JTextField getPhonetf() {
		return phonetf;
	}

	/**
	 * @return the accounttf
	 */
	public JTextField getAccounttf() {
		return accounttf;
	}
}
