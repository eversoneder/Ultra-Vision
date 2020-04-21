package view;

public class Title {

	private Title title;
	
	private int title_id;
	private String title_name;
	private DiscFormat title_format;
	private double title_price;
	private boolean title_available;
	private int title_yor;
	private String title_genre;
	private String title_director;
	private String title_band;
	
	private String title_accessLevel;
	
	public Title() {
		
	}
	
	public Title(int id, String name, double price) {
		
		this.title_id = id;
		this.title_name = name;
		this.title_available = true;
		this.title_format.name();
	}

	/**
	 * @return DiscFormat 
	 */
	public DiscFormat getFormat() {
		return this.title_format;
	}
	
	/**
	 * @param format of disc
	 */
	public void setFormat(DiscFormat format) {
		this.title_format = format;
	}
	
	/**
	 * @return the accessLevel
	 */
	public String getAccessLevel() {
		return title_accessLevel;
	}
	
	/**
	 * @param title_accessLevel the accessLevel to set
	 */
	public void setAccessLevel(AccessLevel access) {
//		level = AccessLevel.values();
		
		this.title_accessLevel = access.getLevel();
	}
	
	public void setAccessLevel(String accessLevel) {
		this.title_accessLevel = accessLevel;
	}
	
	/**
	 * @param name of title to find
	 * @return Title
	 */
	public Title getTitle(String name) {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(Title title) {
		this.title = title;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return title_name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.title_name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return title_price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.title_price = price;
	}

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return title_available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.title_available = available;
	}

	/**
	 * @param format the format to set
	 */
}
