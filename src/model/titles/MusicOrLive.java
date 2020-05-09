package model.titles;

import java.util.ArrayList;
import java.util.Collection;

import model.enums.AccessLevel;
import model.enums.Media;

public class MusicOrLive extends Title {

	private int musicOrLiveID;

	private String singer;
	private String band;
	private int isLiveConcert;
	private int subscriptionplan;

	private ArrayList<MusicOrLive> mlTitles;

	public MusicOrLive() {

	}

	/**
	 * New music by user
	 * 
	 * @param name
	 * @param price
	 * @param format
	 * @param band
	 * @param genre
	 * @param yor
	 * @param available
	 */
	public MusicOrLive(int type, Media format, String name, double price, String genre, int yor,
			String singer, String band, int plan) {
		// title attributes
		super.setTitleTypeDB(type);
		super.setDiscFormatDB(format.getDiscFormatID());
		super.setAvailable(1);
		super.setName(name);
		super.setPrice(price);
		super.setGenre(genre);
		super.setYearOfRelease(yor);
		// music/live concert attributes
		this.setSinger(singer);
		this.setBand(band);
		this.setSubscriptionPlan(plan);
		
	}

	/**
	 * Load titles from database
	 * 
	 * @param titleID
	 * @param name
	 * @param price
	 * @param format
	 * @param band
	 * @param genre
	 * @param yor
	 * @param available
	 */
	public MusicOrLive(int titleID, int MusicOrLiveID,int type, int format, int available, String name, double price, String genre, int yor,
			String singer, String band, int plan) {
		// title attributes
		super.setId(titleID);
		super.setTitleTypeDB(type);
		super.setDiscFormatDB(format);
		super.setAvailable(available);
		super.setName(name);
		super.setPrice(price);
		super.setGenre(genre);
		super.setYearOfRelease(yor);
		// music/live concert attributes
		this.setMusicOrLiveID(MusicOrLiveID);
		this.setSinger(singer);
		this.setBand(band);
		this.setSubscriptionPlan(plan);
	}

	/**
	 * @return the mlTitles
	 */
	public ArrayList<MusicOrLive> getMLTitles() {
		return mlTitles;
	}
	
	/**
	 * @return the subscriptionplan
	 */
	public int getSubscriptionplan() {
		return subscriptionplan;
	}

	/**
	 * @param subscriptionplan the subscriptionplan to set
	 */
	public void setSubscriptionPlan(int subscriptionplan) {
		this.subscriptionplan = subscriptionplan;
	}

	/**
	 * @param mlTitles the mlTitles to set
	 */
	public void setMLTitles(ArrayList<MusicOrLive> mlTitles) {
		this.mlTitles = new ArrayList<>(mlTitles);
	}

	public void addNewTitle(MusicOrLive ml) {
		this.mlTitles.add(ml);
	}

	/**
	 * @return the band String
	 */
	public String getBand() {
		return band;
	}

	/**
	 * @param band the band to set String
	 */
	public void setBand(String band) {
		this.band = band;
	}

	/**
	 * @return singer String
	 */
	public String getSinger() {
		return singer;
	}

	/**
	 * @param singer to set String
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
	 * @param isLiveConcert the isLiveConcert to set int
	 */
	public void setIsLiveConcert(int isLiveConcert) {
		this.isLiveConcert = isLiveConcert;
	}
	
	/**
	 * @return the musicOrLiveID
	 */
	public int getMusicOrLiveID() {
		return musicOrLiveID;
	}

	/**
	 * @param musicOrLiveID the musicOrLiveID to set int
	 */
	public void setMusicOrLiveID(int musicOrLiveID) {
		this.musicOrLiveID = musicOrLiveID;
	}
}
