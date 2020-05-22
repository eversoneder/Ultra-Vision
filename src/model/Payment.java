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
		
		//title state change are done straight in Query as it is only 0 or 1 to available
		
		//set new rent
		Rent newRent = null;
		try {
			newRent = new Rent(title.getPrice(), card.getCardID(), title.getId());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Register rent in DB
		managementSystem.rentTitleByCash(newRent, customer, card);

		Object[] transactionSucceeded = { "Ok" };
		JOptionPane.showOptionDialog(null,
				"Rent Registered! \n" + customer.getCustomer_name() + " is now renting: " + title.getName()
						+ ".\nFrom: " + newRent.getStartDate() + " \nUntil: " + newRent.getReturnDate() + ".",
				"Rent Issued.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
				transactionSucceeded, transactionSucceeded[0]);
	}
	
	public void payByPoints() {
		
		int haspoints = card.hasFreeRents();

		switch (haspoints) {
		
		case 0:// has no free rents
			Object[] freerents = { "Ok" };
			JOptionPane.showOptionDialog(null, "Customer has no free rents available yet.",
					"No available free rents.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
					logoIcon, freerents, freerents[0]);
			return;
			
		case 1:// has free rents to claim
			card.addOngoingRents();
			card.payWithPoints();
			
			Rent newRent = null;
			try {
				newRent = new Rent(card.getCardID(), title.getId());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			managementSystem.rentTitleByPoints(newRent, customer, card);
			
			Object[] transactionSucceeded = { "Ok" };
			JOptionPane.showOptionDialog(null,
					"Free Rent Registered! \n" + customer.getCustomer_name() + " is now renting: " + title.getName()
							+ ".\nFrom: " + newRent.getStartDate() + " \nUntil: " + newRent.getReturnDate() + ".",
					"Rent Issued.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
					transactionSucceeded, transactionSucceeded[0]);
			
			break;
		case 2:// has 4 ongoing rents
			Object[] ongoing = { "Ok" };
			JOptionPane.showOptionDialog(null, "Customer has 4 ongoing rents.",
					"Maximum ongoing rents.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
					logoIcon, ongoing, ongoing[0]);
			return;
		}
	}
}
