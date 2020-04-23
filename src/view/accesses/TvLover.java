package view.accesses;

import java.util.ArrayList;

import view.AccessLevel;
import view.DiscFormat;
import view.Title;

public class TvLover extends Title {

	// general title attributes
//	private int title_id;
//	private String title_name;
//	private DiscFormat title_format;
//	private double title_price;
//	private int title_available;
//	private int title_yor;
//	private String title_accessLevel;

	// movies attributes
	private String title_director;
	private AccessLevel tv_access_level;
	private ArrayList<TvLover> tvTitles;

	/**
	 * @return the tvTitles
	 */
	public ArrayList<TvLover> getTvTitles() {
		return tvTitles;
	}

	/**
	 * @param tvTitles the tvTitles to set
	 */
	public void setTvTitles(ArrayList<TvLover> tvTitles) {
		this.tvTitles = new ArrayList<>(tvTitles);
	}

	public static void main(String[] args) {
		Title a = new TvLover(1, "Shrek Box Set", 1.25);
		System.out.println(a);
		a.getTitle_accessLevel();
	}

	public TvLover(String search, String filter) {
		super(search, filter);
	}

	public TvLover(int id, String name, double price) {
		super(id, name, price);

		tv_access_level = AccessLevel.TVLOVER;
		super.setTitle_accessLevel(tv_access_level);
	}

	/**
	 * @return the title_director
	 */
	public String getTitle_director() {
		return title_director;
	}

	/**
	 * @param title_director the title_director to set
	 */
	public void setTitle_director(String title_director) {
		this.title_director = title_director;
	}
}
