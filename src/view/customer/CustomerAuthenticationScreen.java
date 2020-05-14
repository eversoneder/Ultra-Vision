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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import controller.KeyController;
import model.Payment;
import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.Title;

public class CustomerAuthenticationScreen implements FocusListener {

	ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");
	
	private JFrame authenticationScreen = new JFrame();
	private KeyController keyListener = new KeyController(authenticationScreen);
	
	private MembershipCard card;
	private Customer customer;

	private ArrayList<Object> UnknownTitleType;
	private Title title = new Title();

	private JPasswordField passwordtf;

	public CustomerAuthenticationScreen(Customer customer, MembershipCard card, ArrayList<Object> UnknownTitleType) {
		this.customer = customer;
		this.card = card;
		this.UnknownTitleType = UnknownTitleType;

		unwrapTitle();
		setAttributes();
		setComponents();
		authenticationScreen.setIconImage(new ImageIcon("img\\icons\\logo.png").getImage());
		validation();
	}

	public CustomerAuthenticationScreen(int a) {

	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 80, 110));
		authenticationScreen.add(backPanel);

		JLabel issueRentalLabel = new JLabel("Customer Authentication");
		issueRentalLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		issueRentalLabel.setBounds(40, 05, 300, 30);
		issueRentalLabel.setForeground(Color.WHITE);
		backPanel.add(issueRentalLabel);

		JLabel customerIcon = new JLabel();
		customerIcon.setIcon(new ImageIcon("img\\icons\\customercardiconsmall2.png"));
		customerIcon.setBounds(380, 5, 210, 110);
		backPanel.add(customerIcon);

		JLabel customerScreenIcon = new JLabel();
		customerScreenIcon.setIcon(new ImageIcon("img\\icons\\customerscreenbig2.png"));
		customerScreenIcon.setBounds(40, 40, 250, 250);
		backPanel.add(customerScreenIcon);

		passwordtf = new JPasswordField();
		passwordtf.setText("enter password");
		passwordtf.setForeground(new Color(180, 180, 180));
		passwordtf.addFocusListener(this);
		passwordtf.setBounds(320, 130, 335, 45);
		passwordtf.setBorder(null);
		passwordtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backPanel.add(passwordtf);

		buttons(backPanel);

		JLabel background = new JLabel();
		background.setIcon(new ImageIcon("img\\authenticationbackground.jpg"));
		background.setBounds(0, 0, backPanel.getWidth(), backPanel.getHeight());
		backPanel.add(background);

	}

	public void setAttributes() {
		authenticationScreen.setSize(730, 330);
		authenticationScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		authenticationScreen.setVisible(true);
		authenticationScreen.setResizable(false);
		authenticationScreen.setTitle("Customer Authentication");
		authenticationScreen.setLocationRelativeTo(null);
		
		authenticationScreen.addKeyListener(keyListener);
		authenticationScreen.addWindowListener(keyListener);
	}

	public void validation() {
		authenticationScreen.repaint();
		authenticationScreen.validate();
	}

	/**
	 * @param unknowntitletype ArrayList of titles to unwrap
	 */
	public void unwrapTitle() {

		for (Object obj : UnknownTitleType) {
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

	public void promptPayment() {


		Object[] payment = { "Pay by Points", "Cancel Transaction", "Pay by Cash" };
		int i = JOptionPane.showOptionDialog(null,
				"Choose payment form for \n" + title.getName() + ". Price: " + title.getPrice() + " €.",
				"Payment Form.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, payment, payment[2]);

		if (i == 2) {// pay by cash
			// final check up & finally payment
			checkBalanceAndPay();
		}
		if (i == 0) {// pay by points

			Payment newPayment = new Payment(customer, card, title);
			newPayment.payByPoints();

		}

		if (i == 1 || i == -1) {// cancel or closed
			authenticationScreen.dispose();
		}

	}

	public void checkBalanceAndPay() {


		// -------CHECK IF HAS MONEY---------
		if (!customer.checkFunds(title.getPrice())) {
			Object[] noMoneyBtn = { "Ok" };
			JOptionPane.showOptionDialog(null,
					"Customer has no enough funds to rent: \n" + title.getName() + ". Price: " + title.getPrice()
							+ " €.",
					"Insuficient Funds.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, noMoneyBtn,
					noMoneyBtn[0]);
			return;
		} else {

			Payment newPayment = new Payment(customer, card, title);
			newPayment.payByCash();

		}

	}

	public void buttons(JPanel backPanel) {

		// ---------------------------CANCEL BUTTON-------------------------------
		JButton cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
		cancelBtn.setBackground(backPanel.getBackground());
		cancelBtn.setBounds(315, 185, 170, 80);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		backPanel.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				authenticationScreen.dispose();
			}
		});
		cancelBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cancelBtn.setIcon(new ImageIcon("img\\btn\\hover\\cancelbtnsmallhover.png"));
				cancelBtn.setBounds(311, 183, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
				cancelBtn.setBounds(315, 185, 170, 80);
			}
		});
		// ---------------------------CONFIRM BUTTON-------------------------------
		JButton confirmBtn = new JButton();
		confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
		confirmBtn.setBackground(backPanel.getBackground());
		confirmBtn.setBounds(495, 185, 170, 80);
		confirmBtn.setBorderPainted(false);
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.setFocusPainted(false);
		backPanel.add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cardPass = Integer.toString(card.getPassword());
				String enteredPass = String.valueOf(passwordtf.getPassword());
				
				if (cardPass.equals(enteredPass)) {// validate card pass

					promptPayment();
					authenticationScreen.dispose();

				} else {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Sorry " + customer.getCustomer_name() + ", invalid password, try again.",
							"Wrong Password.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}
			}
		});
		confirmBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				confirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				confirmBtn.setIcon(new ImageIcon("img\\btn\\hover\\confirmbtnhover.png"));
				confirmBtn.setBounds(491, 183, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
				confirmBtn.setBounds(495, 185, 170, 80);
			}
		});
	}

	@Override
	public void focusGained(FocusEvent e) {
//------------------Password TextField-------------------------
		if (String.valueOf(passwordtf.getPassword()).matches("enter password")) {
			passwordtf.setText("");
			passwordtf.setEchoChar((char) '*');
			passwordtf.setForeground(new Color(0, 80, 110));
		}
		if (!passwordtf.hasFocus()) {
			if (String.valueOf(passwordtf.getPassword()).matches("")) {
				passwordtf.setText("enter password");
				passwordtf.setEchoChar((char) 0);
				passwordtf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
