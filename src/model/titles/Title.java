package model.titles;

import java.util.Collection;

import model.enums.AccessLevel;
import model.enums.Media;
import model.interfaces.DiscFormat;
import model.interfaces.TitleType;

public class Title implements DiscFormat, TitleType {

	// general title attributes
	private int id;
	private String titleTypeName;
	private int titleTypeID;
	private String discFormat;
	private int discFormatID;
	private int available;
	private String name;
	private double price;
	private String genre;
	private int yearOfRelease;
	private int subscriptionPlan;

	private Collection<Title> titleList;

	private MusicOrLive ml;
	private Movie vl;

	/**
	 * Constructor for New title by user
	 * 
	 * @param titleType  to set
	 * @param discFormat to set
	 * @param available  to set
	 * @param name       to set
	 * @param price      to set
	 * @param genre      to set
	 * @param yor        to set
	 */
	public Title(int titleType, int discFormat, int available, String name, double price, String genre, int yor) {
		this.setTitleTypeDB(titleType);
		this.setDiscFormatDB(discFormat);
		this.available = available;
		this.name = name;
		this.price = price;
		this.genre = genre;
		this.yearOfRelease = yor;
	}

	/**
	 * Constructor for database load titles
	 * 
	 * @param id
	 * @param titleType
	 * @param discFormat
	 * @param available
	 * @param name
	 * @param price
	 * @param genre
	 * @param yor
	 */
	public Title(int id, int titleType, int discFormat, int available, String name, double price, String genre,
			int yor) {
		this.id = id;
		this.setTitleTypeDB(titleType);
		this.setDiscFormatDB(discFormat);
		this.available = available;
		this.name = name;
		this.price = price;
		this.genre = genre;
		this.yearOfRelease = yor;
	}

//	public static void main(String[] args) {
//		Title a = new Title(3);
//		System.out.println(a);
//	}

	public Title() {
//		this.setTitleTypeDB(3);
	}

	@Override
	public String getTitleTypeGUI() {
		return this.titleTypeName;
	}

	@Override
	public void setTitleTypeGUI(AccessLevel titleClassification) {

		String classificationName = null;

		// split in case it is "ML" which has 2 accesses, music & live concert.
		String types[] = titleClassification.getTitleNameAndID().split(",");
		for (String type : types) {

			for (char ch : type.toCharArray()) {// char by char checking for enum(id)
				if (Character.isDigit(ch)) {// if char is number (id)
					int n = Integer.parseInt(Character.toString(ch));// parses to int
					this.titleTypeID = n;// then I know also the enum.name()
				}
				classificationName += ch;// get letters together without id
			}
		}
		this.titleTypeName = classificationName;
	}

	/**
	 * @param AccessLevel.name() to get it's ID
	 * @return title type ID
	 */
	public int getTitleTypeDB(AccessLevel titleClassification) {

		String classificationName = "";

		// split in case it is "ML" which has 2 accesses, music & live concert.
		String types[] = titleClassification.getTitleNameAndID().split(",");
		for (String type : types) {

			for (char ch : type.toCharArray()) {// char by char checking for enum(id)
				if (Character.isDigit(ch)) {// if char is number (id)
					int n = Integer.parseInt(Character.toString(ch));// parses to int
					this.titleTypeID = n;// get titleTypeID
					this.titleTypeName = classificationName;
					break;
				} else {
					classificationName += ch;
				}
			}
			classificationName = "";// in case the line has 2 types (ML)
		}
		return titleTypeID;
	}

	@Override
	public int getTitleTypeDB() {
		return titleTypeID;
	}

	@Override
	public void setTitleTypeDB(int titleID) {

		AccessLevel[] titleNamesAndIds = AccessLevel.values();

		for (AccessLevel titleNameAndId : titleNamesAndIds) {

			String types[] = titleNameAndId.getTitleNameAndID().split(",");
			for (String type : types) {

				String classificationName = "";
				for (char ch : type.toCharArray()) {// char by char checking for enum(id)
					if (Character.isDigit(ch)) {// if char is number (id)

						int n = Integer.parseInt(Character.toString(ch));// parses to int
						if (titleID == n) {
							this.titleTypeID = n;// get titleTypeID
							this.titleTypeName = classificationName;
							return;
						}
						
					} else {
						classificationName += ch;
					}
				}
			}
		}
		this.titleTypeID = titleID;
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
	 * @return the title name
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
	 * @return double the price
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
	public void setDiscFormatGUI(Media format) {
		this.discFormat = format.name();
		this.discFormatID = format.getDiscFormatID();
	}

	/**
	 * Documentation of this method won't appear on hover over? check super
	 * implementation please
	 */
	@Override
	public void setDiscFormatDB(int discFormat) {
		Media[] discFormats = Media.values();
		for (Media i : discFormats) {
			if (i.getDiscFormatID() == discFormat) {
				this.discFormatID = discFormat;
				this.discFormat = i.name();
			}
		}
	}

	@Override
	public String getDiscFormatGUI() {
		return discFormat;
	}

	@Override
	public int getDiscFormatDB() {
		return discFormatID;
	}

	/**
	 * @return int the title availability
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
	 * @return the String title genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the title genre to set (String)
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return int the title year of release
	 */
	public int getYearOfRelease() {
		return yearOfRelease;
	}

	/**
	 * 
	 * @param yor the title year of release to set (int)
	 */
	public void setYearOfRelease(int yor) {
		this.yearOfRelease = yor;
	}

	@Override
	public String toString() {
		return "Title name: " + this.name + "\n Title price: " + this.price + " Title type: " + this.titleTypeName
				+ ".";
	}
}
