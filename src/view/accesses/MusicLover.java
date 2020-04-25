package view.accesses;

import java.util.ArrayList;
import java.util.Collection;

import view.Level;
import view.Media;
import view.Title;

public class MusicLover extends Title {

	private String band;
	
	private Collection<MusicLover> mlTitles;

	public MusicLover() {
		
	}
	
	/**
	 * New titles by user
	 * @param name
	 * @param price
	 * @param format
	 * @param band
	 * @param genre
	 * @param yor
	 * @param available
	 */
	public MusicLover(String name, double price, Media format, String band, String genre, int yor, int available) {
		super.setName(name);
		super.setPrice(price);
		super.setDiscFormat(format);
		this.setBand(band);
		super.setGenre(genre);
		super.setYearOfRelease(yor);
		super.setAccessLevel(Level.ML);
		super.setAvailable(available);
	}
	
	/**
	 * Load titles from db
	 * @param id
	 * @param name
	 * @param price
	 * @param format
	 * @param band
	 * @param genre
	 * @param yor
	 * @param available
	 */
	public MusicLover(int id, String name, double price, String format, String accessLevel, int available, String band, String genre, int yor) {
		super.setId(id);
		super.setName(name);
		super.setPrice(price);
		super.setDiscFormat(format);
		super.setAccessLevel(accessLevel);
		this.setBand(band);
		super.setGenre(genre);
		super.setYearOfRelease(yor);
		super.setAccessLevel(Level.ML);
		super.setAvailable(available);
	}

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
	
	public void addNewTitle(MusicLover ml) {
		this.mlTitles.add(ml);
	}
	
	/**
	 * @return the band
	 */
	public String getBand() {
		return band;
	}

	/**
	 * @param band the band to set
	 */
	public void setBand(String band) {
		this.band = band;
	}
}
