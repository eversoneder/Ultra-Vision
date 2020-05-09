package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.customer.Customer;
import model.customer.MembershipCard;
import model.enums.Media;
import model.titles.BoxSet;
import model.titles.Movie;
import model.titles.MusicOrLive;
import model.titles.Title;

/**
 * Ultra-Vision Database handling class
 */
public class UltraVisionDB {

	private String dbHost = "jdbc:mysql://localhost:3306/ultra_visiondb" + "?useSSL=false";
	private String user = "root";
	private String password = "pass1234!";

	Connection con = null;
	Statement st = null;
	private int tableSize;

	private ArrayList<Object> titleList = new ArrayList<>();
	
	private ArrayList<Customer> customerList = new ArrayList<>();
	private ArrayList<MembershipCard> cardList = new ArrayList<>();
	private ArrayList<Object> customerInfo = new ArrayList<>();
	
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
	 * @param searchName the name to search
	 * @param filter     the filter to select
	 * @return int of table size
	 * @throws SQLException
	 */
	public int getTableSize(String filter, String searchName) {

		String query = "SELECT COUNT(*) FROM title WHERE " + filter + " LIKE '%" + searchName + "%';";
		ResultSet rs = executeQueryRS(query);
		try {
			tableSize = rs.getInt("COUNT(*)");
			closings();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tableSize;
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
	 */
	private int executeUpdateRS(String query) {

		int rsi = 0;
		try {
			rsi = st.executeUpdate(query);
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
	
	public ArrayList<Object> setSearchGetCustomerList(String search){
		
		String searchCustomer = "SELECT * FROM debit_or_credit_account dc " + 
				"INNER JOIN customer c ON dc.customer_id = c.customer_id " + 
				"INNER JOIN membership_card m ON dc.account_id = m.account_id " + 
				"WHERE c.customer_id LIKE '%"+search+"%' " + 
				"OR c.customer_name LIKE '%"+search+"%' " + 
				"OR c.customer_phone LIKE '%"+search+"%' " + 
				"OR c.customer_email LIKE '%"+search+"%' " + 
				"OR m.card_id LIKE '%"+search+"%' " + 
				"OR m.card_has_free_rent LIKE '%"+search+"%' " + 
				"OR m.card_free_rents LIKE '%"+search+"%' " + 
				"OR m.card_points LIKE '%"+search+"%' " + 
				"OR m.subscription_id LIKE '%"+search+"%';";
		
		customerInfo = customerInfoLoad(searchCustomer);
		
		return customerInfo;
	}
	
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
							rs.getInt("card_has_free_rent"),
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
	 * @param query to get titles loaded from db
	 * @return collection of titles based on quer
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
	 * @param password to check
	 * @return true if password matches database membership_card_password
	 */
	public boolean checkCardPassword(int password) {

		return false;
	}

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

	public Customer updateAccountAndCustomerInfo(Customer customer) {
//		SELECT * FROM customer c INNER JOIN debit_or_credit_account acc ON c.customer_id = acc.customer_id;
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

	public Customer getAccoundID(Customer customer) {

		return customer;
	}

	public MembershipCard addNewMembershipCard(MembershipCard card) {

//		String queryGetSubsID = "SELECT * FROM subscription;";
//
//		ResultSet rs = executeQueryRS(queryGetSubsID);
//		// update card with subscription_id
//		card = setCardSubscriptionID(card, rs);

		String queryInsertCard = "INSERT INTO membership_card (card_password, card_has_free_rent, card_free_rents, card_points, account_id, subscription_id) "
				+ "VALUES (" + card.getPassword() + ", " + card.getHasFreeRent() + ", " + card.getFreeRents() + ", "
				+ card.getPoints() + ", " + card.getAccountID() + ", " + card.getTitleTypeDB() + ");";

		int i = executeUpdateRS(queryInsertCard);
		if (i == 0) {
			System.out.println("Error DB executeUpdate @ UltraVisionDB class, addNewMembershipCard method.");
		}

		// update card with membership_card_id
		card = updateCardInfo(card);

		return card;
	}

	public MembershipCard updateCardInfo(MembershipCard card) {

		String queryInsertAccount = "SELECT * FROM membership_card " + "WHERE card_password LIKE '%"
				+ card.getPassword() + "%' " + "AND card_has_free_rent LIKE '%" + card.getHasFreeRent() + "%' "
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

//	public MembershipCard setCardSubscriptionID(MembershipCard card, ResultSet rs) {
//
//		try {
//			while (rs.next()) {
//				
//				int subsplan = rs.getInt("subscription_id");
//
//				if(subsplan == card.getTitleTypeDB()) {
//					
//				}
//			}
//		} catch (SQLException sqle) {
//			exceptionMessages(sqle);
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//
//		return card;
//	}

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
	 * @param newTitle type raw Title
	 * @return 1 if succeeded, 0 if failed
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
	 * @param newMusicOrLive to add
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
					+ newMusicOrLive.getSubscriptionplan() + ", " + newTitle.getId() + ");";

			musicOrLiveInsert = executeUpdateRS(queryInsertIntoLiveConcert);
			break;
		}
		closings();
		return musicOrLiveInsert;
	}

	/**
	 * @param newMovie to add
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
				+ newMovie.getDirector() + "', " + newMovie.getSubscriptionPlan() + ", " + newTitle.getId() + ");";

		int movieInsert = executeUpdateRS(queryInsertIntoMovie);

		closings();
		return movieInsert;
	}

	/**
	 * @param newBoxSet to add
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
				+ newBoxSet.getNumOfDiscs() + "', " + newBoxSet.getSubscriptionplan() + ", " + newTitle.getId() + ");";

		int boxSetInsert = executeUpdateRS(queryInsertIntoBoxSet);

		closings();
		return boxSetInsert;
	}

	public int searchTitle(String entity, String filter, String search) {
		// TODO Auto-generated method stub
		return 0;
	}

}
