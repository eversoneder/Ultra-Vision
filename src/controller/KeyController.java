package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class KeyController implements KeyListener {

	private JButton btn;
	private JFrame currentScreen;

	public KeyController(JButton btn) {
		this.btn = btn;
	}

	public KeyController(JFrame frame) {
		this.currentScreen = frame;
	}
	
	public KeyController(JFrame frame, JButton btn) {
		this.currentScreen = frame;
		this.btn = btn;
	}
	
	public KeyController() {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Character q = 'q';
		if (e.getKeyCode() == 10 || e.getKeyCode() == 13) {
			btn.doClick();
		} else if ((q.equals(e.getKeyChar()) || (e.getKeyCode() == 81))) {
			System.out.println(e.getKeyChar());
			System.out.println(e.getKeyCode());
			System.out.println("deu");
			currentScreen.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
