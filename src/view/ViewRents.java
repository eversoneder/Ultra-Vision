package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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
import controller.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.Title;

public class ViewRents {
	
	private JFrame viewRentsScreen = new JFrame();
	private KeyController listenerController = new KeyController(viewRentsScreen);

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);
	
	private Customer customer;
	private MembershipCard card;
	private Title title;
	
	public ViewRents() {
		setAttributes();
		setComponents();
		validation();
	}

	private void validation() {
		viewRentsScreen.validate();
		viewRentsScreen.repaint();
	}

	public void setAttributes() {
		viewRentsScreen.setSize(1000, 650);
		viewRentsScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewRentsScreen.setUndecorated(true);
		viewRentsScreen.setVisible(true);
		viewRentsScreen.setResizable(false);
		viewRentsScreen.setTitle("Ultra-Vision | Customer Search");
		viewRentsScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		viewRentsScreen.setLocationRelativeTo(null);

		viewRentsScreen.addKeyListener(listenerController);
		viewRentsScreen.addWindowListener(listenerController);
		viewRentsScreen.addMouseListener(listenerController);
		viewRentsScreen.addMouseMotionListener(listenerController);
	}
	
	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		viewRentsScreen.add(backPanel);

		closeBtn(backPanel);

		JLabel customericon = new JLabel();
		customericon.setIcon(new ImageIcon("img\\icons\\customericonbluebackcircle.png"));
		customericon.setBounds(10, 0, 300, 150);
		backPanel.add(customericon);

		closeBtn(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, viewRentsScreen.getWidth(), viewRentsScreen.getHeight() - 200);
		backPanel.add(backRectangle);

		JPanel panelToLayTable = new JPanel();
		panelToLayTable.setLayout(null);
		panelToLayTable.setBackground(Color.WHITE);
		panelToLayTable.setBounds(50, 70, 885, 370);
		backRectangle.add(panelToLayTable);

		JLabel newCustomerLabel = new JLabel("Customer Info");
		newCustomerLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		newCustomerLabel.setBounds(170, 70, 350, 35);
		newCustomerLabel.setForeground(Color.WHITE);
		backPanel.add(newCustomerLabel);

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img\\icons\\logobluecircle.png"));
		logo.setBounds(420, 0, 300, 120);
		backPanel.add(logo);
	}

	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closepagebtn.png"));
		closeBtn.setBounds(770, 20, 222, 65);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewRentsScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closepagebtnhover.png"));
				closeBtn.setBounds(768, 15, 230, 75);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closepagebtn.png"));
				closeBtn.setBounds(770, 20, 222, 65);
			}
		});
	}
	
}
