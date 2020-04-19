package view;

enum AccessLevel {

		MUSICLOVER("ML"),
		VIDEOLOVER("VL"),
		TVLOVER("TV"),
		PREMIUM("PR");
	
	private final String level;
	
	private AccessLevel(String level){
		this.level = level;
	}
	
	public String getLevel() {
		return this.level;
	}
}
