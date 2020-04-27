package view;

public interface TitleType {
	/**
	 * set which plan can access this title
	 */
	public abstract void setTitleType(SubscriptionPlan accessLevel);
	
	/**
	 * get the Access Level of title
	 */
	public abstract String getTitleType();
}
