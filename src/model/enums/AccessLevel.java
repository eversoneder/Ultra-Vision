package model.enums;

public enum AccessLevel {
	ML("Music1,Live Concert2", "music,live_concert"), 
	VL("Movie3", "movie"), 
	TV("Box Set4", "box_set"),
	PR("Premium", "premium");
	
	private String AccessClassification;
	private String entityName;

	/**
	 * database handling
	 * 
	 * @param titleName 
	 * @param entityName
	 */
	private AccessLevel(String titleName, String entityName) {
		this.AccessClassification = titleName;
		this.entityName = entityName;
	}

	/**
	 * @return title name
	 */
	public String getAccessClassification() {
		return this.AccessClassification;
	}

	/**
	 * @return database entity name
	 */
	public String getEntityName() {
		return this.entityName;
	}
}
