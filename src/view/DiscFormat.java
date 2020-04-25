package view;

public interface DiscFormat {
	/**
	 * @param discType the type of disc to set
	 */
	public abstract void setDiscFormat(Media discType);
	
	/**
	 * @return Disc Format
	 */
	public abstract String getDiscFormat();
}
