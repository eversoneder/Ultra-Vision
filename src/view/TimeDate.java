package view;

import java.text.SimpleDateFormat;
import java.util.Date;

import controller.Rent;

public class TimeDate {

	private Date currentDate; 
	
	public static void main(String[]args) {
		new TimeDate();
	}
	
	public TimeDate() {
		String timenow = getNowHour();
		System.out.println(timenow);
	}

	/**
	 * @return String of now date
	 */
	public String getNowHour() {
		SimpleDateFormat hourFormat = new SimpleDateFormat("hh:mm a");
		currentDate = new Date();
		String now = hourFormat.format(currentDate).toString();
		return now;
	}
}
