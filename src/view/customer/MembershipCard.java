package view.customer;

public class MembershipCard extends DebitOrCreditAccount{

	private int points;
	private boolean hasFreeRent;
	private int freeRents;
	private int password;
	private String accessLevel;

	public void addPoints(int points) {
		this.points += points;
		setRentAllowed();
	}

	public boolean availFreeRent() {
		hasFreeRent = freeRents > 0 ? true : false;
		return this.hasFreeRent;
	}

	private void setRentAllowed() {
		int freeR = 0;
		freeR = points >= 100 ? freeR += 1 : 0;
		this.freeRents += freeR;
	}

	public int getPoints() {
		return this.points;
	}
	
	protected void setPassword(int pass) {
		this.password = pass;
	}
	
	public void setAccessLevel() {
		
	}
}
