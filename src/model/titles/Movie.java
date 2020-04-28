package model.titles;

import java.util.ArrayList;
import java.util.Collection;

import model.enums.AccessLevel;
import model.enums.Media;

public class Movie extends Title {

	private String director;

	private Collection<Movie> movies;

	public Movie() {

	}

	/**
	 * Database load
	 * 
	 * @param type
	 * @param format
	 * @param available
	 * @param name
	 * @param price
	 * @param genre
	 * @param yor
	 * @param director
	 */
	public Movie(int type, Media format, int available, String name, double price, String genre, int yor,
			String director) {
		super.setTitleTypeDB(type);
		super.setDiscFormatDB(format.getDiscFormatID());
		super.setAvailable(available);
		super.setName(name);
		super.setPrice(price);
		super.setGenre(genre);
		super.setYearOfRelease(yor);

		this.setDirector(director);
	}

	/**
	 * Load titles from database
	 * 
	 * @param id        the id to set
	 * @param name      the name to set
	 * @param price     the price to set
	 * @param format    the format to set
	 * @param band      the band to set
	 * @param genre     the genre to set
	 * @param yor       the year of release to set
	 * @param available the available to set
	 */
	public Movie(int id, int type, int format, int available, String name, double price, String genre, int yor,
			String director) {
		super.setId(id);
		super.setTitleTypeDB(type);
		super.setDiscFormatDB(format);
		super.setAvailable(available);
		super.setName(name);
		super.setPrice(price);
		super.setGenre(genre);
		super.setYearOfRelease(yor);

		this.setDirector(director);
	}

	/**
	 * @return the vlTitles
	 */
	public Collection<Movie> getVLTitles() {
		return movies;
	}

	/**
	 * @param vlTitles the vlTitles to set
	 */
	public void setVLTitles(Collection<Movie> vlTitles) {
		this.movies = new ArrayList<>(vlTitles);
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
