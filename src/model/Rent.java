package model;

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

	private Customer customer;
	private MembershipCard membershipCard;

	private int rentID;
	private double totalPrice;
	private Date startDate;
	private Date returnDate;
	private int cardID;
	private int titleID;
	private String startDateString;
	private String returnDateString;

	/**
	 * @param titleID the titleID to set
	 */
	public void setTitleID(int titleID) {
		this.titleID = titleID;
	}

	private ArrayList<Object> rentingTitles = new ArrayList<>();
	
	public Rent(int id) {
		this.rentID = id;
	}
	
	public Rent (int rentID, String startDate, String returnDate, double totalPrice, int cardID, int titleID) {
		this.rentID = rentID;
		this.startDateString = startDate;
		this.returnDateString = returnDate;
		this.totalPrice = totalPrice;
		this.cardID = cardID;
		this.titleID = titleID;
	}
	
	public Rent() {
	}
	
	/**
	 * @param title
	 * @return
	 */
	public void setNewRent(ArrayList<Object> titles) {

		MusicOrLive mu = new MusicOrLive();
		Movie mo = new Movie();
		BoxSet bs = new BoxSet();
		
		totalPrice = 0;
		
		for(Object obj : titles) {
			
			switch(obj.getClass().getName()) {
			case "model.titles.MusicOrLive":
				mu = (MusicOrLive) obj;
				totalPrice += mu.getPrice();
				break;
			case "model.titles.Movie":
				mo = (Movie) obj;
				totalPrice += mo.getPrice();
				break;
			case "model.titles.BoxSet":
				bs = (BoxSet) obj;
				totalPrice += bs.getPrice();
				break;
			}
			System.out.println(totalPrice);
		}
		
//		boolean hasMoney = checkFunds(title.getPrice());

//		if (hasMoney) {
//			hasMoney = rentingList.size() < 4 ? makePayment(title.getPrice(), title) : rentingLimit();
//			return hasMoney;
//		} else {
//			System.out.println("No sufficient money in account.");
//		}
//		return false;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the membershipCard
	 */
	public MembershipCard getMembershipCard() {
		return membershipCard;
	}

	/**
	 * @param membershipCard the membershipCard to set
	 */
	public void setMembershipCard(MembershipCard membershipCard) {
		this.membershipCard = membershipCard;
	}

	private void removeFromTotalPrice(double price) {
		this.totalPrice -= price;
	}
	
	/**
	 * @param price to add to total price
	 */
	private void appendTotalPrice(double priceToAppend) {
		this.totalPrice += priceToAppend;
	}

	/**
	 * @param title to add in renting list
	 */
	public void addNewTitleRent(Title title) {
		rentingTitles.add(title);
		appendTotalPrice(title.getPrice());
	}
	
	/**
	 * @return the rentID
	 */
	public int getRentID() {
		return rentID;
	}
	
	/**
	 * @param rentID to set int
	 */
	public void setRentID(int rentID) {
		this.rentID = rentID;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * @return the date of rent start
	 */
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * @param set now time to start renting
	 */
	public Date setStartDate() {
		
		this.startDate = super.getNowDate();
		this.returnDate = super.getReturnDateOf(startDate);
		
		return startDate;
	}

	/**
	 * @return date of title return
	 */
	public Date getReturnDate() {
		return this.returnDate;
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
	 * @return the titleID
	 */
	public int getTitleID() {
		return titleID;
	}
}
