package view.customer;

public class Customer extends DebitOrCreditAccount{

	private int id;
	private String name;
	private int phone;
	private String address;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, int phone, String address) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.setAccountBalance(5000.00);
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
