package model;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.BoxSet;
import model.titles.Movie;
import model.titles.MusicOrLive;
import model.titles.Title;

public class Payment {

	private int payment_id;
	private double payment_amount;
	private String titleType;

	private Rent rent;

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private MembershipCard card = new MembershipCard();
	private Customer customer = new Customer();
	private Title title = new Title();

	private MusicOrLive musicOrLive = new MusicOrLive();
	private Movie movie = new Movie();
	private BoxSet boxSet = new BoxSet();

	private int subsID;

	private ArrayList<Object> unknowntitletype;

	public Payment(Customer customer, MembershipCard card, ArrayList<Object> unknowntitletype) {

		this.customer = customer;
		this.card = card;
		this.unknowntitletype = unknowntitletype;

		unwrapTitleGetSubsID();
		validateMatch();
	}

	public void unwrapTitleGetSubsID() {

		for (Object obj : unknowntitletype) {
			switch (obj.getClass().getName()) {// or filter.getName()
			case "model.titles.MusicOrLive":
				musicOrLive = (MusicOrLive) obj;
				subsID = musicOrLive.getSubscriptionID();
				titleType = musicOrLive.getTitleTypeGUI();
				break;
			case "model.titles.Movie":
				movie = (Movie) obj;
				subsID = movie.getSubscriptionID();
				titleType = movie.getTitleTypeGUI();
				break;
			case "model.titles.BoxSet":
				boxSet = (BoxSet) obj;
				subsID = boxSet.getSubscriptionID();
				title = (Title) obj;
				break;
			}
		}

	}

	public void validateMatch() {

		ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

		int cardSub = card.getTitleTypeDB();
		String custPlan = whichPlan(card.getTitleTypeDB());

		if (title.getId() != 0) {
			if (cardSub == subsID || cardSub == 4) {

				// promptPaymentForm
				Object[] payment = { "Pay by Points", "Cancel Transaction", "Pay by Cash" };
				int i = JOptionPane.showOptionDialog(null,
						"Choose payment form for \n" + title.getName() + ". Price: " + title.getPrice() + " €.",
						"Payment Form.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, payment,
						payment[2]);

				if (i == 2) {// pay by cash

					boolean hasMoney = customer.checkFunds(title.getPrice());
					if (!hasMoney) {
						Object[] noMoneyBtn = { "Ok" };
						int j = JOptionPane.showOptionDialog(null,
								"Customer has no enough funds to rent: \n" + title.getName() + ". Price: "
										+ title.getPrice() + " €.",
								"Insuficient Funds.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								noMoneyBtn, noMoneyBtn[0]);
					} else {

						int rentlimit = card.checkRentingLimit();

						if (rentlimit == 1) {

							Object[] transactionSucceeded = { "Ok" };
							int j = JOptionPane.showOptionDialog(null,
									"Rent Registered! \n " + customer.getCustomer_name() + " is now renting: "
											+ title.getName() + ".\nFrom: " + rent.setStartDate() + " until: "
											+ rent.getReturnDate() + ".",
									"Insuficient Funds.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
									logoIcon, transactionSucceeded, transactionSucceeded[0]);

							//REGISTER DB
							
							card.setOngoingRents();
							card.setPoints();
//							managementSystem.rentTitle(title.getId(), card);
							
//							managementSystem.
							
						} else {

							Object[] transactionSucceeded = { "Ok" };
							int j = JOptionPane.showOptionDialog(null,
									"Cannot procceed, customer has 4 ongoing rents registered. ",
									"Maximum Renting Limit.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
									logoIcon, transactionSucceeded, transactionSucceeded[0]);
							return;

						}
					}
				}
				if (i == 0) {// pay by points

					int a = card.hasFreeRentsAndIsLessThan4Check();

					switch (a) {
					case 0:
						Object[] freerents = { "Ok" };
						int j = JOptionPane.showOptionDialog(null, "Customer has no free rents available yet.",
								"No available free rents.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
								logoIcon, freerents, freerents[0]);
						break;
					case 1:

						System.out.println("section in construction");

						break;
					case 2:
						Object[] ongoing = { "Ok" };
						int x = JOptionPane.showOptionDialog(null, "Customer has 4 ongoing rents.",
								"Maximum ongoing rents.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
								logoIcon, ongoing, ongoing[0]);
						break;

					}

				}

				if (i == 1 || i == -1) {
//					rentScreen.dispose();
				}

				// check DB if customer has money to rent
//				int hasMoney = managementSystem.checkAccountHasMoney(customer.acc);

			} else {
				Object[] btns = { "Ok" };
				int i = JOptionPane.showOptionDialog(null,
						"Customer is not allowed to rent " + title.getTitleTypeGUI()
								+ " \nas the Customer's subscription is " + custPlan + ".",
						"Title Access Level Error.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
						btns, btns[0]);
			}
		} else {
			Object[] noMoneyBtn = { "Ok" };
			int j = JOptionPane.showOptionDialog(null, "There's no Title with ID: " + title.getId() + ".",
					"Title doesn't exist in System.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
					noMoneyBtn, noMoneyBtn[0]);

		}

	}

	public String whichPlan(int subscriptionID) {

		String plan = "";

		switch (subscriptionID) {
		case 1:
			plan = "ML";
			break;
		case 2:
			plan = "VL";
			break;
		case 3:
			plan = "TV";
			break;
		case 4:
			plan = "PR";
			break;
		}
		return plan;
	}

	/**
	 * @param titlePrice   the title price
	 * @param rentingTitle the title to be rented
	 * @return true if both statements are met (hasMoney && rentingList < 4)
	 */
	public boolean makePayment(double titlePrice, Title rentingTitle) {
		customer.setPayment(titlePrice);
//		recordRent(rentingTitle);
		return true;
	}
}
