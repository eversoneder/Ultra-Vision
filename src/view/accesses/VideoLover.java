package view.accesses;

import java.util.ArrayList;

import view.AccessLevel;
import view.DiscFormat;
import view.Level;
import view.Media;
import view.Title;

public class VideoLover extends Title implements AccessLevel {

	// general title attributes
//	private int title_id;
//	private String title_name;
//	private DiscFormat title_format;
//	private double title_price;
//	private int title_available;
//	private int title_yor;
//	private String title_accessLevel;

	// movies attributes
	private ArrayList<VideoLover> vlTitles;

	private String vl_title_director;
	private Level vl_classification_Level;

	private Media vl_discType;

	/**
	 * @return the vlTitles
	 */
	public ArrayList<VideoLover> getVLTitles() {
		return vlTitles;
	}

	/**
	 * @param vlTitles the vlTitles to set
	 */
	public void setVLTitles(ArrayList<VideoLover> vlTitles) {
		this.vlTitles = new ArrayList<>(vlTitles);
	}

	public static void main(String[] args) {
		Title a = new MusicLover(1, "musica", 1.25);
		System.out.println(a);
	}

	public VideoLover(String search, String filter) {
		super(search, filter);
	}

	public VideoLover(int id, String name, double price) {
		super(id, name, price);
	}

	/**
	 * @return the title_director
	 */
	public String getTitle_director() {
		return vl_title_director;
	}

	/**
	 * @param title_director the title_director to set
	 */
	public void setTitle_director(String title_director) {
		this.vl_title_director = title_director;
	}

	@Override
	public Level getAccessLevel() {
		return this.vl_classification_Level;
	}
	
	@Override
	public void setAccessLevel() {
		vl_classification_Level = Level.VL;
	}
}
