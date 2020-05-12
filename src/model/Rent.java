package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import model.customer.Customer;
import model.customer.MembershipCard;
import model.enums.Media;
import model.titles.BoxSet;
import model.titles.Movie;
import model.titles.MusicOrLive;
import model.titles.Title;

public final class Rent extends TimeDate{

	private int rentID;
	private double rentPrice;
	private int cardID;
	private int titleID;

	public Rent(int id) {
		this.rentID = id;
	}
	
	/**
	 * download rent from DB
	 * 
	 * @param rentID to set
	 * @param startDate to set
	 * @param returnDate to set
	 * @param totalPrice to set
	 * @param cardID to set
	 * @param titleID to set
	 * @throws ParseException 
	 */
	public Rent (int rentID, String startDate, String returnDate, double rentPrice, int cardID, int titleID) throws ParseException {
		this.rentID = rentID;
		super.setStartDate(startDate);
		super.setReturnDate(returnDate);
		this.rentPrice = rentPrice;
		this.cardID = cardID;
		this.titleID = titleID;
	}
	
	/**
	 * adding new Rent by cash
	 *  
	 * @param startDate to set
	 * @param returnDate to set
	 * @param rentPrice to set
	 * @param cardID to set
	 * @param titleID to set
	 * @throws ParseException
	 */
	public Rent (double rentPrice, int cardID, int titleID) throws ParseException {//pay by cash
		super.setNowDate();
		this.rentPrice = rentPrice;
		this.cardID = cardID;
		this.titleID = titleID;
	}
	
	/**
	 * adding new Rent by points
	 *  
	 * @param startDate to set
	 * @param returnDate to set
	 * @param rentPrice to set
	 * @param cardID to set
	 * @param titleID to set
	 * @throws ParseException
	 */
	public Rent (int cardID, int titleID) throws ParseException {//pay by points
		super.setNowDate();
		this.cardID = cardID;
		this.titleID = titleID;
	}
	
	public Rent() {
	}
	
	/**
	 * @return the rentID
	 */
	public int getRentID() {
		return rentID;
	}
	
	/**
	 * @param rentID to set
	 */
	public void setRentID(int rentID) {
		this.rentID = rentID;
	}
	
	/**
	 * @param rentPrice to set
	 */
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	/**
	 * @return the rentPrice
	 */
	public double getRentPrice() {
		return rentPrice;
	}

	/**
	 * @return the cardID
	 */
	public int getCardID() {
		return cardID;
	}

	/**
	 * @param cardID the cardID to set
	 */
	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	/**
	 * @param titleID the titleID to set
	 */
	public void setTitleID(int titleID) {
		this.titleID = titleID;
	}
	
	/**
	 * @return the titleID
	 */
	public int getTitleID() {
		return titleID;
	}
}
