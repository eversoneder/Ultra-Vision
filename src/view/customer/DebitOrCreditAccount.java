package view.customer;

/**
 * Abstract class for each customer to extends
 */
public abstract class DebitOrCreditAccount {

	private long AccountNumber;
	private double AccountBalance;

	/**
	 * @param quantity to subtract
	 */
	public void setTransaction(double quantity) {
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
	public long getAccountNumber() {
		return AccountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}
}
