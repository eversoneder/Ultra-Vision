package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import model.customer.MembershipCard;
import model.titles.Title;

final class Rent {

	private TimeDate td;
	private int rent_id;
	
	private Date rent_DateStart;
	private Date rent_DateReturn;

	private Collection<Title> rentingTitles = new ArrayList<>();
	private double rent_TotalPrice;

	protected Rent(Title title, MembershipCard mc) {
		// TODO Auto-generated constructor stub
		setrent_StartDate();
		System.out.println(rent_DateStart.toString());
	}
	
	protected Rent(int id) {
		this.rent_id = id;
	}

//	public static void main(String[] args) {
//		new Rent();
//	}

	protected void removeTitleRent(Title delT) {
		rentingTitles.remove(delT);
		removeFromTotalPrice(delT);
	}
	
	private void removeFromTotalPrice(Title delTprice) {
		this.rent_TotalPrice -= delTprice.getPrice();
	}

	/**
	 * @param title to add in renting list
	 */
	protected void addNewTitleRent(Title title) {
		rentingTitles.add(title);
		appendTotalPrice(title.getPrice());
	}
	
	/**
	 * @param price to add to total price
	 */
	private void appendTotalPrice(double priceToAppend) {
		this.rent_TotalPrice += priceToAppend;
	}
	
	/**
	 * @return the rent_id
	 */
	protected int getRent_id() {
		return rent_id;
	}

	/**
	 * @param rent_id the rent_id to set
	 */
	protected void setRent_id(int rent_id) {
		this.rent_id = rent_id;
	}

	protected double getrent_TotalPrice() {
		return this.rent_TotalPrice;
	}

	/**
	 * @return the date of rent start
	 */
	protected Date getrent_StartDate() {
		return this.rent_DateStart;
	}

	/**
	 * @param set now time to start renting
	 */
	protected void setrent_StartDate() {
		td = new TimeDate();
		this.rent_DateStart = td.getNowDate();
		this.rent_DateReturn = td.getReturnDateOf(rent_DateStart);
	}

	/**
	 * @return date of title return
	 */
	protected Date getrent_ReturnDate() {
		return this.rent_DateReturn;
	}
}
