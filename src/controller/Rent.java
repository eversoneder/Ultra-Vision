package controller;

import java.util.Date;

public class Rent {
	
	private Date StartDate;
	
	public Rent() {
		// TODO Auto-generated constructor stub
		System.out.println(setStartDate());
	}

	public static void main(String[]args) {
		new Rent();
	}
	
	/**
	 * @return startDate
	 */
	private Date setStartDate() {
		return StartDate = new Date();
	}
}
