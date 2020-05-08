package view.customer;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.KeyController;

public class SearchCustomerScreen {
	
	private JFrame searchCustomerScreen = new JFrame();
	KeyController keyListener = new KeyController(searchCustomerScreen);
	
	public SearchCustomerScreen(){
		setAttributes();
		setComponents();
		validation();
	}
	
	public static void main(String[]args) {
		new SearchCustomerScreen();
	}
	
	public void setAttributes() {
		searchCustomerScreen.setSize(1000, 650);
		searchCustomerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		searchCustomerScreen.setVisible(true);
		searchCustomerScreen.setResizable(false);
		searchCustomerScreen.setTitle("Ultra-Vision | Customer Search");
		searchCustomerScreen.addKeyListener(keyListener);
		searchCustomerScreen.setLocationRelativeTo(null);
	}
	
	public void setComponents(){
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		searchCustomerScreen.add(backPanel);
		
		JLabel logoIconInJLabel = new JLabel();
		logoIconInJLabel.setIcon(new ImageIcon("img\\logo.png"));
		backPanel.add(logoIconInJLabel);
		
		
		
		
		
	}
	
	public void validation() {
		searchCustomerScreen.repaint();
		searchCustomerScreen.validate();
	}
}
