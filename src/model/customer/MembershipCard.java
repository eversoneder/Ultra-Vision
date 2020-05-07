package model.customer;

import java.util.Collection;

import model.enums.AccessLevel;
import model.interfaces.TitleType;
import model.titles.Title;

public class MembershipCard implements TitleType {

	Collection<Title> rentingList;
	
	private int id;
	private int points;
	private int hasFreeRent;
	private int freeRents;
	private int password;
	private AccessLevel subscriptionEnum;
	private int subscriptionID;

	private int accountID;

	/**
	 * DB download
	 * @param customerid
	 * @param plan
	 * @param password
	 */
	public MembershipCard(int id, int password, int hasFreeRent, int freeRents, int points, int accountID, int subscriptionID) {
		this.id = id;
		this.password = password;
		this.hasFreeRent = hasFreeRent;
		this.freeRents = freeRents;
		this.points = points;
		this.accountID = accountID;
		this.subscriptionID = subscriptionID;
		
	}

	public MembershipCard(AccessLevel planEnum) {
		this.setTitleTypeGUI(planEnum);
		this.points = 0;
		this.hasFreeRent = 0;
		this.freeRents = 0;
		
	}

	/**
	 * @param rentingTitle the title to rent
	 */
	public void recordRent(Title rentingTitle) {
		rentingList.add(rentingTitle);
		addLoyaltyPoints(10);
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

	public void subtractFreeRental() {
		this.freeRents -= 1;
	}

	/**
	 * @return card points
	 */
	public int getPoints() {
		return this.points;
	}

	/**
	 * @return the hasFreeRent
	 */
	public int getHasFreeRent() {
		return hasFreeRent;
	}

	/**
	 * @param hasFreeRent the hasFreeRent to set
	 */
	public void setHasFreeRent(int hasFreeRent) {
		this.hasFreeRent = hasFreeRent;
	}

	/**
	 * @return the freeRents
	 */
	public int getFreeRents() {
		return freeRents;
	}

	/**
	 * @param freeRents the freeRents to set
	 */
	public void setFreeRents(int freeRents) {
		this.freeRents = freeRents;
	}

	public void addLoyaltyPoints(int points) {
		this.points += points;

		if (this.points >= 100) {
			updateFreeRents();
		}
	}

	/**
	 * updates free rents whenever points reaches 100
	 */
	private void updateFreeRents() {
		this.freeRents += 1;
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
	public void setTitleTypeGUI(AccessLevel titleClassification) {// here's the card subscription

		AccessLevel values[] = AccessLevel.values();// get instance of all subscription plans
		for (AccessLevel value : values) {// go one by one

			if (value.name().equals(titleClassification.name())) {// if name equals the one received
				//then get the subscriptionID to know what is able to rent. eg: VL = 2 > movie
				this.subscriptionID = Integer.parseInt(titleClassification.getSubscriptionID());
			}
		}
	}

	@Override
	public void setTitleTypeDB(int titleType) {
		this.subscriptionID = titleType;
	}

	@Override
	public String getTitleTypeGUI() {
		return subscriptionEnum.name();
	}

	@Override
	public int getTitleTypeDB() {
		return subscriptionID;
	}
}
