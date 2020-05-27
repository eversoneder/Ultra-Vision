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
import javax.swing.JTextField;

import controller.KeyController;
import model.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.Title;
import view.customer.SearchCustomerScreen;

public class UpdateCustomerEnterIDScreen implements FocusListener {

	private JFrame returnTitleScreen = new JFrame();
	private KeyController listenerController = new KeyController(returnTitleScreen);
	
	private Customer customer = new Customer();
	private MembershipCard card = new MembershipCard();
	
	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField customerIDtf;
	
	public UpdateCustomerEnterIDScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public void setAttributes() {
		returnTitleScreen.setSize(740, 300);
		returnTitleScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		returnTitleScreen.setUndecorated(true);
		returnTitleScreen.setVisible(true);
		returnTitleScreen.setResizable(false);
		returnTitleScreen.setTitle("Ultra-Vision | Update Customer");
		returnTitleScreen.setLocationRelativeTo(null);
		returnTitleScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());

		returnTitleScreen.addKeyListener(listenerController);
		returnTitleScreen.addWindowListener(listenerController);
		returnTitleScreen.addMouseListener(listenerController);
		returnTitleScreen.addMouseMotionListener(listenerController);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		returnTitleScreen.add(backPanel);

		JLabel logobluecircle = new JLabel();
		logobluecircle.setIcon(new ImageIcon("img\\icons\\logobluecircle.png"));
		logobluecircle.setBounds(420, 5, 150, 110);
		backPanel.add(logobluecircle);

		closeBtn(backPanel);

		JLabel issueRentalLabel = new JLabel("Update Customer");
		issueRentalLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		issueRentalLabel.setBounds(30, 15, 200, 30);
		issueRentalLabel.setForeground(Color.WHITE);
		backPanel.add(issueRentalLabel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 60, returnTitleScreen.getWidth(), returnTitleScreen.getHeight() - 80);
		backPanel.add(backRectangle);

		JLabel searchLabel = new JLabel("Update Customer");
		searchLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		searchLabel.setBounds(30, 15, 200, 30);
		searchLabel.setForeground(Color.WHITE);
		backPanel.add(searchLabel);

		JLabel searchBtnLabel = new JLabel("Search to get ID");
		searchBtnLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchBtnLabel.setBounds(100, 35, 150, 20);
		searchBtnLabel.setForeground(Color.WHITE);
		backRectangle.add(searchBtnLabel);

		searchBtn(backRectangle);

		textFields(backRectangle);
		buttons(backRectangle);

	}

	public void searchBtn(JPanel backRectangle) {

		JButton searchCustomerBtn = new JButton();
		searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\searchcustomerbtn.png"));
		searchCustomerBtn.setBackground(backRectangle.getBackground());
		searchCustomerBtn.setBounds(50, 70, 230, 106);
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
				searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\hover\\searchcustomerbtnhover.png"));
				searchCustomerBtn.setBounds(46, 68, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\searchcustomerbtn.png"));
				searchCustomerBtn.setBounds(50, 70, 230, 106);
			}
		});
	}

	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
		closeBtn.setBounds(690, 14, 30, 30);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnTitleScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closebtnsmallhover.png"));
				closeBtn.setBounds(687, 10, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
				closeBtn.setBounds(690, 14, 30, 30);
			}
		});
	}

	public void textFields(JPanel backRectangle) {

		customerIDtf = new JTextField();
		customerIDtf.setText("enter customer id");
		customerIDtf.setForeground(new Color(180, 180, 180));
		customerIDtf.addFocusListener(this);
		customerIDtf.setBounds(380, 65, 250, 45);
		customerIDtf.setBorder(null);
		customerIDtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(customerIDtf);
	}

	public void buttons(JPanel backRectangle) {

		// ---------------------------CANCEL BUTTON-------------------------------
		JButton cancelBtn = new JButton();
		cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
		cancelBtn.setBackground(backRectangle.getBackground());
		cancelBtn.setBounds(335, 123, 170, 80);
		cancelBtn.setBorderPainted(false);
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setFocusPainted(false);
		backRectangle.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnTitleScreen.dispose();
			}
		});
		cancelBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cancelBtn.setIcon(new ImageIcon("img\\btn\\hover\\cancelbtnsmallhover.png"));
				cancelBtn.setBounds(331, 121, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
				cancelBtn.setBounds(335, 123, 170, 80);
			}
		});
		// ---------------------------CONFIRM BUTTON-------------------------------
		JButton confirmBtn = new JButton();
		confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
		confirmBtn.setBackground(backRectangle.getBackground());
		confirmBtn.setBounds(515, 123, 170, 80);
		confirmBtn.setBorderPainted(false);
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.setFocusPainted(false);
		backRectangle.add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

				if (!customerIDtf.getText().matches("[0-9]{1,3}")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Enter an existing Customer ID please.",
							"Title ID Error.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}
				try {
					customer = managementSystem.getCustomerInfoByID(Integer.parseInt(customerIDtf.getText()));
				} catch (Exception exc) {
					exc.getMessage();
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"There's no customer of ID " + customerIDtf.getText() + ".", "Non-Existent Customer.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}
				if (customer == null) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Customer of ID " + customerIDtf.getText() + " doesn't exist.", "Error.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				} else {
					
					// -----------GET CARD INFO TO UPDATE PASSWORD----------
					try {
						card = managementSystem.getCardInfoByID(customer.getCardID());
					} catch (Exception ex) {
						ex.getMessage();
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null,
								"There's no Card ID " + customer.getCardID() + " in the System.", "Non-Existent card ID.",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
						return;
					}
					new UpdateCustomerScreen(customer, card);
				}

			}

		});
		confirmBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				confirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				confirmBtn.setIcon(new ImageIcon("img\\btn\\hover\\confirmbtnhover.png"));
				confirmBtn.setBounds(511, 125, 179, 84);
			}

			public void mouseExited(MouseEvent evt) {
				confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
				confirmBtn.setBounds(515, 123, 170, 80);
			}
		});
	}

	public void validation() {
		returnTitleScreen.repaint();
		returnTitleScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// ------------------movie genre TextField-------------------------
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

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
