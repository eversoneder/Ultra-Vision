package view;

public enum Level {
	ML("MusicLover","music_lover"),
	VL("VideoLover","video_lover"),
	TV("TvLover","tv_lover"),
	PR("Premium","premium");
	
	private String className;
	private String entityName;
	
	private Level(String className, String entityName) {
		this.className = className;
		this.entityName = entityName;
	}
	
	/**
	 * @return class name
	 */
	public String getClassName() {
		return this.entityName;
	}
	
	/**
	 * @return database entity name 
	 */
	public String getEntityName() {
		return this.className;
	}
}
