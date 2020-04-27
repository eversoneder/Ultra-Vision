package view.accesses;

import java.util.ArrayList;
import java.util.Collection;

import view.SubscriptionPlan;
import view.Media;
import view.Title;

public class BoxSet extends Title {

	private String director;
	private String band;
	private String singer;
	
	private Object[] boxSets;

	public BoxSet() {
		
	}
	
	public BoxSet(String name, double price, Media format, String director, String genre, int yor) {
		super.setName(name);
		super.setPrice(price);
		super.setDiscFormat(format);
		this.setDirector(director);
		super.setGenre(genre);
		super.setYearOfRelease(yor);
		super.setTitleType(SubscriptionPlan.TV.getClassName());
		super.setAvailable(1);
	}
	
	/**
	 * @return the tvTitles
	 */
	public Object[] getTvTitles() {
		return boxSets;
	}

	/**
	 * @param tvTitles the tvTitles to set
	 */
	public void setTvTitles(Object[] tvTitles) {
		this.boxSets = tvTitles;
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
	 * @return the singer
	 */
	public String getSinger() {
		return singer;
	}

	/**
	 * @param singer the singer to set
	 */
	public void setSinger(String singer) {
		this.singer = singer;
	}
}
