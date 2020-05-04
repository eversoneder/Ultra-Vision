package model.interfaces;

import model.enums.AccessLevel;

public interface TitleType {
	
	/**
	 * @param titleClassification to set eg. movie(vl) or music(ml) (GUI Creating new Title)
	 */
	public abstract void setTitleTypeGUI(AccessLevel titleClassification);
	
	/**
	 * @param titleType to set from (DB load)
	 */
	public abstract void setTitleTypeDB(int titleType);
	
	/**
	 * @return String the title type (display GUI)
	 */
	public abstract String getTitleTypeGUI();
	
	/**
	 * @return int title type to upload to DB (title_type_id) in entity title
	 */
	public abstract int getTitleTypeDB();
}
