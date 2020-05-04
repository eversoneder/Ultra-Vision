package model.interfaces;

import model.enums.Media;

public interface DiscFormat {
	
	/**
	 * @param discFormat the type of disc to set (GUI Creating new Title)
	 */
	public abstract void setDiscFormatGUI(Media discFormat);
	
	/**
	 * @param title disc format to set from (DB Load)
	 */
	public abstract void setDiscFormatDB(int discFormat);
	
	/**
	 * @return String Disc Format (display to GUI)
	 */
	public abstract String getDiscFormatGUI();
	
	/**
	 * 
	 * @return int Disc format to upload to DB title>(disc_format_id)
	 */
	public abstract int getDiscFormatDB();
}
