package model;


import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.Title;

public class Payment {

	ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");
	
	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private MembershipCard card;
	private Customer customer;
	private Title title;
	
	public Payment(Customer customer, MembershipCard card, Title title) {
		this.customer = customer;
		this.card = card;
		this.title = title;
	}

	public void payByCash() {
		
		//card state changes
		card.setPoints();
		
		//Account state changes for PayByCash
		customer.setPayment(title.getPrice());
		
		//title state change
		title.setAvailable(0);
		
		//set new rent
		Rent newRent = null;
		try {
			newRent = new Rent(title.getPrice(), card.getCardID(), title.getId());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Register rent in DB
		managementSystem.rentTitleByCash(newRent, customer, card);

		Object[] transactionSucceeded = { "Ok" };
		int j = JOptionPane.showOptionDialog(null,
				"Rent Registered! \n" + customer.getCustomer_name() + " is now renting: " + title.getName()
						+ ".\nFrom: " + newRent.getStartDate() + " \nUntil: " + newRent.getReturnDate() + ".",
				"Rent Issued.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
				transactionSucceeded, transactionSucceeded[0]);
	}
	
	public void payByPoints() {
		
		Rent newRent = null;
		try {
			newRent = new Rent(card.getCardID(), title.getId());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int haspoints = card.hasFreeRents();

		switch (haspoints) {
		case 0:// has no free rents
			Object[] freerents = { "Ok" };
			int j = JOptionPane.showOptionDialog(null, "Customer has no free rents available yet.",
					"No available free rents.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
					logoIcon, freerents, freerents[0]);
			return;
		case 1:// has free rents to claim

			Payment newPayment = new Payment(customer, card, title);
			newPayment.payByPoints();

			break;
		case 2:// has 4 ongoing rents
			Object[] ongoing = { "Ok" };
			int x = JOptionPane.showOptionDialog(null, "Customer has 4 ongoing rents.",
					"Maximum ongoing rents.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
					logoIcon, ongoing, ongoing[0]);
			return;
		}
		
		managementSystem.rentTitleByPoints(newRent, customer, card);
		
	}
	
	public void setRentState(Customer customer, MembershipCard card, Title title) {

	}
}
