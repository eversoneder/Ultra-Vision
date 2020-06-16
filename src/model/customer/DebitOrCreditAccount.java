package model.customer;

public class DebitOrCreditAccount {

	private int accountID;
	private String AccountNumber;
	private double AccountBalance;
	private int customerID;

	/**
	 * DB download
	 * 
	 * @param accountID to set
	 * @param accountNum to set
	 * @param accBalance to set
	 * @param custID to set
	 */
	public DebitOrCreditAccount(int accountID, String accountNum, double accBalance, int custID) {
		this.accountID = accountID;
		this.AccountNumber = accountNum;
		this.AccountBalance = accBalance;
		this.customerID = custID;
	}
	
	/**
	 * GUI interaction 
	 * 
	 * @param accountNum to set
	 * @param accBalance to set
	 * @param custID to set
	 */
	public DebitOrCreditAccount(String accountNum, double accBalance, int custID) {
		this.AccountNumber = accountNum;
		this.AccountBalance = accBalance;
		this.customerID = custID;
	}
	
	public DebitOrCreditAccount() {
		
	}
	
	/**
	 * @param id the id to set
	 */
	public void setAccountID(int id) {
		this.accountID = id;
	}

	/**
	 * @return the id
	 */
	public int getAccountID() {
		return accountID;
	}
	
	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * @param quantity to subtract
	 */
	public void setPayment(double quantity) {
		this.AccountBalance -= quantity;
	}

	/**
	 * @return account balance amount
	 */
	public double getAccountBalance() {
		return AccountBalance;
	}

	/**
	 * @param amount to set
	 */
	public void setAccountBalance(double amount) {
		this.AccountBalance = amount;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return AccountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	
	/**
	 * @param titlePrice price to check in balance
	 * @return true if balance contains title price money
	 */
	public boolean hasMoney(double titlePrice) {
		return AccountBalance >= titlePrice ? true : false;
	}
}
