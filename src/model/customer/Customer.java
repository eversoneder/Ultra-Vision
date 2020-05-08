package model.customer;

import java.util.Random;

public class Customer extends DebitOrCreditAccount {

	private int id;
	private String name;
	private long phone;
	private String email;

	/**
	 * load customer from database
	 * 
	 * @param id      to load
	 * @param name    to load
	 * @param phone   to load
	 * @param address to load
	 */
	public Customer(int id, String name, long phone, String address, long accnumber, double balance) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = address;
		this.setAccountBalance(balance);
		this.setAccountNumber(accnumber);
	}

	/**
	 * create new customer by GUI
	 * 
	 * @param name
	 * @param phone
	 * @param address
	 */
	public Customer(String name, long phone, String address) {
		this.name = name;
		this.phone = phone;
		this.email = address;
		this.setAccountBalance(5000.00);
	}

//	public static long randomAccNumGenerator() {//not using
//
//		int sortCode = 900017;// bank branch number
//		int randomAcc = new Random().nextInt(100000000 - 10000000) + 10000000;
//
//		String newAcc = Integer.toString(sortCode) + Integer.toString(randomAcc);
//
//		return Long.parseLong(newAcc);
//	}

	/**
	 * @return the customer_id
	 */
	public int getCustomer_id() {
		return id;
	}

	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomer_id(int customer_id) {
		this.id = customer_id;
	}

	/**
	 * @return the name
	 */
	public String getCustomer_name() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setCustomer_name(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public long getCustomer_phone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setCustomer_phone(long phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param address the address to set
	 */
	public void setEmail(String address) {
		this.email = address;
	}
	
}
