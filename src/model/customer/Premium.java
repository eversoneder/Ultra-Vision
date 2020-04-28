package model.customer;

import java.util.ArrayList;
import java.util.Collection;

import model.titles.Title;

public class Premium extends Title {

	private String band;
	private String director;

	private Collection<Title> prTitleList;

	public Premium() {

	}

	public Premium(int id, String name, double price, String format, String accessLevel, int available, String band,
			String genre, String director, int yor) {
		super.setId(id);
		super.setName(name);
		super.setPrice(price);
//		super.setDiscFormat(format);
//		super.setTitleType(accessLevel);
		super.setAvailable(available);
		this.setBand(band);
		super.setGenre(genre);
		this.setDirector(director);
		super.setYearOfRelease(yor);

	}

	/**
	 * @return the Premium Title list
	 */
	public Collection<Title> getPrTitles() {
		return this.prTitleList;
	}

	/**
	 * @param prTitles the Premium Title to set
	 */
	public void setPrTitles(Collection<Title> prTitles) {
		this.prTitleList = new ArrayList<>(prTitles);
	}
	
	/**
	 * 
	 * @param title the title to add to premium list
	 */
	public void addNewPremiumTitle(Title title) {
		this.prTitleList.add(title);
	}

	/**
	 * @return the band
	 */
	public String getBand() {
		return band;
	}

	/**
	 * @param band the band to set
	 */
	public void setBand(String band) {
		this.band = band;
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
