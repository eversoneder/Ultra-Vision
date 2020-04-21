package view;

public enum AccessLevel {

		MUSICLOVER("ML"),
		MUSICVIDEO("ML"),
		VIDEOLOVER("VL"),
		TVLOVER("TV"),
		PREMIUM("PR");
	
	private String level;
	
	public String getLevel() {
		return this.level;
	}
	
	private AccessLevel(String level){
		this.level = level;
	}
}
