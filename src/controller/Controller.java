package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import model.UltraVisionDB;
import model.customer.Customer;
import model.titles.Title;
import view.MainScreen;

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

	public int addNewCustomer(Customer newCustumer) {

		return db.addNewCustomer(newCustumer);
	}

	public int addNewTitle(Title newTitle) {

		return db.addNewTitle(newTitle);
	}
	
	public int searchTitle(String entity, String filter, String search) {
		
		return db.searchTitle(entity, filter, search);
	}
}
