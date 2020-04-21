package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import view.TimeDate;
import view.Title;

public class Rent {

	TimeDate td;
	private Date DateStart;
	private Date DateReturn;
	
	private Collection<Title> rentedTitle = new ArrayList<>();
	private double totalPrice;
	
	public Rent() {
		// TODO Auto-generated constructor stub
		
		setStartDate();
		System.out.println(DateStart.toString());
	}

	public static void main(String[]args) {
		new Rent();
	}
	
	/**
	 * @return double of total titles price 
	 */
	private double calculateTotalPrice() {
		for(Title t : rentedTitle) {
			totalPrice += t.getPrice();
		}
		return totalPrice;
	}
	
	public double getTotalprice(){
		return this.totalPrice;
	}
	
	public void addNewTitleRent(Title t) {
		rentedTitle.add(t);
	}

	/**
	 * @return the date of rent start 
	 */
	public Date getStartDate() {
		return this.DateStart;
	}
	
	/**
	 * @return startDate
	 */
	protected void setStartDate() {
		td = new TimeDate();
		this.DateStart = td.getNowDate();
		getReturnDate();
	}
	
	public Date getReturnDate() {
		this.DateReturn = td.getReturnDateOf(DateStart);
		return DateReturn;
	}
}
