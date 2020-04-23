package view;

public abstract class Title implements DiscFormat{

	//general title attributes
	private int id;
	private String name;
	private Media format;
	private double price;
	private int available;
	private int yearOfRelease;
	private String genre;
	
	private String search;
	private String filter;
	
	public Title() {
		
	}
	
	public Title(String search, String filter) {
		this.search = search;
		this.filter = filter;
	}
	
	public Title(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.available = 1;
	}
	
//	public static void main(String[]args) { //testing
//		new Title();
//	}
//	public Title() {
//		AccessLevel a = AccessLevel.MUSICLOVER;
//		setTitle_accessLevel(a);
//		title_accessLevel = getTitle_accessLevel();
//		System.out.println(title_accessLevel);
//	}
	
	/**
	 * @return the title genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the title genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	 * @return the title year of release
	 */
	public int getYearOfRelease() {
		return yearOfRelease;
	}

	/**
	 * @param yor the title year of release to set
	 */
	public void setYearOfRelease(int yor) {
		this.yearOfRelease = yor;
	}

	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * @return the filter
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * @param filter the filter to set
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return DiscFormat 
	 */
	public Media getTitle_format() {
		return this.format;
	}
	
	@Override
	public void setDiscFormat(Media format) {
		this.format = format;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the title availability
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param available the title_available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Title name: "+this.name+"\n Title price: "+this.price+".";
	}
}
