package model.enums;

public enum AccessLevel {
	ML("Music1,Live Concert2", 1), 
	VL("Movie3", 2), 
	TV("Box Set4", 3),
	PR("Premium", 4);
	
	private String titleNameAndID;
	private int subscriptionID;

	/**
	 * database handling
	 * 
	 * @param titleNameAndID 
	 * @param subscriptionID
	 */
	private AccessLevel(String titleNameAndID, int subscriptionID) {
		this.titleNameAndID = titleNameAndID;
		this.subscriptionID = subscriptionID;
	}

	/**
	 * @return int subscriptionID
	 */
	public int getSubscriptionID() {
		return this.subscriptionID;
	}

	/**
	 * @return String Title name and TitleID
	 */
	public String getTitleNameAndID() {
		return this.titleNameAndID;
	}
}
