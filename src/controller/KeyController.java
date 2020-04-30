package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class KeyController implements KeyListener{

	private JButton btn;
	public KeyController(JButton btn) {
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
