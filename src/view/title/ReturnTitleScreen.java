package view.title;

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
import controller.UltraVisionManagementSystem;
import model.Rent;
import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.Title;
import view.customer.CustomerAuthenticationScreen;
import view.customer.SearchCustomerScreen;

public class ReturnTitleScreen implements FocusListener{

	private JFrame returnTitleScreen = new JFrame();
	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);
	
	KeyController keyListener = new KeyController(returnTitleScreen);
	
	private JTextField titleIDtf;
	
	private MembershipCard card = new MembershipCard();
	private Customer customer = new Customer();

	private Title title;
	private Rent rent;
	
	public ReturnTitleScreen(){
		setAttributes();
		setComponents();
		validation();
	}
	
	public void setAttributes() {
		returnTitleScreen.setSize(1000, 650);
		returnTitleScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		returnTitleScreen.setVisible(true);
		returnTitleScreen.setResizable(false);
		returnTitleScreen.setTitle("Ultra-Vision | Return Title");
		returnTitleScreen.addKeyListener(keyListener);
		returnTitleScreen.setLocationRelativeTo(null);
	}
	
	public void setComponents(){
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		returnTitleScreen.add(backPanel);
		
		closeBtn(backPanel);

		JLabel issueRentalLabel = new JLabel("Issue Title Rental");
		issueRentalLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		issueRentalLabel.setBounds(30, 15, 200, 30);
		issueRentalLabel.setForeground(Color.WHITE);
		backPanel.add(issueRentalLabel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 60, returnTitleScreen.getWidth(), returnTitleScreen.getHeight() - 115);
		backPanel.add(backRectangle);

		JLabel customerIcon = new JLabel();
		customerIcon.setIcon(new ImageIcon("img\\icons\\custiconbluesmall.png"));
		customerIcon.setBounds(25, 5, 100, 100);
		backRectangle.add(customerIcon);

		JLabel titleIcon = new JLabel();
		titleIcon.setIcon(new ImageIcon("img\\icons\\titleiconbluesmall.png"));
		titleIcon.setBounds(25, 105, 100, 100);
		backRectangle.add(titleIcon);

		textFields(backRectangle);
		buttons(backRectangle);
		
	}
	
	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
		closeBtn.setBounds(740, 14, 30, 30);
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
				closeBtn.setBounds(737, 10, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
				closeBtn.setBounds(740, 14, 30, 30);
			}
		});
	}
	
	public void textFields(JPanel backRectangle) {

		titleIDtf = new JTextField();
		titleIDtf.setText("enter title id");
		titleIDtf.setForeground(new Color(180, 180, 180));
		titleIDtf.addFocusListener(this);
		titleIDtf.setBounds(140, 130, 250, 45);
		titleIDtf.setBorder(null);
		titleIDtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(titleIDtf);
	}
	
	public void buttons(JPanel backRectangle) {

		// ---------------------------CANCEL BUTTON-------------------------------
				JButton cancelBtn = new JButton();
				cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
				cancelBtn.setBackground(backRectangle.getBackground());
				cancelBtn.setBounds(595, 13, 170, 80);
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
						cancelBtn.setBounds(591, 11, 179, 84);
					}

					public void mouseExited(MouseEvent evt) {
						cancelBtn.setIcon(new ImageIcon("img\\btn\\cancelbtnsmall.png"));
						cancelBtn.setBounds(595, 13, 170, 80);
					}
				});
		// ---------------------------CONFIRM BUTTON-------------------------------
				JButton confirmBtn = new JButton();
				confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
				confirmBtn.setBackground(backRectangle.getBackground());
				confirmBtn.setBounds(595, 113, 170, 80);
				confirmBtn.setBorderPainted(false);
				confirmBtn.setContentAreaFilled(false);
				confirmBtn.setFocusPainted(false);
				backRectangle.add(confirmBtn);
				confirmBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

						if (!titleIDtf.getText().matches("[0-9]{1,3}")) {
							Object[] btns = { "Ok" };
							int i = JOptionPane.showOptionDialog(null, "Enter an existing Title ID please.", "Title ID Error.",
									JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
							return;
						}
						// -----------GET RENT INFO TO UPDATE----------
						rent = managementSystem.getRentByTitleID(Integer.parseInt(titleIDtf.getText()));
						
						// -----------GET TITLE JUST TO CHECK IF IT EXISTS----------
						ArrayList<Object> UnknownTitleType;
						
						try {//try/catch in case it is null not to pause the program
							UnknownTitleType = managementSystem.getTitleInfoByID(rent.getTitleID());

							if (UnknownTitleType.isEmpty()) {
								Object[] btns = { "Ok" };
								int i = JOptionPane.showOptionDialog(null,
										"There's no Title ID " + titleIDtf.getText() + " in the System.", "Non-Existent ID.",
										JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
								return;
							}
						} catch (Exception exc) {
							exc.getMessage();
							Object[] btns = { "Ok" };
							int i = JOptionPane.showOptionDialog(null,
									"There's no Title ID " + titleIDtf.getText() + " in the System.", "Non-Existent ID.",
									JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
							return;
						}

//						unwrapTitle(UnknownTitleType);
						
						// -----------GET CARD TO UPDATE----------
						card = new MembershipCard();
						try {
							card = managementSystem.getCardInfoByID(customer.getCardID());
						} catch (Exception ex) {
							ex.getMessage();
							Object[] btns = { "Ok" };
							int i = JOptionPane.showOptionDialog(null,
									"error class ReturnTitle, GET CARD INFO section", "Error at returnTitle, GET CARD INFO",
									JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
							return;
						}
						//return title rental from card
						card.removeOngoingRents();
						
						// -----------GET CUSTOMER JUST TO GET IT'S ACCOUNT ID ----------
						customer = new Customer();
						try {
							customer = managementSystem.getCustomerInfoByID(rent.getCardID());
						} catch (Exception exx) {
							exx.getMessage();
							Object[] btns = { "Ok" };
							int i = JOptionPane.showOptionDialog(null,
									"There's no customer ID " + customer.getCustomer_id() + " in the System.", "Non-Existent ID.",
									JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
							return;
						}
						
						int check = managementSystem.returnTitle(rent, card);
						switch(check) {
						case 1:
							Object[] btnz = { "Ok" };
							int y = JOptionPane.showOptionDialog(null,
									"Title returned successfully", "Title Returned.",
									JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btnz, btnz[0]);
							break;
						case 2:
							Object[] btns = { "Ok" };
							int i = JOptionPane.showOptionDialog(null,
									"Error while setting back Title to available", "Error Title Availability.",
									JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
							return;
						case 3:
							Object[] btnss = { "Ok" };
							int ii = JOptionPane.showOptionDialog(null,
									"Error while setting back return Title on Card", "Error Card Ongoing Rents.",
									JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btnss, btnss[0]);
							return;
						case 4:
							Object[] btnsss = { "Ok" };
							int iii = JOptionPane.showOptionDialog(null,
									"Error while deleting Rent from system", "Error Rent Deletion.",
									JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btnsss, btnsss[0]);
							return;
						}
						
						
					}
				});
				confirmBtn.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						confirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
						confirmBtn.setIcon(new ImageIcon("img\\btn\\hover\\confirmbtnhover.png"));
						confirmBtn.setBounds(591, 115, 179, 84);
					}

					public void mouseExited(MouseEvent evt) {
						confirmBtn.setIcon(new ImageIcon("img\\btn\\confirmbtn.png"));
						confirmBtn.setBounds(595, 113, 170, 80);
					}
				});
			}

	/**
	 * @param unknowntitletype the ArrayList of object title types
	 */
//	public void unwrapTitle(ArrayList<Object> unknowntitletype) {
//
//		for (Object obj : unknowntitletype) {
//			switch (obj.getClass().getName()) {// or filter.getName()
//			case "model.titles.MusicOrLive":
//				title = (Title) obj;
//				break;
//			case "model.titles.Movie":
//				title = (Title) obj;
//				break;
//			case "model.titles.BoxSet":
//				title = (Title) obj;
//				break;
//			}
//		}
//	}
	
	public void validation() {
		returnTitleScreen.repaint();
		returnTitleScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
