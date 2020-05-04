package controller;

import java.util.Collection;

import javax.swing.JFrame;

import model.UltraVisionDB;
import model.customer.Customer;
import model.titles.BoxSet;
import model.titles.Movie;
import model.titles.MusicOrLive;
import model.titles.Title;
import view.MainScreen;

public class UltraVisionManagementSystem {

	private UltraVisionDB db;
	private MainScreen mainScreen;
	private JFrame frame;
	
	private Collection<Title> titleList;

	public UltraVisionManagementSystem() {
		mainScreen = new MainScreen();
	}
	
	public UltraVisionManagementSystem(int instanceWithoutMainScreenBeingStarted) {
	}

	public void getTitleList(Collection<Title> titleList) {
		this.titleList = titleList;
	}

	public int addNewCustomer(Customer newCustumer) {

		return db.addNewCustomer(newCustumer);
	}

	/**
	 * @param newTitle the new raw Title to add 
	 * @return 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(Title newTitle) {
		
		return db.addNewTitle(newTitle);
	}
	
	/**
	 * @param newTitle the new MusicOrLive to add 
	 * @return 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(MusicOrLive newMusicOrLive) {
		
		db = new UltraVisionDB();
		return db.addNewTitle(newMusicOrLive);
	}
	
	/**
	 * @param newTitle the new MusicOrLive to add 
	 * @return 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(Movie newMovie) {
		return db.addNewTitle(newMovie);
	}
	
	public int addNewTitle(BoxSet newTitle) {
		return db.addNewTitle(newTitle);
	}
	
	public int searchTitle(String entity, String filter, String search) {
		
		return db.searchTitle(entity, filter, search);
	}
}
