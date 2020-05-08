package model.titles;

import java.util.ArrayList;
import java.util.Collection;

import model.enums.AccessLevel;
import model.enums.Media;

public class Movie extends Title {

	private int movieID;
	private String director;
	private int subscriptionPlan;
	
	private ArrayList<Movie> movies;

	public Movie() {

	}

	/**
	 * Movie Creation from user (GUI)
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
			String director, int plan) {
		super.setTitleTypeDB(type);
		super.setDiscFormatDB(format.getDiscFormatID());
		super.setAvailable(available);
		super.setName(name);
		super.setPrice(price);
		super.setGenre(genre);
		super.setYearOfRelease(yor);

		this.setDirector(director);
		this.setSubscriptionPlan(plan);
	}

	/**
	 * Load titles from database
	 * 
	 * @param titleID        the id to set
	 * @param name      the name to set
	 * @param price     the price to set
	 * @param format    the format to set
	 * @param band      the band to set
	 * @param genre     the genre to set
	 * @param yor       the year of release to set
	 * @param available the available to set
	 */
	public Movie(int titleID, int movieID , int type, int format, int available, String name, double price, String genre, int yor,
			String director, int plan) {
		super.setId(titleID);
		super.setTitleTypeDB(type);
		super.setDiscFormatDB(format);
		super.setAvailable(available);
		super.setName(name);
		super.setPrice(price);
		super.setGenre(genre);
		super.setYearOfRelease(yor);
		
		this.setMovieID(movieID);
		this.setDirector(director);
		this.setSubscriptionPlan(plan);
	}

	/**
	 * @return the vlTitles
	 */
	public ArrayList<Movie> getVLTitles() {
		return movies;
	}

	/**
	 * @param vlTitles the vlTitles to set
	 */
	public void setVLTitles(ArrayList<Movie> vlTitles) {
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
	
	/**
	 * @return the subscriptionPlan
	 */
	public int getSubscriptionPlan() {
		return subscriptionPlan;
	}

	/**
	 * @param subscriptionPlan the subscriptionplan to set
	 */
	public void setSubscriptionPlan(int subscriptionPlan) {
		this.subscriptionPlan = subscriptionPlan;
	}
	
	/**
	 * @return the movieID
	 */
	public int getMovieID() {
		return movieID;
	}

	/**
	 * @param movieID the movieID to set
	 */
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
}
