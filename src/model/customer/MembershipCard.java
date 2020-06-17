package model.customer;

import model.UltraVisionManagementSystem;
import model.enums.AccessLevel;
import model.interfaces.TitleType;

public class MembershipCard implements TitleType {

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private int cardID;
	private int points;
	private int freeRents;
	private int password;
	private AccessLevel subscriptionEnum;
	private int subscriptionID;

	private int onGoingRents;
	private String SubscriptionPlan;

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
		this.setSubsID(subscriptionID);

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

	public void setSubsID(int subsID) {
		
		switch(subsID) {
		case 1:
			this.subscriptionID = subsID;
			this.subscriptionEnum = AccessLevel.ML;
			break;
		case 2:
			this.subscriptionID = subsID;
			this.subscriptionEnum = AccessLevel.VL;
			break;
		case 3:
			this.subscriptionID = subsID;
			this.subscriptionEnum = AccessLevel.TV;
			break;
		case 4:
			this.subscriptionID = subsID;
			this.subscriptionEnum = AccessLevel.PR;
			 break;
		}
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
	 * @param rentintTitle title to rent for free
	 * @return 0 if has no free rents / 1 if has free rents
	 */
	public int hasFreeRents() {
		return freeRents;
	}

	/**
	 * @return true if renting less than 4
	 */
	public boolean hasLessThan4OngoingRents() {

		boolean canRentMore = onGoingRents < 4 ? true : false;

		return canRentMore;
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

		addOngoingRents();
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

	public void payWithPoints() {
		this.freeRents -= 1;
	}

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

	public void addOngoingRents() {
		this.onGoingRents += 1;
	}

	public void removeOngoingRents() {
		this.onGoingRents -= 1;
	}

	/**
	 * @return the subscriptionPlan
	 */
	public String getSubscriptionPlan() {
		return SubscriptionPlan;
	}

	/**
	 * @param subscriptionPlan the subscriptionPlan to set
	 */
	public void setSubscriptionPlan(String subscriptionPlan) {
		SubscriptionPlan = subscriptionPlan;
	}

	/**
	 * @param subscriptionID the subscriptionID to set
	 */
	public void setSubscriptionID(int subscriptionID) {
		this.subscriptionID = subscriptionID;
	}
}
