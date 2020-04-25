package view.customer;

/**
 * Abstract class for each customer to extends
 */
public abstract class DebitOrCreditAccount {

	private int AccountNumber;
	private double AccountBalance;

	/**
	 * @param quantity to subtract
	 */
	public void setTransaction(double quantity) {
		this.AccountBalance -= quantity;
	}

	/**
	 * @param amount to set
	 */
	public void setAccountBalance(double amount) {
		this.AccountBalance = amount;
	}

	/**
	 * @param hasThisAmount the amount to check in balance
	 * @return if contains passed value in balance
	 */
	public boolean checkBalance(double hasThisAmount) {
		boolean hasMoney;
		hasMoney = AccountBalance > hasThisAmount ? true : false;
		return hasMoney;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return AccountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
}
