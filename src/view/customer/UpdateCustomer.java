package view.customer;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.KeyController;

public class UpdateCustomer {

	private JFrame updateCustomerScreen = new JFrame();
	KeyController keyListener = new KeyController(updateCustomerScreen);
	
	
	public UpdateCustomer(){
		setAttributes();
		setComponents();
		validation();
	}
	
	public void setAttributes() {
		updateCustomerScreen.setSize(1000, 650);
		updateCustomerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateCustomerScreen.setVisible(true);
		updateCustomerScreen.setResizable(false);
		updateCustomerScreen.setTitle("Ultra-Vision | Customer Information Update");
		updateCustomerScreen.addKeyListener(keyListener);
		updateCustomerScreen.setLocationRelativeTo(null);
	}
	
	public void setComponents(){
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		updateCustomerScreen.add(backPanel);
		
		JLabel logoIconInJLabel = new JLabel();
		logoIconInJLabel.setIcon(new ImageIcon("img\\logo.png"));
		backPanel.add(logoIconInJLabel);
		
		
		
		
		
	}
	
	public void validation() {
		updateCustomerScreen.repaint();
		updateCustomerScreen.validate();
	}
}
