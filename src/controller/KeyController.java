package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class KeyController implements KeyListener{

	private JButton btn;
	private JFrame currentScreen;
	
	public KeyController(JFrame frame) {
		this.currentScreen = frame;
	}

	public KeyController(JFrame frame, JButton btn) {
		this.currentScreen = frame;
		this.btn = btn;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == 10 || e.getKeyCode() == 13) {
			btn.doClick();
		}
		if (e.getKeyCode() == 81) {
			currentScreen.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
