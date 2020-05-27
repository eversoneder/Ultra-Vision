package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// HERE I ADDED THE WINDOW LISTENER
public class KeyController implements KeyListener, WindowListener, MouseListener, MouseMotionListener {

	private JButton btn;
	private JFrame currentScreen;

	public KeyController(JFrame frame) {
		this.currentScreen = frame;
	}

	public KeyController(JFrame frame, JButton btn) {
		this.currentScreen = frame;
		this.btn = btn;
	}

//-----------------------------KEY LISTENER EVENTS-----------------------------
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

//		System.out.println("q");

		if (e.getKeyCode() == 10 || e.getKeyCode() == 13) {
			btn.doClick();
		}
		// 81 is letter q
		if (e.getKeyCode() == 81) {
			currentScreen.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

//-----------------------------WINDOW LISTENER EVENTS-----------------------------
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

//-----------------------------MOUSE MOTION EVENTS-----------------------------
	@Override
	public void mouseDragged(MouseEvent e) {
		int xDragged = e.getXOnScreen() - xPressed;// - where mouse was pressed
		int yDragged = e.getYOnScreen() - yPressed;// - where mouse was pressed
		// set frame location to where mouse is while pressed
		currentScreen.setLocation(xDragged, yDragged);
		// Explanation: if mouse was pressed at x,y: 20,50 on the frame then the
		// frame.setLocation would place the frame x,y: 0,0 at the mouse pointer
		// (20,50) making the new Location x,y: 20, 50(or where the mouse is).
		// (glitch) In Order not to swift the 0,0 frame location to where mouse is,
		// subtract the x,y of where the mouse is.
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

//-----------------------------MOUSE LISTENER EVENTS-----------------------------
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private int xPressed, yPressed;

	@Override
	public void mousePressed(MouseEvent e) {
		xPressed = e.getX();// get where the mouse was pressed
		yPressed = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
