package view.accesses;

import java.util.ArrayList;
import java.util.Collection;

import view.SubscriptionPlan;
import view.Media;
import view.Title;

public class MusicLover extends Title {

	private String singer;
	private String band;
	private int isLiveConcert;

	private Collection<MusicLover> mlTitles;

	public MusicLover() {

	}

	/**
	 * New titles by user
	 * 
	 * @param name
	 * @param price
	 * @param format
	 * @param band
	 * @param genre
	 * @param yor
	 * @param available
	 */
	public MusicLover(String type, String name, double price, Media format, String singer, String band, String genre, int yor,
			int available) {
		// title attributes
		super.setTitleType(type);
		super.setName(name);
		super.setPrice(price);
		super.setDiscFormat(format);
		super.setAvailable(available);
		super.setGenre(genre);
		super.setYearOfRelease(yor);
		// music/live concert attributes
		this.setSinger(singer);
		this.setBand(band);
		
	}

	/**
	 * Load titles from database
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param format
	 * @param band
	 * @param genre
	 * @param yor
	 * @param available
	 */
	public MusicLover(int id, String type, String name, double price, String format, int available, String genre,
			int yor, String singer, String band) {
		// title attributes
		super.setId(id);
		super.setTitleType(type);
		super.setName(name);
		super.setPrice(price);
		super.setDiscFormat(format);
		super.setAvailable(available);
		super.setGenre(genre);
		super.setYearOfRelease(yor);
		// music/live concert attributes
		this.setSinger(singer);
		this.setBand(band);
	}

	/**
	 * @return the mlTitles
	 */
	public Collection<MusicLover> getMLTitles() {
		return mlTitles;
	}

	/**
	 * @param mlTitles the mlTitles to set
	 */
	public void setMLTitles(Collection<MusicLover> mlTitles) {
		this.mlTitles = new ArrayList<>(mlTitles);
	}

	public void addNewTitle(MusicLover ml) {
		this.mlTitles.add(ml);
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
	 * @return singer
	 */
	public String getSinger() {
		return singer;
	}

	/**
	 * @param singer to set
	 */
	private void setSinger(String singer) {
		this.singer = singer;
	}

	/**
	 * @return the isLiveConcert
	 */
	public int getIsLiveConcert() {
		return isLiveConcert;
	}

	/**
	 * @param isLiveConcert the isLiveConcert to set
	 */
	public void setIsLiveConcert(int isLiveConcert) {
		this.isLiveConcert = isLiveConcert;
	}
}
