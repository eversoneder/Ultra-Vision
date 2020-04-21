package view.customer;

public class Customer {

	private int customer_id;
	private String customer_name;
	private int customer_phone;
	private String customer_address;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return customer_name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.customer_name = name;
	}

	/**
	 * @return the phone
	 */
	public int getPhone() {
		return customer_phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.customer_phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return customer_address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.customer_address = address;
	}
	
	

}
