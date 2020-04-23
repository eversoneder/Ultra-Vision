package controller;

import java.util.Collection;

import model.UltraVisionDB;
import view.KeyController;
import view.MainScreen;
import view.Title;

public class Controller {

	private UltraVisionDB db;
	private MainScreen ms;
	
	private KeyController keyController;
	
	
	private Collection<Title> titleList;
	
	public Controller() {
		ms = new MainScreen();
	}
	
	public void getTitleList(Collection<Title> titleList) {
		this.titleList = titleList;
	}

	
}
