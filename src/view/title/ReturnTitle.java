package view.title;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.KeyController;

public class ReturnTitle {

	private JFrame returnTitleScreen = new JFrame();
	KeyController keyListener = new KeyController(returnTitleScreen);
	
	public ReturnTitle(){
		setAttributes();
		setComponents();
		validation();
	}
	
	public void setAttributes() {
		returnTitleScreen.setSize(1000, 650);
		returnTitleScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		returnTitleScreen.setVisible(true);
		returnTitleScreen.setResizable(false);
		returnTitleScreen.setTitle("Ultra-Vision | Returning Title Registration");
		returnTitleScreen.addKeyListener(keyListener);
		returnTitleScreen.setLocationRelativeTo(null);
	}
	
	public void setComponents(){
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		returnTitleScreen.add(backPanel);
		
		JLabel logoIconInJLabel = new JLabel();
		logoIconInJLabel.setIcon(new ImageIcon("img\\logo.png"));
		backPanel.add(logoIconInJLabel);
		
		
		
		
		
	}
	
	public void validation() {
		returnTitleScreen.repaint();
		returnTitleScreen.validate();
	}
}
