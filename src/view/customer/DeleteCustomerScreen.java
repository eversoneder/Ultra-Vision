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
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.KeyController;

public class DeleteCustomerScreen implements FocusListener {

	private JFrame deleteCustomerScreen = new JFrame();
	KeyController keyListener = new KeyController(deleteCustomerScreen);

	private JTextField IDtf;
	private JButton deleteBtn;

	public DeleteCustomerScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public static void main(String[] args) {
		new DeleteCustomerScreen();
	}

	public void setAttributes() {
		deleteCustomerScreen.setSize(900, 300);
		deleteCustomerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		deleteCustomerScreen.setVisible(true);
		deleteCustomerScreen.setResizable(false);
		deleteCustomerScreen.setTitle("Ultra-Vision | Cancel Customer Subscription");
		deleteCustomerScreen.addKeyListener(keyListener);
		deleteCustomerScreen.setLocationRelativeTo(null);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		deleteCustomerScreen.add(backPanel);

		closeBtn(backPanel);

		JLabel deleteCustomerIcon = new JLabel();
		deleteCustomerIcon.setIcon(new ImageIcon("img\\icons\\deletecustomericon.png"));
		deleteCustomerIcon.setBounds(30, 60, 170, 170);
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

		IDtf = new JTextField();
		IDtf.setText("enter customer id to delete");
		IDtf.setHorizontalAlignment(JTextField.CENTER);
		IDtf.setForeground(new Color(180, 180, 180));
		IDtf.addFocusListener(this);
		IDtf.setBounds(570, 40, 250, 45);
		IDtf.setBorder(null);
		IDtf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backRectangle.add(IDtf);
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
//				deleteCustomerScreen.dispose();
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
// ---------------------------CANCEL BUTTON-------------------------------
				deleteBtn = new JButton();
				deleteBtn.setIcon(new ImageIcon("img\\btn\\deletebtn.png"));
				deleteBtn.setBackground(backRectangle.getBackground());
				deleteBtn.setBounds(580, 120, 230, 106);
				deleteBtn.setBorderPainted(false);
				deleteBtn.setContentAreaFilled(false);
				deleteBtn.setFocusPainted(false);
				backRectangle.add(deleteBtn);
				deleteBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						deleteCustomerScreen.dispose();
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
		if (IDtf.getText().matches("enter customer id to delete")) {
			IDtf.setText("");
			IDtf.setForeground(new Color(0, 80, 110));
		}
		if (!IDtf.hasFocus()) {
			if (IDtf.getText().matches("")) {
				IDtf.setText("enter customer id to delete");
				IDtf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
