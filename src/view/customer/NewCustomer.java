package view.customer;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.KeyController;

public class NewCustomer {

	private JFrame newCustomerScreen;
	KeyController keylistener;
	
	public NewCustomer(){
		setAttributes();
		setComponents();
		validation();
	}
	
	public void setAttributes() {
		newCustomerScreen = new JFrame();
		newCustomerScreen.setSize(1000, 650);
		newCustomerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newCustomerScreen.setVisible(true);
		newCustomerScreen.setResizable(false);
		newCustomerScreen.setTitle("Customer registration");
		newCustomerScreen.addKeyListener(keylistener);
		newCustomerScreen.setLocationRelativeTo(null);
	}
	
	public void setComponents(){
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		newCustomerScreen.add(backPanel);
		
		JLabel logoIconInJLabel = new JLabel();
		logoIconInJLabel.setIcon(new ImageIcon("img\\logo.png"));
		backPanel.add(logoIconInJLabel);
		
		
		
		
		
	}
	
	public void validation() {
		newCustomerScreen.repaint();
		newCustomerScreen.validate();
	}
	
}
