package view.customer;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.KeyController;

public class DeleteCustomerScreen {

	private JFrame deleteCustomerScreen = new JFrame();
	KeyController keyListener = new KeyController(deleteCustomerScreen);
	
	public DeleteCustomerScreen(){
		setAttributes();
		setComponents();
		validation();
	}
	
	public void setAttributes() {
		deleteCustomerScreen.setSize(1000, 650);
		deleteCustomerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		deleteCustomerScreen.setVisible(true);
		deleteCustomerScreen.setResizable(false);
		deleteCustomerScreen.setTitle("Ultra-Vision | Cancel Customer Subscription");
		deleteCustomerScreen.addKeyListener(keyListener);
		deleteCustomerScreen.setLocationRelativeTo(null);
	}
	
	public void setComponents(){
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		deleteCustomerScreen.add(backPanel);
		
		JLabel logoIconInJLabel = new JLabel();
		logoIconInJLabel.setIcon(new ImageIcon("img\\logo.png"));
		backPanel.add(logoIconInJLabel);
		
		
		
		
		
	}
	
	public void validation() {
		deleteCustomerScreen.repaint();
		deleteCustomerScreen.validate();
	}
}
