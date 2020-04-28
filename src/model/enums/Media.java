package model.enums;

public enum Media {
	CD(1),
	DVD(2),
	BLURAY(3);
	
	private int discFormatID;
	
	private Media(int discFormatID) {
		this.discFormatID = discFormatID;
	}
	
	/**
	 * @return disc format id
	 */
	public int getDiscFormatID() {
		return discFormatID;
	}
}
