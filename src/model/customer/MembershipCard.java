package model.customer;

import java.util.Collection;

import model.enums.AccessLevel;
import model.interfaces.TitleType;
import model.titles.Title;

public class MembershipCard extends DebitOrCreditAccount implements Subscription {

	private int id;
	private int points;
	private int hasFreeRent;
	private int freeRents;
	private int password;
	private AccessLevel subscription;

	Collection<Title> rentingList;

	private Customer customer;

	public MembershipCard(Customer customer, int password) {
		this.customer = customer;
		this.password = password;
	}

	/**
	 * @param title
	 * @return
	 */
	public boolean setNewRent(Title title) {

		boolean hasMoney = checkFunds(title.getPrice());

		if (hasMoney) {
			hasMoney = rentingList.size() < 4 ? makePayment(title.getPrice(), title) : rentingLimit();
			return hasMoney;
		} else {
			System.out.println("No sufficient money in account.");
		}
		return false;
	}

	/**
	 * @param titlePrice price to check in balance
	 * @return true if balance contains title price money
	 */
	public boolean checkFunds(double titlePrice) {
		boolean hasMoney = customer.hasMoney(titlePrice);
		return hasMoney;
	}

	/**
	 * @param titlePrice   the title price
	 * @param rentingTitle the title to be rented
	 * @return true if both statements are met (hasMoney && rentingList < 4)
	 */
	public boolean makePayment(double titlePrice, Title rentingTitle) {
		customer.setTransaction(titlePrice);
		recordRent(rentingTitle);
		return true;
	}

	/**
	 * @param rentingTitle the title to rent
	 */
	public void recordRent(Title rentingTitle) {
		rentingList.add(rentingTitle);
		addPoints(10);
		rentingTitle.setAvailable(0);
	}

	/**
	 * @return return false as maximum renting limit has reached.
	 */
	public boolean rentingLimit() {
		System.out.println("Rent limit reached (4). Customer needs to return 1 title in order to rent another.");
		return false;
	}

	/**
	 * @param returningTitle the title to return
	 */
	public void returnRent(Title returningTitle) {
		rentingList.remove(returningTitle);
		returningTitle.setAvailable(1);
		System.out.println("Title successfully returned.");
	}

	/**
	 * @return current renting number
	 */
	public int getCurrentRentingCount() {
		return rentingList.size();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return number of available free rents
	 */
	public int availFreeRent() {
		hasFreeRent = freeRents > 0 ? 1 : 0;
		return this.hasFreeRent;
	}

	/**
	 * @param rentintTitle title to rent for free
	 * @return true if > 100 points && < than 4 current renting titles
	 */
	public boolean retrieveFreeRental(Title rentingTitle) {

		int hasFreeRent = 0;
		hasFreeRent = availFreeRent(); // check if customer has freeRent to claim

		boolean isLessThanFour = true;

		switch (hasFreeRent) {
		case 0: // if don't have free rent to claim return false
			System.out.println("No available free rents.");
			return false;
		default:// if has free rent, check if is on limit (4 rents)
			isLessThanFour = checkRentingLimit();
			if (isLessThanFour) {//
				rentingList.add(rentingTitle); // no points gains && no payment as it is free rental
				System.out.println("Retrieval done.");
			} else {
				break;// if renting 4, break and return false to the method
			}
		}
		return isLessThanFour;
	}

	/**
	 * @return true if renting less than 4
	 */
	public boolean checkRentingLimit() {

		boolean isLessThanFour;
		isLessThanFour = rentingList.size() < 4 ? true : rentingLimit();

		return isLessThanFour;
	}

	public void freeRentalChoise() {
		this.freeRents -= 1;
	}

	/**
	 * @return card points
	 */
	public int getPoints() {
		return this.points;
	}

	public void addPoints(int points) {
		this.points += points;

		if (this.points >= 100) {
			updateFreeRents();
		}
	}

	/**
	 * updates free rents whenever points reaches 100
	 */
	private int updateFreeRents() {
		this.freeRents += 1;
		System.out.println("New free rent available for " + customer.getCustomer_name() + ".");
		return 0;
	}

	/**
	 * @return card password
	 */
	public int getPassword() {
		return this.password;
	}

	/**
	 * @param password to set
	 */
	protected void setPassword(int pass) {
		this.password = pass;
	}

	@Override
	public AccessLevel getSubscription() {
		return this.subscription;
	}

	public void setSubscription(AccessLevel subscription) {
		this.subscription = subscription;
	}
}
