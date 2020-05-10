package controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;

import model.UltraVisionDB;
import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.BoxSet;
import model.titles.Movie;
import model.titles.MusicOrLive;
import model.titles.Title;
import view.MainScreen;

public class UltraVisionManagementSystem {

	private UltraVisionDB db;
	private MainScreen mainScreen;

	public UltraVisionManagementSystem() {
		mainScreen = new MainScreen();
	}

	public UltraVisionManagementSystem(int instanceWithoutMainScreenBeingStarted) {
	}
	
	public int rentTitle(int TitleID, MembershipCard card) {
		db = new UltraVisionDB();
		return db.rentTitle(TitleID, card);
	}
	
	public int rentTitle(MusicOrLive musicOrLive, MembershipCard card) {
		db = new UltraVisionDB();
		return db.rentTitle(musicOrLive, card);
	}
	
	public int rentTitle(Movie movie, MembershipCard card) {
		db = new UltraVisionDB();
		return db.rentTitle(movie, card);
	}
	
	public int rentTitle(BoxSet boxSet, MembershipCard card) {
		db = new UltraVisionDB();
		return db.rentTitle(boxSet, card);
	}
	
	public int returnTitle(MusicOrLive returningTitle) {
		db = new UltraVisionDB();
		return db.returnTitle(returningTitle);
	}
	
	public int returnTitle(Movie returningTitle) {
		db = new UltraVisionDB();
		int flag = 0;
		
		
		
		
		return flag;
	}

	public int returnTitle(BoxSet returningTitle) {
		db = new UltraVisionDB();
		int flag = 0;
	
	
	
	
	return flag;
}
	/**
	 * @param customerID to query DB
	 * @return Customer from ID given
	 */
	public Customer getCustomerInfoByID(int customerID) {
		db = new UltraVisionDB();
		return db.getCustomerInfoByID(customerID);
	}
	
	/**
	 * @param cardID to query DB
	 * @return MembershipCard from ID given
	 */
	public MembershipCard getCardInfoByID(int cardID) {
		db = new UltraVisionDB();
		return db.getCardInfoByID(cardID);
	}
	
	public ArrayList<Object> getTitleInfoByID(int titleID){
		db = new UltraVisionDB();
		return db.getTitleInfoByID(titleID);
	}

	/**
	 * @param search to query DB
	 * @param filter to set (music, live, movie or box set)
	 * @return ArrayList<Object> of titles
	 */
	public ArrayList<Object> setSearchGetTitleList(String search, String filter) {
		db = new UltraVisionDB();
		return db.setSearchGetTitleList(search,filter);
	}
	
	/**
	 * @param search to query DB
	 * @return ArrayList<Object> of customers
	 */
	public ArrayList<Object> setSearchGetCustomerList(String search){
		db = new UltraVisionDB();
		return db.setSearchGetCustomerList(search);
	}

	/**
	 * @param customer to upload DB
	 * @return customer uploaded with ID
	 */
	public Customer addNewCustomer(Customer customer) {
		db = new UltraVisionDB();
		return db.addNewCustomer(customer);
	}
	
	/**
	 * @param customer and account to upload DB
	 * @return account and customer with ID
	 */
	public Customer addNewAccount(Customer customerinfo) {
		db = new UltraVisionDB();
		return db.addNewAccount(customerinfo);
	}
	
	/**
	 * @param card to upload DB
	 * @return card with ID
	 */
	public MembershipCard addNewMembershipCard(MembershipCard card) {
		db = new UltraVisionDB();
		return db.addNewMembershipCard(card);
	}
	
	/**
	 * @param newTitle to upload DB
	 * @return Title with ID
	 */
	public Title addNewTitle(Title newTitle) {// polymorphism of overload
		return db.addNewTitle(newTitle);
	}

	/**
	 * @param newMusicOrLive to upload DB
	 * @return int 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(MusicOrLive newMusicOrLive) {// polymorphism of overload
		db = new UltraVisionDB();
		return db.addNewTitle(newMusicOrLive);
	}
	
	/**
	 * @param newMovie to upload DB
	 * @return int 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(Movie newMovie) {// polymorphism of overload
		db = new UltraVisionDB();
		return db.addNewTitle(newMovie);
	}

	/**
	 * @param newBoxSet to upload DB
	 * @return int 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(BoxSet newBoxSet) {// polymorphism of overload
		db = new UltraVisionDB();
		return db.addNewTitle(newBoxSet);
	}
}
