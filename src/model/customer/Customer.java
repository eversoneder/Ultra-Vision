package model.customer;

import java.util.Random;

public class Customer extends DebitOrCreditAccount {

	private int id;
	private String name;
	private int phone;
	private String address;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * load customer from database
	 * 
	 * @param id
	 * @param name
	 * @param phone
	 * @param address
	 */
	public Customer(int id, String name, int phone, String address) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public Customer(String name, int phone, String address, Long accountNum) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		super.setAccountNumber(accountNum);
		
	}

	/**
	 * create new customer by user
	 * 
	 * @param name
	 * @param phone
	 * @param address
	 */
	public Customer(String name, int phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.setAccountBalance(5000.00);
		this.setAccountNumber(randomAccNumGenerator());
	}

	public static void main(String[] args) {

		Customer a = new Customer("everson",838431954,"mountjoy square");

		System.out.println(a.getCustomer_name());
		System.out.println(a.getCustomer_phone());
		System.out.println(a.getAccountNumber());
		System.out.println(a.getAccountBalance());
		System.out.println(a.getCustomer_address());
	}

	public static long randomAccNumGenerator() {

		int sortCode = 900017;// bank branch number

		// 8 digits account no. 9 digits -1 because it starts 0 to 999999999 < 8 digits
		// ---------------------\/-----------------generate starting at 9 digts 10000000
		// ---------------------\/-----------------\/>>>>>>>>>>>>>\/
		// ---------------------->>>>>>>>>>\/---------------------\/
		int randomAcc = new Random().nextInt(100000000 - 10000000) + 10000000;
		// ----------------------------------------------/\
		// subtract 10000000 because added 10000000 to generate as start point

		String newAcc = Integer.toString(sortCode) + Integer.toString(randomAcc);

		return Long.parseLong(newAcc);
	}

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
	public int getCustomer_phone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setCustomer_phone(int phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getCustomer_address() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setCustomer_address(String address) {
		this.address = address;
	}

}
