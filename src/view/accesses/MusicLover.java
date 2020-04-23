package view.accesses;

import java.util.ArrayList;
import java.util.Collection;

import view.AccessLevel;
import view.DiscFormat;
import view.Level;
import view.Title;

public class MusicLover extends Title implements AccessLevel{

	// general title attributes
//	private int title_id;
//	private String title_name;
//	private DiscFormat title_format;
//	private double title_price;
//	private int title_available;
//	private int title_yor;
//	private String title_accessLevel;

	// musical attributes
	private String band;
	private Level accessLevel;
	private Collection<MusicLover> mlTitles = new ArrayList<>();

	/**
	 * @return the mlTitles
	 */
	public Collection<MusicLover> getMLTitles() {
		return mlTitles;
	}

	/**
	 * @param mlTitles the mlTitles to set
	 */
	public void setMLTitles(Collection<MusicLover> mlTitles) {
		this.mlTitles = new ArrayList<>(mlTitles);
	}

	public static void main(String[] args) {
		Title a = new MusicLover(1,"musica",1.25);
		System.out.println(a);
		
	}

	public MusicLover(String search, String filter) {
		super(search, filter);
	}

	public MusicLover(int id, String name, double price) {
		super(id, name, price);
		setAccessLevel();
	}

	/**
	 * @return the title_band
	 */
	public String getTitle_band() {
		return band;
	}

	/**
	 * @param title_band the title_band to set
	 */
	public void setTitle_band(String title_band) {
		this.band = title_band;
	}

	@Override
	public void setAccessLevel() {
		this.accessLevel = Level.ML;
	}

	@Override
	public Level getAccessLevel() {
		return accessLevel;
	}
	
	@Override
	public String toString() {
		return super.toString()+" Access Level: "+this.accessLevel+".";
	}
}
