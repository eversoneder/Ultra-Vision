package view.title;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.KeyController;

public class DeleteTitleScreen {

	private JFrame deleteTitleScreen = new JFrame();
	KeyController keyListener = new KeyController(deleteTitleScreen);
	
	public DeleteTitleScreen(){
		setAttributes();
		setComponents();
		validation();
	}
	
	public void setAttributes() {
		deleteTitleScreen.setSize(1000, 650);
		deleteTitleScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		deleteTitleScreen.setVisible(true);
		deleteTitleScreen.setResizable(false);
		deleteTitleScreen.setTitle("Ultra-Vision | Title Deletion");
		deleteTitleScreen.addKeyListener(keyListener);
		deleteTitleScreen.setLocationRelativeTo(null);
	}
	
	public void setComponents(){
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		deleteTitleScreen.add(backPanel);
		
		JLabel logoIconInJLabel = new JLabel();
		logoIconInJLabel.setIcon(new ImageIcon("img\\logo.png"));
		backPanel.add(logoIconInJLabel);
		
		
		
		
		
	}
	
	public void validation() {
		deleteTitleScreen.repaint();
		deleteTitleScreen.validate();
	}
}
