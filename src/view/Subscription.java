package view;

public interface Subscription {

	/**
	 * the subscription of card to set
	 */
	public abstract void setSubscription(SubscriptionPlan plan);
	
	/**
	 * get the subscription of card
	 */
	public abstract SubscriptionPlan getSubscription();
}
