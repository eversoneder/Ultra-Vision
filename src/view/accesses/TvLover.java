package view.accesses;

import java.util.ArrayList;
import java.util.Collection;

import view.Level;
import view.Media;
import view.Title;

public class TvLover extends Title {

	private String director;
	
	private Collection<TvLover> tvTitles;

	public TvLover() {
		
	}
	
	public TvLover(String name, double price, Media format, String director, String genre, int yor) {
		super.setName(name);
		super.setPrice(price);
		super.setDiscFormat(format);
		this.setDirector(director);
		super.setGenre(genre);
		super.setYearOfRelease(yor);
		super.setAccessLevel(Level.TV);
		super.setAvailable(1);
	}
	
	/**
	 * @return the tvTitles
	 */
	public Collection<TvLover> getTvTitles() {
		return tvTitles;
	}

	/**
	 * @param tvTitles the tvTitles to set
	 */
	public void setTvTitles(Collection<TvLover> tvTitles) {
		this.tvTitles = new ArrayList<>(tvTitles);
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
}
