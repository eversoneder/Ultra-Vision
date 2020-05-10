package model.customer;

import java.util.ArrayList;
import java.util.Collection;

import controller.UltraVisionManagementSystem;
import model.enums.AccessLevel;
import model.interfaces.TitleType;
import model.titles.BoxSet;
import model.titles.Movie;
import model.titles.MusicOrLive;
import model.titles.Title;

public class MembershipCard implements TitleType {

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private int cardID;
	private int points;
	private int freeRents;
	private int password;
	private AccessLevel subscriptionEnum;
	private int subscriptionID;
	private int onGoingRents;

	private int accountID;

	/**
	 * DB download
	 * 
	 * @param customerid
	 * @param plan
	 * @param password
	 */
	public MembershipCard(int id, int password, int card_ongoing_rents, int freeRents, int points, int accountID,
			int subscriptionID) {
		this.cardID = id;
		this.password = password;
		this.onGoingRents = card_ongoing_rents;
		this.freeRents = freeRents;
		this.points = points;
		this.accountID = accountID;
		this.subscriptionID = subscriptionID;

	}

	public MembershipCard(AccessLevel planEnum) {
		this.setTitleTypeGUI(planEnum);
		this.points = 0;
		this.onGoingRents = 0;
		this.freeRents = 0;
	}

	public MembershipCard() {
		this.cardID = 0;
	}
	
	public int rentTitle(MusicOrLive rentingTitle){
		return managementSystem.rentTitle(rentingTitle, this);
	}
	
	public int rentTitle(Movie rentingTitle){
		return managementSystem.rentTitle(rentingTitle, this);
	}
	
	public int rentTitle(BoxSet rentingTitle){
		return managementSystem.rentTitle(rentingTitle, this);
	}

	/**
	 * @param returningTitle the title to return
	 */
	public int returnRent(MusicOrLive returningTitle) {
		returningTitle.setAvailable(1);
		return managementSystem.returnTitle(returningTitle);
	}
	
	/**
	 * @param returningTitle the title to return
	 */
	public int returnRent(Movie returningTitle) {
		returningTitle.setAvailable(1);
		return managementSystem.returnTitle(returningTitle);
	}
	
	/**
	 * @param returningTitle the title to return
	 */
	public int returnRent(BoxSet returningTitle) {
		returningTitle.setAvailable(1);
		return managementSystem.returnTitle(returningTitle);
	}

	/**
	 * @return the id
	 */
	public int getCardID() {
		return cardID;
	}

	/**
	 * @param id the id to set
	 */
	public void setCardID(int id) {
		this.cardID = id;
	}

	/**
	 * @return number of available free rents
	 */
	public int hasFreeRents() {
		int hasFreeRents = 0;
		hasFreeRents = freeRents > 0 ? 1 : 0;
		return hasFreeRents;
	}

	/**
	 * @param rentintTitle title to rent for free
	 * @return 0 if has no free rents / 1 if has free rents & < 4 ongoing rents / 2 if > 4 ongoing rents. 
	 */
	public int hasFreeRentsAndIsLessThan4Check() {

		int hasFreeRent = hasFreeRents(); // check if customer has freeRent to claim

		switch (hasFreeRent) {
		case 0: // has no free rents to claim
			return hasFreeRent;
		case 1:// has free rents to claim
			
			int isLessThanFour = checkRentingLimit();
			
			if (isLessThanFour == 0) {//has 4 ongoing rents
				hasFreeRent = 2;
			}
			break;
		}
		return hasFreeRent;//return 1 or 2
	}

	/**
	 * @return true if renting less than 4
	 */
	public int checkRentingLimit() {

		int isLessThanFour;
		isLessThanFour = onGoingRents < 4 ? 1 : 0;

		return isLessThanFour;
	}

	/**
	 * @return card points
	 */
	public int getPoints() {
		return this.points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints() {
		this.points += 10;

		if (this.points >= 100) {
			updateFreeRents();
		}
	}

	/**
	 * updates free rents whenever points reaches 100
	 */
	private void updateFreeRents() {
		this.freeRents += 1;
		this.points -= 100;
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
	public void setPassword(int pass) {
		this.password = pass;
	}

	@Override
	public void setTitleTypeGUI(AccessLevel titleClassification) {// here gets the card subscriptionID

		AccessLevel values[] = AccessLevel.values();// get instance of all subscription plans
		for (AccessLevel value : values) {// go one by one

			if (value.name().equals(titleClassification.name())) {// if name equals the one received
				// then get the subscriptionID to know what is able to rent. eg: VL = 2 > movie
				this.subscriptionEnum = titleClassification;
				this.subscriptionID = titleClassification.getSubscriptionID();
				break;
			}
		}
	}

	public int payWithPoints() {
		int flag = 0;
		
		if (this.freeRents > 0) {
			this.freeRents -= 1;
			flag = 1;
			
		}
		
		return flag;
	}
	
	public int payByCash(double price) {
		
		
		return 1;
	}

//	public void setCardPlan(AccessLevel plan) {//here gets the subs classification
//		AccessLevel values[] = AccessLevel.values();// get instance of all subscription plans
//		for (AccessLevel value : values) {// go one by one
//
//			if (value.name().equals(plan.name())) {
//				this.subscriptionEnum = plan;
//				break;
//			}
//		}
//	}

	@Override
	public void setTitleTypeDB(int titleType) {
		this.subscriptionID = titleType;
	}

	@Override
	public String getTitleTypeGUI() {
		return subscriptionEnum.name();
	}

	/**
	 * @return subscriptionID
	 */
	@Override
	public int getTitleTypeDB() {
		return subscriptionID;
	}

	/**
	 * @return the accountID
	 */
	public int getAccountID() {
		return accountID;
	}

	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public int getOngoingRents() {
		return onGoingRents;
	}
	
	public int getFreeRents() {
		return freeRents;
	}
	
	/**
	 * @param onGoingRents the onGoingRents to set
	 */
	public void setOngoingRents() {
		this.onGoingRents += 1;
	}
}
