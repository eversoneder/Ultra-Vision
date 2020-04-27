package view;

import java.util.Collection;

import view.accesses.MusicLover;
import view.accesses.Movie;

public class Title implements DiscFormat, TitleType {

	// general title attributes
	private int id;
	private String titleType;
	private String name;
	private double price;
	private String discFormat;
	private int available;
	private String genre;
	private int yearOfRelease;

	private Collection<Title> titleList;
	
	private MusicLover ml;
	private Movie vl;

	public Title() {

	}

	public Title(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.available = 1;
	}

	/**
	 * DB load title
	 * 
	 * @param id          to set
	 * @param name        to set
	 * @param price       to set
	 * @param format      to set
	 * @param accessLevel to set
	 * @param available   to set
	 * @param band        to set
	 * @param genre       to set
	 * @param director    to set
	 * @param yor         to set
	 */
	public Title(int id, String name, double price, String format, String accessLevel, int available, String band,
			String genre, String director, int yor) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.discFormat = format;
		this.titleType = accessLevel;
		this.available = available;
		this.genre = genre;
		this.yearOfRelease = yor;

		if (accessLevel.equals("ML")) {
			ml.setBand(band);
			
		} else if (accessLevel.equals("VL")) {
			vl.setDirector(director);
		}
	}

	@Override
	public String getTitleType() {
		return this.titleType;
	}

	@Override
	public void setTitleType(SubscriptionPlan accessLevel) {
		this.titleType = accessLevel.name();
	}
	
	/**
	 * title type to set from database loading
	 */
	public void setTitleType(String type) {
		this.titleType = type;
	}

	/**
	 * @return title list
	 */
	public Collection<Title> getTitleList() {
		return titleList;
	}

	/**
	 * @param titleList
	 */
	public void setTitleList(Collection<Title> titleList) {
		this.titleList = titleList;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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

	@Override
	public String getDiscFormat() {
		return this.discFormat;
	}

	@Override
	public void setDiscFormat(Media format) {
		this.discFormat = format.name();
	}
	
	/**
	 * disc format to set (database load) 
	 */
	public void setDiscFormat(String format) {
		this.discFormat = format;
	}

	/**
	 * @return the title availability
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param available the title_available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * @return the title genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the title genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the title year of release
	 */
	public int getYearOfRelease() {
		return yearOfRelease;
	}

	/**
	 * @param yor the title year of release to set
	 */
	public void setYearOfRelease(int yor) {
		this.yearOfRelease = yor;
	}

	@Override
	public String toString() {
		return "Title name: " + this.name + "\n Title price: " + this.price + " Title type: " + this.titleType
				+ ".";
	}
}
