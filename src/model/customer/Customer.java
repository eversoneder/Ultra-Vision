package model.customer;

public class Customer extends DebitOrCreditAccount {

	private int id;
	private String name;
	private long phone;
	private String email;
	private int cardID;

	/**
	 * load customer from database
	 * 
	 * @param id      to load
	 * @param name    to load
	 * @param phone   to load
	 * @param address to load
	 */
	public Customer(int accID, String accNum, double accBalance, int custID, String name, long phone, String email) {
		super.setAccountID(accID);
		super.setAccountNumber(accNum);
		super.setAccountBalance(accBalance);
		this.id = custID;
		this.name = name;
		this.phone = phone;
		this.email = email;
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
		super.setAccountBalance(5000.00);
	}
	
	public Customer() {
		this.id = 0;
		
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
	
}
