package view;

public class Title {

	private Title title;
	
	private String name;
	private String format;
	private int discQuantity;
	private double price;
	private boolean available;
	private String accessLevel;
	
	Title() {
		this.discQuantity = 1;
		this.available = true;
	}

	/**
	 * @param name of title to find
	 * @return Title
	 */
	public Title findTitle(String name) {
		
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
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * @return the accessLevel
	 */
	public String getAccessLevel() {
		return accessLevel;
	}

	/**
	 * @param accessLevel the accessLevel to set
	 */
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @param discQuantity the discQuantity to set
	 */
	public void setDiscQuantity(int discQuantity) {
		this.discQuantity = discQuantity;
	}

}
