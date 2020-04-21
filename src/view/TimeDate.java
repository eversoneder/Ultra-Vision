package view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeDate {

	SimpleDateFormat hourFormat = new SimpleDateFormat("hh:mm a dd/MM/yyyy");;
	private Date currentDate;
	
	/**
	 * @return String of now date
	 */
	public Date getNowDate() {
		Calendar c = Calendar.getInstance();
		currentDate = c.getTime();
		hourFormat.format(currentDate).toString();
		
		return currentDate;
	}

//	public static void main(String[]args) {
//		new TimeDate();
//	}
//	public TimeDate() {
//
//		Date a = new Date();
//		a = getReturnDateOf(a);
//		System.out.println(a);
//	}

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
