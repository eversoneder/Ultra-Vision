package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.KeyController;
import view.customer.NewCustomerClassificationsScreen;
import view.customer.DeleteCustomerScreen;
import view.customer.SearchCustomerScreen;
import view.customer.UpdateCustomerEnterIDScreen;
import view.title.DeleteTitleScreen;
import view.title.ReturnTitleScreen;
import view.title.SearchTitleScreen;
import view.title.NewTitleClassificationsScreen;

public class MainScreen {

	private JButton closeBtn;
	private JFrame MainScreen = new JFrame();

	private KeyController listenerController = new KeyController(MainScreen);

	public MainScreen() {
		setAttributes();
		setComponents();
		validation();
	}
	
	public void setAttributes() {
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//was trying to do full screen
		MainScreen.setSize(1300, 800);
		MainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainScreen.setUndecorated(true);
		MainScreen.setVisible(true);
		MainScreen.setResizable(false);
		MainScreen.setTitle("Ultra-Vision Management System");
		MainScreen.setLocationRelativeTo(null);
		MainScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		
		MainScreen.addKeyListener(listenerController);
		MainScreen.addWindowListener(listenerController);
		MainScreen.addMouseListener(listenerController);
		MainScreen.addMouseMotionListener(listenerController);
	}
	
	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		MainScreen.add(backPanel);
		
		JLabel logoIconInJLabel = new JLabel();
		logoIconInJLabel.setIcon(new ImageIcon("img\\icons\\logo.png"));
		logoIconInJLabel.setBounds(400, 20, 500, 375);
		backPanel.add(logoIconInJLabel);

		JPanel whiteStrip1 = new JPanel();
		whiteStrip1.setLayout(null);
		whiteStrip1.setBackground(new Color(0, 80, 110));
		whiteStrip1.setBounds(0, 395, 1300, 150);
		backPanel.add(whiteStrip1);

		objsWithinStrip1(whiteStrip1);

		JPanel whiteStrip2 = new JPanel();
		whiteStrip2.setLayout(null);
		whiteStrip2.setBackground(new Color(0, 80, 110));
		whiteStrip2.setBounds(0, whiteStrip1.getY() + 180, 1300, 150);
		backPanel.add(whiteStrip2);

		objsWithinStrip2(whiteStrip2);

		rentBtns(backPanel);
		closeBtn(backPanel);
		
		JLabel background = new JLabel(new ImageIcon("img\\background.jpg"));
		background.setBounds(0, 0, 1300, 800);
		backPanel.add(background);
	}
	
	public void rentBtns(JPanel backPanel) {
		
		JButton rentBtn = new JButton();
		rentBtn.setIcon(new ImageIcon("img\\btn\\newrentbtn.png"));
		rentBtn.setBounds(15, 15, 230, 230);
		rentBtn.setBorderPainted(false);
		rentBtn.setContentAreaFilled(false);
		rentBtn.setFocusPainted(false);
		rentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RentScreen();
			}
		});
		backPanel.add(rentBtn);
		rentBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				rentBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				rentBtn.setIcon(new ImageIcon("img\\btn\\hover\\newrentbtnhover.png"));
				rentBtn.setBounds(10, 10, 240, 240);
			}

			public void mouseExited(MouseEvent evt) {
				rentBtn.setIcon(new ImageIcon("img\\btn\\newrentbtn.png"));
				rentBtn.setBounds(15, 15, 230, 230);
			}
		});
		
		JButton viewRentsBtn = new JButton();
		viewRentsBtn.setIcon(new ImageIcon("img\\btn\\viewrentsbtn.png"));
		viewRentsBtn.setBounds(0, 225, 160, 170);
		viewRentsBtn.setBorderPainted(false);
		viewRentsBtn.setContentAreaFilled(false);
		viewRentsBtn.setFocusPainted(false);
		viewRentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewRents();
			}
		});
		backPanel.add(viewRentsBtn);
		viewRentsBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				viewRentsBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				viewRentsBtn.setIcon(new ImageIcon("img\\btn\\hover\\viewrentsbtnhover.png"));
				viewRentsBtn.setBounds(-4, 221, 170, 180);
			}

			public void mouseExited(MouseEvent evt) {
				viewRentsBtn.setIcon(new ImageIcon("img\\btn\\viewrentsbtn.png"));
				viewRentsBtn.setBounds(0, 225, 160, 170);
			}
		});
	}

	public void objsWithinStrip1(JPanel whiteStrip1) {

//----------------Customer Icon----------------------------------------------
		JLabel customerIconInJLabel = new JLabel();
		customerIconInJLabel.setIcon(new ImageIcon("img\\icons\\customericon.png"));
		customerIconInJLabel.setBounds(54, 0, 150, 150);
		whiteStrip1.add(customerIconInJLabel);

//----------------New Customer Button----------------------------------------------
		JButton newCustomerBtn = new JButton();
		newCustomerBtn.setIcon(new ImageIcon("img\\btn\\newcustomerbtn.png"));
		newCustomerBtn.setBackground(whiteStrip1.getBackground());
		newCustomerBtn.setBounds(222, 22, 230, 106);
		newCustomerBtn.setBorderPainted(false);
		newCustomerBtn.setContentAreaFilled(false);
		newCustomerBtn.setFocusPainted(false);
		whiteStrip1.add(newCustomerBtn);
		newCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewCustomerClassificationsScreen();
			}
		});
		newCustomerBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				newCustomerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				newCustomerBtn.setIcon(new ImageIcon("img\\btn\\hover\\newcustomerbtnhover.png"));
				newCustomerBtn.setBounds(218, 20, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				newCustomerBtn.setIcon(new ImageIcon("img\\btn\\newcustomerbtn.png"));
				newCustomerBtn.setBounds(222, 22, 230, 106);
			}
		});
//----------------Search Customer Button----------------------------------------------
		JButton searchCustomerBtn = new JButton();
		searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\searchcustomerbtn.png"));
		searchCustomerBtn.setBackground(whiteStrip1.getBackground());
		searchCustomerBtn.setBounds(484, 22, 230, 106);
		searchCustomerBtn.setBorderPainted(false);
		searchCustomerBtn.setContentAreaFilled(false);
		searchCustomerBtn.setFocusPainted(false);
		whiteStrip1.add(searchCustomerBtn);
		searchCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchCustomerScreen();
			}
		});
		searchCustomerBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				searchCustomerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\hover\\searchcustomerbtnhover.png"));
				searchCustomerBtn.setBounds(480, 20, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\searchcustomerbtn.png"));
				searchCustomerBtn.setBounds(484, 22, 230, 106);
			}
		});
//----------------Update Customer Button----------------------------------------------
		JButton updateCustomerBtn = new JButton();
		updateCustomerBtn.setIcon(new ImageIcon("img\\btn\\updatecustomerbtn.png"));
		updateCustomerBtn.setBackground(whiteStrip1.getBackground());
		updateCustomerBtn.setBounds(746, 22, 230, 106);
		updateCustomerBtn.setBorderPainted(false);
		updateCustomerBtn.setContentAreaFilled(false);
		updateCustomerBtn.setFocusPainted(false);
		whiteStrip1.add(updateCustomerBtn);
		updateCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateCustomerEnterIDScreen();
			}
		});
		updateCustomerBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				updateCustomerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				updateCustomerBtn.setIcon(new ImageIcon("img\\btn\\hover\\updatecustomerbtnhover.png"));
				updateCustomerBtn.setBounds(742, 20, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				updateCustomerBtn.setIcon(new ImageIcon("img\\btn\\updatecustomerbtn.png"));
				updateCustomerBtn.setBounds(746, 22, 230, 106);
			}
		});
//----------------Delete Customer Button----------------------------------------------
		JButton deleteCustomerBtn = new JButton();
		deleteCustomerBtn.setIcon(new ImageIcon("img\\btn\\deletecustomerbtn.png"));
		deleteCustomerBtn.setBackground(whiteStrip1.getBackground());
		deleteCustomerBtn.setBounds(1008, 22, 230, 106);
		deleteCustomerBtn.setBorderPainted(false);
		deleteCustomerBtn.setContentAreaFilled(false);
		deleteCustomerBtn.setFocusPainted(false);
		whiteStrip1.add(deleteCustomerBtn);
		deleteCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteCustomerScreen();
			}
		});
		deleteCustomerBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				deleteCustomerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				deleteCustomerBtn.setIcon(new ImageIcon("img\\btn\\hover\\deletecustomerbtnhover.png"));
				deleteCustomerBtn.setBounds(1004, 20, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				deleteCustomerBtn.setIcon(new ImageIcon("img\\btn\\deletecustomerbtn.png"));
				deleteCustomerBtn.setBounds(1008, 22, 230, 106);
			}
		});
	}

	public void objsWithinStrip2(JPanel whiteStrip2) {

// ----------------Title Icon----------------------------------------------
		JLabel customerIconInJLabel = new JLabel();
		customerIconInJLabel.setIcon(new ImageIcon("img\\icons\\titleicon.png"));
		customerIconInJLabel.setBounds(54, 0, 150, 150);
		whiteStrip2.add(customerIconInJLabel);

// ----------------New Title Button----------------------------------------------
		JButton newTitleBtn = new JButton();
		newTitleBtn.setIcon(new ImageIcon("img\\btn\\newtitlebtn.png"));
		newTitleBtn.setBounds(222, 22, 230, 106);
		newTitleBtn.setBorderPainted(false);
		newTitleBtn.setContentAreaFilled(false);
		newTitleBtn.setFocusPainted(false);

		newTitleBtn.setActionCommand("newTitleBtn");
		newTitleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewTitleClassificationsScreen();
			}
		});

		whiteStrip2.add(newTitleBtn);
		newTitleBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				newTitleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				newTitleBtn.setIcon(new ImageIcon("img\\btn\\hover\\newtitlebtnhover.png"));
				newTitleBtn.setBounds(218, 20, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				newTitleBtn.setIcon(new ImageIcon("img\\btn\\newtitlebtn.png"));
				newTitleBtn.setBounds(222, 22, 230, 106);
			}
		});
// ----------------Search Title Button----------------------------------------------
		JButton searchTitleBtn = new JButton();
		searchTitleBtn.setIcon(new ImageIcon("img\\btn\\searchtitlebtn.png"));
		searchTitleBtn.setBackground(whiteStrip2.getBackground());
		searchTitleBtn.setBounds(484, 22, 230, 106);
		searchTitleBtn.setBorderPainted(false);
		searchTitleBtn.setContentAreaFilled(false);
		searchTitleBtn.setFocusPainted(false);
		whiteStrip2.add(searchTitleBtn);
		searchTitleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchTitleScreen();
			}
		});
		searchTitleBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				searchTitleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				searchTitleBtn.setIcon(new ImageIcon("img\\btn\\hover\\searchtitlebtnhover.png"));
				searchTitleBtn.setBounds(480, 20, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				searchTitleBtn.setIcon(new ImageIcon("img\\btn\\searchtitlebtn.png"));
				searchTitleBtn.setBounds(484, 22, 230, 106);
			}
		});
// ----------------Return Title Button----------------------------------------------
		JButton updateCustomerBtn = new JButton();
		updateCustomerBtn.setIcon(new ImageIcon("img\\btn\\returntitlebtn.png"));
		updateCustomerBtn.setBackground(whiteStrip2.getBackground());
		updateCustomerBtn.setBounds(746, 22, 230, 106);
		updateCustomerBtn.setBorderPainted(false);
		updateCustomerBtn.setContentAreaFilled(false);
		updateCustomerBtn.setFocusPainted(false);
		whiteStrip2.add(updateCustomerBtn);
		updateCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReturnTitleScreen();
			}
		});
		updateCustomerBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				updateCustomerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				updateCustomerBtn.setIcon(new ImageIcon("img\\btn\\hover\\returntitlebtnhover.png"));
				updateCustomerBtn.setBounds(742, 20, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				updateCustomerBtn.setIcon(new ImageIcon("img\\btn\\returntitlebtn.png"));
				updateCustomerBtn.setBounds(746, 22, 230, 106);
			}
		});
// ----------------Delete Title Button----------------------------------------------
		JButton deleteCustomerBtn = new JButton();
		deleteCustomerBtn.setIcon(new ImageIcon("img\\btn\\deletetitlebtn.png"));
		deleteCustomerBtn.setBackground(whiteStrip2.getBackground());
		deleteCustomerBtn.setBounds(1008, 22, 230, 106);
		deleteCustomerBtn.setBorderPainted(false);
		deleteCustomerBtn.setContentAreaFilled(false);
		deleteCustomerBtn.setFocusPainted(false);
		whiteStrip2.add(deleteCustomerBtn);
		deleteCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteTitleScreen();
			}
		});
		deleteCustomerBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				deleteCustomerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				deleteCustomerBtn.setIcon(new ImageIcon("img\\btn\\hover\\deletetitlebtnhover.png"));
				deleteCustomerBtn.setBounds(1004, 20, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				deleteCustomerBtn.setIcon(new ImageIcon("img\\btn\\deletetitlebtn.png"));
				deleteCustomerBtn.setBounds(1008, 22, 230, 106);
			}
		});
	}

	public void closeBtn(JPanel backPanel) {

		closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtn.png"));
		closeBtn.setBounds(MainScreen.getWidth() - 100, 22, 71, 71);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		backPanel.add(closeBtn);
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closebtnhover.png"));
				closeBtn.setBounds(MainScreen.getWidth() - 104, 17, 80, 80);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtn.png"));
				closeBtn.setBounds(MainScreen.getWidth() - 100, 22, 71, 71);
			}
		});
	}

	public void validation() {
		MainScreen.validate();
		MainScreen.repaint();
	}
}
