package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.customer.Customer;
import model.customer.DebitOrCreditAccount;
import model.customer.MembershipCard;
import model.titles.BoxSet;
import model.titles.Movie;
import model.titles.MusicOrLive;
import model.titles.Title;

/**
 * Ultra-Vision Database handling class
 */
public class UltraVisionDB {

	private String dbHost = "jdbc:mysql://apontejaj.com:3306/everson" + "?useSSL=false";
	private String user = "everson";
	private String password = "everson";
	
//	private String dbHost = "jdbc:mysql://localhost:3306/ultra_visiondb" + "?useSSL=false";
//	private String user = "root";
//	private String password = "pass1234!";

	Connection con = null;
	Statement st = null;

	private ArrayList<Object> titleList = new ArrayList<>();
	private ArrayList<Object> customerInfo = new ArrayList<>();
	
	private Customer customer = new Customer();
	private MembershipCard membershipCard = new MembershipCard();
	
	/**
	 * DB Default Constructor, creation of database connection
	 */
	public UltraVisionDB() {

		try {
			con = DriverManager.getConnection(dbHost, user, password);
			st = con.createStatement();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	/**
	 * closes Statement and Connection
	 */
	private void closings() {
		try {
			st.close();
			con.close();
		} catch (SQLException ex) {
			Logger.getLogger(UltraVisionDB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * @param query the query to execute (reusable method)
	 * @return ResultSet of query given
	 */
	private ResultSet executeQueryRS(String query) {

		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
			rs.next();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}

	/**
	 * @param query query to execute update
	 * @return int 1 if succeed, 0 if fail 
	 */
	private int executeUpdateRS(String query) {

		int rsi = 0;
		try {
			st.executeUpdate(query);
			rsi = 1;
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rsi;
	}

	/**
	 * @param sqle exception messages to execute if error occurs(breaking down code)
	 */
	private void exceptionMessages(SQLException sqle) {
		while (sqle != null) {
			System.out.println("State: " + sqle.getSQLState());
			System.out.println("Message: " + sqle.getMessage());
			System.out.println("Error: " + sqle.getErrorCode());
			sqle = sqle.getNextException();
		}
	}
	
	/**
	 * @param customerID to query DB
	 * @return Customer
	 */
	public Customer getCustomerInfoByID(int customerID) {
		
		String getCustInfo = "SELECT * FROM debit_or_credit_account dc " + 
				"INNER JOIN customer c ON dc.customer_id = c.customer_id " + 
				"INNER JOIN membership_card m ON dc.account_id = m.account_id " + 
				"WHERE c.customer_id = "+customerID+";";
		
		customer = loadCustomerInfoByID(getCustInfo);
		
		return customer; 
	}
	
	/**
	 * @param query to query DB
	 * @return Customer
	 */
	public Customer loadCustomerInfoByID(String query) {
		
		ResultSet rs = executeQueryRS(query);
		Customer newCustomer = null;
		
		try {
			if(!rs.wasNull()) {
				newCustomer = new Customer(
						rs.getInt("account_id"), 
						rs.getString("account_number"), 
						rs.getDouble("account_balance"),
						rs.getInt("customer_id"),
						rs.getString("customer_name"),
						rs.getLong("customer_phone"),
						rs.getString("customer_email")
						);
				newCustomer.setCardID(rs.getInt("card_id"));
			}
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return newCustomer;
	}
	
	public int updateCustomer(Customer customer) {
		
		String getCardInfo = "UPDATE customer"
				+ " SET customer_name = '"+customer.getCustomer_name()+"', "
				+ "customer_phone = '"+customer.getCustomer_phone()+"', "
				+ "customer_email = '"+customer.getEmail()+"' "
				+ "WHERE customer_id = "+customer.getCustomer_id()+";";
		
		int a = executeUpdateRS(getCardInfo);
		
		return a;
	}
	
	public int updateCard(MembershipCard card) {
		
		String getCardInfo = "UPDATE membership_card "
				+ "SET card_password = '"+card.getPassword()+"', "
				+ "card_ongoing_rents = '"+card.getOngoingRents()+"', "
				+ "card_free_rents = '"+card.getFreeRents()+"', "
				+ "card_points = '"+card.getPoints()+"', "
				+ "account_id = '"+card.getAccountID()+"', "
				+ "subscription_id = '"+card.getSubscriptionID()+"' "
				+ "WHERE card_id = '"+card.getCardID()+"';";
		
		int a = executeUpdateRS(getCardInfo);
		
		return a;
	}
	
	/**
	 * @param cardID to query DB
	 * @return MembershipCard
	 */
	public MembershipCard getCardInfoByID(int cardID) {
		
		String getCardInfo = "SELECT * FROM membership_card m " + 
				"INNER JOIN subscription s ON m.subscription_id = s.subscription_id " + 
				"WHERE m.card_id = "+cardID+";";
		
		membershipCard = loadCardInfoByID(getCardInfo);
		
		return membershipCard; 
	}
	
	/**
	 * @param query to query DB
	 * @return MembershipCard
	 */
	public MembershipCard loadCardInfoByID(String query) {
		
		ResultSet rs = executeQueryRS(query);
		MembershipCard newCard = null;
		
		try {
			if(!rs.wasNull()) {
				newCard = new MembershipCard(
						rs.getInt("card_id"), 
						rs.getInt("card_password"), 
						rs.getInt("card_ongoing_rents"),
						rs.getInt("card_free_rents"),
						rs.getInt("card_points"),
						rs.getInt("account_id"),
						rs.getInt("subscription_id")
						);
				newCard.setSubscriptionPlan(rs.getString("subscription_plan"));
			}
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return newCard;
	}
	
	public ArrayList<Object> getTitleInfoByID(int titleID){
		
		String query = "SELECT * FROM title t "
				+ "INNER JOIN title_type tt ON t.title_type_id = tt.title_type_id "
				+ "WHERE t.title_id = '"+titleID+"';";
		
		Title title;
		title = loadRawTitle(query);
		
		switch(title.getTitleTypeDB()) {
		case 1://ML(Music)
			String queryMusic = "SELECT * FROM title t "
					+ "INNER JOIN music m ON t.title_id = m.title_id "
					+ "WHERE t.title_id = '"+titleID+"';";
			MusicOrLive music;
			music = loadMusic(queryMusic);
			titleList.add(music);
			break;
		case 2://ML(Live Concert)
			String queryLive = "SELECT * FROM title t "
					+ "INNER JOIN live_concert lc ON t.title_id = lc.title_id "
					+ "WHERE t.title_id = '"+titleID+"';";
			MusicOrLive live;
			live = loadLive(queryLive);
			titleList.add(live);
			break;
		case 3://VL(Movie)
			String queryMovie = "SELECT * FROM title t "
					+ "INNER JOIN movie m ON t.title_id = m.title_id "
					+ "WHERE t.title_id = '"+titleID+"';";
			Movie movie;
			movie = loadMovie(queryMovie);
			titleList.add(movie);
			break;
		case 4://TV(Box Set)
			String queryBoxSet = "SELECT * FROM title t "
					+ "INNER JOIN box_set b ON t.title_id = b.title_id "
					+ "WHERE t.title_id = '"+titleID+"';";
			BoxSet boxSet;
			boxSet = loadBoxSet(queryBoxSet);
			titleList.add(boxSet);
			break;
		}
		
		return titleList;
	}
	
	/**
	 * @param query to query DB
	 * @return Music or Live
	 */
	public MusicOrLive loadMusic(String query) {
		
		ResultSet rs = executeQueryRS(query);
		MusicOrLive musicOrLive = null;
		
		try {
			if(!rs.wasNull()) {
				musicOrLive = new MusicOrLive(
						rs.getInt("title_id"), 
						rs.getInt("music_id"), 
						rs.getInt("title_type_id"),
						rs.getInt("disc_format_id"),
						rs.getInt("title_available"),
						rs.getString("title_name"),
						rs.getDouble("title_price"),
						rs.getString("title_genre"),
						rs.getInt("title_yor"),
						rs.getString("music_singer"), 
						rs.getString("music_band"),
						rs.getInt("subscription_id")
						);
			}
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return musicOrLive;
	}
	
	/**
	 * @param query to query DB
	 * @return Music or Live
	 */
	public MusicOrLive loadLive(String query) {
		
		ResultSet rs = executeQueryRS(query);
		MusicOrLive musicOrLive = null;
		
		try {
			if(!rs.wasNull()) {
				musicOrLive = new MusicOrLive(
						rs.getInt("title_id"), 
						rs.getInt("live_concert_id"), 
						rs.getInt("title_type_id"),
						rs.getInt("disc_format_id"),
						rs.getInt("title_available"),
						rs.getString("title_name"),
						rs.getDouble("title_price"),
						rs.getString("title_genre"),
						rs.getInt("title_yor"),
						rs.getString("live_concert_singer"), 
						rs.getString("live_concert_band"),
						rs.getInt("subscription_id")
						);
			}
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return musicOrLive;
	}
	
	/**
	 * @param query to query DB 
	 * @return Movie
	 */
	public Movie loadMovie(String query) {
		
		ResultSet rs = executeQueryRS(query);
		Movie movie = null;
		
		try {
			if(!rs.wasNull()) {
				movie = new Movie(
						rs.getInt("title_id"), 
						rs.getInt("movie_id"), 
						rs.getInt("title_type_id"),
						rs.getInt("disc_format_id"),
						rs.getInt("title_available"),
						rs.getString("title_name"),
						rs.getDouble("title_price"),
						rs.getString("title_genre"),
						rs.getInt("title_yor"),
						rs.getString("movie_director"),
						rs.getInt("subscription_id")
						);
			}
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return movie;
	}
	
	public BoxSet loadBoxSet(String query) {
		
		ResultSet rs = executeQueryRS(query);
		BoxSet boxSet = null;
		
		try {
			if(!rs.wasNull()) {
				boxSet = new BoxSet(
						rs.getInt("title_id"), 
						rs.getInt("box_set_id"), 
						rs.getInt("title_type_id"),
						rs.getInt("disc_format_id"),
						rs.getInt("title_available"),
						rs.getString("title_name"),
						rs.getDouble("title_price"),
						rs.getInt("title_yor"),
						rs.getInt("number_of_discs"),
						rs.getString("title_genre"),
						rs.getInt("subscription_id")
						);
			}
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return boxSet;
	}
	
	/**
	 * @param query to query DB
	 * @return Title
	 */
	public Title loadRawTitle(String query) {
			
			ResultSet rs = executeQueryRS(query);
			Title newTitle = new Title(0);
			
			try {
				if(!rs.wasNull()) {
					newTitle = new Title(
							rs.getInt("title_id"), 
							rs.getInt("title_type_id"), 
							rs.getInt("disc_format_id"),
							rs.getInt("title_available"),
							rs.getString("title_name"),
							rs.getDouble("title_price"),
							rs.getString("title_genre"),
							rs.getInt("title_yor")
							);
				}
			} catch (SQLException sqle) {
				exceptionMessages(sqle);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return newTitle;
	}
	
	/**
	 * @param titleID to set available
	 */
	public void setTitleAvailableByID(int titleID) {
		
		String query = "UPDATE title SET title_available = 1 WHERE title_id = '"+titleID+"';";
		executeUpdateRS(query);
	}
	
	/**
	 * @param search to query DB
	 * @return ArrayList of Object customer & card
	 */
	public ArrayList<Object> setSearchGetCustomerList(String search){
		
		String searchCustomer = "SELECT * FROM debit_or_credit_account dc " + 
				"INNER JOIN customer c ON dc.customer_id = c.customer_id " + 
				"INNER JOIN membership_card m ON dc.account_id = m.account_id " + 
				"WHERE c.customer_id LIKE '%"+search+"%' " + 
				"OR c.customer_name LIKE '%"+search+"%' " + 
				"OR c.customer_phone LIKE '%"+search+"%' " + 
				"OR c.customer_email LIKE '%"+search+"%' " + 
				"OR m.card_id LIKE '%"+search+"%' " + 
				"OR m.card_ongoing_rents LIKE '%"+search+"%' " + 
				"OR m.card_free_rents LIKE '%"+search+"%' " + 
				"OR m.card_points LIKE '%"+search+"%' " + 
				"OR m.subscription_id LIKE '%"+search+"%';";
		
		customerInfo = customerInfoLoad(searchCustomer);
		
		return customerInfo;
	}
	
	/**
	 * @param query to query DB
	 * @return ArrayList Object of customers
	 */
	private ArrayList<Object> customerInfoLoad(String query) {

		ResultSet rs = executeQueryRS(query);
		
		try {
			
			do {
				if(!rs.wasNull()) {
					Customer newCustomer = new Customer(
							rs.getInt("account_id"), 
							rs.getString("account_number"), 
							rs.getDouble("account_balance"),
							rs.getInt("customer_id"),
							rs.getString("customer_name"),
							rs.getLong("customer_phone"),
							rs.getString("customer_email")
							);
					customerInfo.add(newCustomer);
					
					MembershipCard newCard = new MembershipCard(
							rs.getInt("card_id"), 
							rs.getInt("card_password"), 
							rs.getInt("card_ongoing_rents"),
							rs.getInt("card_free_rents"),
							rs.getInt("card_points"),
							rs.getInt("account_id"),
							rs.getInt("subscription_id")
							);
					customerInfo.add(newCard);
				}
			}while (rs.next());
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return customerInfo;
	}

	/**
	 * @param search to query DB
	 * @param titleClassification title type to query DB
	 * @return ArrayList of Object titles
	 */
	public ArrayList<Object> setSearchGetTitleList(String search, String titleClassification) {

		switch (titleClassification) {
		case "music":
			String searchMusic = "SELECT * FROM title t "
					+ "INNER JOIN music m ON t.title_id = m.title_id "
					+ "INNER JOIN disc_format d ON t.disc_format_id = d.disc_format_id WHERE "
					+ "t.title_id LIKE '%"+search+"%' OR "
					+ "t.title_name LIKE '%"+search+"%' OR "
					+ "t.title_genre LIKE '%"+search+"%' OR "
					+ "t.title_yor LIKE '%"+search+"%' OR "
					+ "t.title_price LIKE '%"+search+"%' OR "
					+ "d.disc_type LIKE '%"+search+"%' OR "
					+ "m.music_id LIKE '%"+search+"%' OR "
					+ "m.music_singer LIKE '%"+search+"%' OR "
					+ "m.music_band LIKE '%"+search+"%';";
			titleList = titleLoad(searchMusic, titleClassification);
			break;
		case "live_concert":
			String searchLive = "SELECT * FROM title t "
					+ "INNER JOIN live_concert lc ON t.title_id = lc.title_id "
					+ "INNER JOIN disc_format d ON t.disc_format_id = d.disc_format_id WHERE "
					+ "t.title_id LIKE '%"+search+"%' OR "
					+ "t.title_name LIKE '%"+search+"%' OR "
					+ "t.title_genre LIKE '%"+search+"%' OR "
					+ "t.title_yor LIKE '%"+search+"%' OR "
					+ "t.title_price LIKE '%"+search+"%' OR "
					+ "d.disc_type LIKE '%"+search+"%' OR "
					+ "lc.live_concert_id LIKE '%"+search+"%' OR "
					+ "lc.live_concert_singer LIKE '%"+search+"%' OR "
					+ "lc.live_concert_band LIKE '%"+search+"%';";
			titleList = titleLoad(searchLive, titleClassification);
			break;
		case "movie":
			String searchMovie = "SELECT * FROM title t "
					+ "INNER JOIN movie m ON t.title_id = m.title_id "
					+ "INNER JOIN disc_format d ON t.disc_format_id = d.disc_format_id WHERE "
					+ "t.title_id LIKE '%"+search+"%' OR "
					+ "t.title_name LIKE '%"+search+"%' OR "
					+ "t.title_genre LIKE '%"+search+"%' OR "
					+ "t.title_yor LIKE '%"+search+"%' OR "
					+ "t.title_price LIKE '%"+search+"%' OR "
					+ "d.disc_type LIKE '%"+search+"%' OR "
					+ "m.movie_id LIKE '%"+search+"%' OR "
					+ "m.movie_director LIKE '%"+search+"%';";
			titleList = titleLoad(searchMovie, titleClassification);
			break;
		case "box_set":
			String searchBoxSet = "SELECT * FROM title t "
					+ "INNER JOIN box_set bs ON t.title_id = bs.title_id "
					+ "INNER JOIN disc_format d ON t.disc_format_id = d.disc_format_id WHERE "
					+ "t.title_id LIKE '%"+search+"%' OR "
					+ "t.title_name LIKE '%"+search+"%' OR "
					+ "t.title_genre LIKE '%"+search+"%' OR "
					+ "t.title_yor LIKE '%"+search+"%' OR "
					+ "t.title_price LIKE '%"+search+"%' OR "
					+ "d.disc_type LIKE '%"+search+"%' OR "
					+ "bs.box_set_id LIKE '%"+search+"%' OR "
					+ "bs.number_of_discs LIKE '%"+search+"%';";
			titleList = titleLoad(searchBoxSet, titleClassification);
			break;
		}
		return titleList;
	}

	/**
	 * @param query to query DB
	 * @param titleClassification title type to query DB
	 * @return ArrayList of Object titles
	 */
	private ArrayList<Object> titleLoad(String query, String titleClassification) {

		ResultSet rs = executeQueryRS(query);
		
		try {
			
			do {
				if(!rs.wasNull()) {
				switch(titleClassification) {
				case "music":
					MusicOrLive newMusic = new MusicOrLive(
							rs.getInt("title_id"), 
							rs.getInt("music_id"), 
							rs.getInt("title_type_id"),
							rs.getInt("disc_format_id"),
							rs.getInt("title_available"),
							rs.getString("title_name"),
							rs.getDouble("title_price"),
							rs.getString("title_genre"),
							rs.getInt("title_yor"),
							rs.getString("music_singer"), 
							rs.getString("music_band"),
							rs.getInt("subscription_id")
							);
					titleList.add(newMusic);
					break;
				case "live_concert":
					MusicOrLive newLive = new MusicOrLive(
							rs.getInt("title_id"), 
							rs.getInt("live_concert_id"), 
							rs.getInt("title_type_id"),
							rs.getInt("disc_format_id"),
							rs.getInt("title_available"),
							rs.getString("title_name"),
							rs.getDouble("title_price"),
							rs.getString("title_genre"),
							rs.getInt("title_yor"),
							rs.getString("live_concert_singer"), 
							rs.getString("live_concert_band"),
							rs.getInt("subscription_id")
							);
					titleList.add(newLive);
					break;
				case "movie":
					Movie newMovie = new Movie(
							rs.getInt("title_id"), 
							rs.getInt("movie_id"), 
							rs.getInt("title_type_id"),
							rs.getInt("disc_format_id"),
							rs.getInt("title_available"),
							rs.getString("title_name"),
							rs.getDouble("title_price"),
							rs.getString("title_genre"),
							rs.getInt("title_yor"),
							rs.getString("movie_director"),
							rs.getInt("subscription_id")
							);
					titleList.add(newMovie);
					break;
				case "box_set":
					BoxSet boxSet = new BoxSet(
							rs.getInt("title_id"), 
							rs.getInt("box_set_id"), 
							rs.getInt("title_type_id"),
							rs.getInt("disc_format_id"),
							rs.getInt("title_available"),
							rs.getString("title_name"),
							rs.getDouble("title_price"),
							rs.getInt("title_yor"),
							rs.getInt("number_of_discs"),
							rs.getString("title_genre"),
							rs.getInt("subscription_id")
							);
					titleList.add(boxSet);
					break;
				}
				}
			}while (rs.next());
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return titleList;
	}

	/**
	 * @param customer to upload
	 * @return customer with ID
	 */
	public Customer addNewCustomer(Customer customer) {

		String queryInsert = "INSERT INTO customer (customer_name, customer_phone, customer_email) " + "VALUES ('"
				+ customer.getCustomer_name() + "', " + customer.getCustomer_phone() + ", '" + customer.getEmail()
				+ "');";

		int i = executeUpdateRS(queryInsert);
		if (i == 0) {
			System.out.println("Error DB executeUpdate @ UltraVisionDB class, addNewCustomer method.");
		}

		String queryGetCustID = "SELECT * FROM customer WHERE " + "customer_name LIKE '%" + customer.getCustomer_name()
				+ "%' " + "AND customer_phone LIKE '%" + customer.getCustomer_phone() + "%' "
				+ "AND customer_email LIKE '%" + customer.getEmail() + "%';";

		ResultSet rs = executeQueryRS(queryGetCustID);

		try {
			int custID = rs.getInt("customer_id");
			customer.setCustomer_id(custID);
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		}
		closings();
		return customer;
	}

	/**
	 * @param customer to update
	 * @return customer & account with ID
	 */
	public Customer updateAccountAndCustomerInfo(Customer customer) {

		String query = "SELECT * FROM customer c INNER JOIN debit_or_credit_account acc ON c.customer_id = acc.customer_id WHERE "
				+ "customer_name LIKE '%" + customer.getCustomer_name() + "%' " + "AND customer_phone LIKE '%"
				+ customer.getCustomer_phone() + "%' " + "AND customer_email LIKE '%" + customer.getEmail() + "%';";

		ResultSet rs = executeQueryRS(query);
		try {
			// customer info
			customer.setCustomer_id(rs.getInt("customer_id"));
			customer.setCustomer_name(rs.getString("customer_name"));
			customer.setCustomer_phone(rs.getLong("customer_phone"));
			customer.setEmail(rs.getString("customer_email"));
			// account info
			customer.setAccountID(rs.getInt("account_id"));
			customer.setAccountNumber(rs.getString("account_number"));
			customer.setAccountBalance(rs.getInt("account_balance"));
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		}
		return customer;
	}

	/**
	 * @param customer to upload
	 * @return customer with ID
	 */
	public Customer addNewAccount(Customer customer) {

		String queryInsertAccount = "INSERT INTO debit_or_credit_account (account_number, account_balance, customer_id) "
				+ "VALUES ('" + customer.getAccountNumber() + "', " + customer.getAccountBalance() + ", "
				+ customer.getCustomer_id() + ");";

		int i = executeUpdateRS(queryInsertAccount);
		if (i == 0) {
			System.out.println("Error DB executeUpdate @ UltraVisionDB class, addNewAccount method.");
		}

		// updates info with auto incremented ID
		customer = updateAccountAndCustomerInfo(customer);

		closings();
		return customer;
	}

	/**
	 * @param card to upload
	 * @return card with ID
	 */
	public MembershipCard addNewMembershipCard(MembershipCard card) {

		String queryInsertCard = "INSERT INTO membership_card (card_password, card_ongoing_rents, card_free_rents, card_points, account_id, subscription_id) "
				+ "VALUES (" + card.getPassword() + ", " + card.getOngoingRents() + ", " + card.getFreeRents() + ", "
				+ card.getPoints() + ", " + card.getAccountID() + ", " + card.getTitleTypeDB() + ");";

		int i = executeUpdateRS(queryInsertCard);
		if (i == 0) {
			System.out.println("Error DB executeUpdate @ UltraVisionDB class, addNewMembershipCard method.");
		}

		// update card with membership_card_id
		card = updateCardInfoGetID(card);

		return card;
	}

	/**
	 * @param card to update with ID
	 * @return card with ID
	 */
	public MembershipCard updateCardInfoGetID(MembershipCard card) {

		String queryInsertAccount = "SELECT * FROM membership_card " + "WHERE card_password LIKE '%"
				+ card.getPassword() + "%' " + "AND card_ongoing_rents LIKE '%" + card.getOngoingRents() + "%' "
				+ "AND card_free_rents LIKE '%" + card.getFreeRents() + "%' " + "AND card_points LIKE '%"
				+ card.getPoints() + "%' " + "AND account_id LIKE '%" + card.getAccountID() + "%' "
				+ "AND subscription_id LIKE '%" + card.getTitleTypeDB() + "%';";

		ResultSet rs = executeQueryRS(queryInsertAccount);

		try {
			card.setCardID(rs.getInt("card_id"));
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		}
		closings();
		return card;
	}
	
	public MembershipCard updateCardInfoReturnTitle(MembershipCard card) {

		String queryInsertAccount = "SELECT * FROM membership_card " + "WHERE card_id = "+card.getCardID()+";";

		ResultSet rs = executeQueryRS(queryInsertAccount);

		try {
			card.setCardID(rs.getInt("card_id"));
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		}
		closings();
		return card;
	}

	/**
	 * 
	 * @param title to update with ID
	 * @return title with ID
	 */
	public Title updateTitleInfo(Title title) {

		String query = "SELECT * FROM title WHERE title_type_id LIKE '%" + title.getTitleTypeDB() + "%' "
				+ "AND disc_format_id LIKE '%" + title.getDiscFormatDB() + "%' " + "AND title_available LIKE '%"
				+ title.getAvailable() + "%' " + "AND title_name LIKE '%" + title.getName() + "%' "
				+ "AND title_price LIKE '%" + title.getPrice() + "%' " + "and title_genre LIKE '%" + title.getGenre()
				+ "%' " + "and title_yor LIKE '%" + title.getYearOfRelease() + "%';";

		ResultSet rs = executeQueryRS(query);
		try {
			title.setId(rs.getInt("title_id"));
			title.setTitleTypeDB(rs.getInt("title_type_id"));
			title.setDiscFormatDB(rs.getInt("disc_format_id"));
			title.setAvailable(rs.getInt("title_available"));
			title.setName(rs.getString("title_name"));
			title.setPrice(rs.getDouble("title_price"));
			title.setGenre(rs.getString("title_genre"));
			title.setYearOfRelease(rs.getInt("title_yor"));
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		}
		return title;
	}

	/**
	 * @param newTitle to upload raw Title
	 * @return title with ID
	 */
	public Title addNewTitle(Title newTitle) {

		String queryInsertTitle = "INSERT INTO title (title_type_id, disc_format_id, title_available, title_name, title_price, title_genre, title_yor) "
				+ "VALUES (" + newTitle.getTitleTypeDB() + ", " + newTitle.getDiscFormatDB() + ", "
				+ newTitle.getAvailable() + ", '" + newTitle.getName() + "', " + newTitle.getPrice() + ", '"
				+ newTitle.getGenre() + "', " + newTitle.getYearOfRelease() + ");";

		int i = executeUpdateRS(queryInsertTitle);
		if (i == 0) {
			System.out.println("Error DB executeUpdate @ UltraVisionDB class, addNewTitle method.");
		}

		newTitle = updateTitleInfo(newTitle);

		return newTitle;
	}

	/**
	 * @param newMusicOrLive to upload
	 * @return 1 if succeeded 0 if failed
	 */
	public int addNewTitle(MusicOrLive newMusicOrLive) {// polymorphism of overloading. same signature,
														// different param
//---------------------------------RAW TITLE DB UPLOAD-------------------------------------------
		// add new title and returns with title_id
		// upload first raw title to DB
		Title newTitle = addNewTitle(new Title(newMusicOrLive.getTitleTypeDB(), newMusicOrLive.getDiscFormatDB(),
				newMusicOrLive.getAvailable(), newMusicOrLive.getName(), newMusicOrLive.getPrice(),
				newMusicOrLive.getGenre(), newMusicOrLive.getYearOfRelease()));

//---------------------------------MUSIC DB UPLOAD-------------------------------------------

		int musicOrLiveInsert = 0;

		switch (newMusicOrLive.getTitleTypeDB()) {
		case 1:// if music
			String queryInsertIntoMusic = "INSERT INTO music (music_singer, music_band, subscription_id, title_id) "
					+ "VALUES ('" + newMusicOrLive.getSinger() + "', '" + newMusicOrLive.getBand() + "', "
					+ newMusicOrLive.getTitleTypeDB() + ", " + newTitle.getId() + ");";

			musicOrLiveInsert = executeUpdateRS(queryInsertIntoMusic);
			break;
		case 2:// if live
			String queryInsertIntoLiveConcert = "INSERT INTO live_concert (live_concert_singer, live_concert_band, subscription_id, title_id) "
					+ "VALUES ('" + newMusicOrLive.getSinger() + "', '" + newMusicOrLive.getBand() + "', "
					+ newMusicOrLive.getSubscriptionID() + ", " + newTitle.getId() + ");";

			musicOrLiveInsert = executeUpdateRS(queryInsertIntoLiveConcert);
			break;
		}
		closings();
		return musicOrLiveInsert;
	}

	/**
	 * @param newMovie to upload
	 * @return 1 if succeeded 0 if failed
	 */
	public int addNewTitle(Movie newMovie) {// polymorphism of overloading. same signature,
											// different param
//---------------------------------RAW TITLE DB UPLOAD-------------------------------------------
		// add new title and returns with title_id
		// upload first raw title to DB
		Title newTitle = addNewTitle(
				new Title(newMovie.getTitleTypeDB(), newMovie.getDiscFormatDB(), newMovie.getAvailable(),
						newMovie.getName(), newMovie.getPrice(), newMovie.getGenre(), newMovie.getYearOfRelease()));

//---------------------------------MOVIE DB UPLOAD-------------------------------------------
		String queryInsertIntoMovie = "INSERT INTO movie (movie_director, subscription_id, title_id) " + "VALUES ('"
				+ newMovie.getDirector() + "', " + newMovie.getSubscriptionID() + ", " + newTitle.getId() + ");";

		int movieInsert = executeUpdateRS(queryInsertIntoMovie);

		closings();
		return movieInsert;
	}

	/**
	 * @param newBoxSet to upload
	 * @return 1 if succeeded 0 if failed
	 */
	public int addNewTitle(BoxSet newBoxSet) {// polymorphism of overloading. same signature,
												// different param
//---------------------------------RAW TITLE DB UPLOAD-------------------------------------------
		// add new title and returns with title_id
		// upload first raw title to DB
		Title newTitle = addNewTitle(
				new Title(newBoxSet.getTitleTypeDB(), newBoxSet.getDiscFormatDB(), newBoxSet.getAvailable(),
						newBoxSet.getName(), newBoxSet.getPrice(), newBoxSet.getGenre(), newBoxSet.getYearOfRelease()));

//---------------------------------MOVIE DB UPLOAD-------------------------------------------
		String queryInsertIntoBoxSet = "INSERT INTO box_set (number_of_discs, subscription_id, title_id) " + "VALUES ('"
				+ newBoxSet.getNumOfDiscs() + "', " + newBoxSet.getSubscriptionID() + ", " + newTitle.getId() + ");";

		int boxSetInsert = executeUpdateRS(queryInsertIntoBoxSet);

		closings();
		return boxSetInsert;
	}
	
	public Customer uploadCardRentedTitle(Customer customer) {

		String query = "SELECT * FROM customer c INNER JOIN debit_or_credit_account acc ON c.customer_id = acc.customer_id WHERE "
				+ "customer_name LIKE '%" + customer.getCustomer_name() + "%' " + "AND customer_phone LIKE '%"
				+ customer.getCustomer_phone() + "%' " + "AND customer_email LIKE '%" + customer.getEmail() + "%';";

		ResultSet rs = executeQueryRS(query);
		try {
			// customer info
			customer.setCustomer_id(rs.getInt("customer_id"));
			customer.setCustomer_name(rs.getString("customer_name"));
			customer.setCustomer_phone(rs.getLong("customer_phone"));
			customer.setEmail(rs.getString("customer_email"));
			// account info
			customer.setAccountID(rs.getInt("account_id"));
			customer.setAccountNumber(rs.getString("account_number"));
			customer.setAccountBalance(rs.getInt("account_balance"));
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		}
		return customer;
	}
	
	public void rentTitleByCash(Rent newRent, Customer customer, MembershipCard card){
		
		String alterTitle = "UPDATE title SET title_available = '0' WHERE title_id = '"+newRent.getTitleID()+"';";
		executeUpdateRS(alterTitle);
		
		String updateCustomer = "UPDATE debit_or_credit_account "
				+ "SET account_balance = '"+customer.getAccountBalance()+"' "
				+ "WHERE account_id = '"+customer.getAccountID()+"';";
		executeUpdateRS(updateCustomer);
		
		String updateCard = "UPDATE membership_card "
				+ "SET card_ongoing_rents = '"+card.getOngoingRents()+"', "
				+ "card_free_rents = '"+card.getFreeRents()+"', "
				+ "card_points = '"+card.getPoints()+"' "
				+ "WHERE card_id = '"+card.getCardID()+"';";
		executeUpdateRS(updateCard);
		
		String insertRent = "INSERT INTO rent (rent_start_date, rent_return_date, rent_price, card_id, title_id) VALUES ("
				+ "'"+newRent.getStartDate()+"', "
				+ "'"+newRent.getReturnDate()+"', "
				+ "'"+newRent.getRentPrice()+"', "
				+ "'"+newRent.getCardID()+"', "
				+ "'"+newRent.getTitleID()+"');";
		executeUpdateRS(insertRent);
	}
	
	public void rentTitleByPoints(Rent newRent, Customer customer, MembershipCard card){
		
		String alterTitle = "UPDATE title SET title_available = '0' WHERE title_id = '"+newRent.getTitleID()+"';";
		executeUpdateRS(alterTitle);
		
		String updateCard = "UPDATE membership_card "
				+ "SET card_ongoing_rents = '"+card.getOngoingRents()+"', "
				+ "card_free_rents = '"+card.getFreeRents()+"' "
				+ "WHERE card_id = '"+card.getCardID()+"';";
		executeUpdateRS(updateCard);
		
		String insertRent = "INSERT INTO rent (rent_start_date, rent_return_date, rent_price, card_id, title_id) VALUES ("
				+ "'"+newRent.getStartDate()+"', "
				+ "'"+newRent.getReturnDate()+"', "
				+ "'"+newRent.getRentPrice()+"', "
				+ "'"+newRent.getCardID()+"', "
				+ "'"+newRent.getTitleID()+"');";
		executeUpdateRS(insertRent);
	}
	
	public Rent getRentByTitleID(int titleID){
		
		String queryRent = "SELECT * FROM rent WHERE title_id = "+titleID+";";
		
		ResultSet rs = executeQueryRS(queryRent);
		Rent rent = null;
		
		try {
			if(!rs.wasNull()) {
				rent = new Rent(
						rs.getInt("rent_id"), 
						rs.getString("rent_start_date"), 
						rs.getString("rent_return_date"),
						rs.getDouble("rent_price"),
						rs.getInt("card_id"),
						rs.getInt("title_id")
						);
			}
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return rent;
	}
	
	public DebitOrCreditAccount getAccountInfoByID(int accountID) {
		
		String getAccoundInfo = "";
		
		
		
		ResultSet rs = executeQueryRS(getAccoundInfo);
		DebitOrCreditAccount accountRentingTitle = null;
		try {
			if(!rs.wasNull()) {
				accountRentingTitle = new DebitOrCreditAccount(
						rs.getInt("account_id"), 
						rs.getString("account_number"), 
						rs.getDouble("account_balance"),
						rs.getInt("customer_id")
						);
			}
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return accountRentingTitle;
	}
	
	/**
	 * @param returnRent
	 * @param card
	 * @return
	 */
	public int returnTitle(Rent returnRent, MembershipCard card){
		int flag = 1;
		
		String alterTitle = "UPDATE title SET title_available = '1' WHERE title_id = '"+returnRent.getTitleID()+"';";
		flag = executeUpdateRS(alterTitle);
		
		if(flag == 0) {
			return 2;
		}
		
		String updateCard = "UPDATE membership_card "
				+ "SET card_ongoing_rents = '"+card.getOngoingRents()+"' "
				+ "WHERE card_id = '"+card.getCardID()+"';";
		flag = executeUpdateRS(updateCard);
		
		if(flag == 0) {
			return 3;
		}
		
		String insertRent = "DELETE FROM rent WHERE rent_id = '"+returnRent.getRentID()+"';";
		flag = executeUpdateRS(insertRent);
		
		if(flag == 0) {
			return 4;
		}
		return flag;
	}
	
	public int deleteCustomer(Customer custToDel) {
		
		String getAccountID = "SELECT * FROM debit_or_credit_account dc " + 
				"INNER JOIN customer c ON dc.customer_id = c.customer_id " + 
				"INNER JOIN membership_card m ON dc.account_id = m.account_id " + 
				"WHERE c.customer_id = "+custToDel.getCustomer_id()+";";
		
		ResultSet rs = executeQueryRS(getAccountID);
		int accID = 0;
		try{
			accID = rs.getInt("account_id");
		}catch(SQLException sqle) {
			exceptionMessages(sqle);
		}

		String deleteCard = "DELETE FROM membership_card WHERE account_id = '"+accID+"';";
		int flag = executeUpdateRS(deleteCard);
		
		String deleteAccount = "DELETE FROM debit_or_credit_account WHERE customer_id = '"+custToDel.getCustomer_id()+"';";
		flag = executeUpdateRS(deleteAccount);
		
		String deleteCust = "DELETE FROM customer WHERE customer_id = '"+custToDel.getCustomer_id()+"';";
		flag = executeUpdateRS(deleteCust);
		
		closings();
		return flag;
	}

	public int deleteTitle(Title title) {
		
		String getTitleType = "SELECT * FROM title WHERE title_id = '"+title.getId()+"';";
		
		ResultSet rs = executeQueryRS(getTitleType);
		int titleType = 0;
		try{
			titleType = rs.getInt("title_type_id");
		}catch(SQLException sqle) {
			exceptionMessages(sqle);
		}
		
		String entity = "";
		
		switch(titleType) {
		case 1:
			entity = "music";
			break;
		case 2:
			entity = "live_concert";
			break;
		case 3:
			entity = "movie";
			break;
		case 4:
			entity = "box_set";
			break;
		}
		
		String childDelete = "DELETE FROM "+entity+" WHERE title_id = '"+title.getId()+"';";
		int flag = executeUpdateRS(childDelete);

		String titleDelete = "DELETE FROM title WHERE title_id = '"+title.getId()+"';";
		flag = executeUpdateRS(titleDelete);
		
		closings();
		return flag;
	}
	
	public int returnTitle(Movie returningTitle){
		
		int flag = 0;
		
		
		
		
		return flag;
	}

	public int returnTitle(BoxSet returningTitle){
	
		int flag = 0;
	
	
		return flag;
	}
	
	public Rent loadRentInfo(String query) {
		
		ResultSet rs = executeQueryRS(query);
		Rent rent = new Rent();
		
		try {
			if(!rs.wasNull()) {
				rent = new Rent(
						rs.getInt("rent_id"), 
						rs.getString("rent_start_date"), 
						rs.getString("rent_return_date"),
						rs.getDouble("rent_total_price"),
						rs.getInt("card_id"),
						rs.getInt("title_id")
						);
			}
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return rent;
	}
}
