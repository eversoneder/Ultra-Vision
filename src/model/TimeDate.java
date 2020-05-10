package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeDate {

	/**
	 * @hourFormat the format of hours, mins, day, month and year to show (hh:mm a dd/MM/yyyy)
	 */
	private SimpleDateFormat hourFormat = new SimpleDateFormat("hh:mm a dd/MM/yyyy");
	
	/**
	 * @currentDate now date
	 */
	private Date currentDate;

	
	public TimeDate() {
		
	}
	
	/**
	 * @return String of now date
	 */
	public Date getNowDate() {
		Calendar c = Calendar.getInstance();
		currentDate = c.getTime();
		hourFormat.format(currentDate).toString();
		
		return currentDate;
	}
	
	public Date getStartedDate() {
		return currentDate;
	}

	/**
	 * @return String of three days later from now time
	 */
	public Date getReturnDateOf(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 3);

		hourFormat.format(date = c.getTime());
		return date;
	}
}
