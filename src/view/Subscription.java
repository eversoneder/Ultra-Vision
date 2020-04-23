package view;

public interface Subscription {

	/**
	 * the subscription of card to set
	 */
	public abstract void setSubscription(Level subscription);
	
	/**
	 * get the subscription of card
	 */
	public abstract Level getSubscription();
}
