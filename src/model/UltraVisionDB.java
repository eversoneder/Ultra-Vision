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

	private Connection con = null;
	private Statement st = null;
	private int tableSize;

	private Collection<Title> titleList;
	private Title title;

	public static void main(String[] args) {
		UltraVisionDB a = new UltraVisionDB();
		int r = a.getTableSize("title_name", "a");
		System.out.println(r);
	}

	/**
	 * DB Default Constructor, creation of database connection
	 */
	UltraVisionDB() {

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
	private void executeUpdateRS(String query) {

		int rs = 0;
		try {
			rs = st.executeUpdate(query);
			closings();
		} catch (SQLException sqle) {
			exceptionMessages(sqle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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

	public int addNewTitle(Title newTitle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int searchTitle(String entity, String filter, String search) {
		// TODO Auto-generated method stub
		return 0;
	}

}
