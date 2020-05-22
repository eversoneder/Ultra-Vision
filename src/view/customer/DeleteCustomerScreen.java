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
import javax.swing.JTextField;

import controller.KeyController;
import controller.UltraVisionManagementSystem;
import model.customer.Customer;

public class DeleteCustomerScreen implements FocusListener {

	private JFrame deleteCustomerScreen = new JFrame();
	private KeyController keyAndWindowListener = new KeyController(deleteCustomerScreen);

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField customerIDtf;

	private Customer customer = new Customer();

	public DeleteCustomerScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public void setAttributes() {
		deleteCustomerScreen.setSize(900, 300);
		deleteCustomerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		deleteCustomerScreen.setVisible(true);
		deleteCustomerScreen.setResizable(false);
		deleteCustomerScreen.setTitle("Ultra-Vision | Cancel Customer Subscription");
		deleteCustomerScreen.setLocationRelativeTo(null);
		deleteCustomerScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());

		deleteCustomerScreen.addKeyListener(keyAndWindowListener);
		deleteCustomerScreen.addWindowListener(keyAndWindowListener);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		deleteCustomerScreen.add(backPanel);

		closeBtn(backPanel);

		JLabel deleteCustomerIcon = new JLabel();
		deleteCustomerIcon.setIcon(new ImageIcon("img\\icons\\deletecustomericon.png"));
		deleteCustomerIcon.setBounds(40, 60, 170, 170);
		backPanel.add(deleteCustomerIcon);

		JLabel newCustomerLabel = new JLabel("Delete Customer");
		newCustomerLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		newCustomerLabel.setBounds(40, 10, 300, 35);
		newCustomerLabel.setForeground(Color.WHITE);
		backPanel.add(newCustomerLabel);

		buttons(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 50, deleteCustomerScreen.getWidth(), deleteCustomerScreen.getHeight() - 110);
		backPanel.add(backRectangle);

		JLabel searchIDLabel = new JLabel("Search to get ID");
		searchIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchIDLabel.setBounds(320, 10, 350, 35);
		searchIDLabel.setForeground(Color.WHITE);
		backRectangle.add(searchIDLabel);

		customerIDtf = new JTextField();
		customerIDtf.setText("enter customer id to delete");
		customerIDtf.setHorizontalAlignment(JTextField.CENTER);
		customerIDtf.setForeground(new Color(180, 180, 180));
		customerIDtf.addFocusListener(this);
		customerIDtf.setBounds(570, 40, 250, 45);
		customerIDtf.setBorder(null);
		customerIDtf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backRectangle.add(customerIDtf);
	}

	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
		closeBtn.setBounds(840, 10, 30, 30);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCustomerScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closebtnsmallhover.png"));
				closeBtn.setBounds(837, 6, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
				closeBtn.setBounds(840, 10, 30, 30);
			}
		});
	}

	public void buttons(JPanel backRectangle) {

// ----------------Search Customer Button----------------------------------------------
		JButton searchCustomerBtn = new JButton();
		searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\searchcustomerbtn.png"));
		searchCustomerBtn.setBackground(backRectangle.getBackground());
		searchCustomerBtn.setBounds(264, 112, 230, 106);
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
				searchCustomerBtn.setBounds(260, 110, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				searchCustomerBtn.setIcon(new ImageIcon("img\\btn\\searchcustomerbtn.png"));
				searchCustomerBtn.setBounds(264, 112, 230, 106);
			}
		});
// ---------------------------DELETE BUTTON-------------------------------
		JButton deleteBtn = new JButton();
		deleteBtn.setIcon(new ImageIcon("img\\btn\\deletebtn.png"));
		deleteBtn.setBackground(backRectangle.getBackground());
		deleteBtn.setBounds(580, 120, 230, 106);
		deleteBtn.setBorderPainted(false);
		deleteBtn.setContentAreaFilled(false);
		deleteBtn.setFocusPainted(false);
		backRectangle.add(deleteBtn);
		deleteBtn.addActionListener(new ActionListener() {
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
				}

				int a = managementSystem.deleteCustomer(customer);

				switch (a) {
				case 0:
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Customer of ID " + customerIDtf + " doesn't exist.",
							"Error.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				case 1:
					Object[] btnss = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Customer: " + customer.getCustomer_name() + ", ID: " + customer.getCustomer_id()
									+ " was successfully deleted from the system.",
							"Customer Removal Done.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
							btnss, btnss[0]);
					break;
				}
			}
		});
		deleteBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				deleteBtn.setIcon(new ImageIcon("img\\btn\\hover\\deletebtnhover.png"));
				deleteBtn.setBounds(576, 118, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				deleteBtn.setIcon(new ImageIcon("img\\btn\\deletebtn.png"));
				deleteBtn.setBounds(580, 120, 230, 106);
			}
		});

	}

	public void validation() {
		deleteCustomerScreen.repaint();
		deleteCustomerScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// ------------------movie genre TextField-------------------------
		if (customerIDtf.getText().matches("enter customer id to delete")) {
			customerIDtf.setText("");
			customerIDtf.setForeground(new Color(0, 80, 110));
		}
		if (!customerIDtf.hasFocus()) {
			if (customerIDtf.getText().matches("")) {
				customerIDtf.setText("enter customer id to delete");
				customerIDtf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
