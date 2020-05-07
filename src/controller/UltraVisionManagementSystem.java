package controller;

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

	public Customer addNewCustomer(Customer customer) {
		db = new UltraVisionDB();
		return db.addNewCustomer(customer);
	}
	
	/**
	 * @param customerinfo customer to set the account_id, account_number & account_balance 
	 * @return int 1 if succeeded, 0 if failed
	 */
	public Customer addNewAccount(Customer customerinfo) {
		return db.addNewAccount(customerinfo);
	}
	
	public MembershipCard addNewMembershipCard(MembershipCard card, int accountID) {
		return db.addNewMembershipCard(card, accountID);
	}
	
	/**
	 * @param newTitle add new BoxSet to db
	 * @return int 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(Title newTitle) {// polymorphism of overload
		db = new UltraVisionDB();
		return db.addNewTitle(newTitle);
	}

	/**
	 * @param newTitle add new BoxSet to db
	 * @return int 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(MusicOrLive newMusicOrLive) {// polymorphism of overload
		db = new UltraVisionDB();
		return db.addNewTitle(newMusicOrLive);
	}

	/**
	 * @param newTitle add new BoxSet to db
	 * @return int 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(Movie newMovie) {// polymorphism of overload
		db = new UltraVisionDB();
		return db.addNewTitle(newMovie);
	}

	/**
	 * @param newTitle add new BoxSet to db
	 * @return int 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(BoxSet newTitle) {// polymorphism of overload
		return db.addNewTitle(newTitle);
	}

	public int searchTitle(String entity, String filter, String search) {

		return db.searchTitle(entity, filter, search);
	}
}
