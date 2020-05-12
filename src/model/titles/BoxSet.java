package model.titles;

import java.util.ArrayList;
import java.util.Collection;

import model.enums.AccessLevel;
import model.enums.Media;

public class BoxSet extends Title {

	private int boxSetID;
	private int numOfDiscs;
	
	private ArrayList<BoxSet> movies;
	
	public BoxSet() {
		super.setId(0);
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
	public BoxSet(int titleType, Media discFormat, int available, String name, double price, int yor,
			int numofdiscs, String genre, int plan) {
		super.setTitleTypeDB(titleType);
		super.setDiscFormatDB(discFormat.getDiscFormatID());
		super.setAvailable(available);
		super.setName(name);
		super.setPrice(price);
		super.setYearOfRelease(yor);
		super.setGenre(genre);
		super.setSubscriptionID(plan);
		
		this.setNumOfDiscs(numofdiscs);
	}

	/**
	 * database download
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
	public BoxSet(int id, int boxSetID, int titleType, int discFormat, int available, String name, double price,
			int yor, int numofdiscs, String genre, int plan) {
		super.setId(id);
		super.setTitleTypeDB(titleType);
		super.setDiscFormatDB(discFormat);
		super.setAvailable(available);
		super.setName(name);
		super.setPrice(price);
		super.setYearOfRelease(yor);
		super.setGenre(genre);
		super.setSubscriptionID(plan);

		this.setBoxSetID(boxSetID);
		this.setNumOfDiscs(numofdiscs);
	}
	
	/**
	 * @return the vlTitles
	 */
	public ArrayList<BoxSet> getVLTitles() {
		return movies;
	}

	/**
	 * @param vlTitles the vlTitles to set
	 */
	public void setVLTitles(ArrayList<BoxSet> vlTitles) {
		this.movies = new ArrayList<>(vlTitles);
	}

	/**
	 * @return the numOfDiscs
	 */
	public int getNumOfDiscs() {
		return numOfDiscs;
	}

	/**
	 * @param numOfDiscs the numOfDiscs to set
	 */
	public void setNumOfDiscs(int numOfDiscs) {
		this.numOfDiscs = numOfDiscs;
	}
	/**
	 * @return the boxSetID
	 */
	public int getBoxSetID() {
		return boxSetID;
	}

	/**
	 * @param boxSetID the boxSetID to set
	 */
	public void setBoxSetID(int boxSetID) {
		this.boxSetID = boxSetID;
	}
}
