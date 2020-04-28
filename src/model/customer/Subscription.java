package model.customer;

import model.enums.AccessLevel;

public interface Subscription {

	/**
	 * the subscription of card to set
	 */
	public abstract void setSubscription(AccessLevel plan);
	
	/**
	 * get the subscription of card
	 */
	public abstract AccessLevel getSubscription();
}
