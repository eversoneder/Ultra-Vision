package view.title;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.KeyController;

public class SearchTitle {

	private JFrame searchTitleScreen = new JFrame();
	KeyController keyListener = new KeyController(searchTitleScreen);
	
	public SearchTitle(){
		setAttributes();
		setComponents();
		validation();
	}
	
	public void setAttributes() {
		searchTitleScreen.setSize(1000, 650);
		searchTitleScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		searchTitleScreen.setVisible(true);
		searchTitleScreen.setResizable(false);
		searchTitleScreen.setTitle("Ultra-Vision | Title Search");
		searchTitleScreen.addKeyListener(keyListener);
		searchTitleScreen.setLocationRelativeTo(null);
	}
	
	public void setComponents(){
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		searchTitleScreen.add(backPanel);
		
		JLabel logoIconInJLabel = new JLabel();
		logoIconInJLabel.setIcon(new ImageIcon("img\\logo.png"));
		backPanel.add(logoIconInJLabel);
		
		
		
		
		
	}
	
	public void validation() {
		searchTitleScreen.repaint();
		searchTitleScreen.validate();
	}
}
