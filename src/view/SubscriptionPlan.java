package view;

public enum SubscriptionPlan {
	ML("Music,Live Concert", "music_lover"), 
	VL("Movie", "video_lover"), 
	TV("Box Set", "tv_lover"),
	PR("Premium", "premium");

	private String className;
	private String entityName;

	/**
	 * database handling
	 * 
	 * @param className 
	 * @param entityName
	 */
	private SubscriptionPlan(String className, String entityName) {
		this.className = className;
		this.entityName = entityName;
	}

	/**
	 * @return class name
	 */
	public String getClassName() {
		return this.className;
	}

	/**
	 * @return database entity name
	 */
	public String getEntityName() {
		return this.entityName;
	}
}
