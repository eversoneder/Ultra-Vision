package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// HERE I ADDED THE WINDOW LISTENER
public class KeyController implements KeyListener, WindowListener{

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
		
		System.out.println("q");
		//81 is letter q
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

	// WHEN THE WINDOW IS ON FIRST PLANE, THEN THE WINDOW REQUEST THE FOCUS SO THE KEYLISTENER WORKS
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		currentScreen.requestFocus();
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
