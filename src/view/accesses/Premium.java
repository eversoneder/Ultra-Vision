package view.accesses;

import java.util.ArrayList;

import view.AccessLevel;
import view.DiscFormat;
import view.Title;

public class Premium extends Title {

	// general title attributes
//	private int title_id;
//	private String title_name;
//	private DiscFormat title_format;
//	private double title_price;
//	private int title_available;
//	private int title_yor;
//	private String title_accessLevel;

	// premium attributes
	private AccessLevel VL_access_level;
	private ArrayList<Title> prTitles;

	/**
	 * @return the vlTitles
	 */
	public ArrayList<Title> getVLTitles() {
		return prTitles;
	}

	/**
	 * @param prTitles the vlTitles to set
	 */
	public void setVLTitles(ArrayList<Title> prTitles) {
		this.prTitles = new ArrayList<>(prTitles);
	}

	public static void main(String[] args) {
		Title a = new MusicLover(1, "musica", 1.25);
		System.out.println(a);
		a.getTitle_accessLevel();
	}

	public Premium(String search, String filter) {
		super(search, filter);
	}

	public Premium(int id, String name, double price) {
		super(id, name, price);

		VL_access_level = AccessLevel.PREMIUM;
		super.setTitle_accessLevel(VL_access_level);
	}
}
