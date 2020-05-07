package model.enums;

public enum AccessLevel {
	ML("Music1,Live Concert2", "1"), 
	VL("Movie3", "2"), 
	TV("Box Set4", "3"),
	PR("Premium", "4");
	
	private String titleNameAndID;
	private String subscriptionID;

	/**
	 * database handling
	 * 
	 * @param titleNameAndID 
	 * @param subscriptionID
	 */
	private AccessLevel(String titleNameAndID, String subscriptionID) {
		this.titleNameAndID = titleNameAndID;
		this.subscriptionID = subscriptionID;
	}

	/**
	 * @return title name
	 */
	public String getSubscriptionID() {
		return this.titleNameAndID;
	}

	/**
	 * @return database entity name
	 */
	public String getTitleNameAndID() {
		return this.subscriptionID;
	}
}
