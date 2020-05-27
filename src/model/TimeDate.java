package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeDate {

	private Date startDate;
	private Date returnDate;
	private String startDateString;
	private String returnDateString;

	/**
	 * @hourFormat the format of hours, mins, day, month and year to show (hh:mm
	 *             dd/MM/yyyy)
	 */
	private SimpleDateFormat hourFormat = new SimpleDateFormat("hh:mm dd/MM/yyyy");

	public TimeDate() {

	}

	/**
	 * sets now date for rent
	 */
	public void setNowDate() {
		Calendar c = Calendar.getInstance();
		this.startDate = c.getTime();
		hourFormat.format(startDate).toString();
		
		this.returnDate = getReturnDateOf(startDate);
	}

	/**
	 * @return String of three days later from date given
	 */
	public Date getReturnDateOf(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 3);

		hourFormat.format(date = c.getTime());
		return date;
	}

	/**
	 * @param startDate to set (from DB)
	 * @throws ParseException
	 */
	public void setStartDateString(String startDate) {
		this.startDateString = startDate;
	}

	/**
	 * @return start date String
	 */
	public String getStartDate() {
		return startDate.toString();
	}
	
	/**
	 * @param returnDate to set (from DB)
	 * @throws ParseException
	 */
	public void setReturnDateString(String returnDate) {
		this.returnDateString = returnDate;
	}
	
	public String getStartDateString() {
		return startDateString;
	}

	/**
	 * @return return date String
	 */
	public String getReturnDate() {
		return returnDate.toString();
	}
	
	public String getReturnDateString() {
		return returnDateString;
	}
}
