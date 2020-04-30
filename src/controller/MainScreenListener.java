package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.UltraVisionDB;

public class MainScreenListener implements ActionListener{

	private UltraVisionDB db;
	
	public MainScreenListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		db = new UltraVisionDB();
	}

}
