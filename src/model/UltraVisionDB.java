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

	private Collection<Title> titleList;
	private Title title;

//	public static void main(String[] args) {
//		UltraVisionDB a = new UltraVisionDB();
//		int r = a.getTableSize("title_name", "a");
//		System.out.println(r);
//	}

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
//			closings();
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

	public Collection<Title> getTitleList(String search, String filter) {

		titleList = new ArrayList<>();

		String query_nf = "SELECT * FROM title WHERE title_name LIKE '%" + search + "%' OR title_price LIKE '%" + search
				+ "%' OR title_format LIKE '%" + search + "%' OR title_access_level LIKE '%" + search
				+ "%' OR title_band LIKE '%" + search + "%' OR title_genre LIKE '%" + search + "%' OR title_yor LIKE '%"
				+ search + "%';";
		String query = "SELECT * FROM title WHERE " + filter + " LIKE '%" + search + "%';";

		if (filter.equals("nofilter")) {
			titleList = titleLoad(query_nf);
			return titleList;
		} else {
			titleList = titleLoad(query);
		}
		return titleList;
	}

	/**
	 * @param query to get titles loaded from db
	 * @return collection of titles based on quer
	 */
	private Collection<Title> titleLoad(String query) {

		ResultSet rs = executeQueryRS(query);
		try {
			while (rs.next()) {
				for (int i = 0; i < tableSize; i++) {

					// decision ml, vl, tv, title
					title = titleSort(rs);
					titleList.add(title);
					rs.next();
				}
			}
			closings();
			title.setTitleList(titleList);
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return titleList;
	}

	/**
	 * Sorts if title will be loaded as Title, MusicLover, VideoLover or TvLover
	 * 
	 * @param rs the ResultSet from db to be used in the operation
	 * @return polymorphed Title loaded
	 */
	public Title titleSort(ResultSet rs) {

		title = null;
		try {
			switch (rs.getInt("title_type_id")) {
			case 3:
//				title = new Movie(rs.getInt("title_id"), rs.getString("title_name"), rs.getDouble("title_price"),
//						rs.getString("title_format"), rs.getString("title_access_level"), rs.getInt("title_available"),
//						rs.getString("title_genre"), rs.getString("title_director"), rs.getInt("title_yor"));
				break;
			case 4:
//				title = new BoxSet(rs.getInt("title_id"),rs.getInt("title_type_id"), rs.getInt("disc_format_id"), rs.getInt("title_available"),
//						rs.getString("title_name"), rs.getDouble("title_price"), rs.getString("title_genre"),
//						rs.getInt("title_yor"));
				break;
			default:
//				title = new MusicLover(rs.getInt("title_id"), rs.getString("title_name"), rs.getDouble("title_price"),
//						rs.getString("title_format"), rs.getString("title_access_level"), rs.getInt("title_available"),
//						rs.getString("title_band"), rs.getString("title_genre"), rs.getInt("title_yor"));
				break;
			}

		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return title;
	}

	/**
	 * @param password to check
	 * @return true if password matches database membership_card_password
	 */
	public boolean checkCardPassword(int password) {

		return false;
	}

	public int addNewCustomer(Customer newCustumer) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param newTitle type raw Title
	 * @return 1 if succeeded, 0 if failed
	 */
	public int addNewTitle(Title newTitle) {

		String queryInsertTitle = "INSERT INTO title (title_type_id, disc_format_id, title_available, title_name, title_price, title_genre, title_yor) "
				+ "VALUES (" + newTitle.getTitleTypeDB() + ", " + newTitle.getDiscFormatDB() + ", "
				+ newTitle.getAvailable() + ", '" + newTitle.getName() + "', " + newTitle.getPrice() + ", '"
				+ newTitle.getGenre() + "', " + newTitle.getYearOfRelease() + ");";

		return executeUpdateRS(queryInsertTitle);
	}

	/**
	 * @param newMusicOrLive to add but should of first have inserted the raw title
	 *                       in order to get the title_id to insert it to
	 *                       music.title_id
	 * @return 1 if succeeded 0 if failed
	 */
	public int addNewTitle(MusicOrLive newMusicOrLive) {// polymorphism of overloading. same signature, different param

		int toreturn = 0;
//---------------------------------RAW TITLE DB UPLOAD-------------------------------------------
		Title newTitle = new Title(newMusicOrLive.getTitleTypeDB(), newMusicOrLive.getDiscFormatDB(),
				newMusicOrLive.getAvailable(), newMusicOrLive.getName(), newMusicOrLive.getPrice(),
				newMusicOrLive.getGenre(), newMusicOrLive.getYearOfRelease());
		int rawTitle = addNewTitle(newTitle);// upload first raw title to DB

		if (rawTitle == 0) {
			System.out.println("Title upload failed.(class: UltraVision. method: addNewTitle(MusicOrLive).");
			return toreturn;
		}
//---------------------------------MUSIC DB UPLOAD-------------------------------------------
		String queryToGetNewTitleID = "SELECT * FROM title " + "WHERE title_type_id LIKE '%"
				+ newMusicOrLive.getTitleTypeDB() + "%'" + " AND disc_format_id LIKE '%"
				+ newMusicOrLive.getDiscFormatDB() + "%'" + " AND title_available LIKE '%"
				+ newMusicOrLive.getAvailable() + "%'" + " AND title_name LIKE '%" + newMusicOrLive.getName() + "%'"
				+ " AND title_genre LIKE '%" + newMusicOrLive.getGenre() + "%'" + " AND title_price LIKE '%"
				+ newMusicOrLive.getPrice() + "%'" + " AND title_yor LIKE '%" + newMusicOrLive.getYearOfRelease() + "%'"
				+ ";";
		// query DB to get new title id to insert into music.title_id
		ResultSet rs = executeQueryRS(queryToGetNewTitleID);
		int title_id = 0;// variable to hold id from DB title.title_id

		try {
			title_id = rs.getInt("title_id");
//			closings();
			toreturn = 1;
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (toreturn == 0) {
			System.out.println("queryToGetNewTitleID failed. class: UltraVisionDB. method: addNewTitle(MusicOrLive).");
			return toreturn;
		}

		String queryInsertIntoMusic = "INSERT INTO music (music_singer, music_band, subscription_id, title_id) "
				+ "VALUES ('" + newMusicOrLive.getSinger() + "', '" + newMusicOrLive.getBand() + "', " + newMusicOrLive.getTitleTypeDB() + ", " + title_id + ");";

		int musicInsert = executeUpdateRS(queryInsertIntoMusic);

		if (musicInsert == 0) {
			System.out.println("Couldn't Insert Music. Class: UltraVisionDB. method: addNewTitle(MusicOrLive).");
			return toreturn;
		}
		return 1;
	}

	public int searchTitle(String entity, String filter, String search) {
		// TODO Auto-generated method stub
		return 0;
	}

}
