package model.customer;

/**
 * Abstract class for each customer to extends
 */
public abstract class DebitOrCreditAccount {

	private int accountID;
	private String AccountNumber;
	private double AccountBalance;

	/**
	 * @return the id
	 */
	public int getAccountID() {
		return accountID;
	}

	/**
	 * @param id the id to set
	 */
	public void setAccountID(int id) {
		this.accountID = id;
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
	 * @param amount the amount to check in balance
	 * @return if contains passed value in balance
	 */
	public boolean hasMoney(double amount) {
		return AccountBalance > amount ? true : false;
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
	public boolean checkFunds(double titlePrice) {
		
		boolean hasMoney = false; 
		
		if(this.getAccountBalance() >= titlePrice) {
			hasMoney = true;
		}
		
		return hasMoney;
	}
}
