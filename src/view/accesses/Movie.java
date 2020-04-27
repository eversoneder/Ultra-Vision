package view.accesses;

import java.util.ArrayList;
import java.util.Collection;

import view.SubscriptionPlan;
import view.Media;
import view.Title;

public class Movie extends Title {

	private String director;

	private Collection<Movie> movies;

	public Movie() {

	}

	public Movie(String name, double price, Media format, String director, String genre, int yor) {
		super.setName(name);
		super.setPrice(price);
		super.setDiscFormat(format);
		this.setDirector(director);
		super.setGenre(genre);
		super.setYearOfRelease(yor);
		super.setTitleType(SubscriptionPlan.VL.getClassName());
		super.setAvailable(1);
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
	public Movie(int id, String name, double price, String format, String accessLevel, int available, String genre,
			String director, int yor) {
		super.setId(id);
		super.setName(name);
		super.setPrice(price);
		super.setDiscFormat(format);
		super.setTitleType(accessLevel);
		super.setAvailable(available);
		super.setGenre(genre);
		this.setDirector(director);
		super.setYearOfRelease(yor);
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
