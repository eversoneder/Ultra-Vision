package model;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.Title;

public class Payment {

	ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private MembershipCard card;
	private Customer customer;
	private ArrayList<Title> titleList;

	public Payment(Customer customer, MembershipCard card, ArrayList<Title> titleList) {
		this.customer = customer;
		this.card = card;
		this.titleList = titleList;
	}

	public void payByCash() {

		// set new rent
		Rent newRent = null;
		for (Title t : titleList) {

			// card state changes
			card.setPoints();

			// Account state changes for PayByCash
			customer.setPayment(t.getPrice());

			// title state change are done straight in Query as it is only 0 or 1 to
			// available

			try {
				newRent = new Rent(t.getPrice(), card.getCardID(), t.getId());

			} catch (ParseException e) {
				e.printStackTrace();
			}

			// Register rent in DB
			managementSystem.rentTitleByCash(newRent, customer, card);

		}

		Object[] transactionSucceeded = { "Ok" };
		JOptionPane.showOptionDialog(null,
				"" + titleList.size() + " Rent(s) Registered! \n" + customer.getCustomer_name() + " is now renting: "
						+ titleList.get(0).getName() + "\nand other " + (titleList.size() - 1) + " Title(s).\nFrom: "
						+ newRent.getStartDate() + " \nUntil: " + newRent.getReturnDate() + ".",
				"Rent Issued.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, transactionSucceeded,
				transactionSucceeded[0]);
	}

	public void payByPoints() {

		int haspoints = card.hasFreeRents();

		switch (haspoints) {

		case 0:// has no free rents
			Object[] freerents = { "Ok" };
			JOptionPane.showOptionDialog(null, "Customer has no free rents available yet.", "No available free rents.",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, freerents, freerents[0]);
			return;

		case 1:// has free rents to claim

			Rent newRent = null;
			if (card.getFreeRents() >= titleList.size()) {

				for (Title t : titleList) {
					card.addOngoingRents();
					card.payWithPoints();

					try {
						newRent = new Rent(card.getCardID(), t.getId());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					managementSystem.rentTitleByPoints(newRent, customer, card);
				}
			} else {
				Object[] notEnoughFreeRents = { "Ok" };
				JOptionPane.showOptionDialog(null, "Not enough free rents available to rent "+titleList.size()+" Title(s) by points.", "No available free rents.",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, notEnoughFreeRents, notEnoughFreeRents[0]);
				return;
			}

			Object[] transactionSucceeded = { "Ok" };
			JOptionPane.showOptionDialog(null, "Free Rent Registered! \n" + customer.getCustomer_name()
					+ " is now renting: " + titleList.get(0).getName() + "\nand other " + (titleList.size() - 1)
					+ " Title(s).\nFrom: " + newRent.getStartDate() + " \nUntil: " + newRent.getReturnDate() + ".",
					"Rent Issued.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
					transactionSucceeded, transactionSucceeded[0]);

			break;
		case 2:// has 4 ongoing rents
			Object[] ongoing = { "Ok" };
			JOptionPane.showOptionDialog(null, "Customer has 4 ongoing rents.", "Maximum ongoing rents.",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, ongoing, ongoing[0]);
			return;
		}
	}
}
