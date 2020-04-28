package model.titles;

import java.util.ArrayList;
import java.util.Collection;

import model.enums.AccessLevel;
import model.enums.Media;

public class BoxSet extends Title {

	private String director;

	public BoxSet() {

	}

	/**
	 * Constructor to new Title from User
	 * 
	 * @param titleType
	 * @param discFormat
	 * @param available
	 * @param name
	 * @param price
	 * @param genre
	 * @param yor
	 * @param director
	 */
	public BoxSet(int titleType, int discFormat, int available, String name, double price, String genre, int yor,
			String director) {
		super.setTitleTypeDB(titleType);
		super.setDiscFormatDB(discFormat);
		super.setAvailable(available);
		super.setName(name);
		super.setPrice(price);
		super.setGenre(genre);
		super.setYearOfRelease(yor);

		this.setDirector(director);
	}

	/**
	 * database load
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
	public BoxSet(int id, int titleType, int discFormat, int available, String name, double price, String genre,
			int yor, String director) {
		super.setId(id);
		super.setTitleTypeDB(titleType);
		super.setDiscFormatDB(discFormat);
		super.setAvailable(available);
		super.setName(name);
		super.setPrice(price);
		super.setGenre(genre);
		super.setYearOfRelease(yor);

		this.setDirector(director);
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

}
