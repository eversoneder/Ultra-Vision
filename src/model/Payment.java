package model;

import model.customer.Customer;
import model.titles.Title;

public class Payment {

	private int payment_id;
	private double payment_amount;
	
	private Customer customer;
	private Rent rent;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param titlePrice   the title price
	 * @param rentingTitle the title to be rented
	 * @return true if both statements are met (hasMoney && rentingList < 4)
	 */
	public boolean makePayment(double titlePrice, Title rentingTitle) {
		customer.setTransaction(titlePrice);
//		recordRent(rentingTitle);
		return true;
	}
}
