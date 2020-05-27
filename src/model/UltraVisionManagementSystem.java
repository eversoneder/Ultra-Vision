package model;

import java.util.ArrayList;

import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.BoxSet;
import model.titles.Movie;
import model.titles.MusicOrLive;
import model.titles.Title;
import view.MainScreen;

public class UltraVisionManagementSystem {

	private UltraVisionDB db;
	
	private ArrayList<Object> arrayObj;

	public UltraVisionManagementSystem() {
		new MainScreen();
	}

	public UltraVisionManagementSystem(int instanceWithoutMainScreenBeingStarted) {
	}
	
	public void rentTitleByCash(Rent newRent, Customer customer, MembershipCard card) {
		db = new UltraVisionDB();
		db.rentTitleByCash(newRent, customer, card);
		db.closings();
	}
	
	public void rentTitleByPoints(Rent newRent, Customer customer, MembershipCard card) {
		db = new UltraVisionDB();
		db.rentTitleByPoints(newRent, customer, card);
		db.closings();
	}
	
	public Rent getRentByTitleID(int titleID) {
		db = new UltraVisionDB();
		Rent r = db.getRentByTitleID(titleID);
		db.closings();
		return r;
	}
	
	public int returnTitle(Rent returningRent, MembershipCard card) {
		db = new UltraVisionDB();
		int i = db.returnTitle(returningRent, card);
		db.closings();
		return i;
	}
	
	public int updateCustomer(Customer customer) {
		db = new UltraVisionDB();
		int i = db.updateCustomer(customer);
		db.closings();
		return 	i;
	}
	
	public int updateCard(MembershipCard card) {
		db = new UltraVisionDB();
		int i = db.updateCard(card);
		db.closings();
		return i;
	}
	
	/**
	 * @param customerID to query DB
	 * @return Customer from ID given
	 */
	public Customer getCustomerInfoByID(int customerID) {
		db = new UltraVisionDB();
		Customer c = db.getCustomerInfoByID(customerID);
		db.closings();
		return c;
	}
	
	public int deleteCustomer(Customer customer) {
		db = new UltraVisionDB();
		int i = db.deleteCustomer(customer);
		db.closings();
		return i;
	}
	
	public int deleteTitle(Title title) {
		db = new UltraVisionDB();
		int i = db.deleteTitle(title);
		db.closings();
		return i;
	}
	
	/**
	 * @param cardID to query DB
	 * @return MembershipCard from ID given
	 */
	public MembershipCard getCardInfoByID(int cardID) {
		db = new UltraVisionDB();
		MembershipCard m = db.getCardInfoByID(cardID);
		db.closings();
		return m;
	}
	
	public ArrayList<Object> getTitleInfoByID(int titleID){
		db = new UltraVisionDB();
		arrayObj = db.getTitleInfoByID(titleID);
		db.closings();
		return arrayObj;
	}

	/**
	 * @param search to query DB
	 * @param filter to set (music, live, movie or box set)
	 * @return ArrayList<Object> of titles
	 */
	public ArrayList<Object> setSearchGetTitleList(String search, String filter) {
		db = new UltraVisionDB();
		arrayObj = db.setSearchGetTitleList(search,filter);
		db.closings();
		return arrayObj;
	}
	
	/**
	 * @param search to query DB
	 * @return ArrayList<Object> of customers
	 */
	public ArrayList<Object> setSearchGetCustomerList(String search){
		db = new UltraVisionDB();
		arrayObj = db.setSearchGetCustomerList(search);
		db.closings();
		return arrayObj;
	}
	
	/**
	 * @param search to query DB
	 * @return ArrayList<Object> of Rent, Customer and Title
	 */
	public ArrayList<Object> setSearchGetRentList(String search){
		db = new UltraVisionDB();
		ArrayList<Object> arrayObj = db.setSearchGetRentList(search);
		db.closings();
		return arrayObj;
	}

	/**
	 * @param customer to upload DB
	 * @return customer uploaded with ID
	 */
	public Customer addNewCustomer(Customer customer) {
		db = new UltraVisionDB();
		Customer c = db.addNewCustomer(customer);
		db.closings();
		return c;
	}
	
	/**
	 * @param customer and account to upload DB
	 * @return account and customer with ID
	 */
	public Customer addNewAccount(Customer customerinfo) {
		db = new UltraVisionDB();
		Customer c = db.addNewAccount(customerinfo);
		db.closings();
		return c;
	}
	
	/**
	 * @param card to upload DB
	 * @return card with ID
	 */
	public MembershipCard addNewMembershipCard(MembershipCard card) {
		db = new UltraVisionDB();
		MembershipCard m = db.addNewMembershipCard(card);
		db.closings();
		return m;
	}
	
	/**
	 * @param newMusicOrLive to upload DB
	 * @return int 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(MusicOrLive newMusicOrLive) {// polymorphism of overload
		db = new UltraVisionDB();
		int i = db.addNewTitle(newMusicOrLive);
		db.closings();
		return i;
	}
	
	/**
	 * @param newMovie to upload DB
	 * @return int 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(Movie newMovie) {// polymorphism of overload
		db = new UltraVisionDB();
		int i = db.addNewTitle(newMovie);
		db.closings();
		return i;
	}

	/**
	 * @param newBoxSet to upload DB
	 * @return int 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(BoxSet newBoxSet) {// polymorphism of overload
		db = new UltraVisionDB();
		int i = db.addNewTitle(newBoxSet);
		db.closings();
		return i;
	}
}
